package fr.eni.projetEni.bll2;

import java.util.List;

import fr.eni.projetEni.bo2.Enchere;

public interface EnchereManager {
	public List<Enchere> getAll()							throws ManagerException;
	public List<Enchere> getEncheresByUsedID(int id)		throws ManagerException;
	public Enchere getEncheresByArticleID(int id)	throws ManagerException;
	public Enchere getEncheresByID(int id)					throws ManagerException;
	public void addEnchere(Enchere enchere)				throws ManagerException;
	public void supprimerEnchere(int id)					throws ManagerException;
	public Enchere findEnchereByArticleId(int id) throws ManagerException;
}
