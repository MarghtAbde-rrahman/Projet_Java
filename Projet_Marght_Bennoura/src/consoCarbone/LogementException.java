package consoCarbone;

public class LogementException extends Exception {
	private static final long serialVersionUID = 1L;
	/**
	 * Constructeur par defaut d'une exception sur un logement
     */
    public LogementException() {};
    /**
	 * Affichage sur la console d'un message d'exception 
	 * @param message affichee sur la console si l'exception est levee 
     */
    public LogementException(String message) {
	   super(message);
	}
}
