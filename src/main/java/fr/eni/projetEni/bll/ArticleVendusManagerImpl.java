package fr.eni.projetEni.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEni.bo.ArticlesVendus;
import fr.eni.projetEni.dal.ArticleVendusDAO;
import fr.eni.projetEni.dal.DAOFact;
import fr.eni.projetEni.dal.DalException;

public class ArticleVendusManagerImpl implements ArticleVendusManager {
	private ArticleVendusDAO dao = DAOFact.getArticleVenduDAO();

	@Override
	public List<ArticlesVendus> getAllArticlesVendus() throws ManagerException {
		List<ArticlesVendus> lst = new ArrayList<ArticlesVendus>();
		
		try {
			lst = dao.getAll();
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		
		return lst;
	}

	@Override
	public ArticlesVendus getArticlesVendus(int id) throws ManagerException {
		ArticlesVendus result = null;
		
		try {
			result = dao.findByArticleByNo(id);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		
		return result;
	}

	@Override
	public void addArticlesVendus(ArticlesVendus articleVendu) throws ManagerException {
		try {
			dao.insert(articleVendu);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
	}

	@Override
	public void supprimerArticlesVendus(int id) throws ManagerException {
		try {
			dao.delete(id);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
	}
}
