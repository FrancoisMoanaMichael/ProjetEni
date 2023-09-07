package fr.eni.projetEni.dal2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEni.bo2.ArticlesVendu;
import fr.eni.projetEni.bo2.Enchere;
import fr.eni.projetEni.bo2.Retrait;
import fr.eni.projetEni.bo2.Utilisateur;
import fr.eni.projetEni.utils.ConnectionProvider;

public class EncheresDAOImpl implements EncheresDAO {
	final String INSERT = """
			INSERT INTO ENCHERES	(no_utilisateur, no_article, date_enchere, montant_enchere)
						VALUES		(?			   , ?		   , ?			 , ?);
			""";
	final String DELETE = "DELETE FROM ENCHERES WHERE no_enchere = ?;";
	final String SELECT_ALL = "SELECT * FROM ENCHERES;";
	final String SELECT_BY_NO_ARTICLE = "SELECT * FROM ENCHERES WHERE no_article=?;";
	final String SELECT_ARTICLE_ENCHERE_BY_NO_ARTICLE = """
												SELECT e.no_enchere,a.*,e.date_enchere,e.montant_enchere, u.nom, c.libelle AS nomCat, r.* FROM ENCHERES e
			INNER JOIN ARTICLES_VENDUS a ON e.no_article= a.no_article
			INNER JOIN UTILISATEURS u ON a.no_utilisateur = u.no_utilisateur
			INNER JOIN CATEGORIES c ON a.no_categorie = c.no_categorie
			INNER JOIN RETRAITS r ON a.no_article = r.no_article
			WHERE e.no_article=?;
												""";
	final String SELECT_BY_NO_USER = "SELECT * FROM ENCHERES WHERE no_utilisateur = ?";
	final String SELECT_BY_NO_ENCHERE = "SELECT * FROM ENCHERES WHERE no_enchere = ?";
	final String UPDATE_BY_ID = "UPDATE ENCHERES SET no_utilisateur=?, montant_enchere=? WHERE no_enchere=?";
	final String SELECT_ENCHERE_GAGNANTE = """
			SELECT TOP 1 *
			FROM ENCHERES			AS e
			INNER JOIN UTILISATEURS AS u ON u.no_utilisateur = e.no_utilisateur
			WHERE e.no_article = ?
			ORDER BY e.montant_enchere DESC;
			""";

//	private UtilisateursDAO daoUtilisateur = DAOFact.getUtilisateursDAO();
//	private ArticleVendusDAO daoArticle = DAOFact.getArticleVenduDAO();

	@Override
	public void insert(Enchere encheres) throws DalException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, encheres.getUtilisateur().getNo_utilisateur());
			stmt.setInt(2, encheres.getArticle().getNo_article());

			LocalDateTime ldt = encheres.getDate_enchere();
			java.sql.Date sqlDate = java.sql.Date.valueOf(ldt.toLocalDate());
			stmt.setDate(3, sqlDate);

			stmt.setInt(4, encheres.getMontant_enchere());

			int nb = stmt.executeUpdate();
			if (nb > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					encheres.setNo_enchere(rs.getInt(1));
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
	public List<Enchere> getAll() throws DalException {
		List<Enchere> result = new ArrayList<>();
		UtilisateursDAOImpl daoUtilisateur = new UtilisateursDAOImpl();
		ArticleVendusDAOImpl daoArticleVendus = new ArticleVendusDAOImpl();

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_ALL);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				java.sql.Timestamp timestamp = rs.getTimestamp("date_enchere");
				LocalDateTime localDateTime = timestamp.toLocalDateTime();
				Utilisateur utilisateur = daoUtilisateur.findUtilisateurByNo2(rs.getInt("no_utilisateur"));
				ArticlesVendu article = daoArticleVendus.findByArticleByNo(rs.getInt("no_article"));
				Enchere encheres = new Enchere(utilisateur, article, localDateTime, rs.getInt("montant_enchere"));
				encheres.setNo_enchere(rs.getInt("no_enchere"));
				// Enchere encheres = new Enchere(rs.getInt("no_enchere"), localDateTime,
				// rs.getInt("montant_enchere"));
				result.add(encheres);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}

		return result;
	}

//	@Override
//	public List<Enchere> findEnchereByArticleId(int id) throws DalException {
//		Enchere result = new Enchere();
//		ArticlesVendu article = new ArticlesVendu()
//		Retrait retrait= new Retrait()
//		UtilisateursDAOImpl daoUtilisateur = new UtilisateursDAOImpl();
//		ArticleVendusDAOImpl daoArticleVendus = new ArticleVendusDAOImpl();

//		try (Connection con = ConnectionProvider.getConnection()) {
//			PreparedStatement stmt = con.prepareStatement(SELECT_ARTICLE_ENCHERE_BY_NO_ARTICLE);
//			stmt.setInt(1, id);
//
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				java.sql.Timestamp timestamp = rs.getTimestamp("date_enchere");
//				LocalDateTime localDateTime = timestamp.toLocalDateTime();
////				
////				java.sql.Timestamp timestampArticle = rs.getTimestamp("date_fin_encheres");
////				LocalDate localDateTimeArticle = timestampArticle.tol();
//				
////				Utilisateur utilisateur = daoUtilisateur.findUtilisateurByNo2(rs.getInt("no_utilisateur"));
////				ArticlesVendu article	= daoArticleVendus.findByArticleByNo(rs.getInt("no_article"));
////				Enchere encheres = new Enchere(utilisateur, article, localDateTime, rs.getInt("montant_enchere"));
//				Retrait retrait = new Retrait( rs.getInt("no_article"),rs.getString("rue"), rs.getString("code_postal"), rs.getString("vill"));
//				ArticlesVendu article = new ArticlesVendu(rs.getString("nom_article"),rs.getString("description"), localDateTimeArticle, rs.getInt("prix_initial"),rs.getInt("prix_vente"),rs.getString("nomCat"),retrait);
//				Enchere enchere = new Enchere(rs.getInt("no_enchere"), rs.getString("nomUtilisateur"), rs.getString("nomCat"),article,localDateTime, rs.getInt("montant_enchere");
//				result.add(enchere);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new DalException(e.getMessage());
//		}
//
//		return result;
//	}
////	
	@Override
	public List<Enchere> findEnchereByArticleId(int id) throws DalException {
		List<Enchere> result = new ArrayList<>();
		UtilisateursDAOImpl daoUtilisateur = new UtilisateursDAOImpl();
		ArticleVendusDAOImpl daoArticleVendus = new ArticleVendusDAOImpl();
		
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_NO_ARTICLE);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				java.sql.Timestamp timestamp = rs.getTimestamp("date_enchere");
				LocalDateTime localDateTime = timestamp.toLocalDateTime();
				Utilisateur utilisateur = daoUtilisateur.findUtilisateurByNo2(rs.getInt("no_utilisateur"));
				ArticlesVendu article = daoArticleVendus.findByArticleByNo(rs.getInt("no_article"));
				Enchere encheres = new Enchere(utilisateur, article, localDateTime, rs.getInt("montant_enchere"));
				result.add(encheres);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}
		
		return result;
	}

	@Override
	public Enchere findEnchereById(int id) throws DalException {
		Enchere enchere = new Enchere();
		UtilisateursDAOImpl daoUtilisateur = new UtilisateursDAOImpl();
		ArticleVendusDAOImpl daoArticleVendus = new ArticleVendusDAOImpl();

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_NO_ENCHERE);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				java.sql.Timestamp timestamp = rs.getTimestamp("date_enchere");
				LocalDateTime localDateTime = timestamp.toLocalDateTime();
//				Utilisateur utilisateur = daoUtilisateur.findUtilisateurByNo(rs.getInt("no_utilisateur"));
//				ArticlesVendu article	= daoArticle.findByArticleByNo(rs.getInt("no_article"));
//				Enchere encheres = new Enchere(utilisateur, article
//						, localDateTime, rs.getInt("montant_enchere"));
//				encheres.setNo_enchere(rs.getInt("no_enchere"));
				// Enchere encheres = new Enchere(rs.getInt("no_enchere"), localDateTime,
				// rs.getInt("montant_enchere"));
				System.out.println(rs.getInt("no_utilisateur"));

				Utilisateur utilisateur = daoUtilisateur.findUtilisateurByNo2(rs.getInt("no_utilisateur"));
				ArticlesVendu article = daoArticleVendus.findByArticleByNo(rs.getInt("no_article"));
				enchere = new Enchere(utilisateur, article, localDateTime, rs.getInt("montant_enchere"));
				enchere.setNo_enchere(rs.getInt("no_enchere"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}
		System.out.println("   coucou   " + id + " --- " + String.valueOf(enchere));
		return enchere;
	}

	@Override
	public List<Enchere> findEnchereByUserId(int id) throws DalException {
		List<Enchere> result = new ArrayList<>();
		UtilisateursDAOImpl daoUtilisateur = new UtilisateursDAOImpl();
		ArticleVendusDAOImpl daoArticleVendus = new ArticleVendusDAOImpl();

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_NO_USER);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				java.sql.Timestamp timestamp = rs.getTimestamp("date_enchere");
				LocalDateTime localDateTime = timestamp.toLocalDateTime();
				Utilisateur utilisateur = daoUtilisateur.findUtilisateurByNo2(rs.getInt("no_utilisateur"));
				ArticlesVendu article = daoArticleVendus.findByArticleByNo(rs.getInt("no_article"));
				Enchere encheres = new Enchere(utilisateur, article, localDateTime, rs.getInt("montant_enchere"));
				encheres.setNo_enchere(rs.getInt("no_enchere"));

				// Enchere encheres = new Enchere(rs.getInt("no_enchere"), localDateTime,
				// rs.getInt("montant_enchere"));
				result.add(encheres);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}

		return result;
	}

	@Override
	public void update(Enchere enchere) throws DalException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(UPDATE_BY_ID);
			stmt.setInt(1, enchere.getNo_utilisateur());
			stmt.setInt(2, enchere.getMontant_enchere());
			stmt.setInt(3, enchere.getNo_enchere());

			int nb = stmt.executeUpdate();

			if (nb == 0) {
				throw new DalException("Aucune ligne mise à jour, vérifiez l'ID.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}
	}

	@Override
	public Enchere findEnchereGagnante(int id) throws DalException {
		Enchere enchere = new Enchere();
		ArticleVendusDAOImpl daoArticleVendus = new ArticleVendusDAOImpl();

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_ENCHERE_GAGNANTE);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				java.sql.Timestamp timestamp = rs.getTimestamp("date_enchere");
				LocalDateTime localDateTime = timestamp.toLocalDateTime();

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
				ArticlesVendu article = daoArticleVendus.findByArticleByNo(rs.getInt("no_article"));
				enchere = new Enchere(utilisateur, article, localDateTime, rs.getInt("montant_enchere"));
				enchere.setNo_enchere(rs.getInt("no_enchere"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}

		return enchere;
	}

}
