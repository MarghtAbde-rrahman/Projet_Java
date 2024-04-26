package suite;

import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
import consoCarbone.*;

/**
 * Utilisateur repertorie tous les postes de consommation d'un individu 
 * @author Karim Bennoura,Abde-rrahman Marght
 * @version 3.7
 */
public class Utilisateur{
	/**
	 * @see consoCarbone.Alimentation
	 */
	public Alimentation alimentation;
	/**
	 * @see consoCarbone.BienConso
	 */
	public BienConso bienConso;
	/**
	 * @see consoCarbone.ServicesPublic
	 */
	public ServicesPublic services;
	/**
	 * @see consoCarbone.Numerique
	 */
	public Numerique numerique;
	/**
	 * Collections de logements objets de la classe Logement
	 * @see consoCarbone.Logement
	 */
	public Collection<Logement> colLogement;
	/**
	 * Collection de transports objets de la classe Transport
	 * @see consoCarbone.Transport
	 */
	public Collection<Transport> colTransport;
	
	/**
	 * Constructeur par defaut d'un utilisateur 
	 */
	public Utilisateur() {
		alimentation = new Alimentation();
		bienConso = new BienConso();
		services = new ServicesPublic();
		numerique = new Numerique();
		colLogement = new ArrayList<Logement>();
		colTransport = new ArrayList<Transport>();
	}
	/**
	 * Constructeur d'un utilisateur ou l'on a donne en argument les "consoCarbone"
	 * @param alimentation Consommation carbone de l'alimentation de l'utilisateur @see consoCarbone.Alimentation
	 * @param bienConso Consommation carbone des depenses de l'utilisateur @see consoCarbone.BienConso 
	 * @param services Consommation carbone des services publics @see consoCarbone.ServicesPublic 
	 * @param numerique Consommation carbone des appareils numeriques de l'utilisateur @see consoCarbone.Numerique 
	 * @param logements Collections de logements objets de la classe Logement @see consoCarbone.Logement
	 * @param transports Collection de transports objets de la classe Transport  @see consoCarbone.Transport
	 */
	public Utilisateur(Alimentation alimentation, BienConso bienConso,ServicesPublic services,Numerique numerique,Collection<Logement> logements, Collection<Transport> transports) {
		this.alimentation = alimentation;
		this.bienConso = bienConso;
		this.services = services;
		this.numerique = numerique;
		this.colLogement = logements;
		this.colTransport = transports;
	}
	/**
	 * 
	 * @param nom Le nom du fichier ou sont stockes les informations de l'utilisateur
	 * @throws IOException
	 */
	public Utilisateur(String nom) throws IOException{
	    BufferedReader lecteurAvecBuffer = null;
	    String ligne;
	    //cpt est un compteur pour savoir quand est ce que je switch de liste
	    int cpt = 0;
	    // Liste qui va nous permettre de recuperer l'information necessaire au calcul de l'empreinte carbone de Alimentation, BienConso et Numerique
	    ArrayList<String> infos1 = new ArrayList<String>();
	    Boolean[] infosNum = {false,false,false,false,false};
	    // Liste qui va nous permettre de recuperer l'information necessaire au calcul de l'empreinte carbone de ou des logement(s)
	    ArrayList<String> infos2 = new ArrayList<String>();
	    // Liste qui va nous permettre de recuperer l'information necessaire au calcul de l'empreinte carbone de ou des voiture(s)
	    ArrayList<String> infos3 = new ArrayList<String>();

	    try
	      {lecteurAvecBuffer = new BufferedReader(new FileReader(nom));}
	    catch(FileNotFoundException exc)
	      {System.out.println("Erreur d'ouverture");}
	    while (((ligne = lecteurAvecBuffer.readLine()) != null)&&(cpt<8)) { // je verifie que cpt est inferieur a 8 car j'ai 7 informations à recuperer avant de passer a logement et transport
	    	if(ligne.equals("(ecrivez juste en dessous)")){
	    		cpt += 1;
	    		if((ligne = lecteurAvecBuffer.readLine()) != null){
	    			if(!(ligne.equals(""))){
		    			infos1.add(ligne);
		    		}
		    	}
	    	}
	    }
	    while (((ligne = lecteurAvecBuffer.readLine()) != null)&&(cpt==8)) {
	    	if(ligne.equals("(ecrivez juste en dessous)")){
	    		while(((ligne = lecteurAvecBuffer.readLine()) != null)&&(!(ligne.equals("VOITURE(S)")))){
	    			cpt = 9;
		    		if(!(ligne.equals(""))){
		    			infos2.add(ligne);
		    		}
		    	}
	    	}
	    }
	    while ((ligne = lecteurAvecBuffer.readLine()) != null) {
	    	if(ligne.equals("(ecrivez juste en dessous)")){
	    		while((ligne = lecteurAvecBuffer.readLine()) != null){
		    		if(!(ligne.equals(""))){
		    			infos3.add(ligne);
		    		}
		    	}
	    	}
	    }
	    
	    lecteurAvecBuffer.close();

	    String tmp; // str temporaire qui me permet de recuper les lignes independamment avec les infos necessaires
	    String[] args; // tableau de str avec les arguments separes de chaque ligne
	    alimentation = new Alimentation(Double.parseDouble(infos1.get(0)),Double.parseDouble(infos1.get(1))); // initialisation de la consommation carbone  alimentaire de l'utilisateur
	    bienConso = new BienConso(Double.parseDouble(infos1.get(2))); // initialisation de la consommation carbone des biens achetes de l'utilisateur
	    for(int i=3;i<infos1.size();i++) {
	    	if(infos1.get(i).equals("oui")) // lorsque il y a un "oui" dans le fichier txt on met a true l'appareil numerique correspondant
	    		infosNum[i-3] = true;
	    	
	    }
		services = new ServicesPublic(); // initialisation de la consommation carbone du au services public de l'utilisateur
		numerique = new Numerique(infosNum[0],infosNum[1],infosNum[2],infosNum[3],infosNum[4]);// initialisation de la consommation carbone du aux appareils numerique de l'utilisateur
		colLogement = new ArrayList<Logement>();
		for(int i=0;i<infos2.size();i++) {
			tmp = infos2.get(i);
			args = tmp.split(" ");
			int a = Integer.parseInt(args[0]); // evite la reecriture relou
			switch(args[1]) {
   		 		case "A":
   		 			colLogement.add(new Logement(a, CE.A));
                    break;
	   		 	case "B":
		 			colLogement.add(new Logement(a, CE.B));
		 			break;
	   		 	case "C":
	   		 		colLogement.add(new Logement(a, CE.C));
		 			break;	
	   		 	case "D":
	   		 		colLogement.add(new Logement(a, CE.D));
		 			break;	
	   		 	case "E":
	   		 		colLogement.add(new Logement(a, CE.E));
		 			break;	
	   		 	case "F":
	   		 		colLogement.add(new Logement(a, CE.F));
		 			break;	
	   		 	case "G":
	   		 		colLogement.add(new Logement(a, CE.G));
		 			break;	
   		  	}
		}
		colTransport = new ArrayList<Transport>();
		for(int i=0;i<infos3.size();i++) {
			tmp = infos3.get(i);
			args = tmp.split(" ");
			int a = Integer.parseInt(args[1]);
			int b = Integer.parseInt(args[2]);
			switch(args[0]) {
   		 		case "petite":
   		 			colTransport.add(new Transport(true,Taille.P,a,b));
                    break;
	   		 	case "grande":
	   		 		colTransport.add(new Transport(true,Taille.G,a,b));
		 			break;
			}
		}
		
	  }

	/**
	 * Recupere la consommation carbone de l'alimentation de l'utilisateur
	 * @return un objet de classe Alimentation propre à l'utilisateur
	 */
	public Alimentation getAlimentation() {
		return alimentation;
	}
	/**
	 * Mise a jour de la consommation carbone de l'alimentaion de l'utilsateur
	 * @param alimentation consommation carbone de l'alimentaion de l'utilsateur
	 */
	public void setAlimentation(Alimentation alimentation) {
		this.alimentation = alimentation;
	}
	/**
	 * Recupere la consommation carbone du à la consommation de biens de l'utilisateur
	 * @return un objet de classe BienConso propre à l'utilisateur
	 */
	public BienConso getBienConso() {
		return bienConso;
	}
	/**
	 * Mise a jour de la consommation carbone du à la consommation de biens de l'utilsateur
	 * @param bienConso Consommation carbone du à la consommation de biens de l'utilsateur
	 */
	public void setBienConso(BienConso bienConso) {
		this.bienConso = bienConso;
	}
	/**
	 * Recupere la consommation carbone des services public 
	 * @return un objet de classe ServicesPublic propre à l'utilisateur
	 */
	public ServicesPublic getServices() {
		return services;
	}
	/**
	 * Mise a jour de la consommation carbone des services public
	 * @param services Consommation carbone des services public
	 */
	public void setServices(ServicesPublic services) {
		this.services = services;
	}
	/**
	 * Recupere la consommation carbone des appareils numeriques de l'utilisateur
	 * @return un objet de classe Numerique propre à l'utilisateur
	 */
	public Numerique getNumerique() {
		return numerique;
	}
	/**
	 * Mise a jour de la consommation carbone des appareils numeriques de l'utilisateur
	 * @param numerique Consommation carbone des appareils numeriques de l'utilisateur
	 */
	public void setNumerique(Numerique numerique) {
		this.numerique = numerique;
	}
	/**
	 * Recupere la consommation carbone du/des logement/s de l'utilisateur
	 * @return une collection d'objets de classe Logement propre à l'utilisateur
	 */
	public Collection<Logement> getColLogement() {
		return colLogement;
	}
	/** 
	 * Mise a jour de la consommation carbone du au/x logement/s de l'utilisateur
	 * @param colLogement Consommation carbone du au/x logement/s de l'utilisateur
	 */
	public void setColLogement(Collection<Logement> colLogement) {
		this.colLogement = colLogement;
	}
	/**
	 * Recupere la consommation carbone du/des voiture/s de l'utilisateur
	 * @return une collection d'objets de classe Transport propre à l'utilisateur
	 */
	public Collection<Transport> getColTransport() {
		return colTransport;
	}
	/** 
	 * Mise a jour de la consommation carbone du au/x voiture/s de l'utilisateur
	 * @param colTransport Consommation carbone du au/x voiture/s de l'utilisateur
	 */
	public void setColTransport(Collection<Transport> colTransport) {
		this.colTransport = colTransport;
	}
	
	/**
	 * Calculateur de l'empreinte carbone totale d'un utlisateur en prenant en compte tous ses postes de consommation
	 * @return un double qui est la valeur de l'empreinte carbone en tonnes de C02
	 */
	public double calculerEmpreinte() {
		double d=0;
		// A OPTIMISER 
		d += alimentation.getImpact();
		d += bienConso.getImpact();
		d += services.getImpact();
		for(Logement l : colLogement) {
			d += l.getImpact();
		}
		for(Transport t : colTransport) {
			d += t.getImpact();
		}
	    return d;
	}
	/**
	 * Affichage sur la console des empreintes carbones de chaque poste de consommation de l'utilisateur
	 */
	public void detaillerEmpreinte() {
		System.out.print("\nEmpreinte carbone de votre alimentation : ");
		System.out.println(alimentation.toString());
		System.out.print("\nEmpreinte carbone de votre consommation de bien : ");
		System.out.println(bienConso.toString());
		System.out.print("\nEmpreinte carbone des services publics : ");
		System.out.println(services.toString());
		if(!(colLogement.isEmpty())) {
			System.out.print("\nEmpreinte carbone de votre/vos logement/s : ");}
		for(Logement l : colLogement) 
			System.out.println(l.toString());
		if(!(colTransport.isEmpty())) {	
			System.out.print("\nEmpreinte carbone de votre/vos transport/s : ");}
		for(Transport t : colTransport) 
			System.out.println(t.toString());
		String number = String.format("%.02f", calculerEmpreinte());
		System.out.println("\nEmpreinte carbone totale: "+number+" TCO2eq.");

	}
	
	/**
	 * @return une liste de ConsoCarbone trie par rapport à leur impact carbone 
	 */
	public List<ConsoCarbone> listerImpactsTriee(){
		List<ConsoCarbone> posteDeConsos = new ArrayList<ConsoCarbone>();
		posteDeConsos.add(alimentation);
		posteDeConsos.add(bienConso);
		posteDeConsos.add(services);
		posteDeConsos.add(numerique);
		for(Logement lo : colLogement) 
			posteDeConsos.add(lo);
		for(Transport t : colTransport)
			posteDeConsos.add(t);
		List<ConsoCarbone> sortedList = posteDeConsos.stream().sorted((o1,o2) -> o2.compareTo(o1)).collect(Collectors.toList());
		return sortedList;
	}
	/**
	 * Affiche la consommation carbone de tous les poste de consommations de l'utilisateur du plus consommmateur au moins consommateur.
	 */
	public void informationTriee() {
		List<ConsoCarbone> consosTriee = listerImpactsTriee();
		for(ConsoCarbone c: consosTriee) {
			System.out.println(c);
		}
	}
	/**
	 * Affiche des conseils sur les postes de consommation de l'utilisateur ou sa consommation est superieur à celle de la moyenne en France. 
	 *  
	 */
	public void conseil() {
		List<ConsoCarbone> consosTriee = listerImpactsTriee();
		for(ConsoCarbone c: consosTriee) {
			if((c instanceof Logement) && (c.getImpact()>Logement.EC)) {
				System.out.println("\nVotre logement consomme plus que la moyenne en France !");
				System.out.println(c);
				double tmp = c.getImpact()-Logement.EC;
				System.out.print("Soit ");
				System.out.format("%.2f", tmp);
				System.out.println(" de plus que la moyenne.");
				System.out.println(" Vous devriez songer à mieux isoler votre logement afin d'avoir une meilleur classe énergétique pour votre logement");
			}
			if((c instanceof Alimentation) && (c.getImpact()>Alimentation.EC)) {
				System.out.println("\nVotre alimentation consomme plus que la moyenne en France !");
				System.out.println(c);
				double tmp = c.getImpact()-Alimentation.EC;
				System.out.print("Soit ");
				System.out.format("%.2f", tmp);
				System.out.println(" de plus que la moyenne.");
				System.out.println("Vous devriez consommer moins de repas à base de boeuf ou volaiille et privilegiez des repas végétariens");
			}
			if((c instanceof BienConso) && (c.getImpact()>BienConso.EC)) {
				System.out.println("\nVotre consommation de biens consomme plus que la moyenne en France !");
				System.out.println(c);
				double tmp = c.getImpact()-BienConso.EC;
				System.out.print("Soit ");
				System.out.format("%.2f", tmp);
				System.out.println(" de plus que la moyenne.");
				System.out.println("Donnez une chance aux produits de seconde main");
			}
			if((c instanceof Numerique) && (c.getImpact()>Numerique.EC)) {
				System.out.println("\nVos appareils numériques consomme plus que la moyenne en France !");
				System.out.println(c);
				double tmp = c.getImpact()-Numerique.EC;
				System.out.print("Soit ");
				System.out.format("%.2f", tmp);
				System.out.println(" de plus que la moyenne.");
				System.out.println("Vous devriez arreter d'utiliser vos appareils numériques !");
			}
			if((c instanceof Transport) && (c.getImpact()>Transport.EC)) {
				System.out.println("\nVotre voiture consomme plus que la moyenne en France !");
				System.out.println(c);
				double tmp = c.getImpact()-Transport.EC;
				System.out.print("Soit ");
				System.out.format("%.2f", tmp);
				System.out.println(" de plus que la moyenne.");
				System.out.println("Vous devriez essayer de privilégier les transports en commun !");
			}
		}
	}
}