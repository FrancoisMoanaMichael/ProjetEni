package fr.eni.projetEni.dal;

public class DAOFact {
	public static ArticleVendusDAO getArticleVenduDAO() {
		return new ArticleVendusDAOImpl();
	}
}
