package fr.eni.projetEni.dal2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEni.bo2.ArticlesVendu;
import fr.eni.projetEni.bo2.Enchere;
import fr.eni.projetEni.bo2.Utilisateur;
import fr.eni.projetEni.utils.ConnectionProvider;

public class EncheresDAOImpl implements EncheresDAO {
	final String INSERT					= """
			INSERT INTO ENCHERES	(no_utilisateur, no_article, date_enchere, montant_enchere)
						VALUES		(?			   , ?		   , ?			 , ?);
			""";
	final String DELETE					= "DELETE FROM ENCHERES WHERE no_enchere = ?;";
	final String SELECT_ALL				= "SELECT * FROM ENCHERES;";
	final String SELECT_BY_NO_ARTICLE	= "SELECT * FROM ENCHERES WHERE no_article=?;";
	final String SELECT_BY_NO_USER		= "SELECT * FROM ENCHERES WHERE no_utilisateur = ?";
	final String SELECT_BY_NO_ENCHERE	= "SELECT * FROM ENCHERES WHERE no_enchere = ?";
	
//	private UtilisateursDAO daoUtilisateur = DAOFact.getUtilisateursDAO();
//	private ArticleVendusDAO daoArticle = DAOFact.getArticleVenduDAO();


	@Override
	public void insert(Enchere encheres) throws DalException {
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, encheres.getUtilisateur().getNo_utilisateur() );
			stmt.setInt(2, encheres.getArticle().getNo_article() );
			
			LocalDateTime ldt = encheres.getDate_enchere();
			java.sql.Date sqlDate = java.sql.Date.valueOf(ldt.toLocalDate());
			stmt.setDate(3, sqlDate);
			
			stmt.setInt(4, encheres.getMontant_enchere());
			
			int nb = stmt.executeUpdate();
			if(nb>0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if(rs.next()) {
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
		try(Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(DELETE);
			stmt.setInt(1, id);
			stmt.executeQuery();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}
	}
	
	@Override
	public List<Enchere> getAll() throws DalException {
		List<Enchere> result = new ArrayList<>();
		
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_ALL);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				java.sql.Timestamp timestamp = rs.getTimestamp("date_enchere");
				LocalDateTime localDateTime = timestamp.toLocalDateTime();
//				Utilisateur utilisateur = daoUtilisateur.findUtilisateurByNo(rs.getInt("no_utilisateur"));
//				ArticlesVendu article	= daoArticle.findByArticleByNo(rs.getInt("no_article"));
//				Enchere encheres = new Enchere(utilisateur, article
//						, localDateTime, rs.getInt("montant_enchere"));
//				encheres.setNo_enchere(rs.getInt("no_enchere"));
				Enchere encheres = new Enchere(rs.getInt("no_enchere"), localDateTime, rs.getInt("montant_enchere"));
				result.add(encheres);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}
		
		return result;
	}

	@Override                          
	public List<Enchere> findEnchereByArticleId(int id) throws DalException {
		List<Enchere> result = new ArrayList<>();

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_NO_ARTICLE);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				java.sql.Timestamp timestamp = rs.getTimestamp("date_enchere");
				LocalDateTime localDateTime = timestamp.toLocalDateTime();
//				Utilisateur utilisateur = daoUtilisateur.findUtilisateurByNo(rs.getInt("no_utilisateur"));
//				ArticlesVendu article	= daoArticle.findByArticleByNo(rs.getInt("no_article"));
//				Enchere encheres = new Enchere(utilisateur, article
//						, localDateTime, rs.getInt("montant_enchere"));
				Enchere encheres = new Enchere(rs.getInt("no_enchere"), localDateTime, rs.getInt("montant_enchere"));
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
		Enchere result = new Enchere();

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
				Enchere encheres = new Enchere(rs.getInt("no_enchere"), localDateTime, rs.getInt("montant_enchere"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}
		
		return result;
	}
	
	@Override                          
	public List<Enchere> findEnchereByUserId(int id) throws DalException {
		List<Enchere> result = new ArrayList<>();

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_NO_USER);
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
				Enchere encheres = new Enchere(rs.getInt("no_enchere"), localDateTime, rs.getInt("montant_enchere"));
				result.add(encheres);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}
		
		return result;
	}
}
