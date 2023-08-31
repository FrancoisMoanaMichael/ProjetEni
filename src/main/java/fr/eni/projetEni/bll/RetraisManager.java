package fr.eni.projetEni.bll;

import java.util.List;

import fr.eni.projetEni.bo.Retrait;

public interface RetraisManager {
	public List<Retrait> getAllRetraits()			throws ManagerException;
	public Retrait getRetraitsByArticleNo(int id)	throws ManagerException;
	public void addRetraits(Retrait retrait)		throws ManagerException;
	public void supprimerRetraits(int id)			throws ManagerException;
}
