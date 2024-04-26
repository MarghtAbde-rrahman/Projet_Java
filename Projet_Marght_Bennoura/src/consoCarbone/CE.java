package consoCarbone;

/**
 * CE est une enumeration des classes energetiques d'un logement associee a leur facteur d'empreinte carbone 
 * @author Karim Bennoura,Abde-Rrahman 
 */
public enum CE{A(0.005),B(0.01),C(0.02),D(0.035),E(0.055),F(0.08),G(0.1);
	
	private double alphaCE;
	CE(double a){
		this.alphaCE = a;
	}
	
	/**
	 * Recupere le coefficient multiplicatif de la classe energetique
	 * @return la valeur du coefficient multiplicatif de la classe energetique et qui est utile au calcul de l'empreinte carbone du logement
	 */
	public double getAlphaCE() {
		return alphaCE;
	}


};
