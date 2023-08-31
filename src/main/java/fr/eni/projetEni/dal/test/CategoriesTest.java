package fr.eni.projetEni.dal.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import fr.eni.projetEni.bo.Categorie;
import fr.eni.projetEni.dal.CategorieDAO;
import fr.eni.projetEni.dal.CategorieDAOImpl;

public class CategoriesTest {

	CategorieDAO categorieDao = new CategorieDAOImpl();

//	@Test
//	public void testFindByNo() {
//	    try {
//	        Categories categorie = categorieDao.findByNo(1);
//	        System.out.println(categorie);
//	        assertEquals("Category IDs do not match", (Integer) 1, (Integer) categorie.getNo_categorie());
//	    } catch (Exception e) {
//	        fail("FindByNo failed: " + e.getMessage());
//	    }
//	}
	
//	@Test
//	public void testFindByName() {
//	    try {
//	        Categories categorie = categorieDao.findByName("Montres");
//	        assertNotNull("Categorie should not be null", categorie);
//	        assertEquals("Montres", categorie.getLibelle());
//	    } catch (Exception e) {
//	        fail("FindByName failed: " + e.getMessage());
//	    }
//	}
	
//	@Test
//	public void testGetAll() {
//	    try {
//	        List<Categories> categories = categorieDao.getAll();
//	        assertNotNull("List should not be null", categories);
//	        assertTrue("List should not be empty", categories.size() > 0);
//	    } catch (Exception e) {
//	        fail("GetAll failed: " + e.getMessage());
//	    }
//	}


	
}
