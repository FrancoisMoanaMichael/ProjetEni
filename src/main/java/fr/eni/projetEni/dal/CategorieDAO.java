package fr.eni.projetEni.dal;

import java.util.List;

import fr.eni.projetEni.bo.CATEGORIES;

public interface CategorieDAO {
	//public void insert(CATEGORIES categories);
	//public void delete(int id);
	public List<CATEGORIES> getAll();
	public CATEGORIES findByNo(int id);
	public CATEGORIES findByName(String name);
}
