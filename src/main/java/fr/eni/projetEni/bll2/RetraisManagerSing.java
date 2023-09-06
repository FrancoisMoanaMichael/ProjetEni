package fr.eni.projetEni.bll2;

public class RetraisManagerSing {
	private static RetraisManager instance;
	
	public static RetraisManager getInstance() {
		if (instance==null) {
			instance = new RetraisManagerImpl();
		}
		return instance;
	}
}
