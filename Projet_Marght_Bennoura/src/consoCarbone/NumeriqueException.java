package consoCarbone;

public class NumeriqueException extends Exception{
	private static final long serialVersionUID = 1L;
	   /**
	    * Constructeur par defaut d'une exception sur la possession d'un appareil numerique
	    */
	   public NumeriqueException() {};
	   /**
	    * Affichage sur la console d'un message d'exception 
	    * @param message affichee sur la console si l'exception est levee 
	    */
	   public NumeriqueException(String message) {
		   super(message);
	   }
}
