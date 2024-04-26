package consoCarbone; 

/**
 * Alimentation est un poste de consommation carbone concernant le logement d'un individu
 * @author Karim Bennoura,Abde-Rrahman 
 * @version 3.1
 */
public class Logement extends ConsoCarbone{
	private int superficie;
	private CE ce;
	/**
	 * Empreinte carbone moyenne d'un logement 
	 */
	public final static double EC = 2.706;

	/**
	 * constructeur par défaut d'un Logement
	 */
	public Logement(){
		super();
		superficie=0;
		ce=CE.G;  //le pire des cas est applique si l'utilisateur ne nous donne pas l'information
		impact=0;
	}
	
	/**
	 * constructeur d'un Logement
	 * @param superficie est la superficie en metres carres du logement
	 * @param ce est la classe energetique du logement
	 */
	public Logement(int superficie,CE ce){
	  super();
	  this.superficie=superficie;
	  this.ce=ce;
	  impact = ce.getAlphaCE()*superficie;
	}
	
	/**
	 * Recupere la valeur de l'empreinte carbone moyenne des francais concernant leur logement
	 * @return la valeur de l'empreinte carbone moyenne d'un logement en france
	 */
	public double getEC() {
		return EC;
	}
	
	/**
	 * Recupere la valeur de la superficie d'un logement en metres carres 
	 * @return la superficie d'un logement
	 */
	public int getSuperficie() {
		return superficie;
	}
    
	/**
	 * Mise a jour de la superficie du logement et recalcul de l'imapact carbone
	 * @param superficie la superficie du logement
	 */
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
		impact = ce.getAlphaCE()*superficie;
	}
    
	/**
	 * Recupere la classe energetique du logement
	 * @return la valeur de l'enumeration CE correspondant a la classe energetique du logement 
	 */
	public CE getCe() {
		return ce;
	}
    
	/**
	 * Mise a jour de la classe energetique du logement
	 * @param ce la classe energetique du logement
	 */
	public void setCe(CE ce) {
		this.ce = ce;
		impact = ce.getAlphaCE()*superficie;
	}

	/**
	 * Recupere l'impact carbone du poste de consommation Logement
	 * @return impact la valeur de l'empreinte carbone generee par le logement
	 */
	public double getImpact() {
		return impact;
	}
	
	/**
	 * Affichage sur la console de l’empreinte carbone moyenne du logement d'un.e français.e
	 */
	public static void EC_logement(){
	  System.out.println("\nFUN FACT : L'empreinte carbone moyen d'un.e français.e concernant le logement est de 2706 Kg de CO2 par an ?");
	}
	
	/**
	 * Affichage des informartions d'un logement dans une chaine de caracteres
	 */
    @Override
    public String toString(){ 
    	return "\nLa superficie du logement est de " + superficie + "m² et sa classe énérgétique est " + ce +"."+super.toString();
    }	
}

