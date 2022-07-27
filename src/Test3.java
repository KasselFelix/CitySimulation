

import java.util.ArrayList;

public class Test3 {
	public static void main(String[] args) {

		System.out.println("====================================================================");
		//Build
		
		String NAME="Gotham";
		Ville city=new Ville(NAME);
		Travaille t0=new Travaille(city,2,6);
		city.ajouterInfra(t0);
		
		Travaille t1=new Travaille(city,6,14);
		city.ajouterInfra(t1);
		
		Ecole ecole=new Ecole(city,6,6);
		city.ajouterInfra(ecole);
		
		Maison m0=new Maison(city,6,2);
		city.ajouterInfra(m0);
		
		Maison m1=new Maison(city,2,2);
		city.ajouterInfra(m1);
		
		for(int i=0;i<city.getTaille();i++){
			for(int j=0;j<city.getTaille();j++){
				if(j%4==2 && (i==city.getTaille()-8 || i==city.getTaille()-4)){
					city.ajouterInfra(new Maison(city,i,j));
				}
			}
		}
		
		for(int i=0;i<city.getTaille();i++){
			for(int j=0;j<city.getTaille();j++){
					Route r=new Route();
					if((i%4==1) && (j!=city.getTaille()-1))r.addE();
					if((i%4==0) && (j!=0))r.addW();
					if((i!=0) && (j%4==1))r.addN();
					if((i!=city.getTaille()-1) && (j%4==0))r.addS();
					city.ajouterRoute(r,i,j);
			}
		}
		System.out.println(city.printVillageois());
		System.out.println(city.printWorks());
		System.out.println(ecole.print());
		
		System.out.println("====================================================================");
		
		//TIME
		ArrayList<Infrastructure> infrastructures =city.getInfrastructures();
		
		int nbH=8;
		int nbM=60;
		int nbS=60;
		for(int t=0;t<nbS*nbM*nbH;t++){
			for(int i=0;i<infrastructures.size();i++){
				Ville.setPollution(Ville.getPollution()+ infrastructures.get(i).getCo2_S());
				infrastructures.get(i).majPollution();
			}
			if(t%((nbS*nbS))==0){
				System.out.println(city);
				System.out.println(t0.print());
				System.out.println(t1.print());
				System.out.println(ecole.print());
				System.out.println(m0.print());
				System.out.println(m1.print());
				try {Thread.sleep(1000);}catch(InterruptedException e) {e.printStackTrace();}
			}
		}
		
		
		
		System.out.println("===================================================================");
		
		//ALLER
		
		System.out.println(city);
		
		ArrayList<Voiture> voitures=city.getVoitures();
		
		System.out.println(city.printVoitures());
		for(int i=0;i<voitures.size();i++){
			voitures.get(i).start();
		}
		
		System.out.println(city+city.printVoitures());
	
		
		boolean tmp;
		boolean b=false;
		while(b != true){
			tmp=true;
			for(int i=0;i<voitures.size();i++){
				if(voitures.get(i).getIndice()<voitures.get(i).getNb()) {
					voitures.get(i).roadToWork();
					tmp=false;
				}
			}
			for(int i=0;i<infrastructures.size();i++){
				Ville.setPollution(Ville.getPollution()+ infrastructures.get(i).getCo2_S());
				infrastructures.get(i).majPollution();
			}
			System.out.println(city+city.printVoitures());
			try {Thread.sleep(600);}catch(InterruptedException e) {e.printStackTrace();}
			
			if(tmp==true)b=true;
			
		}
		
		System.out.println(t0.print());
		System.out.println(t1.print());
		System.out.println(ecole.print());
		System.out.println(m0.print());
		System.out.println(m1.print());
		
		System.out.println("====================================================================");
		
		//TIME
	
		for(int t=0;t<nbS*nbM*nbH;t++){
			for(int i=0;i<infrastructures.size();i++){
				Ville.setPollution(Ville.getPollution()+ infrastructures.get(i).getCo2_S());
				infrastructures.get(i).majPollution();
			}
			if(t%((nbS*nbS))==0){
				System.out.println(city);
				System.out.println(t0.print());
				System.out.println(t1.print());
				System.out.println(ecole.print());
				System.out.println(m0.print());
				System.out.println(m1.print());		
				
				try {Thread.sleep(1000);}catch(InterruptedException e) {e.printStackTrace();}
			}
		}
		
		
		
		System.out.println("====================================================================");
		
		//RETOUR
		
		
		b=false;
		while(b != true){
			tmp=true;
			for(int i=0;i<voitures.size();i++){
				if(voitures.get(i).getIndice()>-2) {
					if(voitures.get(i).isDepart()==false){
						voitures.get(i).startRetour();
					}else{
						voitures.get(i).roadToHome();
					}
					tmp=false;
				}
			}
			
			for(int i=0;i<infrastructures.size();i++){
				Ville.setPollution(Ville.getPollution()+ infrastructures.get(i).getCo2_S());
				infrastructures.get(i).majPollution();
			}
			
			System.out.println(city+city.printVoitures());
			try {Thread.sleep(600);}catch(InterruptedException e) {e.printStackTrace();}
			
			if(tmp==true)b=true;
		}
		
		System.out.println(m0.print());
		System.out.println(m1.print());
		System.out.println(t0.print());
		System.out.println(t1.print());
		System.out.println(ecole.print());
	
		System.out.println("====================================================================");
	
		//TIME
		for(int t=0;t<nbS*nbM*nbH;t++){
			for(int i=0;i<infrastructures.size();i++){
				Ville.setPollution(Ville.getPollution()+ infrastructures.get(i).getCo2_S());
				infrastructures.get(i).majPollution();
			}
			if(t%((nbS*nbS))==0){
				System.out.println(city);
				System.out.println(t0.print());
				System.out.println(t1.print());
				System.out.println(ecole.print());
				System.out.println(m0.print());
				System.out.println(m1.print());
				try {Thread.sleep(1000);}catch(InterruptedException e) {e.printStackTrace();}
			}
		}
	}
}
