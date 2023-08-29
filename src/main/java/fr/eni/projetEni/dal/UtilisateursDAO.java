package fr.eni.projetEni.dal;

import java.util.List;

import fr.eni.projetEni.bo.UTILISATEURS;

public interface UtilisateursDAO {
	public void insert(UTILISATEURS utilisateur)	throws DalException;
	public void delete(int id)						throws DalException;
	public UTILISATEURS findUtilisateurByNo(int id) throws DalException;
	public List<UTILISATEURS> getAll()				throws DalException;
}
