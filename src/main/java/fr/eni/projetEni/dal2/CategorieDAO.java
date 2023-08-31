package fr.eni.projetEni.dal2;

import java.util.List;

import fr.eni.projetEni.bo.Categorie;

public interface CategorieDAO {
	public void insert(Categorie categorie)	throws DalException;
	public void update(Categorie categorie)	throws DalException;
	public void delete(int id)					throws DalException;
	public List<Categorie> getAll()			throws DalException;
	public Categorie findByNo(int id)			throws DalException;
	public Categorie findByName(String name)	throws DalException;
}
