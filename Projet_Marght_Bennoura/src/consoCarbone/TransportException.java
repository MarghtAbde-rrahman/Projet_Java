package consoCarbone;

public class TransportException extends Exception{
	private static final long serialVersionUID = 1L;
	/**
	 * Constructeur par defaut d'une exception sur un moyen de transport
     */
    public TransportException() {};
    /**
	 * Affichage sur la console d'un message d'exception 
	 * @param message affichee sur la console si l'exception est levee 
     */
    public TransportException(String message) {
	   super(message);
	}
}
