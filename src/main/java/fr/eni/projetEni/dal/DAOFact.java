package fr.eni.projetEni.dal;

public class DAOFact {
	public static ArticleVendusDAO getArticleVenduDAO() {
		return new ArticleVendusDAOImpl();
	}

	public static UtilisateursDAO getUtilisateursDAO() {
		return new UtilisateursDAOImpl();
	}

	public static RetraitsDAO getRetraitsDAO() {
		return new RetraitsDAOImpl();
	}
	
}
