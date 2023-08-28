package fr.eni.projetEni.dal;

import java.util.List;

import fr.eni.projetEni.bo.ARTICLES_VENDUS;

public interface ArticleVendusDao {
	public void insert(ARTICLES_VENDUS articleVendus);
	public void delete(ARTICLES_VENDUS articleVendus);
	public ARTICLES_VENDUS findByArticleByNo(int id);
	public List<ARTICLES_VENDUS> getAll();
}
