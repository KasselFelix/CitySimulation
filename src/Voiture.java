import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.util.ArrayList;

public class Voiture {

	private Maison home;
	private int posi;
	private int posj;
	private Infrastructure destination;
	private Villageoi[] places;
	private int indice=0;
	private int nb=0;
	private boolean depart=false; 
	private double co2=0;
	private int id;
	private static int cpt=0;
	private final Ville ville;
	
	public Voiture(Ville ville,Maison home) {
		this.ville=ville;
		this.home=home;
		posi=home.getPosi();
		posj=home.getPosj();
		places=new Villageoi[5];
		id=cpt++;
		ville.getVoitures().add(this);
	}

	public boolean sortir(Villageoi v) {
		for(int i=0;i<5;i++) {
			if (places[i]==v || places[i].equals(v)) {
				places[i]=null;
				nb-=1;
				return true;
			}
		}
		return false;
	}

	public boolean entrer(Villageoi v) {
		for(int i=0;i<5;i++) {
			if (places[i]==null) {
				places[i]=v;
				nb+=1;
				return true;
			}
		}
		return false;
	}


	public void avancer(int di, int dj){
		if(di == 0 && dj == 0){
			co2+=0.1d;
			Ville.setPollution(Ville.getPollution()+ 0.1);
		}
		else {
			ville.getElements(posi+di,posj+dj).push(this);
			ville.getElements(posi,posj).pop();
			posi=posi+di;
			posj=posj+dj;
			co2+=0.575d;
			Ville.setPollution(Ville.getPollution()+ 0.575);
		}
	}

	public double distance( int ia,int ja, int ib,int jb){
		return Math.abs(Math.sqrt((jb-ja)*(jb-ja)+(ib-ia)*(ib-ia)));
	}

	public Direction bestDir(ArrayList<Direction> directions) {
		double dist=distance(0,0,ville.getTaille()+1,ville.getTaille()+1);
		Direction res=null;
		for (int i=0;i<directions.size();i++){
			Direction tmp=directions.get(i);
			double nd=distance(posi+tmp.getI(),posj+tmp.getJ(),destination.getPosi()-1,destination.getPosj());
			if(nd<dist){
				dist=nd;
				res=tmp;
				//System.out.println(1);
			}
		}
		return res;
	}

	public void avancerVers(Direction res) {
		if(res != null){//System.out.println(2);
			if(((ville.getElements(posi+res.getI(),posj+res.getJ())) instanceof Route) && (posi+res.getI()<ville.getTaille() && posj+res.getJ()<ville.getTaille()) ){//System.out.println(3);
				if(ville.getElements(posi+res.getI(),posj+res.getJ()).isEmpty()){//System.out.println(4);
					this.avancer(res.getI(),res.getJ());
				}else this.avancer(0,0);//System.out.println(5);
			}
		}
	}

	public void start() {
		int n=home.size();
		for (int i=0;i<n;i++){
			places[i]=(Villageoi) home.get(home.size()-1);
			home.pop();
			nb+=1;
		}
		if(home.size()==0){
			destination=(Infrastructure)places[indice].getDest();
			Elements c=ville.getElements(home.getPosi()-1,home.getPosj());
			c.push(this);
			posi=posi-1;
		}
	}

	public void startRetour() {
		Elements c=ville.getElements(destination.getPosi()-1,destination.getPosj());
		if(c.isEmpty()){
			indice=nb-1;
			c.push(this);
			posi=posi-1;
			depart=true;
		}else{
			depart=false;
		}
	}


	public void roadToWork(){
		if((posi != destination.getPosi()-1) || (posj != destination.getPosj())){
			ArrayList<Direction> directions =((Route) ville.getElements(posi,posj)).getDirections();
			avancerVers(bestDir(directions));
		}else{
			destination.push(places[indice]);
			places[indice].setTmp(destination); 
			indice=indice+1;
			if(indice>=nb){
				ville.getElements(posi, posj).pop();
				posi=destination.getPosi();
				posj=destination.getPosj();//System.out.println(6);
			}else{
				destination=(Infrastructure)(places[indice].getDest());
				this.avancer(0,0);//System.out.println(7);
			}
		}
	}

	public void roadToHome /*throws*/ (){
		if((posi != destination.getPosi()-1) || (posj != destination.getPosj())){
			ArrayList<Direction> directions =((Route) ville.getElements(posi,posj)).getDirections();
			avancerVers(bestDir(directions));//System.out.println(toString()+2);
		}else{
			if(indice>=0) {
				if(destination.erased(places[indice])){
					if(indice==0){
						indice=indice-1;
						destination=home;
						avancerVers(bestDir( ((Route) ville.getElements(posi,posj)).getDirections() ));//System.out.println(toString()+3);
					}else{
						indice=indice-1;
						destination=(Infrastructure)(places[indice].getDest());
						this.avancer(0,0);//System.out.println(toString()+4);
					}
				}else {System.out.println("Error")/*throw new */;}
			}else {
				for(int i=0;i<nb;i++) {
					places[i].setTmp(home);
					home.push(places[i]);
					places[i]=null;
				}
				//System.out.println(toString()+5+indice);
				ville.getElements(posi, posj).pop();
				indice=indice-1;
			}
		}
	}

	public void setDestination(Infrastructure destination) {
		this.destination = destination;
	}

	public void setPosi(int i){
		posi=i;
	}

	public void setPosj(int j){
		posi=j;
	}

	public Infrastructure getDestination() {
		return destination;
	}

	public int getPosi(){
		return posi;
	}

	public int getPosj(){
		return posj;
	}

	public Maison getHome() {
		return home;
	}

	public double getCo2() {
		return co2;
	}

	public int getIndice() {
		return indice;
	}

	public int getNb() {
		return nb;
	}

	public boolean isDepart() {
		return depart;
	}

	public Villageoi[] getPlaces() {
		return places;
	}

	public int getId() {
		return id;
	}
	public String print(){
		if(indice>=0) 
			return toString()+" [position:("+posi+","+posj+")] "+String.format("[Co2: %.3f",co2)+" g] [destination: <"+destination+">] [passager:"+(nb-indice)+"/"+nb+"]";
		else
			return toString()+" [position:("+posi+","+posj+")] "+String.format("[Co2: %.3f",co2)+" g] [destination: <"+destination+">] [passager:"+nb+"/"+nb+"]";
	}

	public String toString() {
		return "{["+id+"]"+">";
	}

}
