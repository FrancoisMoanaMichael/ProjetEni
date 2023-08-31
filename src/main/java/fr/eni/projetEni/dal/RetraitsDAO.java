package fr.eni.projetEni.dal;

import java.util.List;

import fr.eni.projetEni.bo.Retrait;

public interface RetraitsDAO {
	public void insert(Retrait retraits)			throws DalException;
	public void delete(int id)						throws DalException;
	public Retrait findRetraitsByNoArticle(int id)	throws DalException;
	public List<Retrait> getAll()					throws DalException;
}
