package consoCarbone;
/**
 * ServicesPublic est un poste de consommation carbone concernant les services public
 * @author Karim Bennoura,Abde-Rrahman 
 * @version 3.1
 */
public class ServicesPublic extends ConsoCarbone{
	/**
	 * Valeur de l'empreinte carbone moyenne d'un francais concernant les services public
	 */
	public final static double EC = 1.5;
   /**
    * Constructeur par defaut d'un poste de consommation ServicesPublic
    * Tous les français ont le même impact carbone concernant les services publics, un constructeur par defaut est suffisant
    */
	public ServicesPublic() {
		super();
		impact = 1.5;
	}
	
	/**
	 * Recupere la valeur de l'empreinte carbone generee par les services public qui est toujours la meme 
	 * @return 1.5 la valeur constante de l'empreitne carbone generee par les services public
	 */
    public final double getImpact() {
    	return 1.5;
    }
 
    @Override 
    public String toString() {
        return (super.toString());
    }
   
}