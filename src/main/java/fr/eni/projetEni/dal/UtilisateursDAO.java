package fr.eni.projetEni.dal;

import java.util.List;

import fr.eni.projetEni.bo.Utilisateurs;

public interface UtilisateursDAO {
	public void insert(Utilisateurs utilisateur) throws DalException;

	public void delete(int id) throws DalException;

	public void update(Utilisateurs utilisateur) throws DalException;

	public Utilisateurs findUtilisateurByNo(int id) throws DalException;

	public List<Utilisateurs> getAll() throws DalException;

	public Utilisateurs check(String login, String password) throws DalException;

}
