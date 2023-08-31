package fr.eni.projetEni.dal2;

public class DalException extends Exception {
	private static final long serialVersionUID = 1L;
	
	//Constructeurs
	public DalException() {super();}
	public DalException(String message) {super(message);}
	public DalException(String message, Throwable exception) {super(message, exception);}
	
	//Méthodes
	@Override
	public String getMessage() {
		StringBuffer sb = new StringBuffer("Couche DAL - ");
		sb.append(super.getMessage());
		
		return sb.toString() ;
	}
}
