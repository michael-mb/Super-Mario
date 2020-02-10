package com.mario.jeu;

import javax.swing.JFrame;

public class Fenetre extends JFrame{

	public static Scene scene ;
	public Fenetre()
	{
		this.setTitle("Super Mario");
		this.setSize(700,360);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		scene = new Scene();
		
		this.setContentPane(scene);
		this.setVisible(true);
	}
}
