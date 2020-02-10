package com.mario.affichage;

public class Score {

	private final int TOTAL_PIECE = 10;
	private int nbrePieces ;
	
	public Score() {
		this.nbrePieces = 0 ;
		
	}

	public int getTOTAL_PIECE() {
		return TOTAL_PIECE;
	}

	public int getNbrePieces() {
		return nbrePieces;
	}

	public void setNbrePieces(int nbrePieces) {
		this.nbrePieces = nbrePieces;
	}
}
