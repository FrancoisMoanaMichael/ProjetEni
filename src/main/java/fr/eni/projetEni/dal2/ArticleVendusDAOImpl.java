package fr.eni.projetEni.dal2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEni.bo2.ArticlesVendu;
import fr.eni.projetEni.bo2.Categorie;
import fr.eni.projetEni.bo2.Retrait;
import fr.eni.projetEni.bo2.Utilisateur;
import fr.eni.projetEni.utils.ConnectionProvider;

public class ArticleVendusDAOImpl implements ArticleVendusDAO {
	final String INSERT = """
			INSERT INTO ARTICLES_VENDUS (nom_article, description   , date_debut_encheres   , date_fin_encheres , prix_initial  , prix_vente, no_utilisateur, no_categorie)
								VALUES  (?          , ?             , ?                     , ?                 ,?              , ?         , ?             , ?);
			""";
	final String DELETE = "DELETE FROM ARTICLES_VENDUS WHERE no_article = ?;";
	final String SELECT_BY_ID_ARTICLE = "SELECT * FROM ARTICLES_VENDUS WHERE no_article = ?;";
	final String SELECT_FULL_BY_ID_ARTICLE = """
			SELECT  a.*, u.nom, c.libelle AS nomCat, r.*  FROM ARTICLES_VENDUS a
			INNER JOIN RETRAITS r ON a.no_article = r.no_article
			INNER JOIN CATEGORIES c ON a.no_categorie = c.no_categorie
			INNER JOIN UTILISATEURS u ON a.no_utilisateur = u.no_utilisateur
			WHERE a.no_article=?;
			""";
	final String SELECT_ALL = """
			SELECT *
			FROM ARTICLES_VENDUS a
			INNER JOIN UTILISATEURS u ON a.no_utilisateur = u.no_utilisateur
			INNER JOIN CATEGORIES c ON a.no_categorie = c.no_categorie
			LEFT JOIN RETRAITS r ON r.no_article = a.no_article
			    """;
	final String SELECT_BY_ID_CATEGORIE = "SELECT * FROM ARTICLES_VENDUS WHERE no_categorie = ?;";
	final String SELECT_BY_ID_UTILISATEUR = "SELECT * FROM ARTICLES_VENDUS WHERE no_utilisateur = ?;";
	final String SELECT_FIN_ENCHERES = """
				SELECT *
				FROM ARTICLES_VENDUS	AS a
			    INNER JOIN UTILISATEURS	AS u ON a.no_utilisateur = u.no_utilisateur
				WHERE a.date_fin_encheres  <= GETDATE()
				  AND a.transaction_realise = 0;
			""";
	final String UPDATE = """
				UPDATE ARTICLES_VENDUS
				SET
					prix_vente			= ?,
					transaction_realise = ?
				WHERE no_article = ?
			""";

	@Override
	public void insert(ArticlesVendu articleVendus) throws DalException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, articleVendus.getNom_article());
			stmt.setString(2, articleVendus.getDescription());
			stmt.setDate(3, java.sql.Date.valueOf(articleVendus.getDate_debut_encheres()));
			stmt.setDate(4, java.sql.Date.valueOf(articleVendus.getDate_fin_encheres()));
			stmt.setInt(5, articleVendus.getPrix_initial());
			stmt.setInt(6, articleVendus.getPrix_vente());
			stmt.setInt(7, articleVendus.getUtilisateur().getNo_utilisateur());
			stmt.setInt(8, articleVendus.getCategorie().getNo_categorie());

			int nb = stmt.executeUpdate();
			if (nb > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					articleVendus.setNo_article(rs.getInt(1));
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

	@Override
	public void update(ArticlesVendu articleVendus) throws DalException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setInt(1, articleVendus.getPrix_vente());
			stmt.setBoolean(2, articleVendus.getTransaction_realise());
			stmt.setInt(3, articleVendus.getNo_article());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}
	}

	@Override
	public ArticlesVendu findFullByArticleByNo(int id) throws DalException {
		ArticlesVendu result = new ArticlesVendu();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_FULL_BY_ID_ARTICLE);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Retrait retrait = new Retrait(rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"));
				result = new ArticlesVendu(Integer.valueOf(rs.getInt("no_article")), rs.getString("nom_article"),
						rs.getString("description"), rs.getDate("date_debut_encheres").toLocalDate(),
						rs.getDate("date_fin_encheres").toLocalDate(), Integer.valueOf(rs.getInt("prix_initial")),
						Integer.valueOf(rs.getInt("prix_vente")), retrait,rs.getString("nomCat"), rs.getString("nom"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}

		return result;
	}

	@Override
	public ArticlesVendu findByArticleByNo(int id) throws DalException {
		ArticlesVendu result = new ArticlesVendu();

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_ID_ARTICLE);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				result = new ArticlesVendu(rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), rs.getDate("date_debut_encheres").toLocalDate(),
						rs.getDate("date_fin_encheres").toLocalDate(), rs.getInt("prix_initial"),
						rs.getInt("prix_vente"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}

		return result;
	}

	@Override
	public List<ArticlesVendu> getAll() throws DalException {
		List<ArticlesVendu> result = new ArrayList<>();

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_ALL);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ArticlesVendu article = map(rs);
				result.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<ArticlesVendu> findByCategorieByNo(int id) throws DalException {
		List<ArticlesVendu> result = new ArrayList<>();

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_ID_CATEGORIE);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ArticlesVendu article = new ArticlesVendu();
				article = new ArticlesVendu(rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), rs.getDate("date_debut_encheres").toLocalDate(),
						rs.getDate("date_fin_encheres").toLocalDate(), rs.getInt("prix_initial"),
						rs.getInt("prix_vente"));
				result.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}

		return result;
	}

	@Override
	public List<ArticlesVendu> findByUtilisateurByNo(int id) throws DalException {
		List<ArticlesVendu> result = new ArrayList<>();

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_ID_UTILISATEUR);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ArticlesVendu article = new ArticlesVendu();
				article = new ArticlesVendu(rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), rs.getDate("date_debut_encheres").toLocalDate(),
						rs.getDate("date_fin_encheres").toLocalDate(), rs.getInt("prix_initial"),
						rs.getInt("prix_vente"));
				result.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}

		return result;
	}

	public ArticlesVendu map(ResultSet rs) throws SQLException {
		Categorie categorie = new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"));
		Utilisateur utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"),
				rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"),
				rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),
				rs.getInt("credit"), rs.getBoolean("administrateur"));
		Retrait pointDeRetrait = new Retrait(rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"));
		ArticlesVendu article = new ArticlesVendu(rs.getInt("no_article"), rs.getString("nom_article"),
				rs.getString("description"), rs.getDate("date_debut_encheres").toLocalDate(),
				rs.getDate("date_fin_encheres").toLocalDate(), rs.getInt("prix_initial"), rs.getInt("prix_vente"),
				utilisateur, categorie, pointDeRetrait);
		return article;
	}

	@Override
	public List<ArticlesVendu> findTransaction() throws DalException {
		List<ArticlesVendu> result = new ArrayList<>();

<<<<<<< HEAD
        try (Connection con = ConnectionProvider.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(SELECT_FIN_ENCHERES);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	Utilisateur utilisateur = new Utilisateur(
						rs.getInt("no_utilisateur"),
						rs.getString("pseudo"),
						rs.getString("nom"),
						rs.getString("prenom"), 
						rs.getString("email"),
						rs.getString("telephone"),
						rs.getString("rue"),
						rs.getString("code_postal"),
						rs.getString("ville"),
						rs.getString("mot_de_passe"),
						rs.getInt("credit"),
						rs.getBoolean("administrateur"));
            	ArticlesVendu article = new ArticlesVendu(rs.getInt("no_article"), rs.getString("nom_article"), rs.getString("description"), rs.getDate("date_debut_encheres").toLocalDate(),
                		rs.getDate("date_fin_encheres").toLocalDate(), rs.getInt("prix_initial"), rs.getInt("prix_vente"));
            	article.setUtilisateur(utilisateur);
                result.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return result;
=======
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_FIN_ENCHERES);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Utilisateur utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"),
						rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"),
						rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"),
						rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur"));
				utilisateur.setNo_utilisateur(rs.getInt("no_utilisateur"));
				ArticlesVendu article = new ArticlesVendu(rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), rs.getDate("date_debut_encheres").toLocalDate(),
						rs.getDate("date_fin_encheres").toLocalDate(), rs.getInt("prix_initial"),
						rs.getInt("prix_vente"));
				result.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
>>>>>>> refs/heads/BrancheFrancois
	}
}
