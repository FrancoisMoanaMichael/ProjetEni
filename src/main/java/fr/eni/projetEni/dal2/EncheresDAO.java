package fr.eni.projetEni.dal2;

import java.util.List;

import fr.eni.projetEni.bo2.Enchere;

public interface EncheresDAO {
	public void insert(Enchere encheres) throws DalException;

	public void delete(int id) throws DalException;

	public List<Enchere> getAll() throws DalException;

	public Enchere findEnchereByArticleId(int id) throws DalException;

	public List<Enchere> findEnchereByUserId(int id) throws DalException;

	public Enchere findEnchereById(int id) throws DalException;

	public void update(Enchere enchere) throws DalException;

	public Enchere findEnchereGagnante(int id) throws DalException;

	void update(Enchere enchere, int no_utilisateur, int montant_enchere) throws DalException;
}