package piece;

import java.util.ArrayList;
import java.util.List;

import app.app;

public class pieceLayout {
	
	int xOffSet = app.getApp().xOffSet;
	
	public tetris tPiece() {

		List<int[]> temp = new ArrayList<>();
		
		temp.add(new int[] {xOffSet + (40 * 5), 0});
		temp.add(new int[] {xOffSet + (40 * 4), 40});
		temp.add(new int[] {xOffSet + (40 * 5), 40});
		temp.add(new int[] {xOffSet + (40 * 6), 40});
		
		return new tetris(temp, 8, 1);
	}

	public tetris jPiece() {

		List<int[]> temp = new ArrayList<>();
		
		temp.add(new int[] {xOffSet + (40 * 5), 0});
		temp.add(new int[] {xOffSet + (40 * 5), 40});
		temp.add(new int[] {xOffSet + (40 * 5), 80});
		temp.add(new int[] {xOffSet + (40 * 4), 80});
		
		return new tetris(temp, 7, 2);
	}

	public tetris squarePiece() {

		List<int[]> temp = new ArrayList<>();
		
		temp.add(new int[] {xOffSet + (40 * 4), 0});
		temp.add(new int[] {xOffSet + (40 * 5), 0});
		temp.add(new int[] {xOffSet + (40 * 4), 40});
		temp.add(new int[] {xOffSet + (40 * 5), 40});
		
		return new tetris(temp, 6, 3);
	}

	public tetris zPiece() {
		
		List<int[]> temp = new ArrayList<>();
		
		temp.add(new int[] {xOffSet + (40 * 4), 0});
		temp.add(new int[] {xOffSet + (40 * 5), 0});
		temp.add(new int[] {xOffSet + (40 * 5), 40});
		temp.add(new int[] {xOffSet + (40 * 6), 40});
		
		return new tetris(temp, 5, 4);
	}

	public tetris sPiece() {
		
		List<int[]> temp = new ArrayList<>();
		
		temp.add(new int[] {xOffSet + (40 * 5), 0});
		temp.add(new int[] {xOffSet + (40 * 6), 0});
		temp.add(new int[] {xOffSet + (40 * 5), 40});
		temp.add(new int[] {xOffSet + (40 * 4), 40});
		
		return new tetris(temp, 4, 5);
	}

	public tetris lPiece() {
		
		List<int[]> temp = new ArrayList<>();
		
		temp.add(new int[] {xOffSet + (40 * 4), 0});
		temp.add(new int[] {xOffSet + (40 * 4), 40});
		temp.add(new int[] {xOffSet + (40 * 4), 80});
		temp.add(new int[] {xOffSet + (40 * 5), 80});
		
		return new tetris(temp, 3, 6);
	}

	public tetris linePiece() {
		
		List<int[]> temp = new ArrayList<>();
		
		temp.add(new int[] {xOffSet + (40 * 5), 0});
		temp.add(new int[] {xOffSet + (40 * 5), 40});
		temp.add(new int[] {xOffSet + (40 * 5), 80});
		temp.add(new int[] {xOffSet + (40 * 5), 120});
		
		return new tetris(temp, 2, 7);
		
	}
	
}
