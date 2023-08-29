package fr.eni.projetEni.bo;


public class RETRAITS {
	private Integer no_article;
	private String 	rue;
	private String	code_postal;
	private String	ville;
	private ARTICLES_VENDUS articles_VENDUS;
	
	public RETRAITS() {
		super();
	}

	public RETRAITS(Integer no_article, String rue, String code_postal, String ville, ARTICLES_VENDUS articles_VENDUS) {
		super();
		this.no_article = no_article;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.articles_VENDUS = articles_VENDUS;
	}

	public ARTICLES_VENDUS getArticles_VENDUS() {
		return articles_VENDUS;
	}

	public void setArticles_VENDUS(ARTICLES_VENDUS articles_VENDUS) {
		this.articles_VENDUS = articles_VENDUS;
	}

	public Integer getNo_article() {
		return no_article;
	}

	public void setNo_article(Integer no_article) {
		this.no_article = no_article;
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

	@Override
	public String toString() {
		return "RETRAITS [no_article=" + no_article + ", rue=" + rue + ", code_postal=" + code_postal + ", ville="
				+ ville + "]";
	}
	
}
