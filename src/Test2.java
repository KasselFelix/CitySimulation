
import java.util.ArrayList;

public class Test2 {
	public static void main(String[] args) {
		Ville bilalCity=new Ville("bilalCity");
		
		Travaille t0=new Travaille(bilalCity,2,6);
		bilalCity.ajouterInfra(t0);
		
		Ecole ecole=new Ecole(bilalCity,6,6);
		bilalCity.ajouterInfra(ecole);
		
		Maison m0=new Maison(bilalCity,6,2);
		bilalCity.ajouterInfra(m0);
		
		Maison m1=new Maison(bilalCity,2,2);
		bilalCity.ajouterInfra(m1);
		
		for(int i=0;i<bilalCity.getTaille();i++){
			for(int j=0;j<bilalCity.getTaille();j++){
				if((bilalCity.getElements(i,j) instanceof Infrastructure) == false){
					Route r=new Route();
					if((i%4==1) && (j!=bilalCity.getTaille()-1))r.addE();
					if((i%4==0) && (j!=0))r.addW();
					if((i!=0) && (j%4==1))r.addN();
					if((i!=bilalCity.getTaille()-1) && (j%4==0))r.addS();
					bilalCity.ajouterRoute(r,i,j);
				}
			}
		}
		System.out.println(bilalCity.printVoitures());
		System.out.println(bilalCity.printWorks());
		System.out.println(bilalCity.printVillageois());
		System.out.println(m0.print());
		System.out.println(m1.print());
		System.out.println(ecole.print());
		
		System.out.println("===================================================================");
		
		System.out.println(bilalCity);
		
		ArrayList<Voiture> voitures=bilalCity.getVoitures();
		
		System.out.println(bilalCity.printVoitures());
		for(int i=0;i<voitures.size();i++){
			voitures.get(i).start();
		}
		
		System.out.println(bilalCity+bilalCity.printVoitures());
	
		
		boolean tmp;
		boolean b=false;
		while(b != true){
			tmp=true;
			for(int i=0;i<voitures.size();i++){
				if(voitures.get(i).getIndice()<voitures.get(i).getNb()) {
					voitures.get(i).roadToWork();
					System.out.println("indice "+voitures.get(i).toString()+" :"+voitures.get(i).getIndice());
					System.out.println("destination "+voitures.get(i).toString()+" :"+voitures.get(i).getDestination());
					tmp=false;
				}
			}
			System.out.println(bilalCity+bilalCity.printVoitures());
			try {Thread.sleep(600);}catch(InterruptedException e) {e.printStackTrace();}
			
			if(tmp==true)b=true;
			
		}
		
		System.out.println(t0.print());
		System.out.println(ecole.print());
		System.out.println(m0.print());
		System.out.println(m1.print());
		
		System.out.println("====================================================================\n");
		
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
			System.out.println(bilalCity+bilalCity.printVoitures());
			try {Thread.sleep(600);}catch(InterruptedException e) {e.printStackTrace();}
			
			if(tmp==true)b=true;
			
		}
		
		System.out.println(m0.print());
		System.out.println(m1.print());
		System.out.println(t0.print());
		System.out.println(ecole.print());

		
		
		/*
		public void roadTo(){
			
			//System.out.println("( i:"+posi+", j:"+posj+")");
			//System.out.println("(di :"+destination.getPosi()+", dj:"+destination.getPosj()+")");
			if((posi != destination.getPosi()-1) || (posj != destination.getPosj())){
				//System.out.println(0);
				ArrayList<Direction> directions =((Route) ville.getElements(posi,posj)).getDirections();
				double dist=distance(0,0,ville.getTaille()+1,ville.getTaille()+1);
				Direction res=null;
				for (int i=0;i<directions.size();i++){
					Direction tmp=directions.get(i);
					double nd=distance(posi+tmp.getI(),posj+tmp.getJ(),destination.getPosi()-1,destination.getPosj());
					if(nd<dist){
						dist=nd;
						res=tmp;
						//System.out.println(1);
					}
				}
				if(res != null){//System.out.println(2);
					if(((ville.getElements(posi+res.getI(),posj+res.getJ())) instanceof Route) && (posi+res.getI()<ville.getTaille() && posj+res.getJ()<ville.getTaille()) ){//System.out.println(3);
						if(ville.getElements(posi+res.getI(),posj+res.getJ()).isEmpty()){//System.out.println(4);
							this.avancer(res.getI(),res.getJ());
						}else this.avancer(0,0);//System.out.println(5);
					}
				}
			}
			else{
				destination.push(places[indice]);
				indice=indice+1;
				if(indice>=nb) {
					ville.getElements(posi, posj).pop();
					posi=destination.getPosi();
					posj=destination.getPosj();
					//System.out.println(6);
				}else{
					destination=(Infrastructure)(places[indice].getDest());
					this.avancer(0,0);//System.out.println(7);
				}
			}
			//System.out.println("( i:"+posi+", j:"+posj+")");
			//System.out.println("(di :"+destination.getPosi()+", dj:"+destination.getPosj()+")");
			
		}*/
		
		
	}
}
