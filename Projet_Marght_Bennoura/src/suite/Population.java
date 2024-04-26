package suite;

import java.util.*;

import consoCarbone.*;

/**
 * Population repertorie un esemble d'utilisateur
 * @author Karim Bennoura,Abde-rrahman Marght
 * @version 1.1
 */
public class Population {
    private Collection<Utilisateur> popul;
    // Moyenne des conso carbones : 
    private double mAlim, mBien, mServices, mLog, mTrans;
    
    /**
	 * Constructeur par defaut d'une population
	 */
    public Population() {
		this.popul = new ArrayList<Utilisateur>();
		this.mAlim = 0; this.mBien = 0; this.mServices = 0; this.mLog = 0; this.mTrans = 0;
	}
    /**
     * Constructeur d'une population 
	 * @param popul Un ensemble d'utilisateurs entre sous forme de Collection
     */
    public Population(Collection<Utilisateur> popul) {
		this.popul = popul;
		this.mAlim = 0; this.mBien = 0; this.mServices = 0; this.mLog = 0; this.mTrans = 0;
		moyenneImpact();
	}
    /**
     * @return la moyenne de la consommation carbone de l'alimentation de la population
	 */
	public double getmAlim() {
		return mAlim;
	}
	/**
     * @return la moyenne de la consommation carbone du à la consommation de biens de la population
	 */
	public double getmBien() {
		return mBien;
	}
	/**
     * @return la moyenne de la consommation carbone des services public de la population
	 */
	public double getmServices() {
		return mServices;
	}
	/**
     * @return la moyenne de la consommation carbone des logements de la population
	 */
	public double getmLog() {
		return mLog;
	}
	/**
     * @return la moyenne de la consommation carbone des voitures de la population
	 */
	public double getmTrans() {
		return mTrans;
	}
	/**
	 * Calcul de la moyenne de la population pour chaque poste de consommation
	 */
	public void moyenneImpact() {
    	double cptLog = 0, cptTrans = 0;
    	
    	for(Utilisateur u : popul) {
    		mAlim += u.getAlimentation().getImpact();
    		mBien += u.getBienConso().getImpact();
    		mServices += u.getServices().getImpact();
    		for(Logement l : u.getColLogement() ) {
    			cptLog += 1;
    			mLog += l.getImpact();
    		}
    		for(Transport t : u.getColTransport() ) {
    			cptTrans += 1;
    			mTrans += t.getImpact();
    		}
    	}
    	mAlim = mAlim/popul.size();
    	mBien = mBien/popul.size();
    	mServices = mServices/popul.size();
		if(cptLog!=0){mLog = mLog/cptLog;}
		if(cptTrans!=0){mTrans = mTrans/cptTrans;}
    }
    /**
     * Affiche des conseils pour reduire la consommation de la population
     */
	public void mersuresPolitiques() {
		if(Alimentation.EC < mAlim) {
			System.out.println("La consommation alimentaire de la population est plus élevé que celle de la moyenne en France !");
			System.out.println("La consommation de viande doit être réduite, pour cela vous pouvez appliquer une taxe sur la vente de viande pour dissuader la population de consommer de la viande.\n");			
		}
		if(BienConso.EC < mBien) {
			System.out.println("La consommation de biens de la population est plus élevé que celle de la moyenne en France !");
			System.out.println("Elle doit être réduite, pour cela vous pouvez mettre en place des programmes d'éducation et de sensibilisation pour inciter les consommateurs à réfléchir à leurs habitudes de consommation et à adopter des comportements plus durables.\n");			
		}
		if(Logement.EC < mLog) {
			System.out.println("La consommation dû aux logements de la population est plus élevé que celle de la moyenne en France !");
			System.out.println("Elle doit être réduite, pour cela vous pourriez plus taxer la population sur l'aquisition d'un logement supplémentaire.\n");			
		}
		if(Transport.EC < mTrans) {
			System.out.println("La consommation dû aux transports de la population est plus élevé que celle de la moyenne en France !");
			System.out.println("Elle doit être réduite, pour cela vous pourriez augmenter les taxes sur le carburant et promouvoir l'utilisation de modes de transport alternatifs, tels que les transports en commun, le vélo ou la marche, en améliorant leur infrastructure et en rendant ces options plus pratiques et attrayantes pour les utilisateurs.\n");			
		}
	}
}

