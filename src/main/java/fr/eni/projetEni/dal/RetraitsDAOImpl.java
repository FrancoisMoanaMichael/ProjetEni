package fr.eni.projetEni.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import fr.eni.projetEni.bo.Retraits;
import fr.eni.projetEni.utils.ConnectionProvider;

public class RetraitsDAOImpl implements RetraitsDAO {
	final String INSERTE = "";
	final String SELECT = "SELECT no_article, rue , code_postal , ville FROM RETRAITS";
	final String DELETE = "DELETE FROM RETRAITS WHERE no_article = ?";
	final String SELECT_BY_ID = "SELECT no_article, rue , code_postal , ville FROM RETRAITS WHERE = no_article = ?";
	
	@Override
	public void insert(Retraits retraits) {
		try(Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt= con.prepareStatement(INSERTE, Statement.RETURN_GENERATED_KEYS );
			stmt.setString(1, retraits.getRue());
			stmt.setString(2, retraits.getCode_postal());
			stmt.setString(3, retraits.getVille());
			int nb = stmt.executeUpdate();
			if(nb>0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if(rs.next()) {
					retraits.setNo_article(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try(Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(DELETE);
			stmt.setInt(1, id);
			stmt.executeQuery();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Retraits findByArticleByNo(int id) {
		Retraits result = new Retraits();
		
		try(Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_ID);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                result = new Retraits(rs.getInt("no_article"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"));
            }
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	

	@Override
	public List<Retraits> getAll() {
		List<Retraits> result = new ArrayList<>();
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Retraits retraits = new Retraits(rs.getInt("no_article"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"));
				retraits.setNo_article(rs.getInt("no_article"));
				result.add(retraits);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
