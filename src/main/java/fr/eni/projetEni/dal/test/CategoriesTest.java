package fr.eni.projetEni.dal.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import fr.eni.projetEni.bo.Categories;
import fr.eni.projetEni.dal.CategorieDAO;
import fr.eni.projetEni.dal.CategorieDAOImpl;

public class CategoriesTest {

	CategorieDAO categorieDao = new CategorieDAOImpl();

	@Test
	public void testFindByNo() {
	    try {
	        Categories categorie = categorieDao.findByNo(1);
	        System.out.println(categorie);
	        assertEquals("Category IDs do not match", (Integer) 1, (Integer) categorie.getNo_categorie());
	    } catch (Exception e) {
	        fail("FindByNo failed: " + e.getMessage());
	    }
	}

	
}
