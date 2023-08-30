package fr.eni.projetEni.bll;

import java.util.List;

import fr.eni.projetEni.bo.Encheres;

public interface EnchereManager {
	public List<Encheres> getAll()							throws ManagerException;
	public List<Encheres> getEncheresByUsedID(int id)		throws ManagerException;
	public List<Encheres> getEncheresByArticleID(int id)	throws ManagerException;
	public Encheres getEncheresByID(int id)					throws ManagerException;
	public void addEnchere(Encheres enchere)				throws ManagerException;
	public void supprimerEnchere(int id)					throws ManagerException;
}
