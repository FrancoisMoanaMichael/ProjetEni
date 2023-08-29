package fr.eni.projetEni.dal;

import java.util.List;

import fr.eni.projetEni.bo.Categories;

public interface CategorieDAO {
	public void insert(Categories categorie)	throws DalException;
	public void update(Categories categorie)	throws DalException;
	public void delete(int id)					throws DalException;
	public List<Categories> getAll()			throws DalException;
	public Categories findByNo(int id)			throws DalException;
	public Categories findByName(String name)	throws DalException;
}
