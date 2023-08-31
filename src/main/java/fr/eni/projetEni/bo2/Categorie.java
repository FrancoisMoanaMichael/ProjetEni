package fr.eni.projetEni.bo2;

public class Categorie {
	private Integer no_categorie;
	private String	libelle;
	
	public Categorie() {
		super();
	}

	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
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

	@Override
	public String toString() {
		return "CATEGORIES [no_categorie=" + no_categorie + ", libelle=" + libelle + "]";
	}
	
	
}