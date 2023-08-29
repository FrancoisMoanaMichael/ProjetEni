package fr.eni.projetEni.dal;

import java.util.List;

import fr.eni.projetEni.bo.ENCHERES;

public interface EncheresDAO {
	public void insert(ENCHERES encheres);
	public void deleteEnchereById(int id);
	public List<ENCHERES> getAll();
	public ENCHERES findEnchereByArticleId(int id);
	public ENCHERES findEnchereByUserId(int id);
	public ENCHERES findEnchereById(int id);
}
