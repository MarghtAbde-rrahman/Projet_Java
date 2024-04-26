package consoCarbone;
import java.util.*;

import suite.Utilisateur;

/**
 * Menu est un menu interactif dans lequel l'utilisateur va pouvoir calculer l'empreinte carbone de ses postes de consommation
 * @author Abde-Rrahman Marght,Karim Bennoura
 * @version 4
 */
public class Menu {
	
	/**
	 *main est le corps du menu interactif par lequel l'utilisateur va pouvoir calculer l'empreinte carbone de ses postes de consommation
	 * @param args
	 * @throws TauxAlimentationException @see consoCarbone.TauxAlimentationException
	 * @throws ChoixUtilisateurException @see consocarbone.ChoixUtilisateurException
	 * @throws NumeriqueException @see consocarbone.NumeriqueException
	 * @throws BienConsoException @see consocarbone.BienConsoException
	 * @throws LogementsException @see consocarbone.LogementsException
	 * @throws LogementException @see consocarbone.LogementException
	 * @throws TransportException @see consocarbone.TransportException
	 * @throws TransportsException @see consocarbone.TransportsException
	 */
    public static void main(String[] args) throws TauxAlimentationException,ChoixUtilisateurException,NumeriqueException,BienConsoException,LogementsException,LogementException,TransportException,TransportsException{
    	 Scanner scanner = new Scanner(System.in);
    	 System.out.println("----------------------------------------------------------");
	     System.out.println(" BIENVENUE DANS LE MENU DU CALCULATEUR D'EMPREINTE CARBONE|");
	     System.out.println("----------------------------------------------------------");
	     //variable qui va récuperer le choix de l'utilisateur
    	 int choix;
    	 //on initialise l'ensemble des objets de chaque poste de consommation car peut être que l'utilisateur ne souhaitera pas calculer l'empreinte carbone de tous ses postes de consommation
    	 Alimentation alim = null;
    	 Collection<Logement> logements=null;
		 BienConso bc= null;
		 ServicesPublic sp=null;
		 Collection<Transport> tp=null;
		 Numerique num=null;
    	 do{
    		 choix=recupinfo(scanner);
    		 //on initialise les attributs 
    		 switch(choix) {
    		 //Une methode est ecrite pour l'affichage de l'etude de chaque poste de consommation pour alleger la lecture des cases dans le main 
    		     case 1:
                     alim=Menu.affichage_alimentation(scanner);
                     break;
    		     case 2:
    		    	 logements=Menu.affichage_logements(scanner);
    		    	 break;
    		     case 3:
    		    	 bc=Menu.affichage_biensconso(scanner);
    		    	 break;
    		     case 4:
    		    	 sp=Menu.affichage_servicepub();
    		    	 break;
    		     case 5:
    		    	 tp=Menu.affichage_transports(scanner);
    		    	 break;
    		     case 6:
    		    	 num=Menu.affichage_numerique(scanner);
    		    	 break;
    		  }
    	 }
    	 while (choix!=7);
    	 //On resume les informations d'empreinte carbone a l'utilisateur dans le cas ou il a donne des informations sur chacun de ses postes de consommation
    	 
    	 if ((alim!=null)&&(bc != null)&&(logements!=null)&&(sp!=null)&&(tp!=null)&&(num!=null)){
    		 Utilisateur U=new Utilisateur(alim,bc,sp,num,logements,tp);
    		 System.out.println("\nVoici un résumé de l'empreinte carbone de chacun de vos postes de consommations: ");
    		 U.detaillerEmpreinte();
    		 U.conseil();
    	 }
    	 System.out.println("Merci d'avoir utilisé ce menu pour calculer vos empreintes carbones.");
    	 
    }
    /**
     * Recupere l'information sur le calcul d'empreinte carbone que l'utilisateur souhaite faire
     * @return un entier qui indique l'option que l'utilisateur a choisi
     */
    public static int recupinfo(Scanner scanner) throws ChoixUtilisateurException{
    	 boolean correct;
    	 correct=true;
    	 //c va recuperer le choix de l'utilisateur
    	 int c=0;
	     do {
	        try{
	        	 System.out.println("\n");
		       	 System.out.println("De quel poste de consommation souhaitez-vous calculer votre empreinte carbone?");
		   	     System.out.println("1: Votre alimentation");
		   	     System.out.println("2: Votre logement ou vos logements");
		   	     System.out.println("3: Vos biens de consommation");
		   	     System.out.println("4: Vos dépenses liées au services public");
		   	     System.out.println("5: Votre véhicule ou vos véhicules");
		   	     System.out.println("6: Vos appareils numériques");
		   	     System.out.println("7: Quitter le menu interactif ");
		   	     System.out.println("Vous choisissez l'option(1-7): ");
		    	 c=scanner.nextInt();
		    	 if ((c<1)||(c>7)) {
			    	 throw new ChoixUtilisateurException("Votre choix doit être un entier compris entre 1 et 7!");
			     }
			     correct=false;
	        }
	        catch (InputMismatchException ex) {
	            System.out.println("Recommencez: un entier compris entre 1 et 7 est demandé.");
	            scanner.nextLine();
	           
	        }
	        catch (ChoixUtilisateurException e) {
	        	c=0;
	        	System.out.println(e.getMessage());
	        }
	        }
	        while (correct);
	     return c;
	        
    } 

 
    
    /**
     * Calcul interactif de l'empreinte carbone de l'alimentation de l'utilisateur
     * @return un objet Alimentation qui sera utile pour la creation d'un objet d'Utilisateur une fois toutes les informations recuperees
     */
    public static Alimentation affichage_alimentation(Scanner scanner) throws TauxAlimentationException {
    	boolean correct=true;
    	boolean essai=true;
    	//txBoeuf va recuperer le taux de repas a base de boeuf de l'utilisateur
	    double txBoeuf=0;
	  //txVege va recuperer le taux de repas vegetariens de l'utilisateur
	    double txVege=0; 
	    System.out.println("\nVous avez choisi de calculer l'empreinte carbone de votre alimentation!");
	    do {
	    	try {
	    		
			    do {
			        try{
			    	    System.out.println("Pouvez-vous me donner le taux de repas à base de boeuf que vous dévorer en moyenne (entrez une valeur entre O et 1) ?");
			    	    txBoeuf = scanner.nextDouble();  
			    	    if ((txBoeuf<0)||(txBoeuf>1)) {
			    	    	throw new TauxAlimentationException("Le taux de repas à base de boeuf doit être compris entre zéro et un!");
			    	    }
			    	    
			    	    //si aucune exception n'a ete levee je peux sortir du while creer mon objet Alimentation et le renvoyer
			    	    correct=false;
					 }
			        catch (InputMismatchException ex) {
			            System.out.println("Recommencez: un double compris entre 0 et 1 est demandé.");
			            scanner.nextLine();
			            }
			        catch (TauxAlimentationException e) {
			        	System.out.println(e.getMessage());
			        }
			     }
			     while (correct);
			     correct=true;
			     do {
			        try{
			    	    System.out.println("\nPouvez-vous maintenant m'indiquer le taux de repas végétariens que vous savourez en moyenne (entrez une valeur entre O et 1) ?");
			    	    txVege = scanner.nextDouble();   
			    	    if ((txVege<0)||(txVege>1)) {
			    	    	throw new TauxAlimentationException("Le taux de repas végétariens doit être compris entre zéro et un!");
			    	    }
			    	    //si aucune exception n'a ete levee je peux sortir du while creer mon objet Alimentation et le renvoyer
			    	    correct=false;
					 }
			        catch (InputMismatchException ex) {
			            System.out.println("Recommencez: un double compris entre 0 et 1 est demandé.");
			            scanner.nextLine();
			            }
			        catch (TauxAlimentationException e) {
			        	System.out.println(e.getMessage());
			        }
			     }
			     while (correct);
			     if ((txVege+txBoeuf)>1) {
		    	    	throw new TauxAlimentationException("La somme des taux de repas végétariens et à base de boeuf doit être comprise entre O et 1!");
		    	    }
			     essai=false;
	    	}
	    	catch(TauxAlimentationException e) {
	    		System.out.println(e.getMessage());
	    	}
	    }
	    while (essai);
	     Alimentation alim = new Alimentation(txBoeuf, txVege);   
	     Alimentation.EC_alimentation();
	     System.out.println(alim.toString());
	     return alim;
    }
    
    /**
     * Calcul interactif de l'empreinte carbone des appareils numeriques de l'utilisateur
     * @return un objet Numerique qui sera utile pour la creation d'un objet d'Utilisateur une fois toutes les informations recuperees
     */
    public static Numerique affichage_numerique(Scanner scanner) throws NumeriqueException {
    	boolean correct=true;
    	//Strings utiles pour recuperer les reponses de l'utilisateur concernant la possession de chaque appareil numerique
    	String rep1=""; 
    	String rep2="";
    	String rep3="";
    	String rep4="";
    	String rep5="";
    	//variables qui recupereront l'information sur la possession d'appareils numeriques et permettront d'initialiser un objet Numerique
    	boolean tele=false;
    	boolean ordi=false;
    	boolean tabl=false;
    	boolean smart=false;
    	boolean cons=false;
    	System.out.println("\nVous avez choisi de calculer l'empreinte carbone de vos appareils numériques!");
    	do {
    		try {
	    	    System.out.println("Pouvez-vous me dire si vous possédez une télévision?(oui/non)");
	    	    rep1=scanner.next();
	    	    if (!("oui".equals(rep1))&&!("non".equals(rep1))) {
	    	    	throw new NumeriqueException("Votre réponse doit être oui ou non!");
	    	    }
	    	    correct=false;
    		}
    		catch(NumeriqueException e) {
    			System.out.println(e.getMessage());
    		}
    	}
    	while(correct);
    	correct=true;
    	do {
    		try {
	    	    System.out.println("Pouvez-vous me dire si vous possédez un ordinateur?(oui/non)");
	    	    rep2=scanner.next();
	    	    if (!("oui".equals(rep2))&&!("non".equals(rep2))) {
	    	    	throw new NumeriqueException("Votre réponse doit être oui ou non!");
	    	    }
	    	    correct=false;
    		}
    		catch(NumeriqueException e) {
    			System.out.println(e.getMessage());
    		}
    	}
    	while(correct);
    	correct=true;
    	do {
    		try {
	    	    System.out.println("Pouvez-vous me dire si vous possédez un tablette?(oui/non)");
	    	    rep3=scanner.next();
	    	    if (!("oui".equals(rep3))&&!("non".equals(rep3))) {
	    	    	throw new NumeriqueException("Votre réponse doit être oui ou non!");
	    	    }	    	
	    	    correct=false;
    		}
    		catch(NumeriqueException e) {
    			System.out.println(e.getMessage());
    		}
    	}
    	while(correct);
    	correct=true;
    	do {
    		try {
        	    System.out.println("Pouvez-vous me dire si vous possédez un smartphone?(oui/non)");
	    	    rep4=scanner.next();
	    	    if (!("oui".equals(rep4))&&!("non".equals(rep4))) {
	    	    	throw new NumeriqueException("Votre réponse doit être oui ou non!");
	    	    }
	    	    correct=false;
	    	    
    		}
    		catch(NumeriqueException e) {
    			System.out.println(e.getMessage());
    		}
    	}
    	while(correct);
    	correct=true;
    	do {
    		try {
        	    System.out.println("Pouvez-vous me dire si vous possédez une console de jeu ?(oui/non)");
	    	    rep5=scanner.next();
	    	    if (!("oui".equals(rep5))&&!("non".equals(rep5))) {
	    	    	throw new NumeriqueException("Votre réponse doit être oui ou non!");
	    	    }    
	    	    correct=false;
    		}
    		catch(NumeriqueException e) {
    			System.out.println(e.getMessage());
    		}
    	}
    	while(correct);
	    if ("oui".equals(rep1)) {
	    	tele=true;
	    }
	    if ("oui".equals(rep2)) {
	    	ordi=true;
	    }
	    if ("oui".equals(rep3)) {
	    	tabl=true;
	    }
	    if ("oui".equals(rep4)) {
	    	smart=true;
	    }
	    if ("oui".equals(rep5)) {
	    	cons=true;
	    }
	    Numerique num=new Numerique(tele,ordi,tabl,smart,cons);
	    Numerique.EC_Numerique();
	    System.out.println(num.toString());
	    return num;
    }
    /**
     * Calcul interactif de l'empreinte carbone des biens de consommation de l'utilisateur
     * @return un objet BienConso qui sera utile pour la creation d'un objet d'Utilisateur une fois toutes les informations recuperees
     */
    public static BienConso affichage_biensconso(Scanner scanner) throws BienConsoException {
    	boolean correct=true;
    	//variable qui va recuperer le montant des depenses annuelles de l'utilisateur
    	double montant=0;
	    do {
		       try{
		        	System.out.println("\nVous avez choisi de calculer l'empreinte carbone de vos biens de consommation!");
		     	    System.out.println("Pouvez-vous me donner me donner le montant de vos dépenses annuelles en euros ?");
		     	    montant = scanner.nextDouble();  
		     	    if (montant<0) {
		     	    	throw new BienConsoException("Le montant de vos dépenses doit être une valeur positive!");
		     	    }
		     	    //si aucune exception n'a ete levee je peux sortir du while creer mon objet BienConso et le renvoyer
				    correct=false;
		        }
		        catch (InputMismatchException ex) {
		            System.out.println("Recommencez: une valeur positive est demandée.");
		            scanner.nextLine();
		            }
		        catch (BienConsoException e) {
		        	System.out.println(e.getMessage());
		        }
	      }
		while (correct);
	    //creation de l'element logement de la classe Logement avec les informations qu'on a recuperes
	    BienConso bc = new BienConso(montant);   
	    BienConso.EC_BienConso();
	    System.out.println(bc.toString());
	    return bc;
    }
    
    
    /**
     * Calcul interactif de l'empreinte carbone des services public concernant l'utilisateur
     * @return un objet ServicesPublic qui sera utile pour la creation d'un objet d'Utilisateur une fois toutes les informations recuperees
     */
    public static ServicesPublic affichage_servicepub() {
    	
	    System.out.println("\nVous avez choisi de calculer l'empreinte carbone provenant des services publics !");
	    ServicesPublic sp=new ServicesPublic();
	    System.out.println(sp.toString());
	    return sp;
    }

    /**
     * Calcul interactif de l'empreinte carbone d'un logement 
     * @return un objet Logement 
     */
    public static Logement affichage_logement(int i,Scanner scanner) throws LogementException {
    	boolean correct=true;
    	//on recupere le numero du logement de l'utilisateur pour qu'il ne se perde pas lors de l'entree d'informations
    	String number = Integer.toString(i);
    	//variable qui va recuperer la superfici du logement
	    int superficie=0;
	    //variable qui va recuperer la classe energetique du logement
	    String ce="F"; 
	    do {
	        try{
	        	System.out.println("Pouvez-vous me donner la superficie de votre logement numéro "+number+" en m2 ?");
	    	    superficie = scanner.nextInt();  
	            if(superficie<0) {
	            	throw new LogementException("La superficie doit être une valeur positive!");
	            }
			    correct=false;
	        }
	        catch (InputMismatchException ex) {
	            System.out.println("Recommencez: un entier positif est attendu!");
	            scanner.nextLine();
	            }
	        catch (LogementException e) {
	        	System.out.println(e.getMessage());
	        }
		}
	    while(correct);
	    correct=true;
	    do {
	        try{
	        	System.out.println("\nPouvez-vous maintenant m'indiquer la classe energetique de votre logement ?");
	    	    System.out.println("La classe énergétique de votre logement correspond à l'une des six suivantes: A,B,C,D,E,F ou G.");
	    	    ce = scanner.next(); 
	    	    if (!("A".equals(ce))&&!("B".equals(ce))&&!("C".equals(ce))&&!("D".equals(ce))&&!("E".equals(ce))&&!("F".equals(ce))&&!("G".equals(ce))){
	    	    	throw new LogementException("Vous devez rentrez un des lettres suivantes en majuscule:A,B,C,D,E,F ou G!");
	    	    }
	    	    //si aucune exception n'a ete levee je peux sortir du while, creer l'objet Logement et le renvoyer
			    correct=false;
	        }
	        catch (LogementException e) {
	        	System.out.println(e.getMessage());
	        }
		}
	    while(correct);
	    
	    //creation de l'element logement de la classe Logement avec les informations qu'on a recuperes
	    Logement logement = new Logement(superficie, CE.valueOf(ce));   
	    System.out.println(logement.toString());
	    return logement;
    }
    /**
     * Calcul interactif de l'empreinte carbone de l'ensemble des logements d'un utilisateur
     * @return une collection de Logement utile pour la creation d'un objet d'Utilisateur
     */
    public static Collection<Logement> affichage_logements(Scanner scanner) throws LogementsException,LogementException {
    	boolean correct=true;
    	//on initialise une collection de logements qui va pouvoir acceuilir l'ensemble des objets de Logement qui vont potentiellement etre construits
    	Collection<Logement> col=new ArrayList<Logement>();
    	//variable qui va recuperer le nombre de logement que possede l'utilisateur
    	int nblog=0;
	    do {
	        try{
	        	System.out.println("\nVous avez choisi de calculer l'empreinte carbone provenant de vos logements!");
	     	    System.out.println("Pouvez-vous indiquer le nombre de logements que vous possédez?");
	     	    nblog=scanner.nextInt();
	     	    if (nblog<0) {
	     	    	throw new LogementsException("Le nombre de logements doit être positif");
	     	    }
			    correct=false;
	        }
	        catch (InputMismatchException ex) {
	            System.out.println("Recommencez: un entier positif est attendu!");
	            scanner.nextLine();
	            }
	        catch (LogementsException e) {
	        	System.out.println(e.getMessage());
	        }
		}
	    while(correct);
	    if(nblog==0) {
	    	col.add(new Logement());
	    	return col;
	    }
	    for(int i=1;i<=nblog;i++) {
	    	col.add(affichage_logement(i,scanner));
	    }
	    Logement.EC_logement();
	    return col;
    }
    /**
     * Calcul interactif de l'empreinte carbone d'un vehicule de l'utilisateur
     * @return un objet Transport
     */
    public static Transport affichage_transport(int i,Scanner scanner) throws TransportException{
    	boolean correct=true;
    	//on recupere le numero du vehicule de l'utilisateur pour qu'il ne se perde pas lors de l'entree d'informations
    	String number = Integer.toString(i);
    	// variable qui va recuperer la taille de la voiture s'il y en bien une
	    String t=""; 
	    boolean possede=true; //l'utilisateur possede forcement une voiture lorsque cette methode est appelee dans affichage_transports 
	    //on les initialise pour qu'il n'y ait pas de problemes avec le bloc do while et le reste de la methode
		Taille taille=Taille.P;
		int kilomAnnee=0;
		int amortissement=1;
		do {
	        try{
	        	System.out.println("Pouvez-vous m'indiquer le nombre exacte de kilomètres parcourus avec votre voiture numéro "+number+" durant la dernière année ? ");
	        	kilomAnnee=scanner.nextInt();
	        	if (kilomAnnee<0) {
	        		throw new TransportException("Le nombre de kilomètres parcourus doit être une valeur positive!");
	        	}
			    correct=false;
	        }
	        catch (InputMismatchException ex) {
	            System.out.println("Recommencez: un entier positif est attendu!");
	            scanner.nextLine();
	            }
	        catch (TransportException e) {
	        	System.out.println(e.getMessage());
	        }
		}
	    while(correct);
	    correct=true;
		do {
	        try{
	        	System.out.println("Les préparatifs sont bientôt finis il ne me reste plus qu'à savoir depuis combien de temps, en années, vous possédez ce véhicule?");
	        	amortissement=scanner.nextInt();
	        	if(amortissement<0) {
	        		throw new TransportException("Le nombre d'années doit être positif!");
	        	}
			    correct=false;
	        }
	        catch (InputMismatchException ex) {
	            System.out.println("Recommencez: un entier positif est attendu!");
	            scanner.nextLine();
	            }
	        catch (TransportException e) {
	        	System.out.println(e.getMessage());
	        }
		}
	    while(correct);
	    correct=true;
		
	    do {
	        try{
	        	System.out.println("Pouvez-vous maitenant me donner la taille de votre voiture (petite/grande) ?");
	    	    t=scanner.next();
	    	    // selon si la voiture est petite ou grande on ne lui affecte pas le meme element de la classe enumeration (P ou G)
	    	    if(!("petite".equals(t))&&!("grande".equals(t))) {
	    	    	throw new TransportException("La taille de votre voiture doit être soit petite soit grande!");
	    	    }
	    	    //si aucune exception n'a ete levee je peux sortir du while, creer l'objet Logement et le renvoyer
			    correct=false;
	        }
	        catch (TransportException e) {
	        	System.out.println(e.getMessage());
	        }
		}
	    while(correct);
	    //ici, je sais que l'utilisateur a entre soit petite soit grande sur la console, il ne me reste plus qu'a verifier laquelle des valeurs il a entree
	    if ("petite".equals(t)){
	    	taille = Taille.P;
	    	Transport voit=new Transport(possede,taille,kilomAnnee,amortissement);
	    	Transport.EC_Transport();
		    System.out.println(voit.toString());
		    return voit;
	    }
	    else {
	    	taille = Taille.G;
	        Transport voit=new Transport(possede,taille,kilomAnnee,amortissement);
	    	Transport.EC_Transport();
		    System.out.println(voit.toString());
		    return voit;
	    }
	    	
	}
	    
    /**
     * Calcul interactif de l'empreinte carbone de l'ensemble des vehicules d'un utilisateur 
     */
    public static Collection<Transport> affichage_transports(Scanner scanner) throws TransportsException,TransportException{
    	boolean correct=true;
    	//On intialise une collection de Transport qui va acceuilir les objets de Transport qui vont etre crees 
    	Collection<Transport> col=new ArrayList<Transport>();
    	//variable qui va recuperer le nombre de vehicules que possede l'utilisateur
    	int nbtrans=0;
	    do {
	        try{
	        	System.out.println("\nVous avez choisi de calculer l'empreinte carbone provenant de vos véhicules!");
	    	    System.out.println("Pouvez-vous indiquer le nombre de véhicules que vous possédez?");
	    	    nbtrans=scanner.nextInt();
	    	    if(nbtrans<0) {
	    	    	throw new TransportsException("Le nombre de véhicules que vous possédez doit être plus grand que zéro");
	    	    }
			    correct=false;
	        }
	        catch (InputMismatchException ex) {
	            System.out.println("Recommencez: un entier positif est attendu!");
	            scanner.nextLine();
	            }
	        catch (TransportsException e) {
	        	System.out.println(e.getMessage());
	        }
		}
	    while(correct);
	    if(nbtrans==0) {
	    	col.add(new Transport());
	    	return col;
	    }
	    else {
	    	for(int i=1;i<=nbtrans;i++) {
		    	col.add(affichage_transport(i,scanner));
		    }
		    Transport.EC_Transport();
		    return col;
	    }
    }
    
}
