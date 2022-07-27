import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public abstract class Infrastructure extends Elements {
	protected final int posi,posj;
	
	public Infrastructure(Ville v,int posi,int posj) {
		super();
		this.posi=posi;
		this.posj=posj;
		v.getInfrastructures().add(this);
	}
	
	public int getPosi() {
		return posi;
	}
	
	public int getPosj() {
		return posj;
	}
	
	public abstract double getCo2_S();
	
	public abstract void majPollution();
	
	public String print(){
		return toString()+"["+posi+","+posj+"]: "+super.size();
		//return s+super.print();
	}
		
}
