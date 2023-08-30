package fr.eni.projetEni.bll;

import java.util.List;

import fr.eni.projetEni.bo.Retraits;

public interface RetraisManager {
	public List<Retraits> getAllRetraits()			throws ManagerException;
	public Retraits getRetraitsByArticleNo(int id)	throws ManagerException;
	public void addRetraits(Retraits retrait)		throws ManagerException;
	public void supprimerRetraits(int id)			throws ManagerException;
}
