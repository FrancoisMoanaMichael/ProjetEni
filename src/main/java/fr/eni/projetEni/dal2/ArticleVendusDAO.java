package fr.eni.projetEni.dal2;

import java.util.List;

import fr.eni.projetEni.bo2.ArticlesVendu;

public interface ArticleVendusDAO {
	public void insert(ArticlesVendu articleVendus)				throws DalException;
	public void delete(int id)									throws DalException;
	public void update(ArticlesVendu articleVendus)				throws DalException;
	public ArticlesVendu findByArticleByNo(int id)				throws DalException;
	public List<ArticlesVendu> getAll()							throws DalException;
	public List<ArticlesVendu> findByCategorieByNo(int id)		throws DalException;
	public List<ArticlesVendu> findByUtilisateurByNo(int id)	throws DalException;
}
