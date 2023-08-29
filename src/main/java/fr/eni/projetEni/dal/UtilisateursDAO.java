package fr.eni.projetEni.dal;

import java.util.List;

import fr.eni.projetEni.bo.UTILISATEURS;

public interface UtilisateursDAO {
	public void insert(UTILISATEURS utilisateur);
	public void delete(int id);
	public UTILISATEURS findUtilisateurByNo(int id);
	public List<UTILISATEURS> getAll();
}
