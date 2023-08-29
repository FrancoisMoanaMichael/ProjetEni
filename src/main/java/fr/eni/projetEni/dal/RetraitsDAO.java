package fr.eni.projetEni.dal;


import java.util.List;

import fr.eni.projetEni.bo.RETRAITS;

public interface RetraitsDAO {
	public void insert(RETRAITS retraits);
	public void delete(int id);
	public RETRAITS findByArticleByNo(int id);
	List<RETRAITS> getAll();
	
}
