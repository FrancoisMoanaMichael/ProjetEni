package fr.eni.projetEni.dal;

import java.util.List;

import fr.eni.projetEni.bo.Encheres;

public interface EncheresDAO {
	public void insert(Encheres encheres);
	public void deleteEnchereById(int id);
	public List<Encheres> getAll();
	public Encheres findEnchereByArticleId(int id);
	public Encheres findEnchereByUserId(int id);
	public Encheres findEnchereById(int id);
}
