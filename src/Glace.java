
public class Glace {
	private double surface;
	
	public Glace(double surface) {
	this.surface=surface;
	}
	
	public double getSurface() {
	return surface;
	}
	
	
	public void setSurface(double val) {
	surface-= surface*val/100;
	}
	
	public String toString() {
	return "Surface de glace : "+ (int)surface ;
	}
	
	public void affichage() {
	
	if(surface>0){
		int taille = (int)(Math.sqrt(surface));
		for(int k=0;k<taille;k++) System.out.print("_"); //premiere barre
			System.out.println();
			for(int i=0;i<taille;i++) {
				for(int j=0;j<taille;j++) {
					if(j==0) System.out.print("|");//barre de gauche
					else if(j == taille-1) System.out.println("|");//barre de droite
					else System.out.print("#");
				}
			}
			for(int k=0;k<taille;k++) System.out.print("_"); //derniere barre
		}
		System.out.println();
	}
}
