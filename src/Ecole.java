import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Ecole extends Infrastructure {
	private final double co2=1;
	private double pollution=0;
	private static int cpt=0;
	private int id;
	public Ecole(Ville v,int posi,int posj) {
		super(v,posi,posj);
		id=cpt++;
		v.getEcoles().add(this);
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
		return "e"+id;
	}
	
	public void dessiner(JPanel p) {
		try {
			BufferedImage img = ImageIO.read(new File("redCar.png"));
			p.getGraphics().drawImage(img, posi*(p.getHeight()/Ville.taille), posj*(p.getHeight()/Ville.taille), p.getHeight()/Ville.taille, p.getWidth()/Ville.taille, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
