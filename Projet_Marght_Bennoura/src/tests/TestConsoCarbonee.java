package tests;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import consoCarbone.CE;
import consoCarbone.ConsoCarbone;
import consoCarbone.Logement;

class TestConsoCarbonee {

	private ConsoCarbone X;
    
    /**
     * Initialisation d'un ConsoCarbone qui va servir de comparateur pour tous nos tests
     */
	@BeforeEach
	public void init_conso() {
	  this.X=new Logement(100,CE.C);
	}
	
	
	/**
	 * Liberation de la memoire apres chaque test
	 */
	@AfterEach
	public void clear_conso() {
		X=null;
	}
	/**
	 * Test de comparaison entre deux postes de consommation dont les empreintes carbone sont les memes
	 */
	@Test
	public void compareTo_empreinteegales_returnszero() {
		ConsoCarbone Y=new Logement(200,CE.B);
		assertEquals(0,X.compareTo(Y));
	}
	/**
	 * Test de comparaison avec un poste de consommation dont l'empreinte carbone est moins elevee
	 */
	@Test
	public void compareTo_empreinteplusgrande_returnsone() {
		ConsoCarbone Y=new Logement(100,CE.B);
		assertEquals(0,X.compareTo(Y));
	}
	/**
	 * Test de comparaison avec un poste de consommation dont l'empreinte carbonne est plus elevee
	 */
	@Test
	public void compareTo_empreintemoinsgrande_returnsminusone() {
		ConsoCarbone Y=new Logement(300,CE.B);
		assertEquals(0,X.compareTo(Y));
	}

}
