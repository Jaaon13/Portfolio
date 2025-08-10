package piece.translocation;

import java.util.List;

import piece.tetris;

public class pieceRotation {
	
	
	public tetris rotatePiece(tetris t) {
		
		
		switch(t.getType()) {
		
		case 1:
			t = tPiece(t);
			break;
			
		case 2:
			t = jPiece(t);
			break;
			
		case 3: // square piece
			break;
			
		case 4:
			t = zPiece(t);
			break;
			
		case 5:
			t = sPiece(t);
			break;
			
		case 6:
			t = lPiece(t);
			break;
			
		case 7:
			t = linePiece(t);
			break;
		
		}
		
		
		return t;
		
	}

	private tetris linePiece(tetris t) {

		pieceMovement pM = new pieceMovement();
		List<int[]> cords;
		
		switch(t.getRotation()) {
		
		case 0:
			
			cords = t.getPieceCords();
			
			cords.get(0)[0] -= 80;
			cords.get(1)[0] -= 40;
			cords.get(3)[0] += 40;
			
			cords.get(0)[1] += 80;
			cords.get(1)[1] += 40;
			cords.get(3)[1] -= 40;
			
			if(!pM.collison(cords)) {
				t.setRotation(t.getRotation()+1);
			} else {
				
				cords.get(0)[0] += 80;
				cords.get(1)[0] += 40;
				cords.get(3)[0] -= 40;
				
				cords.get(0)[1] -= 80;
				cords.get(1)[1] -= 40;
				cords.get(3)[1] += 40;
				
			}
			
			break;
			
		case 1:
			
			cords = t.getPieceCords();
			
			cords.get(0)[0] += 80;
			cords.get(1)[0] += 40;
			cords.get(3)[0] -= 40;
			
			cords.get(0)[1] -= 80;
			cords.get(1)[1] -= 40;
			cords.get(3)[1] += 40;
			
			if(!pM.collison(cords)) {
				t.setRotation(0);
			} else {
				
				cords.get(0)[0] -= 80;
				cords.get(1)[0] -= 40;
				cords.get(3)[0] += 40;
				
				cords.get(0)[1] += 80;
				cords.get(1)[1] += 40;
				cords.get(3)[1] -= 40;
				
			}
			
			break;
		
		}
		
		return t;
	}

	private tetris lPiece(tetris t) {

		pieceMovement pM = new pieceMovement();
		List<int[]> cords;
		
		switch(t.getRotation()) {
		
		case 0:
			
			cords = t.getPieceCords();
			
			cords.get(0)[0] += 40;
			cords.get(0)[1] += 40;
			
			cords.get(2)[0] -= 40;
			cords.get(2)[1] -= 40;
			
			cords.get(3)[0] -= 80;
			
			if(!pM.collison(cords)) {
				t.setRotation(t.getRotation()+1);
			} else {
				
				cords.get(0)[0] -= 40;
				cords.get(0)[1] -= 40;
				
				cords.get(2)[0] += 40;
				cords.get(2)[1] += 40;
				
				cords.get(3)[0] += 80;
				
			}
			
			break;
			
		case 1:
			cords = t.getPieceCords();
			
			cords.get(0)[0] -= 40;
			cords.get(0)[1] += 40;
			
			cords.get(2)[0] += 40;
			cords.get(2)[1] -= 40;
			
			cords.get(3)[1] -= 80;
			
			if(!pM.collison(cords)) {
				t.setRotation(t.getRotation()+1);
			} else {
				
				cords.get(0)[0] += 40;
				cords.get(0)[1] -= 40;
				
				cords.get(2)[0] -= 40;
				cords.get(2)[1] += 40;
				
				cords.get(3)[1] += 80;
				
			}
			
			break;
			
		case 2:
			
			cords = t.getPieceCords();
			
			cords.get(0)[0] -= 40;
			cords.get(0)[1] -= 40;
			
			cords.get(2)[0] += 40;
			cords.get(2)[1] += 40;
			
			cords.get(3)[0] += 80;
			
			if(!pM.collison(cords)) {
				t.setRotation(t.getRotation()+1);
			} else {
				
				cords.get(0)[0] += 40;
				cords.get(0)[1] += 40;
				
				cords.get(2)[0] -= 40;
				cords.get(2)[1] -= 40;
				
				cords.get(3)[0] -= 80;
				
			}
			
			break;
			
		case 3:
			cords = t.getPieceCords();
			
			cords.get(0)[0] += 40;
			cords.get(0)[1] -= 40;
			
			cords.get(2)[0] -= 40;
			cords.get(2)[1] += 40;
			
			cords.get(3)[1] += 80;
			
			if(!pM.collison(cords)) {
				t.setRotation(0);
			} else {
				
				cords.get(0)[0] -= 40;
				cords.get(0)[1] += 40;
				
				cords.get(2)[0] += 40;
				cords.get(2)[1] -= 40;
				
				cords.get(3)[1] -= 80;
				
			}
			
			break;
			
		}
		
		return t;
	}
	
	private tetris sPiece(tetris t) {

		pieceMovement pM = new pieceMovement();
		List<int[]> cords;
		
		switch(t.getRotation()) { 
		
		case 0:
			
			cords = t.getPieceCords();
			
			cords.get(1)[1] += 40;
			
			cords.get(3)[0] += 80;
			cords.get(3)[1] += 40;
			
			if(!pM.collison(cords)) {
				t.setRotation(t.getRotation()+1);
			} else {
				
				cords.get(1)[1] -= 40;
				
				cords.get(3)[0] -= 80;
				cords.get(3)[1] -= 40;
				
			}
			
			break;
			
		case 1:
			
			cords = t.getPieceCords();
			
			cords.get(1)[1] -= 40;
			
			cords.get(3)[0] -= 80;
			cords.get(3)[1] -= 40;
			
			if(!pM.collison(cords)) {
				t.setRotation(0);
			} else {
				
				cords.get(1)[1] += 40;
				
				cords.get(3)[0] += 80;
				cords.get(3)[1] += 40;
				
			}
			
			break;
		
		}
		
		return t;
	}

	private tetris zPiece(tetris t) {

		pieceMovement pM = new pieceMovement();
		List<int[]> cords;
		
		switch(t.getRotation()) {
		
		case 0:
			
			cords = t.getPieceCords();
			
			cords.get(0)[0] += 80;
			
			cords.get(1)[0] += 40;
			cords.get(1)[1] += 40;
			
			cords.get(3)[0] -= 40;
			cords.get(3)[1] += 40;
			
			if(!pM.collison(cords)) {
				t.setRotation(t.getRotation()+1);
			} else {
				
				cords.get(0)[0] -= 80;
				
				cords.get(1)[0] -= 40;
				cords.get(1)[1] -= 40;
				
				cords.get(3)[0] += 40;
				cords.get(3)[1] -= 40;
				
			}
			
			break;
			
		case 1:
			
			cords = t.getPieceCords();
			
			cords.get(0)[0] -= 80;
			
			cords.get(1)[0] -= 40;
			cords.get(1)[1] -= 40;
			
			cords.get(3)[0] += 40;
			cords.get(3)[1] -= 40;
			
			if(!pM.collison(cords)) {
				t.setRotation(0);
			} else {
				
				cords.get(0)[0] += 80;
				
				cords.get(1)[0] += 40;
				cords.get(1)[1] += 40;
				
				cords.get(3)[0] -= 40;
				cords.get(3)[1] += 40;
				
			}
			
			break;
		
		}
		
		
		return t;
	}

	private tetris jPiece(tetris t) {
		
		pieceMovement pM = new pieceMovement();
		List<int[]> cords;
		
		switch(t.getRotation()) {
		
		case 0: 
			
			cords = t.getPieceCords();
			
			cords.get(0)[0] += 40;
			cords.get(0)[1] += 40;
			
			cords.get(2)[0] -= 40;
			cords.get(2)[1] -= 40;
			
			cords.get(3)[1] -= 80;
			
			if(!pM.collison(cords)) {
				t.setRotation(t.getRotation()+1);
			} else {
				
				cords.get(0)[0] -= 40;
				cords.get(0)[1] -= 40;
				
				cords.get(2)[0] += 40;
				cords.get(2)[1] += 40;
				
				cords.get(3)[1] += 80;
				
			}
			
			break;
			
		case 1:
			
			cords = t.getPieceCords();
			
			cords.get(0)[0] -= 40;
			cords.get(0)[1] += 40;
			
			cords.get(2)[0] += 40;
			cords.get(2)[1] -= 40;
			
			cords.get(3)[0] += 80;
			
			if(!pM.collison(cords)) {
				t.setRotation(t.getRotation()+1);
			} else {
				
				cords.get(0)[0] += 40;
				cords.get(0)[1] -= 40;
				
				cords.get(2)[0] -= 40;
				cords.get(2)[1] += 40;
				
				cords.get(3)[0] -= 80;
				
			}
			
			break;
			
		case 2:
			
			cords = t.getPieceCords();
			
			cords.get(0)[0] -= 40;
			cords.get(0)[1] -= 40;
			
			cords.get(2)[0] += 40;
			cords.get(2)[1] += 40;
			
			cords.get(3)[1] += 80;
			
			if(!pM.collison(cords)) {
				t.setRotation(t.getRotation()+1);
			} else {
			
				cords.get(0)[0] += 40;
				cords.get(0)[1] += 40;
				
				cords.get(2)[0] -= 40;
				cords.get(2)[1] -= 40;
				
				cords.get(3)[1] -= 80;
				
			}
			
			break;
			
		case 3:
			
			cords = t.getPieceCords();
			
			cords.get(0)[0] += 40;
			cords.get(0)[1] -= 40;
			
			cords.get(2)[0] -= 40;
			cords.get(2)[1] += 40;
			
			cords.get(3)[0] -= 80;
			
			if(!pM.collison(cords)) {
				t.setRotation(0);
			} else {
			
				cords.get(0)[0] -= 40;
				cords.get(0)[1] += 40;
				
				cords.get(2)[0] += 40;
				cords.get(2)[1] -= 40;
				
				cords.get(3)[0] += 80;
				
			}
			
			break;
			
		}
		
			
		
		return t;
	}

	private tetris tPiece(tetris t) {
		
		pieceMovement pM = new pieceMovement();
		List<int[]> cords;
		
		switch(t.getRotation()) {
		
		case 0:
			
			cords = t.getPieceCords();
			
			cords.get(1)[0] += 40;
			cords.get(1)[1] += 40;
			
			if(!pM.collison(cords)) {
				
				t.setRotation(t.getRotation()+1);
				
			} else {
				
				cords.get(1)[0] -= 40;
				cords.get(1)[1] -= 40;
				
			}
			
			break;
			
		case 1 :
			
			cords = t.getPieceCords();
			
			cords.get(0)[1] += 80;
			
			cords.get(1)[0] -= 40;
			cords.get(1)[1] -= 40;
			
			if(!pM.collison(cords)) {
				
				t.setRotation(t.getRotation()+1);
				
			} else {
				
				cords.get(0)[1] -= 80;
				
				cords.get(1)[0] += 40;
				cords.get(1)[1] += 40;
				
			}
			
			break;
			
		case 2:
			
			cords = t.getPieceCords();
			
			cords.get(0)[1] -= 80;
			
			cords.get(3)[0] -= 40;
			cords.get(3)[1] += 40;
			
			if(!pM.collison(cords)) {
				
				t.setRotation(t.getRotation()+1);
				
			} else {
				
				cords.get(0)[1] += 80;
				
				cords.get(3)[0] += 40;
				cords.get(3)[1] -= 40;
				
			}
			
			break;
			
		case 3:
			
			cords = t.getPieceCords();
			
			cords.get(3)[0] += 40;
			cords.get(3)[1] -= 40;
			
			if(!pM.collison(cords)) {
				
				t.setRotation(0);
				
			} else {
				
				cords.get(3)[0] -= 40;
				cords.get(3)[1] += 40;
				
			}
			
			break;
			
		}
		
		return t;
	}
	
}
