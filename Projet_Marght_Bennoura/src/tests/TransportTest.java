package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import consoCarbone.*;

class TransportTest {

	private Transport unePetiteVoiture;
	private Transport uneAutrePetiteVoiture;
	private Transport pasUneVoiture;
	private Transport uneFalseVoiture;
	
	/**
    * Initialisation d'une Petite Voiture dont la consommation sont initalises arbitrairement
    */
	@BeforeEach
	public void init_transport() {
		this.unePetiteVoiture = new Transport(true,Taille.P,60000,5);
		this.uneAutrePetiteVoiture = new Transport(true,Taille.P,60000,0);
		this.pasUneVoiture = new Transport();
		this.uneFalseVoiture = new Transport(false,Taille.P,60000,5);
	}
	
	
	@Test
	public void testGetImpact() {
		assertEquals(unePetiteVoiture.getImpact(), 12.42,"Erreur sur l'impact écologique de la voiture !");
		unePetiteVoiture.setKilomAnnee(500);;
		assertEquals(unePetiteVoiture.getKilomAnnee(), 500,"Erreur sur le nb de kilometre de de la voiture !");
		assertEquals(Math.round(unePetiteVoiture.getImpact() * 100.0) / 100.0, 0.94,"Erreur sur l'impact écologique de la voiture !");
	}

	@Test
	public void testCompareTo() {
		uneAutrePetiteVoiture.setAmortissement(5);
		assertEquals(unePetiteVoiture.compareTo(uneAutrePetiteVoiture),0,"Erreur sur la comparaison de 2 \"Transport\"");
		uneAutrePetiteVoiture.setTaille(Taille.G);
		assertEquals(unePetiteVoiture.compareTo(uneAutrePetiteVoiture),-1,"Erreur sur la comparaison de 2 \"Transport\"");
		assertEquals(uneAutrePetiteVoiture.compareTo(unePetiteVoiture),1,"Erreur sur la comparaison de 2 \"Transport\"");
		
	}
	
	@Test
	public void testToString() {
		assertEquals(pasUneVoiture.toString().equals("\nVous ne possèdez pas de voiture."),false,"Erreur sur le \"toString\"");
		
	}
	
	@Test 
	public void testGetAmortissement(){
		assertEquals(unePetiteVoiture.getAmortissement(),5,"Erreur sur le getter de l'amortissement");
	}
	
	@Test
	public void testGetEC() {
		assertEquals(pasUneVoiture.getEC(),2.920,"Erreur sur le getter de EC");
	}
	
	@Test
	public void testIsAndGetPossede() {
		uneFalseVoiture.setPossede(true);
		assertEquals(uneFalseVoiture.isPossede(),true,"Erreur sur le getter de possede");
		uneFalseVoiture.setPossede(false);
		assertEquals(uneFalseVoiture.isPossede(),false,"Erreur sur le getter de possede");
	}
	
	@Test
	public void testGetTaille() {
		assertEquals(unePetiteVoiture.getTaille(),Taille.P,"Erreur sur le getter de Taille");
	}
	
	/**
    * Liberation de la memoire apres le test
    */
    @AfterEach
    public void clear_transport() {
	    this.unePetiteVoiture=null;
    }
}

