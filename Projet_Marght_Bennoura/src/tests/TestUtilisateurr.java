package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import consoCarbone.Alimentation;
import consoCarbone.BienConso;
import consoCarbone.CE;
import consoCarbone.Logement;
import consoCarbone.Numerique;
import consoCarbone.ServicesPublic;
import consoCarbone.Taille;
import consoCarbone.Transport;
import suite.Utilisateur;

class TestUtilisateurr {

	private Utilisateur U;
	   /**
	    * Initialisation d'un Utilisateur dont les postes de consommation sont initalises arbitrairement
	    */
	   @BeforeEach
	   public void init_util() {
		   Alimentation alimtest=new Alimentation(0.5,0.2);
		   BienConso bctest=new BienConso(3500);
		   ServicesPublic sptest=new ServicesPublic();
		   Numerique num=new Numerique(false,true,true,true,false);
		   Collection<Logement> logementstest=new ArrayList<Logement>();
		   Logement l1=new Logement(100,CE.C);
		   Logement l2=new Logement(200,CE.B);
		   Logement l3=new Logement(400,CE.A);
		   logementstest.add(l1);
		   logementstest.add(l2);
		   logementstest.add(l3);
		   Collection<Transport> transportstest=new ArrayList<Transport>();
		   Transport t1=new Transport(true,Taille.P,20000,7);
		   Transport t2=new Transport(true,Taille.G,50000,4);
		   transportstest.add(t1);
		   transportstest.add(t2);
		   this.U=new Utilisateur(alimtest,bctest,sptest,num,logementstest,transportstest);
	   }
	   /**
	    * Liberation de la memoire apres le test
	    */
	   @AfterEach
	   public void clear_util() {
		   this.U=null;
	   }
	   /**
	    * Test que la methode calculerEmpreinte() renvoie la bonne valeur de l'empreinte carbone totale en tonne de CO2
	    */
	   @Test
	   public void calculerEmpreinte_utilisateur_returnsvaleurempreintecarbone() {
		   //on compare avec la valeur de l'empreinte qu'on a calcule a la main
		   assertEquals(3.415,U.calculerEmpreinte());
	   }

}
