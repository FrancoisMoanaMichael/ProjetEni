package fr.eni.projetEni.dal;

import java.util.List;

import fr.eni.projetEni.bo.Retraits;

public interface RetraitsDAO {
	public void insert(Retraits retraits)			throws DalException;
	public void delete(int id)						throws DalException;
	public Retraits findRetraitsByNoArticle(int id)	throws DalException;
	public List<Retraits> getAll()					throws DalException;
}
