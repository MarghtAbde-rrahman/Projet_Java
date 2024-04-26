package consoCarbone;

public class LogementsException extends Exception{
	private static final long serialVersionUID = 1L;
	/**
	 * Constructeur par defaut d'une exception sur les logements 
     */
    public LogementsException() {};
    /**
	 * Affichage sur la console d'un message d'exception 
	 * @param message affichee sur la console si l'exception est levee 
     */
    public LogementsException(String message) {
	   super(message);
	}
}
