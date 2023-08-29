package fr.eni.projetEni.bll1;

public class RetraisSing {
	private static RetraisManager instance;
	public static RetraisManager getInstance() {
		if(instance==null) {
			instance=new RetraisManagerImpl();
		}
		return instance;
	}

}
