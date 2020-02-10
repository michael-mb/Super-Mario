package com.mario.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.mario.audio.Audio;
import com.mario.jeu.Main;
import com.mario.objets.Objet;
import com.mario.objets.Piece;

public class Mario extends Personnage{

	private ImageIcon icoMario;
	private Image imgMario;
	private boolean saut;
	private int compteurSaut ; // duree du saut 
	private int compteurMort;
	
	public Mario(int x, int y) {
		super(x, y, 28, 50);
		
		icoMario = new ImageIcon(getClass().getResource("/images/marioMarcheDroite.png"));
		imgMario = icoMario.getImage();
		this.saut = false ;
		this.compteurSaut= 0 ;
	}
	
	public ImageIcon getIcoMario() {
		return icoMario;
	}

	public void setIcoMario(ImageIcon icoMario) {
		this.icoMario = icoMario;
	}

	public Image getImgMario() {
		return imgMario;
	}

	public void setImgMario(Image imgMario) {
		this.imgMario = imgMario;
	}
	
	public void setSaut(boolean saut) {
		this.saut = saut ;
	}
	public boolean isSaut() {
		return saut;
	}
	
	public Image saute() {
		
		ImageIcon ico;
		Image img;
		String str;
		
		compteurSaut++;
		
		//Montee du saut 
		if(compteurSaut <=40) {
			if(getY()> Main.f.scene.getHautPlafont()) {
				setY(getY() - 4);
			}
			else {
				compteurSaut = 41;
			}
			
			if(isVersDroite() == true) {
				str = "/images/marioSautDroite.png";
			}
			else {
				str = "/images/marioSautGauche.png";
			}
		}
		
		//Retombe du saut 
		else if (getY() + getHauteur() < Main.f.scene.getySol()) {
			setY(getY()+1);
			if(isVersDroite() == true) {
				str = "/images/marioSautDroite.png";
			}
			else {
				str = "/images/marioSautGauche.png";
			}
		}
		// Saut Termine 
		else {
			if(isVersDroite() == true) {
				str = "/images/marioSautDroite.png";
			}
			else {
				str = "/images/marioSautGauche.png";
			}
			saut = false ;
			compteurSaut = 0 ;
		}
		
		// Affichage image Mario
		
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		
		return img ;
	}
	
	public void contact (Objet objet) {
		
		//Contact horizontal
		if((super.contactAvant(objet) == true && this.isVersDroite() == true ) 
				|| (super.contactArriere(objet)== true && this.isVersDroite()==false)) {
			Main.f.scene.setDx(0);
			this.setMarche(false);
	}
	
		//Contact avec dessous
	if(super.contactDessous(objet) == true && this.saut == true){ //Mario Saute un objet
		Main.f.scene.setySol(objet.getY());
		}
	else if (super.contactDessous(objet) == false) { // Mario tombe sur le sol initial
			Main.f.scene.setySol(293); // niveau normal du sol
			if(saut==false) {
				setY(243);	//altitude initiale de mario
			}
		}
	if(super.contactDessus(objet) == true) {
		Main.f.scene.setHautPlafond(objet.getY() + objet.getHauteur()); // le plafond devient le dessous de l objet
	}else if (super.contactDessus(objet)==false && saut==false) {
		Main.f.scene.setHautPlafond(0); // plafond reinitialise 
		}
	}
	
	public boolean contactPiece(Piece piece) {
		if(contactArriere(piece) || contactAvant(piece) || contactDessous(piece) || contactDessous(piece))
			return true ;	
		return false;
	}
	 
	public void contact (Personnage personnage) {
		if(super.contactAvant(personnage) || super.contactArriere(personnage)) {
			this.setMarche(false);
			this.setVivant(false);
		}
		else if (super.contactDessous(personnage)) {
			personnage.setMarche(false);
			personnage.setVivant(false);
			
		}
	}

	@Override
	public Image marche (String nom , int frequence) {
		String str ="";
		ImageIcon ico ;
		Image img ;
		
		if(!this.marche || Main.f.scene.getxPos()<=0 || Main.f.scene.getxPos() > 4430) {
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
			this.compteur++;
			if(this.compteur/frequence == 0 ) {
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
			if (this.compteur == 2* frequence) {
				this.compteur = 0 ;
			}
			// Affichage Image Perso
						
		}
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		
		return img;
	}
	
public Image meurt() {
		
		String str ;
		Image img;
		ImageIcon ico ;
		
		str= "/images/boom.png";
		
		if(this.compteurMort == 0) {
			Audio.playSound("/audio/boum.wav");
		}
		if(this.compteurMort == 100) {
			Audio.playSound("/audio/game-over.wav");
		}
		compteurMort++;
		if(compteurMort > 100)
		{
			str="/images/marioMeurt.png";
			this.setY(this.getY() - 1);
		}
		ico = new ImageIcon(getClass().getResource(str));
		img= ico.getImage();
		this.setVivant(false);
		return img;
	}	
}