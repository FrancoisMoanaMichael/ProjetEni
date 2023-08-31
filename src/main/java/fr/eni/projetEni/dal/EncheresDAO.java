package fr.eni.projetEni.dal;

import java.util.List;

import fr.eni.projetEni.bo.Enchere;

public interface EncheresDAO {
	public void insert(Enchere encheres)					throws DalException;
	public void delete(int id)								throws DalException;
	public List<Enchere> getAll()							throws DalException;
	public List<Enchere> findEnchereByArticleId(int id)	throws DalException;
	public List<Enchere> findEnchereByUserId(int id)		throws DalException;
	public Enchere findEnchereById(int id)					throws DalException;
}
