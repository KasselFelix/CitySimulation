

public class Travaille extends Infrastructure {
	private final double co2=1;
	private double pollution=0;
	private static int cpt=0;
	private int id;
	public Travaille(Ville v,int posi,int posj) {
		super(v,posi,posj);
		id=cpt++;
		v.getWorks().add(this);
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
		}else{pollution = pollution+co2+(co2*super.size()*10)/100;}
	}
	
	public int getId() {
		return id;
	}
	public String print(){
		return super.print()+String.format(" [%.3f g.co2]",pollution)+"\n";
	}
	
	public String toString() {
		return "T"+id;
	}
}
