package fr.eni.projetEni.bo2;

import java.util.List;

public class Utilisateur {
	private Integer 			no_utilisateur;
	private String				pseudo;
	private String				nom;
	private String				prenom;
	private String				email;
	private String				telephone;
	private String				rue;
	private String				code_postal;
	private String				ville;
	private String				mot_de_passe;
	private Integer				credit;
	private Boolean				administrateur;
	private List<Enchere>		lstEncheres;
	private List<ArticlesVendu>	lstArticles;
	
	public Utilisateur() {
		super();
	}
	
	public Utilisateur(String pseudo, String mot_de_passe) {
		super();
		this.pseudo = pseudo;
		this.mot_de_passe = mot_de_passe;
	}

	public Utilisateur(String pseudo, String nom, String prenom, String email,
			String telephone, String rue, String code_postal, String ville, String mot_de_passe, Integer credit,
			Boolean administrateur) {
		this(pseudo, mot_de_passe);
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.credit = credit;
		this.administrateur = administrateur;
	}
	
	public Utilisateur(Integer no_utilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String code_postal, String ville, String mot_de_passe, Integer credit, Boolean administrateur) {
		this(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur);
		this.no_utilisateur = no_utilisateur;
	}
	
	public Utilisateur(Integer no_utilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String code_postal, String ville, String mot_de_passe, Integer credit, Boolean administrateur,
			List<Enchere> lstEncheres, List<ArticlesVendu> lstArticles) {
		this(no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur);
		this.lstEncheres = lstEncheres;
		this.lstArticles = lstArticles;
	}

	public Integer getNo_utilisateur() {
		return no_utilisateur;
	}

	public void setNo_utilisateur(Integer no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public Boolean getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(Boolean administrateur) {
		this.administrateur = administrateur;
	}
	
	public List<Enchere> getLstEncheres() {
		return lstEncheres;
	}

	public void setLstEncheres(List<Enchere> lstEncheres) {
		this.lstEncheres = lstEncheres;
	}
	
	public void AddEnchere(Enchere enchere) {
		this.lstEncheres.add(enchere);
	}

	public List<ArticlesVendu> getLstArticles() {
		return lstArticles;
	}

	public void setLstArticles(List<ArticlesVendu> lstArticles) {
		this.lstArticles = lstArticles;
	}
	
	public void AddArticle(ArticlesVendu article) {
		this.lstArticles.add(article);
	}

	@Override
	public String toString() {
		return "Utilisateur [no_utilisateur=" + no_utilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom="
				+ prenom + ", email=" + email + ", telephone=" + telephone + ", rue=" + rue + ", code_postal="
				+ code_postal + ", ville=" + ville + ", mot_de_passe=" + mot_de_passe + ", credit=" + credit
				+ ", administrateur=" + administrateur + ", lstEncheres=" + lstEncheres + ", lstArticles=" + lstArticles
				+ "]";
	}
	
}