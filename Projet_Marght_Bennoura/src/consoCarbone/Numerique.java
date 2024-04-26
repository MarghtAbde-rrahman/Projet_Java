package consoCarbone;

/**
 * Numerique est un poste de consommation carbone concernant l'utilisation d'appareils electroniques
 * @author Abde-Rrahman Marght,Karim Bennoura
 * @version 1
 */
public class Numerique extends ConsoCarbone{
	private boolean television;
	private boolean ordinateur;
	private boolean tablette;
	private boolean smartphone;
	private boolean console;
	private double[] consos = {0.1136,0.845,0.75,0.3,0.51};
	/**
	 * Valeur de l'empreinte carbonne moyenne d'un francais concernant ses appareils numeriques
	 */
	public final static double EC = 1.652;
	
	/**
	 * Constructeur par defaut d'un Numerique
	 */
	public Numerique() {
		super();
		boolean[] tab = {television,ordinateur,tablette,smartphone,console};
		for (int j = 0; j < tab.length; j++) {
			tab[j] = false;
		}
		impact = 0;
	}
	
	/**
	 * Constructeur d'un Numerique
	 * @param te indique si l'utilisateur possede une television(true) ou non(false)
	 * @param o indique si l'utilisateur possede un ordinateur(true) ou non(false)
	 * @param ta indique si l'utilisateur possede une tablette(true) ou non(false)
	 * @param s indique si l'utilisateur possede un smartphone(true) ou non(false)
	 * @param c indique si l'utilisateur possede une console(true) ou non(false)
	 */
	public Numerique(boolean te, boolean o, boolean ta, boolean s, boolean c) {
		super();
		this.television = te;
		this.ordinateur = o;
		this.tablette = ta;
		this.smartphone = s;
		this.console = c;
		boolean[] tab = {television,ordinateur,tablette,smartphone,console};
		impact = 0;
		for (int j = 0; j < tab.length; j++) {
			if(tab[j]) {
				impact += consos[j];
			}
		}
	}
    
	/**
	 * Recupere l'information sur la possession d'une television
	 * @return true si l'utilisateur possede une tele,false sinon
	 */
	public boolean isTelevision() {
		return television;
	}

	/**
	 * Mise a jour de la possession d'une television et du calcul de l'impact carbone des appareils numeriques
	 * @param television un boolean indiquant la possession ou non d'une television
	 */
	public void setTelevision(boolean television) {
		this.television = television;
		boolean[] tab = {television,ordinateur,tablette,smartphone,console};
		impact = 0;
		for (int j = 0; j < tab.length; j++) {
			if(tab[j]) {
				impact += consos[j];
			}
		}
	}

	/**
	 * Recupere l'information sur la possession d'un ordinateur
	 * @return true si l'utilisateur possede un ordinateur,false sinon
	 */
	public boolean isOrdinateur() {
		return ordinateur;
	}

	/**
	 * Mise a jour de la possession d'un ordinateur et du calcul de l'impact carbone des appareils numeriques
	 * @param ordinateur un boolean indiquant la possession ou non d'un ordinateur
	 */
	public void setOrdinateur(boolean ordinateur) {
		this.ordinateur = ordinateur;
		boolean[] tab = {television,ordinateur,tablette,smartphone,console};
		impact = 0;
		for (int j = 0; j < tab.length; j++) {
			if(tab[j]) {
				impact += consos[j];
			}
		}
	}

	/**
	 * Recupere l'information sur la possession d'une tablette
	 * @return true si l'utilisateur possede une tablette,false sinon
	 */
	public boolean isTablette() {
		return tablette;
	}

	/**
	 * Mise a jour de la possession d'une television et du calcul de l'impact carbone des appareils numeriques
	 * @param tablette un boolean indiquant la possession ou non d'une tablette
	 */
	public void setTablette(boolean tablette) {
		this.tablette = tablette;
		boolean[] tab = {television,ordinateur,tablette,smartphone,console};
		impact = 0;
		for (int j = 0; j < tab.length; j++) {
			if(tab[j]) {
				impact += consos[j];
			}
		}
	}

	/**
	 * Recupere l'information sur la possession d'un smartphone
	 * @return true si l'utilisateur possede un smartphone,false sinon
	 */
	public boolean isSmartphone() {
		return smartphone;
	}

	/**
	 * Mise a jour de la possession d'un smartphone et du calcul de l'impact carbone des appareils numeriques
	 * @param smartphone un boolean indiquant la possession ou non d'un smartphone
	 */
	public void setSmartphone(boolean smartphone) {
		this.smartphone = smartphone;
		boolean[] tab = {television,ordinateur,tablette,smartphone,console};
		impact = 0;
		for (int j = 0; j < tab.length; j++) {
			if(tab[j]) {
				impact += consos[j];
			}
		}
	}

	/**
	 * Recupere l'information sur la possession d'une console
	 * @return true si l'utilisateur possede une console,false sinon
	 */
	public boolean isConsole() {
		return console;
	}

	/**
	 * Mise a jour de la possession d'une console et du calcul de l'impact carbone des appareils numeriques
	 * @param console Indique si l'utilisateur possede une console ou non.
	 */
	public void setConsole(boolean console) {
		this.console = console;
		boolean[] tab = {television,ordinateur,tablette,smartphone,console};
		impact = 0;
		for (int j = 0; j < tab.length; j++) {
			if(tab[j]) {
				impact += consos[j];
			}
		}
	}
	
	/**
	 * Empreinte carbonne moyenne d'un français vis à vis des appareils numeriques
	 */
	public static void EC_Numerique(){
	    System.out.println("\nFUN FACT : L'empreinte carbone moyen d'un.e français.e"
	    		+ " concernant les appareils numerique est de 228 Kg de CO2 par an.");
	}
	
	/**
	 * Affichage des informations d'un Numerique 
	 */
	@Override
    public String toString(){  
        return(super.toString());
	
    }	
}