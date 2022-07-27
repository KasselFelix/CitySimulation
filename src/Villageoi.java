
public abstract class Villageoi {
	private Maison home;
	private Infrastructure tmp;
	private Voiture voiture;
	private boolean conducteur;
	private final int id;
	private static int cpt=0;
	
	public Villageoi(Ville v,boolean conducteur,Maison home,Voiture voiture) {
		this.conducteur=conducteur;
		this.home=home;
		this.voiture=voiture;
		tmp=home;
		id=cpt++;
		v.getVillageois().add(this);
	}

	public void monter(){
		if(tmp.erased(this))
		voiture.entrer(this);
	}
	public void descendre(){
		if(voiture.sortir(this))
		tmp.push(this);
	}
	
	public boolean equals(Object obj) {
		if (this == obj)  return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass())
			return false;
		Villageoi other = (Villageoi) obj;
		if( id != other.getId()) return false;
		return true;
	}
	
	public abstract Object getDest();
	
	public int getId() {
		return id;
	}
	
	public Infrastructure getHome() {
		return home;
	}
	
	public Infrastructure getTmp() {
		return tmp;
	}

	public boolean getConducteur() {
		return conducteur;
	}

	public Voiture getVoiture() {
		return voiture;
	}
	public void setTmp(Infrastructure tmp) {
		this.tmp = tmp;
	}
	
	public String toString(){
		return "v"+id;
	}
}
