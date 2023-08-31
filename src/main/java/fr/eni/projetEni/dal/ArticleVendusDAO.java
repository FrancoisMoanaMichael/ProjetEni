package fr.eni.projetEni.dal;

import java.util.List;

import fr.eni.projetEni.bo.ArticlesVendu;

public interface ArticleVendusDAO {
	public void insert(ArticlesVendu articleVendus)	throws DalException;
	public void delete(int id)							throws DalException;
	public ArticlesVendu findByArticleByNo(int id)		throws DalException;
	public List<ArticlesVendu> getAll()				throws DalException;
}
