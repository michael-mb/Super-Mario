package com.mario.objets;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Piece extends Objet{

	private int compteur;
	private final int PAUSE = 15 ;
	public Piece(int x, int y) {
		super(x, y, 30, 30);
		
		this.compteur = 0 ;
		super.icoObjet = new ImageIcon(getClass().getResource("/images/piece1.png"));
		super.imgObjet = super.icoObjet.getImage();
	}

}
