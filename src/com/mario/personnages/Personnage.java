package com.mario.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.mario.jeu.Main;
import com.mario.objets.Objet;

public class Personnage {

	private int largeur;
	private int hauteur;
	
	private int x ;
	private int y ;
	
	protected boolean marche;
	public boolean versDroite;
	protected int compteur;
	protected boolean vivant ; // vrai si le perso est vivant 
	
	public Personnage(int x , int y , int largeur , int hauteur) {
		
		this.x = x;
		this.y = y;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.compteur = 0;
		this.marche = false ;
		this.versDroite = true;
		this.vivant = true ;
	}
		
	// Getteurs // 
	public int getLargeur() {
		return largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isVivant() {
		return vivant ;
	}
	// Setteurs // 
	
	public void setY(int y) {
		this.y = y; 
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}
	public void setMarche(boolean marche) {
		this.marche = marche;
	}
	public void setVivant(boolean vivant) {
		this.vivant = vivant;
	}
	
	// Boolean // 
	public boolean isMarche() {
		return marche;
	}

	public boolean isVersDroite() {
		return versDroite;
	}
	public void setVersDroite(boolean versDroite) {
		this.versDroite = versDroite;
	}
	public int getCompteur() {
		return compteur;
	}
	
	
	// Methodes // 
	
	public Image marche (String nom , int frequence) {
		String str ="";
		ImageIcon ico ;
		Image img ;
		
		if(!this.marche) {
			if(versDroite)
			{
				str="/images/"+nom+ "ArretDroite.png";
			}
			else
			{
				str="/images/"+nom+ "ArretGauche.png";
			}
		}
		else {
			compteur++;
			if(compteur/frequence == 0 ) {
				if(versDroite)
					str="/images/"+nom+ "ArretDroite.png";
				else
					str="/images/"+nom+ "ArretGauche.png";
			}
			else{
				if(versDroite)
					str="/images/"+nom+ "MarcheDroite.png";
				else
					str="/images/"+nom+ "MarcheGauche.png";
			}
			if (compteur == 2* frequence) {
				compteur = 0 ;
			}
			// Affichage Image Perso
						
		}
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		
		return img;
	}
	
	// Contact avec objet inanime
	public boolean contactAvant(Objet objet) {
		if(x + largeur < objet.getX() || x + largeur > objet.getX() + 5 
				|| y + hauteur <= objet.getY() || y >=objet.getY() + objet.getHauteur())
			return false ;
		return true;
	}
	
	public boolean contactArriere(Objet objet) {
		if(x > objet.getX() + objet.getLargeur() || x + largeur < objet.getX() + objet.getLargeur() - 5 
				|| y + hauteur <= objet.getY() || y >= objet.getY() + objet.getHauteur())
			return false ;
		return true;
	}
		
	public boolean contactDessous(Objet objet) {
		if(x + largeur < objet.getX() + 5 || x > objet.getX() + objet.getLargeur() - 5 
				|| y + hauteur < objet.getY() || y > objet.getY() + 5)
			return false ;
		return true;
	}
	
	public boolean contactDessus(Objet objet) {
		if(x + largeur < objet.getX() + 5 || x > objet.getX() + objet.getLargeur() - 5 
				|| y < objet.getY() + objet.getHauteur() || y > objet.getY() + objet.getHauteur() + 5)
			return false ;
		return true;
	}
	
	// Contact avec objet anime
		public boolean contactAvant(Personnage personnage) {
			
			if(isVersDroite()) {
				if(x + largeur < personnage.getX() || x + largeur > personnage.getX() + 5 
						|| y + hauteur <= personnage.getY() || y >=personnage.getY() + personnage.getHauteur())
					return false ;
				return true;
			}
			return false;	
		}
		
		public boolean contactArriere(Personnage personnage) {
			if(x > personnage.getX() + personnage.getLargeur() || x + largeur < personnage.getX() + personnage.getLargeur() - 5 
					|| y + hauteur <= personnage.getY() || y >= personnage.getY() + personnage.getHauteur())
				return false ;
			return true;
		}
		
		public boolean contactDessous(Personnage personnage) {
			if(x + largeur < personnage.getX() + 5 || x > personnage.getX() + personnage.getLargeur() - 5 
					|| y + hauteur < personnage.getY() || y > personnage.getY() + 5)
				return false ;
			return true;
		}
		
		
	// Proche objet inanime	
	public boolean proche (Objet objet) {
		if(x + largeur > objet.getX()-10 &&  x < objet.getX() + objet.getLargeur() + 10 
				|| x + largeur  > objet.getX() - 10 && x + largeur <  objet.getX() + objet.getLargeur() + 10)
			return true ;
		return false;
	}
	
	// Proche objet anime
	public boolean proche (Personnage personnage) {
		if(x + largeur > personnage.getX()-10 &&  x < personnage.getX() + personnage.getLargeur() + 10 
				|| x + largeur  > personnage.getX() - 10 && x + largeur <  personnage.getX() + personnage.getLargeur() + 10)
			return true ;
		return false;
	}
	
	public void deplacement() {
		if(Main.f.scene.getxPos() >= 0)
			x = x - Main.f.scene.getDx();
	}
}
