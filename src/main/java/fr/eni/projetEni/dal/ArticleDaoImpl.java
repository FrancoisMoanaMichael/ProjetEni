package fr.eni.projetEni.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.eni.projetEni.bo.ARTICLES_VENDUS;
import fr.eni.projetEni.utils.ConnectionProvider;

public class ArticleDaoImpl implements ArticleVendusDao {
	final String INSERT = """ 
							INSERT INTO ARTICLES_VENDUS (nom_article, description   , date_debut_encheres   , date_fin_encheres , prix_initial  , prix_vente, no_utilisateur, no_categorie)
						    VALUES  (?          , ?             , ?                     , ?                 ,?              , ?         , ?             , ?);			
							""";
	final String DELETE ="DELETE FROM ARTICLES_VENDUS WHERE no_article = ?;";
	final String SELECT_BY_ID = "SELECT * FROM ARTICLES_VENDUS WHERE no_article = ?;";
	final String SELECT = "SELECT * FROM ARTICLES_VENDUS;";


	
	@Override
	public void insert(ARTICLES_VENDUS articleVendus) {
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, articleVendus.getNom_article() );
			stmt.setString(2, articleVendus.getDescription() );
			stmt.setDate(3,java.sql.Date.valueOf( articleVendus.getDate_debut_encheres()));
			stmt.setDate(4,java.sql.Date.valueOf( articleVendus.getDate_fin_encheres()));
			stmt.setInt(5, articleVendus.getPrix_initial());
			stmt.setInt(6, articleVendus.getPrix_vente());
			stmt.setInt(7, articleVendus.getNo_utilisateur());
			stmt.setInt(8, articleVendus.getNo_categorie());
			int nb = stmt.executeUpdate();
			if(nb>0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if(rs.next()) {
					articleVendus.setNo_article(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(ARTICLES_VENDUS articleVendus) {
		

	}

	@Override
	public ARTICLES_VENDUS findByArticleByNo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ARTICLES_VENDUS> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}