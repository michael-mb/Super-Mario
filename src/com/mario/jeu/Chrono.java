package com.mario.jeu;

public class Chrono implements Runnable{

	private final int PAUSE = 3; // temps entre 2 tours de boucle
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			
			Main.f.scene.repaint();
			try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
