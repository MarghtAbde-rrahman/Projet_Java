package consoCarbone;

/**
 * Transport est un poste de consommation carbone concernant l'utilisation d'une voiture par un individu
 * @author Karim Bennoura,Abde-Rrahman 
 * @version 3.1
 */
public class Transport extends ConsoCarbone{
	private boolean possede;
	private Taille taille;
	private int kilomAnnee;
	private int amortissement;
	/**
	 * Valeur de l'empreinte carbone moyenne generee par l'utilisation d'un vehicule
	 */
	public final static double EC = 2.920;
	
	/**
	 * constructeur par defaut d'un Transport
	 */
	public Transport() {
		super();
		possede=false;
		taille=Taille.P; // en realite ca n'a pas de sens mais il faut bien initialiser la variable déclarées comme Taille
		kilomAnnee=0;
		amortissement=0;
		impact=0;
	}
	
	/**
	 * constructeur d'un Transport
	 * @param possede indique si l'utilisateur possede un vehicule (true) ou non (false)
	 * @param taille petite ou grande
	 * @param kilomAnnee nombre de kilometres parcourus en une annee avec le vehicule
	 * @param amortissement nombre d'annee de possession du vehicule
	 */
	public Transport(boolean possede,Taille taille,int kilomAnnee,int amortissement) {
		super();
		this.possede=possede;
		this.taille=taille;
	    this.kilomAnnee=kilomAnnee;
	    this.amortissement=amortissement;
	    if (possede == false)
			impact = 0;
	    else
	    	impact = kilomAnnee * 1.93 * 0.0001 + taille.getEmission()/amortissement;
	}
	/**
	 * @return la consommation carbone moyenne du au transport en France
	 */
	public double getEC() {
		return EC;
	}
	/**
	 * @return Renvoie true si il/elle possede une voiture, false sinon.
	 */
	public boolean isPossede() {
		return possede;
	}
	/**
	 * Mise a jour de la possession d'une voiture et recalcul de l'imapact carbone
	 * @param possede La possession ou non d'une voiture
	 */
	public void setPossede(boolean possede) {
		this.possede = possede;
		if(possede) {impact = kilomAnnee * 1.93 * 0.0001 + taille.getEmission()/amortissement;}
		else {impact = 0;}
	}
	/**
	 * @return Renvoie la taille de la voiture avec un objet de classe Taille
	 */
	public Taille getTaille() {
		return taille;
	}
	/**
	 * Mise a jour de la taille de la voiture et recalcul de l'imapact carbone
	 * @param taille La taille d'une voiture
	 */
	public void setTaille(Taille taille) {
		this.taille = taille;
		impact = kilomAnnee * 1.93 * 0.0001 + taille.getEmission()/amortissement;
	}
	/**
	 * @return Renvoie le nombre de kilometre parcouru par la voiture l'annee derniere
	 */
	public double getKilomAnnee() {
		return kilomAnnee;
	}
	/**
	 * Mise a jour du nombre de kilometre parcouru par la voiture l'annee derniere et recalcul de l'imapact carbone
	 * @param kilomAnnee Le nombre de kilometre parcouru par la voiture l'annee derniere
	 */
	public void setKilomAnnee(int kilomAnnee) {
		this.kilomAnnee = kilomAnnee;
		impact = kilomAnnee * 1.93 * 0.0001 + taille.getEmission()/amortissement;
	}
	/**
	 * @return Renvoie le nombre d'annee d'amortissement de la voiture
	 */
	public int getAmortissement() {
		return amortissement;
	}
	/**
	 * Mise a jour du nombre d'annee d'amortissement de la voiture et recalcul de l'imapact carbone
	 * @param amortissement Le nombre d'annee d'amortissement de la voiture
	 */
	public void setAmortissement(int amortissement) {
		this.amortissement = amortissement;
		impact = kilomAnnee * 1.93 * 0.0001 + taille.getEmission()/amortissement;
	}

	/**
	 * Affichage sur la cosnole de l'empreinte carbonne moyenne d'un français vis à vis du transport
	 */
	public static void EC_Transport(){
	    System.out.println("\nFUN FACT : L'empreinte carbone moyen d'un.e français.e concernant le transport est de 2920 Kg de CO2 par an.");
	}
	/**
	 * Affichage des informations d'un Transport dans une chaine de caracteres
	 */
	@Override
    public String toString(){  
        //cas ou l'utilisateur n'a pas de voiture:
	    if (possede==false) return("\nVous ne possèdez pas de voiture."+super.toString());
	    //sinon l'utilisateur possede une voiture
	    if (taille==Taille.P) return ("\nVous possèdez une petite voiture depuis "+ amortissement +" ans, et vous avez parcouru "+ kilomAnnee+ "km avec."+super.toString());
	    return("\nVous possèdez une grande voiture depuis "+ amortissement +" ans, et vous avez parcouru "+ kilomAnnee+ "km avec."+super.toString());
	
    }	
	
}