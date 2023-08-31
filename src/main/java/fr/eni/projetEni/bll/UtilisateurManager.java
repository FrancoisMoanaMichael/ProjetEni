package fr.eni.projetEni.bll;

import java.util.List;

import fr.eni.projetEni.bo.Utilisateur;

public interface UtilisateurManager {
	public List<Utilisateur> getAllUtilisateurs()			throws ManagerException;
	public Utilisateur getUtilisateur(int id)				throws ManagerException;
	public void addUtilisateur(Utilisateur utilisateur)	throws ManagerException;
	public void supprimerUtilisateur(int id)				throws ManagerException;
	public void majUtilisateur(Utilisateur utilisateur)	throws ManagerException;
	public Utilisateur check(String login, String password) throws ManagerException;
}
