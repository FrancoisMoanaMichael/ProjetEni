package fr.eni.projetEni.dal;

import fr.eni.projetEni.bo.ARTICLES_VENDUS;
import fr.eni.projetEni.bo.RETRAITS;

public interface RetraitsDAO {
	public void insert(RETRAITS retraits);
	public void delete(int id);
	public RETRAITS byArticleVendu(ARTICLES_VENDUS articleVendus);
	public void update(RETRAITS retraits);
	
}
