package fr.eni.projetEni.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEni.bo2.Utilisateur;
import fr.eni.projetEni.dal.DAOFact;
import fr.eni.projetEni.dal.DalException;
import fr.eni.projetEni.dal.UtilisateursDAO;

public class UtilisateurManagerImpl implements UtilisateurManager {
	private UtilisateursDAO dao = DAOFact.getUtilisateursDAO();

	@Override
	public List<Utilisateur> getAllUtilisateurs() throws ManagerException {
		List<Utilisateur> lst = new ArrayList<Utilisateur>();
		
		try {
			lst = dao.getAll();
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		
		return lst;
	}

	@Override
	public Utilisateur getUtilisateur(int id) throws ManagerException {
		Utilisateur result = null;
		
		try {
			result = dao.findUtilisateurByNo(id);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		
		return result;
	}

	@Override
	public void addUtilisateur(Utilisateur utilisateur) throws ManagerException {
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
	public void majUtilisateur(Utilisateur utilisateur) throws ManagerException {
		try {
			dao.update(utilisateur);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
	}
	 
	@Override
	public Utilisateur check(String login, String mdp) throws ManagerException {
		Utilisateur result = null;
		try {
			result = dao.check(login, mdp);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		return result;
	}
	
}
