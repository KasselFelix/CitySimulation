
public class Play {
	public static void main(String[] args) {
		Glace antartique=new Glace(100);
		Creation city =new Creation();
		city.build();
		city.Time(8);
		city.Aller();
		city.Time(16);
		city.Retour();
		city.Time(24);
		System.out.println("==============================================================================");
		System.out.println(antartique);
		antartique.affichage();
		antartique.setSurface(Ville.getPollution()/100000);
		System.out.print("Il reste une ");
		System.out.println(antartique);
		antartique.affichage();
	}
}
