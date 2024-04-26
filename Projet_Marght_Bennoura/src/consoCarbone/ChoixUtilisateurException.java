package consoCarbone;

public class ChoixUtilisateurException extends Exception{
	private static final long serialVersionUID = 1L;
	   /**
	    * Constructeur par defaut d'une exception sur le choix de l'utilisateur
	    */
	   public ChoixUtilisateurException() {};
	   /**
	    * Affichage sur la console d'un message d'exception 
	    * @param message affichee sur la console si l'exception est levee 
	    */
	   public ChoixUtilisateurException(String message) {
		   super(message);
	   }

}
