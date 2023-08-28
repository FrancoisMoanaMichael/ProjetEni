package fr.eni.projetEni.dal;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEni.bo.ARTICLES_VENDUS;

public class ArticleVendusDAOMock implements ArticleVendusDao {
	private static List<ARTICLES_VENDUS> listArticle=ArrayList<ARTICLES_VENDUS>();
	private static Integer idArticleVendus= 0;
	
	@Override
	public void insert(ARTICLES_VENDUS articleVendus) {
		articleVendus.setNo_article(idArticleVendus++);
		listArticle.add(articleVendus);
	}

	@Override
	public void delete(ARTICLES_VENDUS articleVendus) {
		// TODO Auto-generated method stub

	}

	@Override
	public ARTICLES_VENDUS findByArticleByNo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ARTICLES_VENDUS> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
