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
	final String INSERT					= """
			INSERT INTO ENCHERES	(no_utilisateur, no_article, date_enchere, montant_enchere)
						VALUES		(?			   , ?		   , ?			 , ?);
			""";
	final String DELETE					= "DELETE FROM ENCHERES WHERE no_enchere = ?;";
	final String SELECT_ALL				= "SELECT * FROM ENCHERES;";
	final String SELECT_BY_NO_ARTICLE	= "SELECT * FROM ENCHERES WHERE no_article=?;";
	final String SELECT_BY_NO_USER		= "SELECT * FROM ENCHERES WHERE no_utilisateur = ?";
	final String SELECT_BY_NO_ENCHERE	= "SELECT * FROM ENCHERES WHERE no_enchere = ?";

	@Override
	public void insert(Encheres encheres) throws DalException {
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
	public List<Encheres> getAll() throws DalException {
		List<Encheres> result = new ArrayList<>();
		
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_ALL);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				java.sql.Timestamp timestamp = rs.getTimestamp("date_enchere");
				LocalDateTime localDateTime = timestamp.toLocalDateTime();
				Encheres encheres = new Encheres(rs.getInt("no_utilisateur"),
						rs.getInt("no_article"), localDateTime, rs.getInt("montant_enchere"));
				encheres.setNo_enchere(rs.getInt("no_enchere"));
				result.add(encheres);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}
		
		return result;
	}

	@Override                          
	public List<Encheres> findEnchereByArticleId(int id) throws DalException {
		List<Encheres> result = new ArrayList<>();

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_NO_ARTICLE);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				java.sql.Timestamp timestamp = rs.getTimestamp("date_enchere");
				LocalDateTime localDateTime = timestamp.toLocalDateTime();
				Encheres encheres = new Encheres(rs.getInt("no_utilisateur"),
						rs.getInt("no_article"), localDateTime, rs.getInt("montant_enchere"));
				encheres.setNo_enchere(rs.getInt("no_enchere"));
				result.add(encheres);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}
		
		return result;
	}
	
	@Override                          
	public Encheres findEnchereById(int id) throws DalException {
		Encheres result = new Encheres();

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_NO_ENCHERE);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				java.sql.Timestamp timestamp = rs.getTimestamp("date_enchere");
				LocalDateTime localDateTime = timestamp.toLocalDateTime();
				Encheres encheres = new Encheres(rs.getInt("no_utilisateur"),
						rs.getInt("no_article"), localDateTime, rs.getInt("montant_enchere"));
				encheres.setNo_enchere(rs.getInt("no_enchere"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}
		
		return result;
	}
	
	@Override                          
	public List<Encheres> findEnchereByUserId(int id) throws DalException {
		List<Encheres> result = new ArrayList<>();

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_NO_USER);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				java.sql.Timestamp timestamp = rs.getTimestamp("date_enchere");
				LocalDateTime localDateTime = timestamp.toLocalDateTime();
				Encheres encheres = new Encheres(rs.getInt("no_utilisateur"),
						rs.getInt("no_article"), localDateTime, rs.getInt("montant_enchere"));
				encheres.setNo_enchere(rs.getInt("no_enchere"));
				result.add(encheres);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}
		
		return result;
	}
}
