package fr.eni.projetEni.bo;

import java.time.LocalDateTime;

public class Enchere {
	private Integer			no_enchere;
	private Integer			no_utilisateur;
	private Integer			no_article;
	private LocalDateTime	date_enchere;
	private Integer			montant_enchere;
	
	public Enchere() {
		super();
	}
	
	public Enchere(Integer no_utilisateur, Integer no_article, LocalDateTime date_enchere,
			Integer montant_enchere) {
		super();
		//this.no_enchere = no_enchere;
		this.no_utilisateur = no_utilisateur;
		this.no_article = no_article;
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
	}
	
	public Integer getNo_enchere() {
		return no_enchere;
	}
	
	public void setNo_enchere(Integer no_enchere) {
		this.no_enchere = no_enchere;
	}
	
	public Integer getNo_utilisateur() {
		return no_utilisateur;
	}
	
	public void setNo_utilisateur(Integer no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}
	
	public Integer getNo_article() {
		return no_article;
	}
	
	public void setNo_article(Integer no_article) {
		this.no_article = no_article;
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
	
	@Override
	public String toString() {
		return "ENCHERES [no_enchere=" + no_enchere + ", no_utilisateur=" + no_utilisateur + ", no_article="
				+ no_article + ", date_enchere=" + date_enchere + ", montant_enchere=" + montant_enchere + "]";
	}
	
}
