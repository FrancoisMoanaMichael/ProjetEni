package fr.eni.projetEni.dal.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import fr.eni.projetEni.bo.ArticlesVendu;
import fr.eni.projetEni.dal.ArticleVendusDAO;
import fr.eni.projetEni.dal.ArticleVendusDAOImpl;
import fr.eni.projetEni.dal.DalException;

public class ArticleVendusTest {

    private ArticleVendusDAO articleVendusDAO = new ArticleVendusDAOImpl();


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


//    @Test
//    public void testFindByArticleByNo() {
//        int id = 2;  // Again, get this dynamically or set up via a fixture
//        try {
//            ArticlesVendu article = articleVendusDAO.findByArticleByNo(id);
//            assertNotNull("Article should not be null", article);
//        } catch (DalException e) {
//            fail("FindByArticleByNo failed: " + e.getMessage());
//        }
//    }
    
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
