package fr.eni.projetEni.bll2;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEni.bo2.ArticlesVendu;
import fr.eni.projetEni.bo2.Enchere;
import fr.eni.projetEni.bo2.Utilisateur;
import fr.eni.projetEni.dal2.ArticleVendusDAO;
import fr.eni.projetEni.dal2.DAOFact;
import fr.eni.projetEni.dal2.DalException;
import fr.eni.projetEni.dal2.EncheresDAO;
import fr.eni.projetEni.dal2.UtilisateursDAO;

public class ArticleVendusManagerImpl implements ArticleVendusManager {
	private ArticleVendusDAO AVdao = DAOFact.getArticleVenduDAO();

	@Override
	public List<ArticlesVendu> getAllArticlesVendus() throws ManagerException {
		List<ArticlesVendu> lst = new ArrayList<ArticlesVendu>();
		
		try {
			lst = AVdao.getAll();
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
			result = AVdao.findByArticleByNo(id);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		
		return result;
	}
	
	@Override
	public ArticlesVendu getFullArticlesVendus(int id) throws ManagerException {
		ArticlesVendu result = null;
		
		try {
			result = AVdao.findFullByArticleByNo(id);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		
		return result;
	}

	@Override
	public void addArticlesVendus(ArticlesVendu articleVendu) throws ManagerException {
		if (articleVendu.getDate_debut_encheres().isAfter(articleVendu.getDate_fin_encheres()) || articleVendu.getDate_debut_encheres().isEqual(articleVendu.getDate_fin_encheres())) {
			throw new ManagerException("La date de début doit être antérieur à la date de fin !");
		}
		
		if (articleVendu.getPrix_initial() < 1) {
			throw new ManagerException("Le prix doit être supérieur ou égal à 1 !");
		}
		
		try {
			AVdao.insert(articleVendu);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
	}
	
	@Override
	public void majArticlesVendus(ArticlesVendu articleVendu) throws ManagerException {
		try {
			AVdao.update(articleVendu);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
	}

	@Override
	public void supprimerArticlesVendus(int id) throws ManagerException {
		try {
			AVdao.delete(id);
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
	}

	@Override
	public void majTransactions() throws ManagerException {
		EncheresDAO			eDAO			= DAOFact.getEncheresDAO();
		UtilisateursDAO		uDAO			= DAOFact.getUtilisateursDAO();
		List<ArticlesVendu> lstArticles		= new ArrayList<ArticlesVendu>();
		Enchere				enchereGagnante = null;
		Utilisateur			vendeur			= null;
		Utilisateur			acheteur		= null;
		
		try {
			lstArticles = AVdao.findTransaction();
		} catch (DalException e) {
			e.printStackTrace();
			throw new ManagerException(e.getMessage());
		}
		
		for (int i = 0; i < lstArticles.size(); i++) {
			try {
				enchereGagnante = eDAO.findEnchereGagnante(lstArticles.get(i).getNo_article());
				
				if (enchereGagnante.getNo_enchere() != null) {
					acheteur		= uDAO.findUtilisateurByNo2(enchereGagnante.getUtilisateur().getNo_utilisateur());
					vendeur			= lstArticles.get(i).getUtilisateur();
					
					acheteur.setCredit(acheteur.getCredit() - enchereGagnante.getMontant_enchere());
					vendeur.setCredit(vendeur.getCredit() + enchereGagnante.getMontant_enchere());
					uDAO.update(acheteur);
					uDAO.update(vendeur);
				}
				
				lstArticles.get(i).setTransaction_realise(true);
				AVdao.update(lstArticles.get(i));
			} catch (DalException e) {
				e.printStackTrace();
				throw new ManagerException(e.getMessage());
			}
		}
	}
	
}
