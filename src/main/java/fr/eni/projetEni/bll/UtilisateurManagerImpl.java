package fr.eni.projetEni.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEni.bo.Utilisateurs;
import fr.eni.projetEni.dal.DAOFact;
import fr.eni.projetEni.dal.DalException;
import fr.eni.projetEni.dal.UtilisateursDAO;

public class UtilisateurManagerImpl implements UtilisateurManager {
	private UtilisateursDAO dao = DAOFact.getUtilisateursDAO();

	@Override
	public List<Utilisateurs> getAllUtilisateurs() throws ManagerException {
		List<Utilisateurs> lst = new ArrayList<Utilisateurs>();
		
		try {
			lst = dao.getAll();
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		
		return lst;
	}

	@Override
	public Utilisateurs getUtilisateur(int id) throws ManagerException {
		Utilisateurs result = null;
		
		try {
			result = dao.findUtilisateurByNo(id);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		
		return result;
	}

	@Override
	public void addUtilisateur(Utilisateurs utilisateur) throws ManagerException {
		try {
			dao.insert(utilisateur);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
	}

	@Override
	public void supprimerUtilisateur(int id) throws ManagerException {
		try {
			dao.delete(id);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
	}

	@Override
	public void majUtilisateur(Utilisateurs utilisateur) throws ManagerException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Utilisateurs check(String login, String mdp) throws ManagerException {
		Utilisateurs result = null;
		try {
			result = dao.check(login, mdp);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		return result;
	}
	
}
