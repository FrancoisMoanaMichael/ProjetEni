package fr.eni.projetEni.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEni.bo.Encheres;
import fr.eni.projetEni.dal.DAOFact;
import fr.eni.projetEni.dal.DalException;
import fr.eni.projetEni.dal.EncheresDAO;

public class EnchereManagerImpl implements EnchereManager {
	private EncheresDAO dao = DAOFact.getEncheresDAO();

	@Override
	public List<Encheres> getAll() throws ManagerException {
		List<Encheres> lst = new ArrayList<Encheres>();
		
		try {
			lst = dao.getAll();
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		
		return lst;
	}

	@Override
	public List<Encheres> getEncheresByUsedID(int id) throws ManagerException {
		List<Encheres> lst = new ArrayList<Encheres>();
		
		try {
			lst = dao.findEnchereByUserId(id);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		
		return lst;
	}
	
	@Override
	public List<Encheres> getEncheresByArticleID(int id) throws ManagerException {
		List<Encheres> lst = new ArrayList<Encheres>();
		
		try {
			lst = dao.findEnchereByArticleId(id);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		
		return lst;
	}

	@Override
	public Encheres getEncheresByID(int id) throws ManagerException {
		Encheres result = null;
		
		try {
			result = dao.findEnchereById(id);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		
		return result;
	}

	

	@Override
	public void addEnchere(Encheres enchere) throws ManagerException {
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
