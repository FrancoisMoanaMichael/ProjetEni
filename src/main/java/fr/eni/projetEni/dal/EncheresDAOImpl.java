package fr.eni.projetEni.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEni.bo.Encheres;
import fr.eni.projetEni.utils.ConnectionProvider;

public class EncheresDAOImpl implements EncheresDAO {

	final String SELECT = "SELECT * FROM ENCHERES;";
	final String SELECT_BY_NO_ARTICLE = "SELECT no_enchere,"
			+ "          e.no_article, a.nom_article, a.description, a.date_debut_encheres, a.date_fin_encheres, a.prix_initial, a.prix_vente, a.etat_vente,"
			+ "          e.no_utilisateur, u.pseudo, u.nom, u.prenom, u.email, u.telephone, u.rue, u.code_postal, u.ville, u.mot_de_passe, u.credit, u.administrateur,"
			+ "          no_categorie," + "          date_enchere, montant_enchere"
			+ "              FROM ENCHERES AS e INNER JOIN UTILISATEURS AS u ON e.no_utilisateur=u.no_utilisateur"
			+ "                                 INNER JOIN ARTICLES_VENDUS as a on e.no_article = a.no_article"
			+ "                    where e.no_article=?;";
	final String INSERT = "INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) values (?, ?, ?, ?);";
	final String SELECT_BY_NO_ENCHERE = "SELECT * FROM ENCHERES WHERE no_enchere = ?";
	final String SELECT_BY_NO_USER = "SELECT * FROM ENCHERES WHERE no_utilisateur = ?";
	final String DELETE_BY_NO ="DELETE FROM ENCHERES WHERE no_enchere = ?;";

	@Override
	public void insert(Encheres encheres) {
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, encheres.getNo_utilisateur() );
			stmt.setInt(2, encheres.getNo_article() );
			
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Encheres> getAll() {
		List<Encheres> result = new ArrayList<>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				java.sql.Timestamp timestamp = rs.getTimestamp("date_enchere");
				LocalDateTime localDateTime = timestamp.toLocalDateTime();
				Encheres encheres = new Encheres(rs.getInt("no_enchere"), rs.getInt("no_utilisateur"),
						rs.getInt("no_article"), localDateTime, rs.getInt("montant_enchere"));
				result.add(encheres);
			}
		} catch (SQLException e) {
//			throw new DALException("ms_insert");
			e.printStackTrace();
		}
		return result;
	}

	@Override                          
	public Encheres findEnchereByArticleId(int id) {
		Encheres result = new Encheres();

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_NO_ARTICLE);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				java.sql.Timestamp timestamp = rs.getTimestamp("date_enchere");
				LocalDateTime localDateTime = timestamp.toLocalDateTime();
				result = new Encheres(rs.getInt("no_enchere"), rs.getInt("no_utilisateur"), rs.getInt("no_article"),
						localDateTime, rs.getInt("montant_enchere"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@Override                          
	public Encheres findEnchereById(int id) {
		Encheres result = new Encheres();

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_NO_ENCHERE);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				java.sql.Timestamp timestamp = rs.getTimestamp("date_enchere");
				LocalDateTime localDateTime = timestamp.toLocalDateTime();
				result = new Encheres(rs.getInt("no_enchere"), rs.getInt("no_utilisateur"), rs.getInt("no_article"),
						localDateTime, rs.getInt("montant_enchere"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public void deleteEnchereById(int id) {
		try(Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(DELETE_BY_NO);
			stmt.setInt(1, id);
			stmt.executeQuery();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override                          
	public Encheres findEnchereByUserId(int id) {
		Encheres result = new Encheres();

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_NO_USER);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				java.sql.Timestamp timestamp = rs.getTimestamp("date_enchere");
				LocalDateTime localDateTime = timestamp.toLocalDateTime();
				result = new Encheres(rs.getInt("no_enchere"), rs.getInt("no_utilisateur"), rs.getInt("no_article"),
						localDateTime, rs.getInt("montant_enchere"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	

}
