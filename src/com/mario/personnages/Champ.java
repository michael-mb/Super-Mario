package com.mario.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.mario.objets.Objet;

public class Champ extends Personnage implements Runnable{

	private Image imgChamp;
	private ImageIcon icoChamp ;
	
	private final int PAUSE = 15 ;
	private int dxChamp ;
	
	public Champ(int x, int y) {
		super(x, y, 27, 30);
		super.setVersDroite(true);
		super.setMarche(true);
		this.dxChamp = 1 ;
		this.icoChamp = new ImageIcon(getClass().getResource("/images/champArretDroite.png"));
		this.imgChamp = this.icoChamp.getImage();
		
		Thread chronoChamp = new Thread (this);
		chronoChamp.start();
	}

	public Image getImgChamp() {
		return imgChamp;
	}

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			Thread.sleep(25);
		} catch (InterruptedException e) {}
	
		while(true) {
			if(this.isVivant()) 
				bouge();
			
			try {
					Thread.sleep(PAUSE);
			} catch (InterruptedException e) {}
		}
		
	}
	
	public void bouge() {
		if(super.isVersDroite())
			dxChamp = 1;
		else
			dxChamp = -1;
		
		super.setX(super.getX() + dxChamp);
	}
	
	public void contact (Objet objet) {
		
		//Contact horizontal
		if(super.contactAvant(objet) && this.isVersDroite()){
			super.setVersDroite(false);
			this.dxChamp = -1 ;
		}
		else if(super.contactArriere(objet) && !this.isVersDroite()) {
			super.setVersDroite(true);
			this.dxChamp = 1 ;
		}

	}
	
	public void contact (Personnage personnage) {
		
		//Contact horizontal
		if(super.contactAvant(personnage) && this.isVersDroite()){
			super.setVersDroite(false);
			this.dxChamp = -1 ;
		}
		else if(super.contactArriere(personnage) && !this.isVersDroite()) {
			super.setVersDroite(true);
			this.dxChamp = 1 ;
		}

	}
	
	public Image meurt() {
		
		String str ;
		Image img;
		ImageIcon ico ;

		
		if(this.isVersDroite()) {
			str = "/images/champEcraseDroite.png";
		}
		else {
			str="/images/champEcraseGauche.png";
		}
		ico = new ImageIcon(getClass().getResource(str));
		img= ico.getImage();
		this.setVivant(false);
		return img;
	}
	
}
