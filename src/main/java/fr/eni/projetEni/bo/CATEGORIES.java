package fr.eni.projetEni.bo;

public class CATEGORIES {
	private Integer no_categorie;
	private String	libelle;
	
	public CATEGORIES() {
		super();
	}

	public CATEGORIES(Integer no_categorie, String libelle) {
		super();
		this.no_categorie = no_categorie;
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
