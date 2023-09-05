package fr.eni.projetEni.dal2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEni.bo2.ArticlesVendu;
import fr.eni.projetEni.bo2.Categorie;
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
	
	private ArticleVendusDAO dao = DAOFact.getArticleVenduDAO();
	
	@Override
	public void insert(Categorie categorie) throws DalException {
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
	public void update(Categorie categorie) throws DalException {
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
	public List<Categorie> getAll() throws DalException {
		List<Categorie> result = new ArrayList<>();
		
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_ALL);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				//List<ArticlesVendu> articles = dao.findByCategorieByNo(rs.getInt("no_categorie")); 
				//Categorie categories = new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"), articles);
				Categorie categories = new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"));
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
	public Categorie findByNo(int id) throws DalException {
		Categorie result = new Categorie();
		
		try(Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_CATEGORIE_BY_ID);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
            	//List<ArticlesVendu> articles = dao.findByCategorieByNo(rs.getInt("no_categorie"));
                //result = new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"), articles);
                result = new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"));
            }
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}
		
		return result;
	}
	
	@Override
	public Categorie findByName(String name) throws DalException {
		Categorie result = new Categorie();
		
		try(Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_CATEGORIE_BY_NAME);
			stmt.setString(1, name);
			
			ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
            	//List<ArticlesVendu> articles = dao.findByCategorieByNo(rs.getInt("no_categorie"));
                //result = new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"), articles);
                result = new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"));
            }
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}
		
		return result;
	}
}
