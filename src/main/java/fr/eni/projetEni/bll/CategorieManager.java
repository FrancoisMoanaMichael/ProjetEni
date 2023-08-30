package fr.eni.projetEni.bll;

import java.util.List;

import fr.eni.projetEni.bo.Categories;

public interface CategorieManager {
	public void addCategorie(Categories categorie)		throws ManagerException;
	public void majCategorie(Categories categorie)		throws ManagerException;
	public void supprimerCategorie(int id)				throws ManagerException;
	public List<Categories> getAllCategories()			throws ManagerException;
	public Categories getCategorieByNo(int id)			throws ManagerException;
	public Categories getCategorieByName(String name)	throws ManagerException;
}
