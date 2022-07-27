import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class FenetreGraphique extends JPanel {
	private JFrame f = new JFrame();
	public FenetreGraphique() {
		super();
		
	}
	
	public void build() {
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setSize(900,900);
		f.setTitle("Ville");
		f.add(this);
		f.setVisible(true);
	}
	
	/*@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//JPanel.getWidth()/nbColonnes | JPanel.getHeight()/nbLignes
		try {
			BufferedImage img = ImageIO.read(new File("redCar.png"));
			g.drawImage(img, 0, 0, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}*/
	
	public static void main(String args[]) {
		FenetreGraphique f = new FenetreGraphique();
		f.build();
		
		String NAME="Gotham";
		Ville city=new Ville(NAME);
		
		
		Ecole ecole=new Ecole(city,6,6);
		city.ajouterInfra(ecole);
		ecole.dessiner(f);
		f.repaint();
		
		
		/* TODO Mettre comme le paintComponent en haut une fonction 
		 * public void dessiner(JPanel p){
		 *...
		 * p.getGraphics().drawImage(img,x,y,xfin,yfin);
		 * }
		 * 
		 * while(true){
		 * bouger tous les objets
		 * objets.dessiner(f.getContentPane());
		 * repaint();
		 * }
		 * 
		 */
		
	}
}
