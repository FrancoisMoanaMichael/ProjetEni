package fr.eni.projetEni.bll;

import java.util.List;

import fr.eni.projetEni.bo.UTILISATEURS;

public interface UtilisateurManager {
	public List<UTILISATEURS> getAllUtilisateurs()			throws ManagerException;
	public UTILISATEURS getUtilisateur(int id)				throws ManagerException;
	public void addUtilisateur(UTILISATEURS utilisateur)	throws ManagerException;
	public void supprimerUtilisateur(int id)				throws ManagerException;
	public void majUtilisateur(UTILISATEURS utilisateur)	throws ManagerException;
}
