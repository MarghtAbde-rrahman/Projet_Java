package consoCarbone;

public class TransportsException extends Exception {
	private static final long serialVersionUID = 1L;
	/**
	 * Constructeur par defaut d'une exception sur des moyens de transport
     */
    public TransportsException() {};
    /**
	 * Affichage sur la console d'un message d'exception 
	 * @param message affichee sur la console si l'exception est levee 
     */
    public TransportsException(String message) {
	   super(message);
	}
}
