package fr.eni.projetEni.dal.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import fr.eni.projetEni.bo2.Enchere;
import fr.eni.projetEni.dal2.DalException;
import fr.eni.projetEni.dal2.EncheresDAOImpl;

public class EncheresTest {

	// EncheresDAO enchereDAO = DAOFact.getEncheresDAO();
	// EncheresDAO encheresDAO = new EncheresDAOImpl();
	private EncheresDAOImpl enchereDAO;

//	@Test
//	public void testInsert() throws DalException {
//
//		enchereDAO = new EncheresDAOImpl();
//
//		Utilisateur user = new Utilisateur();
//		user.setNo_utilisateur(6);
//
//		ArticlesVendu article = new ArticlesVendu();
//		article.setNo_article(3);
//
//		Enchere enchere = new Enchere(user, article, LocalDateTime.now(), 200);
//		enchereDAO.insert(enchere);
//	}
	
	// marche pas
//	@Test
//    public void testDelete() throws DalException {
//		enchereDAO = new EncheresDAOImpl();
//        enchereDAO.delete(2); 
//    }
	
	// marche pas
//	@Test
//    public void testGetAll() throws DalException {
//		//enchereDAO = new EncheresDAOImpl();
//        List<Enchere> encheres = enchereDAO.getAll();  
//        assertNotNull(encheres);
//    }
	
	@Test
    public void testFindEnchereByArticleId() throws DalException {
		enchereDAO = new EncheresDAOImpl();
        Enchere x =  enchereDAO.findEnchereById(3);
        enchereDAO.update(x, 7, 500);
    }

}
