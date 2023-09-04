package fr.eni.projetEni.dal2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEni.bo2.ArticlesVendu;
import fr.eni.projetEni.bo2.Enchere;
import fr.eni.projetEni.bo2.Utilisateur;
import fr.eni.projetEni.utils.ConnectionProvider;

public class UtilisateursDAOImpl implements UtilisateursDAO {
	final String INSERT = """
			INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur)
			   					VALUES  (?     , ?  , ?     , ?    ,?         , ?  , ?          , ?    , ?			 , ?	 , ?);
			""";

	final String DELETE = "DELETE	FROM UTILISATEURS WHERE no_utilisateur = ?;";

	final String UPDATE = """
			UPDATE UTILISATEURS
			SET pseudo			= ?,
				nom				= ?,
				prenom			= ?,
				email			= ?,
				telephone		= ?,
				rue				= ?,
				code_postal		= ?,
				ville			= ?,
				mot_de_passe	= ?,
				credit			= ?,
				administrateur	= ?
			WHERE no_utilisateur = ?;
			""";
	final String SELECT_BY_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?;";
	final String SELECT_ARTICLE_ENCHERE_BY_ID = """
			SELECT * FROM UTILISATEURS
			INNER JOIN ENCHERES e ON u.no_utilisateur=e.no_utilisateur
			INNER JOIN ARTICLES_VENDUS a ON u.no_utilisateur= a.no_utilisateur
			WHERE e.no_utilisateur=?""";

	final String SELECT_ALL = "SELECT * FROM UTILISATEURS;";
	final String SELECT_LOGGIN_PASSWORD = "SELECT * FROM UTILISATEURS u WHERE u.pseudo = ? AND u.mot_de_passe = ?";

	private EncheresDAO daoEnchere = DAOFact.getEncheresDAO();
	private ArticleVendusDAO daoArticle = DAOFact.getArticleVenduDAO();

	@Override
	public void insert(Utilisateur utilisateur) throws DalException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getNom());
			stmt.setString(3, utilisateur.getPrenom());
			stmt.setString(4, utilisateur.getEmail());
			stmt.setString(5, utilisateur.getTelephone());
			stmt.setString(6, utilisateur.getRue());
			stmt.setString(7, utilisateur.getCode_postal());
			stmt.setString(8, utilisateur.getVille());
			stmt.setString(9, utilisateur.getMot_de_passe());
			stmt.setInt(10, utilisateur.getCredit());
			stmt.setBoolean(11, utilisateur.getAdministrateur());
			int nb = stmt.executeUpdate();

			if (nb > 0) {
				ResultSet rs = stmt.getGeneratedKeys();

				if (rs.next()) {
					utilisateur.setNo_utilisateur(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}
	}

	@Override
	public void delete(int id) throws DalException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(DELETE);
			stmt.setInt(1, id);
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}
	}

	public void update(Utilisateur utilisateur) throws DalException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, utilisateur.getNo_utilisateur());
			stmt.setString(2, utilisateur.getPseudo());
			stmt.setString(3, utilisateur.getNom());
			stmt.setString(4, utilisateur.getPrenom());
			stmt.setString(5, utilisateur.getEmail());
			stmt.setString(6, utilisateur.getTelephone());
			stmt.setString(7, utilisateur.getRue());
			stmt.setString(8, utilisateur.getCode_postal());
			stmt.setString(9, utilisateur.getVille());
			stmt.setString(10, utilisateur.getMot_de_passe());
			stmt.setInt(11, utilisateur.getCredit());
			stmt.setBoolean(12, utilisateur.getAdministrateur());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}
	}
//
//	@Override
//	public Utilisateur findUtilisateurByNo(int id) throws DalException {
//		Utilisateur result = new Utilisateur();
//
//		try (Connection con = ConnectionProvider.getConnection()) {
//			PreparedStatement stmt = con.prepareStatement(SELECT_ARTICLE_ENCHERE_BY_ID);
//			stmt.setInt(1, id);
//			ResultSet rs = stmt.executeQuery();
//
//			while (rs.next()) {
//				Enchere enchere= new Enchere();
//				enchere(rs.getInt("no_enchere"), rs.getDate("date_enchere"), rs.getInt("montant_enchere"));
//				List<ArticlesVendu> articles = daoArticle.findByUtilisateurByNo(rs.getInt("no_utilisateur"));
//				if(rs.)
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new DalException(e.getMessage());
//		}
//		result = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"),
//				rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
//				rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),
//				rs.getInt("credit"), rs.getBoolean("administrateur"), encheres, articles);
//
//		return result;
//	}

	@Override
	public Utilisateur findUtilisateurByNo(int id) throws DalException {
		Utilisateur result = new Utilisateur();

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_ID);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				List<Enchere> encheres = daoEnchere.findEnchereByUserId(rs.getInt("no_utilisateur"));
				List<ArticlesVendu> articles = daoArticle.findByUtilisateurByNo(rs.getInt("no_utilisateur"));
				result = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"),
						rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
						rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),
						rs.getInt("credit"), rs.getBoolean("administrateur"), encheres, articles);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}

		return result;
	}

	@Override
	public List<Utilisateur> getAll() throws DalException {
		List<Utilisateur> result = new ArrayList<>();

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_ALL);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Utilisateur utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"),
						rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"),
						rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"),
						rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur"));
				result.add(utilisateur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}

		return result;
	}

	@Override
	public Utilisateur check(String login, String password) throws DalException {
//		List<User> users = dao.findByLoginAndPassword(login, password);
		Utilisateur result = new Utilisateur();

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_LOGGIN_PASSWORD);
			stmt.setString(1, login);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				result = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"),
						rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
						rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),
						rs.getInt("credit"), rs.getBoolean("administrateur"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}

		return result;
	}
}
