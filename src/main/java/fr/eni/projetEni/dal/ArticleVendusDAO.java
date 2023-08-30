package fr.eni.projetEni.dal;

import java.util.List;

import fr.eni.projetEni.bo.ArticlesVendus;

public interface ArticleVendusDAO {
	public void insert(ArticlesVendus articleVendus)	throws DalException;
	public void delete(int id)							throws DalException;
	public ArticlesVendus findByArticleByNo(int id)		throws DalException;
	public List<ArticlesVendus> getAll()				throws DalException;
}
