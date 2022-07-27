import java.util.ArrayList;


public class Creation {
	private Ville city;
	public Creation(){
		city=new Ville("GothamCity");
	}
	
	public void build(){
		Travaille t0=new Travaille(city,2,6);
		city.ajouterInfra(t0);
		
		Travaille t1=new Travaille(city,14,6);
		city.ajouterInfra(t1);
		
		Travaille t2=new Travaille(city,2,10);
		city.ajouterInfra(t2);
		
		Travaille t3=new Travaille(city,10,18);
		city.ajouterInfra(t3);
		
		Ecole e0=new Ecole(city,18,18);
		city.ajouterInfra(e0);
		
		Ecole e1=new Ecole(city,6,6);
		city.ajouterInfra(e1);
		
		
		Maison m0=new Maison(city,6,10);
		city.ajouterInfra(m0);
		
		Maison m1=new Maison(city,14,18);
		city.ajouterInfra(m1);
		
		Maison m2=new Maison(city,18,6);
		city.ajouterInfra(m2);
		
		Maison m3=new Maison(city,2,18);
		city.ajouterInfra(m3);
		
		Maison m4=new Maison(city,6,18);
		city.ajouterInfra(m4);
		
		Maison m5=new Maison(city,10,10);
		city.ajouterInfra(m5);
		
		for(int i=0;i<city.getTaille();i++){
			for(int j=0;j<city.getTaille();j++){
				if(i%4==2 && (j==2 || j==14)){
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
		try {Thread.sleep(5000);}catch(InterruptedException e) {e.printStackTrace();}
		System.out.println(city.printInfrastructure());
		try {Thread.sleep(5000);}catch(InterruptedException e) {e.printStackTrace();}
	}
	
	public void Time(int nbH){
		
		ArrayList<Infrastructure> infrastructures =city.getInfrastructures();
		
		int nbM=60;
		int nbS=60;
		double z=city.getT();
		for(double t=z;t<nbS*nbM*nbH;t++){
			for(int i=0;i<infrastructures.size();i++){
				Ville.setPollution(Ville.getPollution()+ infrastructures.get(i).getCo2_S());
				infrastructures.get(i).majPollution();
			}
			if((int)t%(nbS*nbS)==0){
				System.out.println(city);
				System.out.println(city.printInfrastructure());
				try {Thread.sleep(1000);}catch(InterruptedException e) {e.printStackTrace();}
			}
			city.setT(1);
		}
		System.out.println(city);
	}
	
	public void Aller(){
		
		ArrayList<Infrastructure> infrastructures =city.getInfrastructures();
		ArrayList<Voiture> voitures=city.getVoitures();
		
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
			if(tmp==false){
				for(int i=0;i<infrastructures.size();i++){
					Ville.setPollution(Ville.getPollution()+ infrastructures.get(i).getCo2_S());
					infrastructures.get(i).majPollution();
				}
			}
			if(tmp==false)city.setT(0.6);
			System.out.println(city+city.printVoitures());
			try {Thread.sleep(600);}catch(InterruptedException e) {e.printStackTrace();}
			if(tmp==true)b=true;
		}
		System.out.println(city.printInfrastructure());
	}
	
	public void Retour(){
		
		ArrayList<Infrastructure> infrastructures =city.getInfrastructures();
		ArrayList<Voiture> voitures=city.getVoitures();
		
		boolean tmp;
		boolean b=false;
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
			if(tmp==false){
				for(int i=0;i<infrastructures.size();i++){
					Ville.setPollution(Ville.getPollution()+ infrastructures.get(i).getCo2_S());
					infrastructures.get(i).majPollution();
				}
			}
			System.out.println(city+city.printVoitures());
			try {Thread.sleep(600);}catch(InterruptedException e) {e.printStackTrace();}
			if(tmp==true)b=true;
			if(tmp==false)city.setT(0.6);
		}
		System.out.println(city.printInfrastructure());
	}
}
