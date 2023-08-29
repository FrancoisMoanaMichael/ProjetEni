package fr.eni.projetEni.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEni.bo.Categories;
import fr.eni.projetEni.utils.ConnectionProvider;

public class CategorieDAOImpl implements CategorieDAO {
	final String INSERT						= """
				INSERT INTO CATEGORIES	(libelle)
								VALUES	(?);
			""";
	final String UPDATE						= """
			UPDATE CATEGORIES	
			SET libelle = ?
			WHERE no_categorie = ?;
		""";
	final String DELETE						= "DELETE	FROM CATEGORIES WHERE no_categorie = ?;";
	final String SELECT_ALL					= "SELECT * FROM CATEGORIES;";
	final String SELECT_CATEGORIE_BY_ID		= "SELECT * FROM CATEGORIES WHERE no_categorie = ?;";
	final String SELECT_CATEGORIE_BY_NAME	= "SELECT * FROM CATEGORIES WHERE libelle = ?;";
	
	@Override
	public void insert(Categories categorie) throws DalException {
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, categorie.getLibelle());
			int nb = stmt.executeUpdate();
			
			if(nb>0) {
				ResultSet rs = stmt.getGeneratedKeys();
				
				if(rs.next()) {
					categorie.setNo_categorie(rs.getInt(1));
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}
	}

	@Override
	public void update(Categories categorie) throws DalException {
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, categorie.getLibelle());
			stmt.setInt(2, categorie.getNo_categorie());
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
	public List<Categories> getAll() throws DalException {
		List<Categories> result = new ArrayList<>();
		
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_ALL);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Categories categories = new Categories(rs.getString("libelle"));
				result.add(categories);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}
		
		return result;
	}

	@Override
	public Categories findByNo(int id) throws DalException {
		Categories result = new Categories();
		
		try(Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_CATEGORIE_BY_ID);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                result = new Categories(rs.getString("libelle"));
            }
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}
		
		return result;
	}
	
	@Override
	public Categories findByName(String name) throws DalException {
		Categories result = new Categories();
		
		try(Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_CATEGORIE_BY_NAME);
			stmt.setString(1, name);
			
			ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                result = new Categories(rs.getString("libelle"));
            }
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}
		
		return result;
	}
}
