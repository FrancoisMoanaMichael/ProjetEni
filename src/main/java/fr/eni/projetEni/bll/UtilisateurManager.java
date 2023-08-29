package fr.eni.projetEni.bll;

import java.util.List;

import fr.eni.projetEni.bo.Utilisateurs;

public interface UtilisateurManager {
	public List<Utilisateurs> getAllUtilisateurs()			throws ManagerException;
	public Utilisateurs getUtilisateur(int id)				throws ManagerException;
	public void addUtilisateur(Utilisateurs utilisateur)	throws ManagerException;
	public void supprimerUtilisateur(int id)				throws ManagerException;
	public void majUtilisateur(Utilisateurs utilisateur)	throws ManagerException;
}
