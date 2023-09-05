package fr.eni.projetEni.bll2;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEni.bo.Enchere;
import fr.eni.projetEni.dal.DAOFact;
import fr.eni.projetEni.dal.DalException;
import fr.eni.projetEni.dal.EncheresDAO;

public class EnchereManagerImpl implements EnchereManager {
	private EncheresDAO dao = DAOFact.getEncheresDAO();

	@Override
	public List<Enchere> getAll() throws ManagerException {
		List<Enchere> lst = new ArrayList<Enchere>();
		
		try {
			lst = dao.getAll();
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		
		return lst;
	}

	@Override
	public List<Enchere> getEncheresByUsedID(int id) throws ManagerException {
		List<Enchere> lst = new ArrayList<Enchere>();
		
		try {
			lst = dao.findEnchereByUserId(id);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		
		return lst;
	}
	
	@Override
	public List<Enchere> getEncheresByArticleID(int id) throws ManagerException {
		List<Enchere> lst = new ArrayList<Enchere>();
		
		try {
			lst = dao.findEnchereByArticleId(id);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		
		return lst;
	}

	@Override
	public Enchere getEncheresByID(int id) throws ManagerException {
		Enchere result = null;
		
		try {
			result = dao.findEnchereById(id);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		
		return result;
	}

	

	@Override
	public void addEnchere(Enchere enchere) throws ManagerException {
		try {
			dao.insert(enchere);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
	}

	@Override
	public void supprimerEnchere(int id) throws ManagerException {
		try {
			dao.delete(id);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
	}
}