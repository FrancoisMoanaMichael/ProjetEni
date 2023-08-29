package fr.eni.projetEni.dal;

import java.util.List;

import fr.eni.projetEni.bo.Articles_Vendus;

public interface ArticleVendusDAO {
	public void insert(Articles_Vendus articleVendus);
	public void delete(int id);
	public Articles_Vendus findByArticleByNo(int id);
	public List<Articles_Vendus> getAll();
}
