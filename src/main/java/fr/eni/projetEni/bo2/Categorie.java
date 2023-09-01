package fr.eni.projetEni.bo2;

import java.util.List;

public class Categorie {
	private Integer				no_categorie;
	private String				libelle;
	private List<ArticlesVendu> lstArticles;
	
	public Categorie() {
		super();
	}

	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
	}
	
	public Categorie(Integer no_categorie, String libelle) {
		this(libelle);
		this.no_categorie = no_categorie;
	}

	public Categorie(Integer no_categorie, String libelle, List<ArticlesVendu> lstArticles) {
		this(no_categorie, libelle);
		this.lstArticles = lstArticles;
	}

	public Integer getNo_categorie() {
		return no_categorie;
	}

	public void setNo_categorie(Integer no_categorie) {
		this.no_categorie = no_categorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<ArticlesVendu> getLstArticles() {
		return lstArticles;
	}

	public void setLstArticles(List<ArticlesVendu> lstArticles) {
		this.lstArticles = lstArticles;
	}
	
	public void addArticlesVendu (ArticlesVendu articleVendu) {
		this.lstArticles.add(articleVendu);
	}

	@Override
	public String toString() {
		return "Categorie [no_categorie=" + no_categorie + ", libelle=" + libelle + ", lstArticles=" + lstArticles
				+ "]";
	}
	
}