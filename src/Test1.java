
import java.util.ArrayList;

public class Test1 {

	public static void main(String[] args) {
		Ville bilalCity=new Ville("bilalCity");
		System.out.println(bilalCity);
		
		System.out.println("===================================================================");
		
		Travaille t0=new Travaille(bilalCity,2,6);
		bilalCity.ajouterInfra(t0);
		
		Ecole ecole=new Ecole(bilalCity,6,6);
		bilalCity.ajouterInfra(ecole);
		
		Maison m0=new Maison(bilalCity,6,2);
		bilalCity.ajouterInfra(m0);
		
		Maison m1=new Maison(bilalCity,2,2);
		bilalCity.ajouterInfra(m1);
		
		System.out.println(bilalCity);
		
		System.out.println("===================================================================");
		
		
		//Villageoi v=new Adulte(bilalCity,true,m1,new Voiture(bilalCity,m1),(Travaille)bilalCity.getElements(2,6));
		//bilalCity.getElements(6,5).push(v.getVoiture());
		//System.out.println(bilalCity);
		
		System.out.println(bilalCity.printVoitures());
		System.out.println(bilalCity.printWorks());
		System.out.println(bilalCity.printVillageois());
		System.out.println(m0.print());
		System.out.println(m1.print());
		System.out.println(ecole.print());
		System.out.println(t0.print());
		
		System.out.println("===================================================================");
		
		ArrayList<Voiture> voitures=bilalCity.getVoitures();
		
		System.out.println(bilalCity);
		System.out.println(bilalCity.printVoitures());
		for(int i=0;i<voitures.size();i++){
			voitures.get(i).start();
		}
		//System.out.println(voitures.get(0).getDestination());
		System.out.println(bilalCity);
		System.out.println(bilalCity.printVoitures());
	
		for(int n=0;n<5;n++){
			for(int i=0;i<voitures.size();i++){
				voitures.get(i).avancer(0,1);
			}
			System.out.println(bilalCity);
			System.out.println(bilalCity.printVoitures());
			try {Thread.sleep(600);}catch(InterruptedException e) {e.printStackTrace();}
		}
		System.out.println( bilalCity.getVoitures().get(0).distance(0, 0, 4, 4) );
		System.out.println(m0.print());
		
	}

}
