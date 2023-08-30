package fr.eni.projetEni.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEni.bo.Utilisateurs;
import fr.eni.projetEni.utils.ConnectionProvider;

public class UtilisateursDAOImpl implements UtilisateursDAO {
	final String INSERT			= """ 
			INSERT INTO ARTICLES_VENDUS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur)
			   					VALUES  (?     , ?  , ?     , ?    ,?         , ?  , ?          , ?    , ?			 , ?	 , ?);			
			""";
	final String DELETE			= "DELETE	FROM UTILISATEURS WHERE no_utilisateur = ?;";
	final String UPDATE			= """ 
			UPDATE UTILISATEURS	
			SET pseudo			= ?,
				nom				= ?,
				prenom			= ?,
				email			= ?,
				telephone		= ?,
				rue				= ?,
				code_postal		= ?,
				ville			= ?,
				mot_de_passe	= ?,
				credit			= ?,
				administrateur	= ?)
			WHERE no_utilisateur = ?;			
			""";
	final String SELECT_BY_ID	= "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?;";
	final String SELECT_ALL		= "SELECT * FROM UTILISATEURS;";
	final String SELECT_LOGGIN_PASSWORD = "SELECT * FROM UTILISATEURS u WHERE u.pseudo = '?' AND u.mot_de_passe = '?'";
	
	
	@Override
	public void insert(Utilisateurs utilisateur) throws DalException {
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getNom());
			stmt.setString(3, utilisateur.getPrenom());
			stmt.setString(4, utilisateur.getEmail());
			stmt.setString(5, utilisateur.getTelephone());
			stmt.setString(6, utilisateur.getRue());
			stmt.setString(7, utilisateur.getCode_postal());
			stmt.setString(8, utilisateur.getVille());
			stmt.setString(9, utilisateur.getMot_de_passe());
			stmt.setInt(10, utilisateur.getCredit());
			stmt.setBoolean(11, utilisateur.getAdministrateur());
			int nb = stmt.executeUpdate();
			
			if(nb>0) {
				ResultSet rs = stmt.getGeneratedKeys();
				
				if(rs.next()) {
					utilisateur.setNo_utilisateur(rs.getInt(1));
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
	
	public void update(Utilisateurs utilisateur) throws DalException {
		try(Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getNom());
			stmt.setString(3, utilisateur.getPrenom());
			stmt.setString(4, utilisateur.getEmail());
			stmt.setString(5, utilisateur.getTelephone());
			stmt.setString(6, utilisateur.getRue());
			stmt.setString(7, utilisateur.getCode_postal());
			stmt.setString(8, utilisateur.getVille());
			stmt.setString(9, utilisateur.getMot_de_passe());
			stmt.setInt(10, utilisateur.getCredit());
			stmt.setBoolean(11, utilisateur.getAdministrateur());
			stmt.setInt(12, utilisateur.getNo_utilisateur());
			stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}
	}

	@Override
	public Utilisateurs findUtilisateurByNo(int id) throws DalException {
		Utilisateurs result = new Utilisateurs();
		
		try(Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_ID);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
            while(rs.next()) {
                result = new Utilisateurs(rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur"));
                result.setNo_utilisateur(rs.getInt("no_utilisateur"));
            }
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}
		
		return result;
	}

	@Override
	public List<Utilisateurs> getAll() throws DalException {
		List<Utilisateurs> result = new ArrayList<>();
		
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_ALL);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Utilisateurs utilisateur = new Utilisateurs(rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur"));
				utilisateur.setNo_utilisateur(rs.getInt("no_utilisateur"));
				result.add(utilisateur);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}
		
		return result;
	}
	
	@Override
	public Utilisateurs check(String login, String password) throws DalException {
//		List<User> users = dao.findByLoginAndPassword(login, password);
		Utilisateurs result = new Utilisateurs();
		
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_LOGGIN_PASSWORD);
			stmt.setString(1, login);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                result = new Utilisateurs(rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur"));
                result.setNo_utilisateur(rs.getInt("no_utilisateur"));
            }
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DalException(e.getMessage());
		}
		return result;
	}
}
