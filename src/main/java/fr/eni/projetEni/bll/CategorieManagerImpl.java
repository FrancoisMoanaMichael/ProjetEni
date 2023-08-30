package fr.eni.projetEni.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEni.bo.Categories;
import fr.eni.projetEni.dal.CategorieDAO;
import fr.eni.projetEni.dal.DAOFact;
import fr.eni.projetEni.dal.DalException;

public class CategorieManagerImpl implements CategorieManager {
	private CategorieDAO dao = DAOFact.getCategorieDAO();
	
	@Override
	public void addCategorie(Categories categorie) throws ManagerException {
		try {
			dao.insert(categorie);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
	}

	@Override
	public void majCategorie(Categories categorie) throws ManagerException {
		try {
			dao.update(categorie);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
	}

	@Override
	public void supprimerCategorie(int id) throws ManagerException {
		try {
			dao.delete(id);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
	}

	@Override
	public List<Categories> getAllCategories() throws ManagerException {
		List<Categories> lst = new ArrayList<Categories>();
		
		try {
			lst = dao.getAll();
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		
		return lst;
	}

	@Override
	public Categories getCategorieByNo(int id) throws ManagerException {
		Categories result = null;
		
		try {
			result = dao.findByNo(id);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}

		return result;
	}

	@Override
	public Categories getCategorieByName(String name) throws ManagerException {
		Categories result = null;
		
		try {
			result = dao.findByName(name);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}

		return result;
	}

}
