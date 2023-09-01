package fr.eni.projetEni.dal2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEni.bo2.Retrait;
import fr.eni.projetEni.utils.ConnectionProvider;

public class RetraitsDAOImpl implements RetraitsDAO {
	final String INSERT			= """
			INSERT INTO RETRAITS	(no_article, rue, code_postal, ville)
							VALUES	(?		   , ?	, ?			 , ?)
			""";
	final String DELETE			= "DELETE FROM RETRAITS WHERE no_article = ?";
	final String SELECT_ALL		= "SELECT * FROM RETRAITS";
	final String SELECT_BY_ID	= "SELECT * FROM RETRAITS WHERE = no_article = ?";
	
	private ArticleVendusDAO dao = DAOFact.getArticleVenduDAO();
	
	@Override
	public void insert(Retrait retraits) throws DalException {
		try(Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt= con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS );
			stmt.setInt(1, retraits.getArticle().getNo_article());
			stmt.setString(2, retraits.getRue());
			stmt.setString(3, retraits.getCode_postal());
			stmt.setString(4, retraits.getVille());
			stmt.executeUpdate();
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
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}
	}

	@Override
	public Retrait findRetraitsByNoArticle(int id) throws DalException {
		Retrait result = new Retrait();
		
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_ID);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				result = new Retrait(dao.findByArticleByNo(rs.getInt("no_article")), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}
		
		return result;
	}

	@Override
	public List<Retrait> getAll() throws DalException {
		List<Retrait> result = new ArrayList<>();
		
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_ALL);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Retrait retrait = new Retrait(dao.findByArticleByNo(rs.getInt("no_article")), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"));
				result.add(retrait);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}
		
		return result;
	}
}
