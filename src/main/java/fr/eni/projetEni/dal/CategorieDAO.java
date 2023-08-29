package fr.eni.projetEni.dal;

import java.util.List;

import fr.eni.projetEni.bo.Categories;

public interface CategorieDAO {
	//public void insert(CATEGORIES categories);
	//public void delete(int id);
	public List<Categories> getAll();
	public Categories findByNo(int id);
	public Categories findByName(String name);
}
