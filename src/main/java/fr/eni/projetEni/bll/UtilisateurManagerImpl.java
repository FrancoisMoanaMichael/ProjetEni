package fr.eni.projetEni.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEni.bo.UTILISATEURS;
import fr.eni.projetEni.dal.DAOFact;
import fr.eni.projetEni.dal.DalException;
import fr.eni.projetEni.dal.UtilisateursDAO;

public class UtilisateurManagerImpl implements UtilisateurManager {
	private UtilisateursDAO dao = DAOFact.getUtilisateursDAO();

	@Override
	public List<UTILISATEURS> getAllUtilisateurs() throws ManagerException {
		List<UTILISATEURS> lst = new ArrayList<UTILISATEURS>();
		
		try {
			lst = dao.getAll();
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		
		return lst;
	}

	@Override
	public UTILISATEURS getUtilisateur(int id) throws ManagerException {
		UTILISATEURS result = null;
		
		try {
			result = dao.findUtilisateurByNo(id);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		
		return result;
	}

	@Override
	public void addUtilisateur(UTILISATEURS utilisateur) throws ManagerException {
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
	public void majUtilisateur(UTILISATEURS utilisateur) throws ManagerException {
		// TODO Auto-generated method stub
		
	}

}
