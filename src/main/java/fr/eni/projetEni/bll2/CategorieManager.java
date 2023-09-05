package fr.eni.projetEni.bll2;

import java.util.List;

import fr.eni.projetEni.bo2.Categorie;

public interface CategorieManager {
	public void addCategorie(Categorie categorie)		throws ManagerException;
	public void majCategorie(Categorie categorie)		throws ManagerException;
	public void supprimerCategorie(int id)				throws ManagerException;
	public List<Categorie> getAllCategories()			throws ManagerException;
	public Categorie getCategorieByNo(int id)			throws ManagerException;
	public Categorie getCategorieByName(String name)	throws ManagerException;
}
