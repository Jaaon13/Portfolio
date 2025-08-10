package piece.translocation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import piece.pieceLayout;
import piece.tetris;

public class pieceMovement {
	
	private tetris currentPiece;
	private tetris tempTetris;
	
	private int ran2;
	
	private int score = 0;
	
	private boolean pieceExists = false;
	
	private List<int[]> squares = new ArrayList<>();
	
	public void reset() {
		
		currentPiece = null;
		tempTetris = null;
		ran2 = 0;
		score = 0;
		pieceExists = false;
		squares = new ArrayList<>();
		
	}
	
	public boolean lose() {
		boolean lost = false;
		
		for(int[] c : squares) {
			
			if(c[1] < 160) {
				lost = true;
			}
			
		}
		
		return lost;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int s) {
		
		score = s;
		
	}
	
	private void calculateScore(int linesCleared) {
		
		float calc = linesCleared * 10;
		calc *= (float) (10 + app.app.getApp().level) / (11 - linesCleared);
		
		score += calc;
		
	}
	
	public void clearLines() {
			
		int linesCleared = 0;
		int y = 0;
			
		for(int z = 0; z < 60; z++) {
				
			int inc = 0;
				
			for(int w = 0; w < squares.size(); w++) {
					
				int[] c = squares.get(w);
					
				if(c[1] == y) {
					inc++;
				}
					
			}
				
			if(inc > 9) {
					
				for(int w = squares.size()-1; w > -1; w--) {
						
					if(squares.get(w)[1] == y) {
						
						squares.remove(w);
						
					} else if(squares.get(w)[1] < y) {
						squares.get(w)[1] += 40;
					}
						
				}
				
				linesCleared++;
					
			}
				
			y += 40;
				
		}
		
		if(linesCleared > 0) {calculateScore(linesCleared);}
		
	}
	
	public List<int[]> getAllSquares() {
		
		List<int[]> temp = new ArrayList<>();
		
		if(Objects.nonNull(currentPiece)) {
			for(int[] c : currentPiece.getPieceCords()) {
				int[] c2 = {c[0], c[1], currentPiece.getColor()};
				temp.add(c2);
			}
		}
		
		if(Objects.nonNull(tempTetris)) {
			for(int[] c : tempTetris.getPieceCords()) {
				int[] c2 = {c[0], c[1], tempTetris.getColor()};
				temp.add(c2);
			}
		}
		
		temp.addAll(squares);
		
		return temp;
		
	}
	
	public void moveTetris(char c) {
		
		if(Objects.nonNull(currentPiece)) {
			
			List<int[]> tcord;
			
			switch (c) {
			
			case 'u':
				
				pieceRotation pr = new pieceRotation();
				currentPiece = pr.rotatePiece(currentPiece);
				
				break;
			
			case 'l':
				
				tcord = currentPiece.getPieceCords();
				
				int left = 0;
				for(int x = 0; x < 4; x++) {
					
					if(x == 0) {
						left = tcord.get(0)[0];
					} else {
						
						if(tcord.get(x)[0] < left) {
							left = tcord.get(x)[0];
						}
						
					}
					
				}
				
				for(int x = 0; x < 4; x++) {
					
					tcord.get(x)[0] -= 40;
					
				}
				
				if(collison(tcord)) {
					
					for(int x = 0; x < 4; x++) {
						tcord.get(x)[0] += 40;
					}
					
				}
				
				currentPiece.setPieceCords(tcord);
				
				break;
				
			case 'r':
				
				tcord = currentPiece.getPieceCords();
				
				int right = 0;
				for(int x = 0; x < 4; x++) {
					
					if(x == 0) {
						right = tcord.get(0)[0];
					} else {
						
						if(tcord.get(x)[0] > right) {
							right = tcord.get(x)[0];
						}
						
					}
					
				}
				
				for(int x = 0; x < 4; x++) {
					
					tcord.get(x)[0] += 40;
					
				}
				
				if(collison(tcord)) {
					
					for(int x = 0; x < 4; x++) {
						tcord.get(x)[0] -= 40;
					}
					
				}
				
				currentPiece.setPieceCords(tcord);
				
				break;
				
			case 'd':
				
				tcord = currentPiece.getPieceCords();
					
				for(int x = 0; x < 4; x++) {
						
					tcord.get(x)[1] += 40;
						
				}
				
				if(collison(tcord)) {
					
					pieceExists = false;
					
					for(int x = 0; x < 4; x++) {
						tcord.get(x)[1] -= 40;
					}
					
				}
				
				currentPiece.setPieceCords(tcord);
				
				break;
			
			}
			
		}
		
	}
	
	public boolean collison(List<int[]> cord) {
		
		boolean collison = false;
		
		for(int[] t : cord) {
			
			// checks if collided with the boundries of the board
			if(t[1] > 780 || t[0] > 560 || t[0] < 200) { 
				collison = true;
				break;
			}
			
			for(int x = 0; x < squares.size(); x++) {
					
				int[] c = squares.get(x);
				
				for(int[] cp : cord) {
						
					if(c[0] == cp[0] && c[1] == cp[1]) {
						collison = true;
					}
						
				}
					
			}
			
		}
		
		return collison;
		
	}
	
	public void genPiece() {
		
		if(Objects.nonNull(currentPiece)) {
			for(int[] cord : currentPiece.getPieceCords()) {
				int[] c2 = {cord[0], cord[1], currentPiece.getColor()};
				squares.add(c2);
			}
		}
		
		tetris t;
		
		int ran1;
		if(ran2 != 0) {
			
			ran1 = ran2;
			
		} else {
			
			ran1 = (int)(Math.random() * 7);
			ran1++;
			
		}
		
		ran2 = (int)(Math.random() * 7);
		ran2++;
		
		t = switchTetris(ran1);
		
		addNextPeice(switchTetris(ran2));
	
		currentPiece = null;
		currentPiece = t;
		
		pieceExists = true;
		
	}
	
	private void addNextPeice(tetris t) {
		
		List<int[]> temp = t.getPieceCords();
		
		for(int x = 0; x < 4; x++) {
			
			temp.get(x)[0] += 300;
			temp.get(x)[1] += 40;
			
		}
		
		t.setPieceCords(temp);
		
		tempTetris = t;
		
	}
	
	private tetris switchTetris(int ran) {
		pieceLayout pl = new pieceLayout();
		
		switch(ran) {
		
		case 1:
			return pl.linePiece();
			
		case 2:
			return pl.lPiece();
			
		case 3:
			return pl.sPiece();
			
		case 4:
			return pl.zPiece();
			
		case 5:
			return pl.squarePiece();
			
		case 6:
			return pl.jPiece();
			
		case 7:
			return pl.tPiece();
			
		default:
			System.out.println("Failed Generation | num: " + ran);
			return null;
			
		}
	}

	public boolean getPieceExists() {
		return pieceExists;
	}
	
}
