package com.mario.objets;

import java.awt.Image;

import javax.swing.ImageIcon;

public class TuyauRouge extends Objet{

	public TuyauRouge(int x, int y) {
		super(x, y, 43, 65);
		super.icoObjet = new ImageIcon(getClass().getResource("/images/tuyauRouge.png"));
		this.imgObjet = this.icoObjet.getImage();
	}

}
