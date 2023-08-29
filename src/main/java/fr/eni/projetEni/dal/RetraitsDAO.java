package fr.eni.projetEni.dal;

import fr.eni.projetEni.bo.ArticlesVendus;
import fr.eni.projetEni.bo.Retraits;

public interface RetraitsDAO {
	public void insert(Retraits retraits);
	public void delete(int id);
	public Retraits byRetrqitsById(ArticlesVendus articleVendus);
	public void update(Retraits retraits);
	
}
