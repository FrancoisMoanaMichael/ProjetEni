package fr.eni.projetEni.bll2;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEni.bo2.ArticlesVendu;
import fr.eni.projetEni.dal2.ArticleVendusDAO;
import fr.eni.projetEni.dal2.DAOFact;
import fr.eni.projetEni.dal2.DalException;

public class ArticleVendusManagerImpl implements ArticleVendusManager {
	private ArticleVendusDAO dao = DAOFact.getArticleVenduDAO();

	@Override
	public List<ArticlesVendu> getAllArticlesVendus() throws ManagerException {
		List<ArticlesVendu> lst = new ArrayList<ArticlesVendu>();
		
		try {
			lst = dao.getAll();
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		
		return lst;
	}

	@Override
	public ArticlesVendu getArticlesVendus(int id) throws ManagerException {
		ArticlesVendu result = null;
		
		try {
			result = dao.findByArticleByNo(id);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		
		return result;
	}

	@Override
	public void addArticlesVendus(ArticlesVendu articleVendu) throws ManagerException {
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
