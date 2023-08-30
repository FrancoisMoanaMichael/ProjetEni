package fr.eni.projetEni.dal.test;

import fr.eni.projetEni.bo.Utilisateurs;
import fr.eni.projetEni.dal.UtilisateursDAO;
import fr.eni.projetEni.dal.UtilisateursDAOImpl;

public class UtilisateursTest {
	
	 UtilisateursDAO dao = new UtilisateursDAOImpl();
	 Utilisateurs testUser = new Utilisateurs("teo", "theo", "jacob", "teo@eni.fr", "0652654522", "bd xav", "75000", "paris", "password", 0, false);
	 
	

//	 @Test
//	    public void testInsert() {
//	        Utilisateurs utilisateur = new Utilisateurs("teo", "theophile", "jacob", "teo@eni.fr", "0782141465", "bd robert schuman", "44300", "nantes", "password", 0, false);
//	        try {
//	            dao.insert(utilisateur);
//	            assertTrue(utilisateur.getNo_utilisateur() > 0);
//	        } catch (DalException e) {
//	            fail("Insert failed: " + e.getMessage());
//	        }
//	    }

//	
//	 @Test
//	 public void testDelete() {
//	     try {
//	         int id = 4;
//	         dao.delete(id);
//	         Utilisateurs utilisateur = dao.findUtilisateurByNo(id);
//	         assertNull(utilisateur);  
//	     } catch (DalException e) {
//	         fail("Delete failed: " + e.getMessage());
//	     }
//	 }
	 
//	 @Test
//	    public void testFindUtilisateurByNo() {
//	        try {
//	            Utilisateurs foundUser = dao.findUtilisateurByNo(5);
//	            assertEquals(testUser.getPseudo(), foundUser.getPseudo());
//	        } catch (DalException e) {
//	            fail("Find by ID failed: " + e.getMessage());
//	        }
//	    }

//	 @Test
//	    public void testGetAll() {
//	        try {
//	            List<Utilisateurs> utilisateurs = dao.getAll();
//	            assertTrue(utilisateurs.size() > 0);
//	        } catch (DalException e) {
//	            fail("Get all failed: " + e.getMessage());
//	        }
//	    }
	 
//	 @Test
//	    public void testUpdate() {
//	        try {
//	        	Utilisateurs user = dao.findUtilisateurByNo(5);
//	        	System.out.println(user);
//	        	user.setPseudo("updatedPseudo");
//	            dao.update(user);
//	            assertEquals("updatedPseudo", user.getPseudo());
//	        } catch (DalException e) {
//	            fail("Update failed: " + e.getMessage());
//	        }
//	    }
	 
}
