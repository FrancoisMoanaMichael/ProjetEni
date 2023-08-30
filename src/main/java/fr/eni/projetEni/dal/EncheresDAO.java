package fr.eni.projetEni.dal;

import java.util.List;

import fr.eni.projetEni.bo.Encheres;

public interface EncheresDAO {
	public void insert(Encheres encheres)					throws DalException;
	public void delete(int id)								throws DalException;
	public List<Encheres> getAll()							throws DalException;
	public List<Encheres> findEnchereByArticleId(int id)	throws DalException;
	public List<Encheres> findEnchereByUserId(int id)		throws DalException;
	public Encheres findEnchereById(int id)					throws DalException;
}
