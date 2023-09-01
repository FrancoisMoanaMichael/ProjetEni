package fr.eni.projetEni.bo2;

public class Retrait {
	private ArticlesVendu	article;
	private String 			rue;
	private String			code_postal;
	private String			ville;
	
	public Retrait() {
		super();
	}
	
	public Retrait(ArticlesVendu article, String rue, String code_postal, String ville) {
		super();
		this.article = article;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
	}
	
	public ArticlesVendu getArticle() {
		return article;
	}

	public void setArticle(ArticlesVendu article) {
		this.article = article;
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
		return "Retrait [article=" + article + ", rue=" + rue + ", code_postal=" + code_postal + ", ville=" + ville
				+ "]";
	}
	
}
