package consoCarbone;

/**
 * Taille est une enumeration des tailles possibles d'un vehicule: petit ou grand
 * @author Karim Bennoura,Abde-Rrahman 
 * @version 3.1
 */
public enum Taille{
	P(4.2),G(19);

	private double emission;
	Taille(double e){
		this.emission = e;
	}
	
	/**
	 * Recupere l'emission carbone d'un vehicule
	 * @return la valeur de l'emission carbone d'un vehicule selon sa taille
	 */
	public double getEmission() {
		return emission;
	}
}
