package fr.eni.projetEni.dal;


import java.util.List;

import fr.eni.projetEni.bo.Retraits;

public interface RetraitsDAO {
	public void insert(Retraits retraits);
	public void delete(int id);
	public Retraits findByArticleByNo(int id);
	List<Retraits> getAll();
	
}
