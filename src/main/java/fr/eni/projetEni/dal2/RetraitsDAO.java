package fr.eni.projetEni.dal2;

import java.util.List;

import fr.eni.projetEni.bo2.Retrait;

public interface RetraitsDAO {
	public void insert(Retrait retraits)			throws DalException;
	public void delete(int id)						throws DalException;
	public Retrait findRetraitsByNoArticle(int id)	throws DalException;
	public List<Retrait> getAll()					throws DalException;
}