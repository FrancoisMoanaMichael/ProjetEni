package fr.eni.projetEni.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEni.bo.Categories;
import fr.eni.projetEni.utils.ConnectionProvider;

public class CategorieDAOImpl implements CategorieDAO {
	
	final String SELECT = "SELECT * FROM CATEGORIES;";
	final String SELECT_CATEGORIE_BY_ID = "SELECT * FROM CATEGORIES WHERE NO_CATEGORIE = ?;";
	final String SELECT_CATEGORIE_BY_NAME = "SELECT * FROM CATEGORIES WHERE LIBELLE = ?;";
	

	@Override
	public Categories findByNo(int id) {
		Categories result = new Categories();
		
		try(Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_CATEGORIE_BY_ID);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                result = new Categories(rs.getString("libelle"));
                result.setNo_categorie(rs.getInt("no_categorie"));
            }
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public Categories findByName(String name) {
		Categories result = new Categories();
		
		try(Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_CATEGORIE_BY_NAME);
			stmt.setString(1, name);
			
			ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                result = new Categories(rs.getString("libelle"));
                result.setNo_categorie(rs.getInt("no_categorie"));
            }
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<Categories> getAll() {
		List<Categories> result = new ArrayList<>();
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Categories categories = new Categories(rs.getString("libelle"));
				result.add(categories);
			}
		}
		catch(SQLException e) {
//			throw new DALException("ms_insert");
			e.printStackTrace();
		}
		return result;
	}
	
	
}
