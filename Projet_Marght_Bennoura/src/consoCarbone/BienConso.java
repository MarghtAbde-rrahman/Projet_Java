package consoCarbone;

/**
 * BienConso est un poste de consommation carbone concernant les biens de consommation d'un individu
 * @author Karim Bennoura,Abde-Rrahman 
 * @version 3.1
 */
public class BienConso extends ConsoCarbone{
	private double montant;
	/**
	 * Empreinte carbonne moyenne provenant des biens de consommation
	 */
	public final static double EC = 2.625;
	
	/**
	 * constructeur par défaut d'un BienConso
	 */
	public BienConso() {
		super();
		montant=0;
		impact=0;
	}
	
	/**
	 * constructeur d'un BienConso
	 * @param montant des depenses anuelles
	 */
	public BienConso(double montant) {
		super();
		this.montant=montant;
	    impact=montant/1750;
	}
	
	/**
	 * Recupere le montant des depenses annuelles
	 * @return le montant des depenses annuelles
	 */
	public double getMontant() {
		return montant;
	}

	/**
	 * Calcul et mise à jour de l'empreinte carbone generee par les depenses annuelles 
	 * @param montant les depenses annuelles
	 */
	public void setMontant(double montant) {
		this.montant = montant;
		impact=montant/1750;
	}
	
	/**
	 * Recupere la valeur de l'empreinte carbone moyenne des français concernant les depenses anuelles
	 * @return l'empreinte carbonne moyenne des français concernant les depenses annuelles
	 */
	public double getEC() {
		return EC;
	}

    /**
     * Affichage sur la console de l'empreinte carbonne moyenne d'un français vis à vis des depenses anuelles 
     */
	public static void EC_BienConso(){
	    System.out.println("\nFUN FACT : L'empreinte carbone moyen d'un.e français.e concernant les biens de consommations est de 2625 Kg de CO2 par an?");
	}
	/**
	 * Affichage des information d'un BienConso dans une chaine de caracteres
	 */
	@Override
    public String toString(){  
		return "\nLe montant des dépenses annuelles est de " + montant +"euros."+super.toString();
    }
			
}