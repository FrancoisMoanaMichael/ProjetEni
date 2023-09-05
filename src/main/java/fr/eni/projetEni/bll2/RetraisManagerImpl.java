package fr.eni.projetEni.bll2;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEni.bo.Retrait;
import fr.eni.projetEni.dal.DAOFact;
import fr.eni.projetEni.dal.DalException;
import fr.eni.projetEni.dal.RetraitsDAO;

public class RetraisManagerImpl implements RetraisManager {
	private RetraitsDAO dao = DAOFact.getRetraitsDAO();
	
	@Override
	public List<Retrait> getAllRetraits() throws ManagerException {
		List<Retrait> lst = new ArrayList<Retrait>();
		
		try {
			lst = dao.getAll();
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		
		return lst;
	}

	@Override
	public Retrait getRetraitsByArticleNo(int id) throws ManagerException {
		Retrait result = null;
		
		try {
			result = dao.findRetraitsByNoArticle(id);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		
		return result;
	}

	@Override
	public void addRetraits(Retrait retrait) throws ManagerException {
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
