package consoCarbone;

public class BienConsoException extends Exception{
	private static final long serialVersionUID = 1L;
	/**
	 * Constructeur par defaut d'une exception sur les biens de consommation
     */
    public BienConsoException() {};
    /**
	 * Affichage sur la console d'un message d'exception 
	 * @param message affichee sur la console si l'exception est levee 
     */
    public BienConsoException(String message) {
	   super(message);
	}
}
