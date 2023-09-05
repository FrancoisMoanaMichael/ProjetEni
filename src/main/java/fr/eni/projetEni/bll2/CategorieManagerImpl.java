package fr.eni.projetEni.bll2;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEni.bo2.Categorie;
import fr.eni.projetEni.dal2.CategorieDAO;
import fr.eni.projetEni.dal2.DAOFact;
import fr.eni.projetEni.dal2.DalException;

public class CategorieManagerImpl implements CategorieManager {
	private CategorieDAO dao = DAOFact.getCategorieDAO();
	
	@Override
	public void addCategorie(Categorie categorie) throws ManagerException {
		try {
			dao.insert(categorie);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
	}

	@Override
	public void majCategorie(Categorie categorie) throws ManagerException {
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
	public List<Categorie> getAllCategories() throws ManagerException {
		List<Categorie> lst = new ArrayList<Categorie>();
		
		try {
			lst = dao.getAll();
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		
		return lst;
	}

	@Override
	public Categorie getCategorieByNo(int id) throws ManagerException {
		Categorie result = null;
		
		try {
			result = dao.findByNo(id);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}

		return result;
	}

	@Override
	public Categorie getCategorieByName(String name) throws ManagerException {
		Categorie result = null;
		
		try {
			result = dao.findByName(name);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}

		return result;
	}

}
