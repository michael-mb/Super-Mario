package com.mario.affichage;

public class CompteARebours implements Runnable{

	private final int PAUSE = 1000 ;
	private int compteurTemps ;
	private String str;
	private boolean isRunning ;
	public CompteARebours() {
		
		this.compteurTemps = 120 ;
		this.str ="Temps restant : 100";
		this.isRunning = true ;
		Thread compteARebours = new Thread(this);
		compteARebours.start();
	}
	public int getPAUSE() {
		return PAUSE;
	}
	public int getCompteurTemps() {
		return compteurTemps;
	}
	public String getStr() {
		return str;
	}
	public void setCompteurTemps(int compteurTemps) {
		this.compteurTemps = compteurTemps;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public void setIsRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning) {
			try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			compteurTemps -- ;
			str = "Temps restant : " + compteurTemps ;
		}
	}

}
