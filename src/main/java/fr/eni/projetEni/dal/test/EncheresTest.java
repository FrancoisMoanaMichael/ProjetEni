package fr.eni.projetEni.dal.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import fr.eni.projetEni.bll.EnchereManager;
import fr.eni.projetEni.bll.EnchereManagerSing;
import fr.eni.projetEni.bll.ManagerException;
import fr.eni.projetEni.bo2.Enchere;
import fr.eni.projetEni.dal2.DalException;
import fr.eni.projetEni.dal2.EncheresDAOImpl;

public class EncheresTest {

	// EncheresDAO enchereDAO = DAOFact.getEncheresDAO();
	// EncheresDAO encheresDAO = new EncheresDAOImpl();
	// private EncheresDAOImpl enchereDAO;
	private EnchereManager eManager = EnchereManagerSing.getInstance();

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

//	@Test
//	public void testFindEnchereByArticleId() throws DalException {
////		enchereDAO = new EncheresDAOImpl();
////        enchereDAO.findEnchereByArticleId(3);
//		List<Enchere> listEncheres = null;
//
//		try {
//			listEncheres = eManager.getAll();
//		} catch (ManagerException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(listEncheres);
//
//	}

}
