package fr.eni.projetEni.dal;

import java.util.List;

import fr.eni.projetEni.bo.ArticlesVendus;

public interface ArticleVendusDAO {
	public void insert(ArticlesVendus articleVendus);
	public void delete(int id);
	public ArticlesVendus findByArticleByNo(int id);
	public List<ArticlesVendus> getAll();
}
