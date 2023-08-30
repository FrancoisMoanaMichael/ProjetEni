package fr.eni.projetEni.bll;

public class ArticleVendusManagerSing {
	private static ArticleVendusManager instance;
	
	public static ArticleVendusManager getInstance() {
		if(instance==null) {
			instance = new ArticleVendusManagerImpl();
		}
		return instance;
	}
}
