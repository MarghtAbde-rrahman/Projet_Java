package consoCarbone;

public class TauxAlimentationException extends Exception{
   private static final long serialVersionUID = 1L;
   /**
    * Constructeur par defaut d'une exception sur le taux d'alimentation 
    */
   public TauxAlimentationException() {};
   /**
    * Affichage sur la console d'un message d'exception 
    * @param message affichee sur la console si l'exception est levee 
    */
   public TauxAlimentationException(String message) {
	   super(message);
   }
}
