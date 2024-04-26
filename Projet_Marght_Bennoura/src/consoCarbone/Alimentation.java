
package consoCarbone;
/**
 * Alimentation est un poste de consommation carbone concernant l'alimentation d'un individu
 * @author Karim Bennoura,Abde-Rrahman 
 * @version 3.1
 */
public class Alimentation extends ConsoCarbone{
	private double txBoeuf;
	private double txVege;
	//valeurs constantes
	private final double cB=8.0;
	private final double cV=0.9;
	private final double cVB=1.6;
	/**
	 * Valeur de l'empreinte carbone moyenne generee par l'alimentation en France
	 */
	public final static double EC = 2.328;
	
	
	/**
	 * constructeur par defaut d'une Alimentation
	 */
	public Alimentation(){
	   super();
	   txBoeuf=0;
	   txVege=0;
	   impact=0;
	}
	
	
	/**
	 * constructeur d'une Alimentation
	 * @param txBoeuf le taux de repas a base de boeuf
	 * @param txVege le taux de repas vegetariens
	 */
	public Alimentation(double txBoeuf,double txVege){
		super();
	    // il y a beaucoup de decimales 
		impact=cB*txBoeuf+cVB*(1-txVege-txBoeuf)+cV*txVege;
		this.txBoeuf=txBoeuf;
		this.txVege=txVege;
	}
	/**
	 * Recupere la valeur de l'empreinte carbonne moyenne generee par l'alimentation
	 * @return la valeur de l'empreinte carbonne moyenne generee par l'alimentation
	 */
	public double getEC() {
		return EC;
	}
	
	/**
	 * Recupere la valeur du taux de repas à base de boeuf
	 * @return la valeur du taux de repas à base de boeuf 
	 */
	public double getTxBoeuf() {
		return txBoeuf;
	}
    
	/**
	 * Mise à jour de la valeur du taux de repas a base de boeuf et recalcul de l'empreinte carbone suite a ce changement 
	 * @param txBoeuf le taux de repas à base de boeuf
	 */
	public void setTxBoeuf(double txBoeuf) {
		this.txBoeuf = txBoeuf;
		impact=cB*txBoeuf+cVB*(1-txVege-txBoeuf)+cV*txVege;
	}
     
	/**
	 * Recupere la valeur du taux de repas vegetariens
	 * @return txVege la valeur du taux de repas de vegetariens
	 */
	public double getTxVege() {
		return txVege;
	}

	/**
	 * Mise à jour de la valeur du taux de repas vegetariens et recalcul de l'empreinte carbone suite a ce changement
	 * @param txVege le taux de repas vegetariens
	 */
	public void setTxVege(double txVege) {
		this.txVege = txVege;
		impact=cB*txBoeuf+cVB*(1-txVege-txBoeuf)+cV*txVege;
	}
    
	/**
	 * Recupere l'impact carbone du poste de consommation de l'alimentation
	 * @return impact la valeur de l'empreinte carbone generee par l'alimentation
	 */
	public double getImpact() {
		return impact;
	}
	/**
	 * Affichage sur la console de l'empreinte carbone moyenne concernant l'alimentation des français.e.s 
	 */
	public static void EC_alimentation(){
		System.out.println("\nFUN FACT : L'empreinte carbone moyenne d'un.e français.e concernant son alimentation est de 2328 Kg de CO2 par an");
	}
	/**
	 * Affichage des informations de l'Alimentation dans une chaine de caracteres
	 */
    @Override
    public String toString(){ 
    	return "\nLe taux de repas à base de boeuf consommés est de " + txBoeuf*100  + "% et le taux de repas végétariens consommés est de " + txVege*100 +"%."+super.toString();
    }
}