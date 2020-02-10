package com.mario.jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.mario.audio.Audio;

public class Clavier implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(Main.f.scene.mario.isVivant())
		{
			
		
			if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				if(Main.f.scene.getxPos() == -1) {
					Main.f.scene.setxPos(0); // Reinitialisation de setxPos
					Main.f.scene.setxFond1(-50);	// Reinitialisation de xFond1
					Main.f.scene.setxFond2(750);	// Reinitialisation de xFond2
				}
				Main.f.scene.mario.setMarche(true);
				Main.f.scene.mario.setVersDroite(true);
				Main.f.scene.setDx(1);	// Deplacement vers la gauche de l image de fond
			}
			else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				
				if(Main.f.scene.getxPos() == 4431) {
					Main.f.scene.setxPos(4430); // Reinitialisation de setxPos
					Main.f.scene.setxFond1(-50);	// Reinitialisation de xFond1
					Main.f.scene.setxFond2(750);	// Reinitialisation de xFond2
				}
				
				Main.f.scene.setDx(-1); // Deplacement vers la droite de l image de fond
				Main.f.scene.mario.setMarche(true);
				Main.f.scene.mario.setVersDroite(false);
			}
			
			// Mario Saute 
			if(e.getKeyCode() == KeyEvent.VK_SPACE) {
				Main.f.scene.mario.setSaut(true);
				Audio.playSound("/audio/saut.wav");
			}
		
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		Main.f.scene.setDx(0);
		Main.f.scene.mario.setMarche(false);
	}

}
