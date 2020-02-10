package com.mario.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.mario.objets.Objet;

public class Tortue extends Personnage implements Runnable{

	private Image imgTortue;
	private ImageIcon icoTortue ;
	
	private final int PAUSE = 15 ;
	private int dxTortue ;
	
	public Tortue(int x, int y) {
		super(x, y, 27, 30);
		super.setVersDroite(true);
		super.setMarche(true);
		this.dxTortue = 1 ;
		this.icoTortue = new ImageIcon(getClass().getResource("/images/tortueArretGauche.png"));
		this.imgTortue = this.icoTortue.getImage();
		
		Thread chronoChamp = new Thread (this);
		chronoChamp.start();
	}

	

	public Image getImgTortue() {
		return imgTortue;
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
			dxTortue = 1;
		else
			dxTortue = -1;
		
		super.setX(super.getX() + dxTortue);
	}
	
	public void contact (Objet objet) {
		
		//Contact horizontal
		if(super.contactAvant(objet) && this.isVersDroite()){
			super.setVersDroite(false);
			this.dxTortue = -1 ;
		}
		else if(super.contactArriere(objet) && !this.isVersDroite()) {
			super.setVersDroite(true);
			this.dxTortue = 1 ;
		}

	}

	public void contact (Personnage personnage) {
		
		//Contact horizontal
		if(super.contactAvant(personnage) && this.isVersDroite()){
			super.setVersDroite(false);
			this.dxTortue = -1 ;
		}
		else if(super.contactArriere(personnage) && !this.isVersDroite()) {
			super.setVersDroite(true);
			this.dxTortue = 1 ;
		}

	}
	
	public Image meurt() {
		
		String str ;
		Image img;
		ImageIcon ico ;
	
		str = "/images/tortueFermee.png";
		ico = new ImageIcon(getClass().getResource(str));
		img= ico.getImage();
		this.setVivant(false);
		return img;
	}
}
