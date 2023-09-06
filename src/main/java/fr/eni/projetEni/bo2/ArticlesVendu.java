package fr.eni.projetEni.bo2;

import java.time.LocalDate;
import java.util.List;

public class ArticlesVendu {
	private Integer			no_article;
	private String			nom_article;
	private String			description;
	private LocalDate		date_debut_encheres;
	private LocalDate		date_fin_encheres;
	private Integer			prix_initial;
	private Integer			prix_vente;
	private Boolean			transaction_realise;
	private Utilisateur		utilisateur;
	private Categorie		categorie;
	private Retrait			retrait;
	private List<Enchere>	lstEncheres;
	
	public ArticlesVendu() {
		super();
	}
	
	public ArticlesVendu(String nom_article, String description, LocalDate date_debut_encheres,
			LocalDate date_fin_encheres, Integer prix_initial) {
		super();
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.prix_initial = prix_initial;
		this.prix_vente = 0;
		this.transaction_realise = false;
	}
	
	public ArticlesVendu(String nom_article, String description, LocalDate date_debut_encheres,
			LocalDate date_fin_encheres, Integer prix_initial, Integer prix_vente) {
		super();
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
	}
	
	public ArticlesVendu(String nom_article, String description, LocalDate date_debut_encheres,
			LocalDate date_fin_encheres, Integer prix_initial, Integer prix_vente, Utilisateur utilisateur,
			Categorie categorie) {
		this(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente);
		this.utilisateur = utilisateur;
		this.categorie = categorie;
	}
	
	
	public ArticlesVendu(Integer no_article, String nom_article, String description, LocalDate date_debut_encheres,
			LocalDate date_fin_encheres, Integer prix_initial, Integer prix_vente) {
		this(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente);
		this.no_article = no_article;
	}
	
	public ArticlesVendu(Integer no_article, String nom_article, String description, LocalDate date_debut_encheres,
			LocalDate date_fin_encheres, Integer prix_initial, Integer prix_vente, Utilisateur utilisateur,
			Categorie categorie) {
		this(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, utilisateur, categorie);
		this.no_article = no_article;
	}

	public ArticlesVendu(Integer no_article, String nom_article, String description, LocalDate date_debut_encheres,
			LocalDate date_fin_encheres, Integer prix_initial, Integer prix_vente, Utilisateur utilisateur,
			Categorie categorie, Retrait retrait, List<Enchere> lstEnceres) {
		this(no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, utilisateur, categorie);
		this.retrait = retrait;
		this.lstEncheres = lstEnceres;
	}
	public ArticlesVendu(Integer no_article, String nom_article, String description, LocalDate date_debut_encheres,
			LocalDate date_fin_encheres, Integer prix_initial, Integer prix_vente, Utilisateur utilisateur,
			Categorie categorie, Retrait retrait) {
		this(no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, utilisateur, categorie);
		this.retrait = retrait;
	}

	public Integer getNo_article() {
		return no_article;
	}

	public void setNo_article(Integer no_article) {
		this.no_article = no_article;
	}

	public String getNom_article() {
		return nom_article;
	}

	public void setNom_article(String nom_article) {
		this.nom_article = nom_article;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate_debut_encheres() {
		return date_debut_encheres;
	}

	public void setDate_debut_encheres(LocalDate date_debut_encheres) {
		this.date_debut_encheres = date_debut_encheres;
	}

	public LocalDate getDate_fin_encheres() {
		return date_fin_encheres;
	}

	public void setDate_fin_encheres(LocalDate date_fin_encheres) {
		this.date_fin_encheres = date_fin_encheres;
	}

	public Integer getPrix_initial() {
		return prix_initial;
	}

	public void setPrix_initial(Integer prix_initial) {
		this.prix_initial = prix_initial;
	}

	public Integer getPrix_vente() {
		return prix_vente;
	}

	public void setPrix_vente(Integer prix_vente) {
		this.prix_vente = prix_vente;
	}
	
	public Boolean getTransaction_realise() {
		return transaction_realise;
	}

	public void setTransaction_realise(Boolean transaction_realise) {
		this.transaction_realise = transaction_realise;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	public Retrait getRetrait() {
		return retrait;
	}

	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}

	public List<Enchere> getLstEncheres() {
		return lstEncheres;
	}

	public void setLstEncheres(List<Enchere> lstEncheres) {
		this.lstEncheres = lstEncheres;
	}
	
	public void addEncheres(Enchere enchere) {
		this.lstEncheres.add(enchere);
	}

	@Override
	public String toString() {
		return "ArticlesVendu [no_article=" + no_article + ", nom_article=" + nom_article + ", description="
				+ description + ", date_debut_encheres=" + date_debut_encheres + ", date_fin_encheres="
				+ date_fin_encheres + ", prix_initial=" + prix_initial + ", prix_vente=" + prix_vente
				+ ", transaction_realise=" + transaction_realise + ", utilisateur=" + utilisateur + ", categorie="
				+ categorie + ", retrait=" + retrait + ", lstEncheres=" + lstEncheres + "]";
	}
	
}