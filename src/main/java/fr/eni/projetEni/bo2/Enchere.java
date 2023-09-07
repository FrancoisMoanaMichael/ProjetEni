package fr.eni.projetEni.bo2;

import java.time.LocalDateTime;

public class Enchere {
	private Integer no_enchere;
	private Integer no_utilisateur;
	private Integer no_article;

	private Utilisateur utilisateur;
	private ArticlesVendu article;
	private LocalDateTime date_enchere;
	private Integer montant_enchere;
	private String nomUtilisateur;
	private String nomCategorie;

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public Enchere() {
		super();
	}

	public Enchere(Integer no_enchere, String nomUtilisateur, String nomCategorie, ArticlesVendu article, LocalDateTime date_enchere,
			Integer montant_enchere) {
		super();
		this.nomUtilisateur = nomUtilisateur;
		this.nomCategorie = nomCategorie;
		this.no_enchere = no_enchere;
		this.article = article;
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
	}

	public Enchere(Utilisateur utilisateur, ArticlesVendu article, LocalDateTime date_enchere,
			Integer montant_enchere) {
		super();
		this.utilisateur = utilisateur;
		this.article = article;
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
	}

	public Enchere(Integer no_enchere, LocalDateTime date_enchere, Integer montant_enchere) {
		super();
		this.no_enchere = no_enchere;
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
	}

	public Enchere(Integer no_enchere, Integer no_utilisateur, Integer no_article, LocalDateTime date_enchere,
			Integer montant_enchere) {
		super();
		this.no_enchere = no_enchere;
		this.no_utilisateur = no_utilisateur;
		this.no_article = no_article;
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public Integer getNo_enchere() {
		return no_enchere;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public ArticlesVendu getArticle() {
		return article;
	}

	public void setArticle(ArticlesVendu article) {
		this.article = article;
	}

	public void setNo_enchere(Integer no_enchere) {
		this.no_enchere = no_enchere;
	}

	public LocalDateTime getDate_enchere() {
		return date_enchere;
	}

	public void setDate_enchere(LocalDateTime date_enchere) {
		this.date_enchere = date_enchere;
	}

	public Integer getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(Integer montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	public Integer getNo_article() {
		return no_article;
	}

	public void setNo_article(Integer no_article) {
		this.no_article = no_article;
	}

	@Override
	public String toString() {
		return "Enchere [no_enchere=" + no_enchere + ", utilisateur=" + utilisateur + ", article=" + article
				+ ", date_enchere=" + date_enchere + ", montant_enchere=" + montant_enchere + "]";
	}

	public Integer getNo_utilisateur() {
		return no_utilisateur;
	}

	public void setNo_utilisateur(Integer no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}

}
