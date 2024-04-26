/**
 * Comparable est une interface de comparaison de l'empreinte carbone de deux postes de consommation carbone
 * @author Karim Bennoura,Abde-Rrahman Marght
 * @version 1
 */
package consoCarbone;

/**
 * Interface generique qui va etre utile pour la comparaison de deux postes de consommation carbone
 * @param <T> la classe que l'on considere ce sera ConsoCarbone dans ce projet
 */
public interface Comparable<T> {
    
	/**
	 * Methode de comparaison qui sera definie dans la classe ConsoCarbone implementant cette interface
	 * @param c2 un objet de notre classe (ce sera un poste de consommation carbone)
	 * @return Revoie 0 si les 2 consoCarbone ont le meme impact, -1 si celui de 1 est inferieur a c2 et 1 sinon.
	 */
    public int compareTo(T c2);
}
