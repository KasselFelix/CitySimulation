
public class Enfant extends Villageoi {
	private Ecole ecole;
	public Enfant(Ville ville,Maison home,Voiture voiture,Ecole e){
		super(ville,false,home, voiture);
		ecole=e;
		home.push(this);
	}
	public Ecole getDest() {
		return ecole;
	}
	
	public String print(){
		return "Enfant_"+super.toString();
	}
	
	public String toString(){
		return print()+": [maison: "+getHome()+",conducteur: "+getConducteur()+",voiture : "+getVoiture()+","+"ecole : "+ecole+"]\n";
	}

}
