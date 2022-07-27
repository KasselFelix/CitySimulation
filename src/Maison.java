
public class Maison extends Infrastructure {
	private final double co2=0.5;
	private double pollution=0;
	private static int cpt=0;
	private int id;
	private Voiture voiture;
	public Maison(Ville v,int posi,int posj) {
		super(v,posi,posj);
		id=cpt++;
		voiture = new Voiture(v,this);
		
		if(v.getWorks().size()!=0){
			new Adulte(v,true,this,voiture,v.randWork());
			if(Math.random()<0.8){
				new Adulte(v,false,this,voiture,v.randWork());
				int nb=3;
				if(v.getEcoles().size()!=0){
					for(int i=0;i<nb;i++){
						if(Math.random()<0.4){
							new Enfant(v,this,voiture,v.randEcole());
						}
					}
				}
			}
		}
	}
	
	public double getCo2_S(){
		return co2+(co2*super.size())/100;
	}
	
	public double getPollution() {
		return pollution;
	}

	public void majPollution() {
		if(super.size()==0) {
			pollution = pollution+co2;
		}else{pollution = pollution+(co2*super.size()*10)/100;}
	}
	
	public int getId() {
		return id;
	}
	public Voiture getVoiture() {
		return voiture;
	}
	
	public String print(){
		return super.print()+String.format(" [%.3f g co2]",pollution)+"\n";
	}
	
	public String toString() {
		return "H"+id;
	}
}
