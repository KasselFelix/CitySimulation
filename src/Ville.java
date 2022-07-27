import java.util.ArrayList;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.*;

public class Ville extends JPanel {
	
	private final String nom;
	public static final int taille=22;
	private final double surface=(taille*5.0)*(taille*5.0);
	private static double pollution=0;
	private double t=0;
	private Elements[][] ville;
	private ArrayList<Villageoi> villageois;
	private ArrayList<Voiture> voitures;
	private ArrayList<Travaille> works;
	private ArrayList<Ecole> ecoles;
	private ArrayList<Infrastructure> infrastructures;

	public Ville(String nom){
		this.nom=nom;
		voitures = new ArrayList<Voiture>();
		works = new ArrayList<Travaille>();
		ecoles = new ArrayList<Ecole>();
		villageois=new ArrayList<Villageoi>();
		infrastructures= new ArrayList<Infrastructure>();
		ville=new Elements[taille][taille];
		for(int i=0;i<taille;i++){
			for(int j=0;j<taille;j++){
				ville[i][j]=new Elements();
			}
		}
		this.setPreferredSize(new Dimension(taille, taille));
	}

	public void ajouterInfra(Infrastructure i) {
		if(((i.getPosi()<ville.length-2) && (i.getPosj()<ville.length-2)) &&((i.getPosi()>1) && (i.getPosj()>1)) ) {
			if(i.getPosi()%4==2 && i.getPosj()%4==2){
				ville[i.getPosi()][i.getPosj()]=i;
				ville[i.getPosi()+1][i.getPosj()]=i;
				ville[i.getPosi()][i.getPosj()+1]=i;
				ville[i.getPosi()+1][i.getPosj()+1]=i;
			}
		}
	}
	
	public void ajouterRoute(Route r,int i,int j){
		if((i<(ville.length) && j<(ville.length)) && (i>=0 && j>=0) ) {
			if( (ville[i][j] instanceof Infrastructure) == false){
				if((i%4==1)||(i%4==0)||(j%4==1)||(j%4==0)){
					ville[i][j]=r;
				}
			}
		}
	}
	
	public Travaille randWork(){
		int i=(int)(Math.random()*works.size());
		return works.get(i);
	}
	
	public Ecole randEcole(){
		int i=(int)(Math.random()*ecoles.size());
		return ecoles.get(i);
	}
	
	public Elements getElements(int i,int j) {
		return ville[i][j];
	}
	
	public int getNbHabitants(){
		return villageois.size();
	}
	
	public ArrayList<Infrastructure> getInfrastructures() {
		return infrastructures;
	}
	public ArrayList<Travaille> getWorks() {
		return works;
	}
	public ArrayList<Ecole> getEcoles() {
		return ecoles;
	}

	public ArrayList<Villageoi> getVillageois() {
		return villageois;
	}
	
	public ArrayList<Voiture> getVoitures() {
		return voitures;
	}
	
	public int getTaille() {
		return taille;
	}

	public String getNom() {
		return nom;
	}

	public double getSurface() {
		return surface;
	}
	
	public static double getPollution() {
		return pollution;
	}
	public double getT() {
		return t;
	}
	public void setT(double s) {
		t=t+s;
	}
	public static void setPollution(double pollution) {
		Ville.pollution = pollution;
	}

	public String printVoitures() {
		String s="[Voitures]:\n";
		for(int i=0;i<voitures.size();i++) {
			s+=voitures.get(i).print()+"\n";
		}
		return s;
	}
	
	public String printWorks() {
		String s="[Works]:\n";
		for(int i=0;i<works.size();i++) {
			s+=works.get(i).print()+"\n";
		}
		return s;
	}
	
	public String printEcoles() {
		String s="[Ecoles]:\n";
		for(int i=0;i<ecoles.size();i++) {
			s+=ecoles.get(i).print()+"\n";
		}
		return s;
	}
	
	public String printVillageois() {
		int n=villageois.size();
		String s="[Villageois]: "+n+"\n";
		for(int i=0;i<n;i++) {
			s+=villageois.get(i)+"\n";
		}
		return s;
	}
	
	public String printInfrastructure() {
		String s="[Infrastructures]:\n";
		for(int i=0;i<infrastructures.size();i++) {
			s+=infrastructures.get(i).print()+"\n";
		}
		return s;
	}
	
	public String toString(){
		String s;
		if(t==0)s=nom+": ["+surface+"m caree, "+getNbHabitants()+" habitants] Pollution="+String.format(" %.3f kg.co2",pollution/1000)+" "+0+":"+0+":"+0+"\n";
		else s=nom+": ["+surface+"m caree, "+getNbHabitants()+" habitants] Pollution="+String.format(" %.3f kg.co2",pollution/1000)+" "+(int)(((t/60)/60))+":"+(int)(t/60)%60+":"+(int)(t%60)+"\n";
		for(int i=0;i<taille;i++){
			for(int j=0;j<taille;j++){
				s+=ville[i][j].toString()+"\t";
			}
			s+="\n";
		}
		return s;
	}
}
