package consoCarbone;

/**
 * ConsoCarbone represente un poste de consommation carbone d'un individu
 * @author Karim Bennoura,Abde-Rrahman Marght
 * @version 2.1
 */
public abstract class ConsoCarbone implements Comparable<ConsoCarbone>{
	/**
	 * Variable pour la couleur
	 */
	public static final String ANSI_RED = "\u001B[31m";
	/**
	 * Variable pour la couleur
	 */
	public static final String ANSI_RESET = "\u001B[0m";
	protected double impact;
	private final int ID;
	private static int cpt;
	
	
	/**
	 * constructeur par defaut d'un poste de consommation ConsoCarbone
	 */
	public ConsoCarbone() {
		impact = 0;
		cpt++;
		ID = cpt;
	}
	
	/**
	 * constructeur d'un poste de consommation ConsoCarbone
	 * @param impact Impact de la consommation carbone
	 */
	public ConsoCarbone(double impact) {
		this.impact = impact;
		cpt++;
		ID = cpt;
	}
	/**
	 * Recupere l'impact carbone du poste de consommation
	 * @return un double qui est la valeur de l'empreinte carbone en tonne de CO2
	 */
	public double getImpact() {
		return impact;
	}
	
	/**
	 * Renvoie l'identifiant du poste de consommation
	 * @return un entier 
	 */
	public int getID() {
		return ID;
	}
	/**
	 * Affichage sur la console de l'empreinte carbone du poste de consommation
	 * @return une chaine de caracteres
	 */
	public String toString(){   
		String impact2 = String.format("%.02f", impact);
		return "\nL'empreinte carbone est donc de "+ANSI_RED+impact2+ANSI_RESET+" TCO2eq.";
    }
	
	@Override
	/**
	 * Comparaison des empreintes carbones de deux postes de consommation carbone
	 * @paramc2 un poste de consommation
	 * @return 0 si les empreintes sont les memes,1 si c2 a une empreinte moins elevee et _1 dans le dernier cas
	 */
	public int compareTo(ConsoCarbone c2) {
	  //les valeurs retournées ont été choisies arbitrairement 
	  if (this.getImpact()<c2.getImpact()) return (-1);
	  if (this.getImpact()==c2.getImpact()) return 0;
	  else return 1;
    }

}
