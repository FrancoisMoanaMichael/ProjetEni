package fr.eni.projetEni.dal.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import fr.eni.projetEni.bll.CategorieManager;
import fr.eni.projetEni.bll.CategorieManagerSing;
import fr.eni.projetEni.bll.ManagerException;
import fr.eni.projetEni.bll.UtilisateurManager;
import fr.eni.projetEni.bll.UtilisateurManagerSing;
import fr.eni.projetEni.bo2.Utilisateur;

public class ArticleVendusTest {

    //private ArticleVendusDAO articleVendusDAO = new ArticleVendusDAOImpl();
	//private UtilisateurManager uManager = UtilisateurManagerSing.getInstance();
	//private CategorieManager cManager = CategorieManagerSing.getInstance();
	//private RetraisManager rManager = RetraisSing.getInstance();
//	private EnchereManager eManager = EnchereManagerSing.getInstance();


//    @Test
//    public void testInsert() {
//        ArticlesVendu article = new ArticlesVendu("apple watch", "description", LocalDate.now(), LocalDate.of(2023, 9, 30), 100, 0, 5, 1);
//        try {
//            articleVendusDAO.insert(article);
//            assertNotNull("No Article ID generated", article.getNo_article());
//        } catch (DalException e) {
//            fail("Insert failed: " + e.getMessage());
//        }
//    }

//    @Test
//    public void testDelete() {
//        int id = 1; 
//        try {
//            articleVendusDAO.delete(id);
//            ArticlesVendu article = articleVendusDAO.findByArticleByNo(id);
//            assertNull("Article should be deleted", article);
//        } catch (DalException e) {
//            fail("Delete failed: " + e.getMessage());
//        }
//    }


//	 @Test
//    public void testFindArticleByNo() throws ManagerException  {
//        ArticlesVendu article = aManager.getArticlesVendus(2);
//        System.out.println(article);
//		assertNotNull(article);
//    }
	 

	 @Test
    public void DEBUG() throws ManagerException  {
		 
        //ArticlesVendu article = aManager.getArticlesVendus(2);
		 UtilisateurManager uManager = UtilisateurManagerSing.getInstance();
        Utilisateur user = uManager.getUtilisateur(5);
        CategorieManager cManager = CategorieManagerSing.getInstance();
        System.out.println(user);
        
        
		assertNotNull(user);
    }
    
//    @Test
//    public void testGetAll() {
//        try {
//            List<ArticlesVendu> articles = articleVendusDAO.getAll();
//            assertNotNull("List should not be null", articles);
//            assertTrue("List should not be empty", articles.size() > 0);
//        } catch (DalException e) {
//            fail("GetAll failed: " + e.getMessage());
//        }
//    }

} 
