package fr.eni.projetEni.dal;

import java.util.List;

import fr.eni.projetEni.bo.Utilisateur;

public interface UtilisateursDAO {
	public void insert(Utilisateur utilisateur) throws DalException;

	public void delete(int id) throws DalException;

	public void update(Utilisateur utilisateur) throws DalException;

	public Utilisateur findUtilisateurByNo(int id) throws DalException;

	public List<Utilisateur> getAll() throws DalException;

	public Utilisateur check(String login, String password) throws DalException;

}
