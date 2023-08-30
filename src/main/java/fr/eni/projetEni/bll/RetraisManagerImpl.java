package fr.eni.projetEni.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEni.bo.Retraits;
import fr.eni.projetEni.dal.DAOFact;
import fr.eni.projetEni.dal.DalException;
import fr.eni.projetEni.dal.RetraitsDAO;

public class RetraisManagerImpl implements RetraisManager {
	private RetraitsDAO dao = DAOFact.getRetraitsDAO();
	
	@Override
	public List<Retraits> getAllRetraits() throws ManagerException {
		List<Retraits> lst = new ArrayList<Retraits>();
		
		try {
			lst = dao.getAll();
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		
		return lst;
	}

	@Override
	public Retraits getRetraitsByArticleNo(int id) throws ManagerException {
		Retraits result = null;
		
		try {
			result = dao.findRetraitsByNoArticle(id);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		
		return result;
	}

	@Override
	public void addRetraits(Retraits retrait) throws ManagerException {
		try {
			dao.insert(retrait);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
	}

	@Override
	public void supprimerRetraits(int id) throws ManagerException {
		try {
			dao.delete(id);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
	}
}
