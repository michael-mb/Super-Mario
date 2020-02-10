package com.mario.jeu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.mario.affichage.CompteARebours;
import com.mario.affichage.Score;
import com.mario.audio.Audio;
import com.mario.objets.Bloc;
import com.mario.objets.Objet;
import com.mario.objets.Piece;
import com.mario.objets.TuyauRouge;
import com.mario.personnages.Champ;
import com.mario.personnages.Mario;
import com.mario.personnages.Tortue;

public class Scene extends JPanel{
	
	private ImageIcon icoFond;
	private Image imgFond1;
	private Image imgFond2;
	
	private ImageIcon icoChateau1;
	private Image imgChateau1;
	
	private ImageIcon icoDepart;
	private Image imgDepart;
	
	private int xFond1;
	private int xFond2;
	private int dx;		// deplacement du fond d ecran
	
	private int xPos;  // position absolu dans le jeu
	
	private int ySol;	// hauteur courante du sol 
	private int hautPlafont; // hauteur courante du plafond
	
	public Mario mario ;
	
	public Objet tuyauRouge1;
	public Objet tuyauRouge2;
	public Objet tuyauRouge3;
	public Objet tuyauRouge4;
	public Objet tuyauRouge5;
	public Objet tuyauRouge6;
	public Objet tuyauRouge7;
	public Objet tuyauRouge8;
	
	
	public Objet bloc1;
	public Objet bloc2;
	public Objet bloc3;
	public Objet bloc4;
	public Objet bloc5;
	public Objet bloc6;
	public Objet bloc7;
	public Objet bloc8;
	public Objet bloc9;
	public Objet bloc10;
	public Objet bloc11;
	public Objet bloc12;
	
	public Piece piece1 ;
	public Piece piece2 ;
	public Piece piece3 ;
	public Piece piece4 ;
	public Piece piece5 ;
	public Piece piece6 ;
	public Piece piece7 ;
	public Piece piece8 ;
	public Piece piece9 ;
	public Piece piece10 ;
	
	public Tortue tortue1;
	public Tortue tortue2;
	public Tortue tortue3;
	public Tortue tortue4;
	public Tortue tortue5;
	public Tortue tortue6;
	public Tortue tortue7;
	public Tortue tortue8;
	public Tortue tortue9;
	
	public Champ champ1 ;
	public Champ champ2 ;
	public Champ champ3 ;
	public Champ champ4 ;
	public Champ champ5 ;
	public Champ champ6 ;
	public Champ champ7 ;
	public Champ champ8 ;

	private ImageIcon icoDrapeau;
	private Image imgDrapeau;
	
	private ImageIcon icoChateauFin;
	private Image imgChateauFin;
	
	
	// Alternative Pieces 

	private Image imgP;
	
	private Image imgP1;
	private ImageIcon icoP1;
	
	private Image imgP2;
	private ImageIcon icoP2;
	
	
	List<Objet> tabObjets;
	List<Piece> tabPieces;
	List<Champ> tabChamps;
	List<Tortue> tabTortues;
	
	private int compteurPieces;
	
	private Score score;
	private Font police ;
	private CompteARebours temps ;
	
	private boolean gagne = false ;
	
	public Scene(){
		super();
		
		this.xFond1 = -50;
		this.xFond2 = 750;
		this.dx = 0 ;
		this.xPos=-1; // Juste pour gerer le decalage
		
		this.ySol = 293 ;
		this.hautPlafont = 0 ;
		this.compteurPieces = 0 ;
		
		icoFond = new ImageIcon(getClass().getResource("/images/fondEcran.png"));
		imgFond1 = icoFond.getImage();
		imgFond2 = icoFond.getImage();
		
		icoDepart = new ImageIcon(getClass().getResource("/images/depart.png"));
		imgDepart = icoDepart.getImage();
		
		icoChateau1 = new ImageIcon(getClass().getResource("/images/chateau1.png"));
		imgChateau1 = icoChateau1.getImage();
		
		icoP1 = new ImageIcon(getClass().getResource("/images/piece1.png"));
		imgP1 = icoP1.getImage();
		
		icoP2 = new ImageIcon(getClass().getResource("/images/piece2.png"));
		imgP2 = icoP2.getImage();
		
		score = new Score();
		police = new Font("Arial" , Font.PLAIN , 18);
		temps = new CompteARebours();
		
		mario 	= new Mario(300,245);
				
		
		tuyauRouge1 = new TuyauRouge(600,230);
		tuyauRouge2 = new TuyauRouge(1000,230);
		tuyauRouge3 = new TuyauRouge(1600,230); 
		tuyauRouge4 = new TuyauRouge(1900,230);
		tuyauRouge5 = new TuyauRouge(2500,230);
		tuyauRouge6 = new TuyauRouge(3000,230);
		tuyauRouge7 = new TuyauRouge(3800,230);
		tuyauRouge8 = new TuyauRouge(4500,230);
		
		bloc1 	= new Bloc(400 , 180);
		bloc2 	= new Bloc(1200 , 180);
		bloc3 	= new Bloc(1270 , 170);
		bloc4 	= new Bloc(1340 , 160);
		bloc5 	= new Bloc(2000 , 180);
		bloc6 	= new Bloc(2600 , 160);
		bloc7 	= new Bloc(2650 , 180);
		bloc8 	= new Bloc(3500 , 160);
		bloc9 	= new Bloc(3550 , 140);
		bloc10 	= new Bloc(4000 , 170);
		bloc11	= new Bloc(4200 , 200);
		bloc12 	= new Bloc(4300 , 210);
		
		piece1 	= new Piece(402,145);
		piece2 	= new Piece(1202,140);
		piece3 	= new Piece(1272,95);
		piece4 	= new Piece(1342,40);
		piece5 	= new Piece(1650,145);
		piece6 	= new Piece(2650,145);
		piece7 	= new Piece(3000,135);
		piece8 	= new Piece(3400,125);
		piece9 	= new Piece(4200,145);
		piece10 = new Piece(4600,40);
		
		champ1 = new Champ(800,263);
		champ2 = new Champ(1100,263);
		champ3 = new Champ(2100,263);
		champ4 = new Champ(2400,263);
		champ5 = new Champ(3200,263);
		champ6 = new Champ(3500,263);
		champ7 = new Champ(3700,263);
		champ8 = new Champ(4500,263);
		
		tortue1 = new Tortue(950,243);
		tortue2 = new Tortue(1500,243);
		tortue3 = new Tortue(1800,243);
		tortue4 = new Tortue(2400,243);
		tortue5 = new Tortue(3100,243);
		tortue6 = new Tortue(3600,243);
		tortue7 = new Tortue(3900,243);
		tortue8 = new Tortue(4200,243);
		tortue9 = new Tortue(4400,243);
		
		icoChateauFin = new ImageIcon(getClass().getResource("/images/chateauFin.png"));
		imgChateauFin = icoChateauFin.getImage();
		
		icoDrapeau = new ImageIcon(getClass().getResource("/images/drapeau.png"));
		imgDrapeau = icoDrapeau.getImage();
		
		tabObjets = new ArrayList<>();
		tabPieces = new ArrayList<>();
		tabChamps = new ArrayList<>();
		tabTortues = new ArrayList<>();
		
		tabObjets.add(tuyauRouge1);
		tabObjets.add(tuyauRouge2);
		tabObjets.add(tuyauRouge3);
		tabObjets.add(tuyauRouge4);
		tabObjets.add(tuyauRouge5);
		tabObjets.add(tuyauRouge6);
		tabObjets.add(tuyauRouge7);
		tabObjets.add(tuyauRouge8);
		
		tabObjets.add(bloc1);
		tabObjets.add(bloc2);
		tabObjets.add(bloc3);
		tabObjets.add(bloc4);
		tabObjets.add(bloc5);
		tabObjets.add(bloc6);
		tabObjets.add(bloc7);
		tabObjets.add(bloc8);
		tabObjets.add(bloc9);
		tabObjets.add(bloc10);
		tabObjets.add(bloc11);
		tabObjets.add(bloc12);
		
		tabPieces.add(piece1);
		tabPieces.add(piece2);
		tabPieces.add(piece3);
		tabPieces.add(piece4);
		tabPieces.add(piece5);
		tabPieces.add(piece6);
		tabPieces.add(piece7);
		tabPieces.add(piece8);
		tabPieces.add(piece9);
		tabPieces.add(piece10);
		
		tabChamps.add(champ1);
		tabChamps.add(champ2);
		tabChamps.add(champ3);
		tabChamps.add(champ4);
		tabChamps.add(champ5);
		tabChamps.add(champ6);
		tabChamps.add(champ7);
		tabChamps.add(champ8);

		tabTortues.add(tortue1);
		tabTortues.add(tortue2);
		tabTortues.add(tortue3);
		tabTortues.add(tortue4);
		tabTortues.add(tortue5);
		tabTortues.add(tortue6);
		tabTortues.add(tortue7);
		tabTortues.add(tortue8);
		tabTortues.add(tortue9);

		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier());
		Thread chronoEcran = new Thread(new Chrono());
		Audio.playSound("/audio/son.wav");
		chronoEcran.start();
		
		
		

	}

	public void paintComponent(Graphics g){
		
		 super.paintComponent(g);
		 Graphics2D g2 = (Graphics2D)g;
		  		 
		 // Detection Contact
		   		// ici l ordre est d une grande importance ! 
		 for(Objet ob : tabObjets) {
			 if(mario.proche(ob))
				 mario.contact(ob);
			 for (Champ champ : tabChamps) {
				 if(champ.proche(ob))
					 champ.contact(ob);
			 }
			 for (Tortue tortue : tabTortues) {
				 if(tortue.proche(ob))
					 tortue.contact(ob);
			 }
		}
		 
		 for (Tortue tortue : tabTortues) {
			 for(Champ champ : tabChamps) {
				 if(tortue.proche(champ))
					 tortue.contact(champ);
			 }
		 }
		 
		 for (Champ champ : tabChamps) {
			 for(Tortue tortue : tabTortues) {
				 if(champ.proche(tortue))
					 champ.contact(tortue);
			 }
		 }
		 
		 for (Champ champ : tabChamps) {
			 if (champ.isVivant()) {
				 if(mario.proche(champ))
					 mario.contact(champ); 
				 if(!champ.isVivant()) {
					 Audio.playSound("/audio/ecrasePersonnage.wav");
				 }
			 }
		 }
		 for(Tortue tortue : tabTortues) {
			 if(tortue.isVivant()) {
				 if(mario.proche(tortue))
					 mario.contact(tortue);
				 if(!tortue.isVivant()) {
					 Audio.playSound("/audio/ecrasePersonnage.wav");
				 }
			 }
		 }
		 
		 // Detection contact avec Pieces 
		 for(Piece ob : tabPieces) {
			 if(mario.proche(ob))
				 if(mario.contactPiece(ob)) {
					 tabPieces.remove(ob);
					 score.setNbrePieces(score.getNbrePieces()+1);
					 Audio.playSound("/audio/piece.wav");
				 }
		 }
		 
		 
		 // Deplacement objets fixes
		 deplacementFond();
		 
		 for(Objet ob : tabObjets) {
			 if (xPos >= 0 && xPos <= 4430)
				 ob.deplacement();
		 }
		 
		 for(Piece ob : tabPieces) {
			 if (xPos >= 0 && xPos <= 4430)
				 ob.deplacement();
		 }
		 
		 for(Champ champ : tabChamps) {
			 champ.deplacement();
		 }
		 for(Tortue tortue : tabTortues) {
			 tortue.deplacement();
		 }
		 
		 // images de fond 
		 g2.drawImage(this.imgFond1, this.xFond1, 0, null);
		 g2.drawImage(this.imgFond2, this.xFond2, 0, null);
		 
		 // image chateur depart avec fleche
		 g2.drawImage(this.imgChateau1, 10 - xPos, 95, null);
		 g2.drawImage(this.imgDepart, 220 - xPos, 234, null);
		 
		 //On dessine tous les obstacles 
		 for (Objet ob : tabObjets) {
			 g2.drawImage(ob.getImgObjet() , ob.getX(), ob.getY() , null);
		 }
		 
		 // piece Mouvement 
		 if((int)(compteurPieces / 100) == 0 )
			 imgP = imgP1;
		 else
			 imgP = imgP2;
		 
		 for (Piece ob : tabPieces) {
			 g2.drawImage(imgP , ob.getX(), ob.getY() , null);
		 }
		 
		 g2.drawImage(imgDrapeau, 4650 - xPos, 115, null);
		 g2.drawImage(imgChateauFin, 5000 - xPos, 145, null);
		 
		 // image champignon 	 
		 
		 
		 for (Champ champ : tabChamps) {
			 if(!champ.isVivant())
				 g2.drawImage(champ.meurt() , champ.getX() , champ.getY() + 20 , null);
			 else 
				 g2.drawImage(champ.marche("champ", 45) , champ.getX() , champ.getY() , null);
		 }
				 
		 
		 // image Tortue
		 
		 for (Tortue tortue : tabTortues) {
			 if(!tortue.isVivant())
				 g2.drawImage(tortue.meurt() , tortue.getX() , tortue.getY() + 30 , null);
			 else
				 g2.drawImage(tortue.marche("tortue", 45) , tortue.getX() , tortue.getY() , null);
		 }
		 

		 
		 // image mario
		 
		 if(mario.isVivant()) {
			 if(mario.isSaut()) 
				 g2.drawImage(mario.saute(),mario.getX(),mario.getY(),null);
			 else 
				 g2.drawImage(mario.marche("mario", 25),mario.getX(),mario.getY(),null);
		 }
		 else {
			 g2.drawImage(mario.meurt(),mario.getX(),mario.getY(),null);
		 }
		 
		 // Mise a jour score ! 
		 g2.setFont(police);
		 g2.drawString(score.getNbrePieces() + " piece(s) trouve(s) sur " + score.getTOTAL_PIECE(), 460, 25);

		 // Mise a jour Temps 
		 g2.drawString(temps.getStr() , 5, 15);
		 
		 // Pieces bougent
		 if(compteurPieces >= 200 )
			 compteurPieces = 0 ;
		 compteurPieces ++ ;
		 
		 //Fin de partie
		 if(finDePartie()) {
			 Font policeFin = new Font("Arial", Font.BOLD,50);
			 g2.setFont(policeFin);
			 temps.setIsRunning(false);
			 
			 if(this.partieGagnee()) {
				 g.setColor(Color.yellow);
				 g2.drawString("Vous avez Gagne !!!!!!", 120 , 180);
				 
			 }
			 else {
				 g.setColor(Color.red);
				 g2.drawString("Vous avez Perdu !!!!!!", 120 , 180);
				 
				 
			 }
		 }
		 
	 }
	 
	 public void deplacementFond() {
		 
		 if (xPos >= 0 && xPos <= 4430)
		 {
			 xPos = xPos + dx;
			 xFond1 = xFond1 - dx;
			 xFond2 = xFond2 - dx;
		 }

		 // on regle le vide a gauche 
		 if(this.xFond1 == -800)
		 {
			 xFond1 = 800 ;
		 }
		 else if(xFond2 == -800)
		 {
			 xFond2 = 800 ;
		 }
		 
		// on regle le vide a droite
		 else if(xFond1 == 800)
		 {
			 xFond1 = -800 ;
		 }
		 else if(xFond2 == 800)
		 {
			 xFond2 = -800 ;
		 }
	 }

	
	 public boolean partieGagnee() {
		 if(temps.getCompteurTemps() > 0 && mario.isVivant() && score.getNbrePieces() == score.getTOTAL_PIECE() && xPos > 4400) {
			 if (gagne == false)
			 {
				 Audio.playSound("/audio/partieGagnee.wav");
				 gagne = true ;
			 }
			 return true;
		 }
		return false ;
	 }
	 
	 public boolean partiePerdu() {
		 if(temps.getCompteurTemps() <= 0 || !mario.isVivant())
			 return true;
		return false ;
	 }
	 public boolean finDePartie() {
		 if(this.partieGagnee() || this.partiePerdu())
			 return true ;
		return false ;
	 }
	 //+++++++ Getters++++++++//
	 
	public int getDx() {
		return dx;
	}
	 public int getxPos() {
		return xPos;
	}

	public int getySol() {
		return ySol;
	}

	public int getHautPlafont() {
		return hautPlafont;
	}

	//+++++++Setters++++++//
	
	public void setDx(int dx) {
		this.dx = dx;
	}
	
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	
	public void setxFond1(int xFond1){
		this.xFond1 = xFond1;
	}
	public void setxFond2(int xFond2){
		this.xFond2 = xFond2;
	}
	public void setySol(int ySol){
		this.ySol = ySol;
	}
	public void setHautPlafond(int hautPlafont){
		this.hautPlafont = hautPlafont;
	}
	 
}
