package fr.eni.projetEni.dal;

import fr.eni.projetEni.bo.RETRAITS;

public class RetraitsDAOImpl implements RetraitsDAO {
	final String INSERTE = "";
	final String SELECT = "SELECT no_article, rue , code_postal , ville FROM RETRAITS";
	final String DELETE = "DELETE FROM RETRAITS WHERE no_article = ?";
	final String SELECT_BY_ARTICLE_VENDU = "SELECT no_article, rue , code_postal , ville FROM RETRAITS WHERE = no_article = ?";
	
	@Override
	public void insert(RETRAITS retraits) {
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public RETRAITS findByArticleByNo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
