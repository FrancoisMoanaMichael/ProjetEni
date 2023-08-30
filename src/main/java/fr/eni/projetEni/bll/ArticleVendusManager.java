package fr.eni.projetEni.bll;

import java.util.List;

import fr.eni.projetEni.bo.ArticlesVendus;

public interface ArticleVendusManager {
	public List<ArticlesVendus> getAllArticlesVendus()			throws ManagerException;
	public ArticlesVendus getArticlesVendus(int id)				throws ManagerException;
	public void addArticlesVendus(ArticlesVendus articleVendu)	throws ManagerException;
	public void supprimerArticlesVendus(int id)					throws ManagerException;
}
