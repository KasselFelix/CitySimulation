

public class Adulte extends Villageoi {
	private Travaille work;
	public Adulte(Ville ville,boolean conducteur,Maison home,Voiture voiture,Travaille work){
		super(ville,conducteur,home, voiture);
		this.work=work;
		home.push(this);
	}
	public void setWork(Travaille work) {
		this.work = work;
	}
	public Travaille getDest() {
		return work;
	}
	
	public String print(){
		return "Adulte_"+super.toString();
	}
	
	public String toString(){
		return print()+": [maison: "+getHome()+",conducteur: "+getConducteur()+",voiture : "+getVoiture()+","+"travail : "+work+"]\n";
	}
}
