package fr.eni.projetEni.bll2;

public class ManagerException extends Exception {
	private static final long serialVersionUID = 1L;
	
	//Constructeurs
		public ManagerException() {super();}
		public ManagerException(String message) {super(message);}
		public ManagerException(String message, Throwable exception) {super(message, exception);}
		
		//Méthodes
		@Override
		public String getMessage() {
			StringBuffer sb = new StringBuffer("Couche BLL - ");
			sb.append(super.getMessage());
			
			return sb.toString() ;
		}
}
