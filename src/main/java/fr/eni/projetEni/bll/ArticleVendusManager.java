package fr.eni.projetEni.bll;

import java.util.List;

import fr.eni.projetEni.bo.ArticlesVendu;

public interface ArticleVendusManager {
	public List<ArticlesVendu> getAllArticlesVendus()			throws ManagerException;
	public ArticlesVendu getArticlesVendus(int id)				throws ManagerException;
	public void addArticlesVendus(ArticlesVendu articleVendu)	throws ManagerException;
	public void supprimerArticlesVendus(int id)					throws ManagerException;
}
