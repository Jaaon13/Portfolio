package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.swing.JFrame;

import display.display;
import display.snakeListener;
import snake.peice;
import snake.snake;

public class app {
	
	private static display dis = new display();
	private static app app1 = new app();
	
	private List<int[]> squares = new ArrayList<>();
	public snake player = new snake();
	
	private boolean appleExist = false;
	private int score = 0;

	public static void main(String[] args) {
		
		app1.loop();

	}
	public static display getDisplay() {
		return dis;
	}
	
	public static app getAppObj() {
		return app1;
	}
	
	private void loop() {
		
			drawSnake();
			
			generateApple();
			
			squares.add(new int[] {0, 0, 19*25, 10}); // edge square
			
			dis.dMain(squares);
		
	}
	
	private void drawSnake() {
		
		List<peice> peices = player.getPeices();
		
		if(Objects.nonNull(peices)) {
			
			for(int x = 0; x < peices.size(); x++) {
				
				int[] newPos = peices.get(x).getCord();
				
				squares.add(
						new int[] {newPos[0], newPos[1], 25, 2}
						);
				
			}
			
		}
		
		int[] pcord = player.getCord();
		
		squares.add(
				new int[] {pcord[0], pcord[1], 25, 1}
				);
		
	}
	
	public void moveSnake(int dir) {
		
		player.setDir(dir);
		
		int[] oldCord = player.getCord();
			
		int[] pCord = movePeice(player.getDir(), player.getCord());
			
		checkCollison(pCord, player.getDir());
		moveAllPeices(oldCord);
		
		player.setCord(pCord);
		
		updateSquares();
		
	}
	
	private void moveAllPeices(int[] oldCord) {
		
		List<peice> peices = player.getPeices();

		for(int x = peices.size()-1; x > -1; x--) {
			
			if( x == 0 ) {
				
				peices.get(0).setCord(peiceMove(player.getCord(), player.getDir()));
				peices.get(0).setDir(player.getDir());
				
			} else {
				
				peices.get(x).setCord(peices.get(x-1).getCord());
				peices.get(x).setDir(peices.get(x-1).getDir());
				
			}
			
		}
		
	}
	
	private int[] movePeice(int dir, int[] tCord) {
		
		int[] pCord = tCord;
		
		switch(dir) {
		
		case 1:
			if(pCord[0] > 24) {
				pCord[0] -= 25;
			} else {
				killSnake();
			}
			break;
				
		case 2:
			if(pCord[1] < 18*25) {
				pCord[1] += 25;
			} else {
				killSnake();
			}
			break;
				
		case 3:
			if(pCord[0] < 18*25) {
				pCord[0] += 25;
			} else {
				killSnake();
			}
			break;
				
		case 4:
			if(pCord[1] > 24) {
				pCord[1] -= 25;
			} else {
				killSnake();
			}
			break;
			
		}
		
		return pCord;
		
	}
	private void checkCollison(int[] pCord, int dir) {
		
		for(int x = 0; x < squares.size(); x++) {
			
			if(squares.get(x)[0] == pCord[0] && squares.get(x)[1] == pCord[1] && squares.get(x)[3] != 1) {
				
				switch(squares.get(x)[3]) {
				
					case 3: // Collided with the apple
						
						snakeGrow(dir);
						squares.remove(x);
						appleExist = false;
						generateApple();
						
						score++;
						System.out.println("\n" + score + "\n");
						
						break;
						
					case 2:
						killSnake();
						break;
				
				}
				
			}
			
		}
		
	}
	
	private void killSnake() {
		
		((snakeListener) dis.getKeyListener()).killSnake();
		
		app1 = new app();
		
		JFrame temp = dis.getFrame();
		temp.removeAll();
		temp.setVisible(false);
		
		dis = new display();
		
		dis.setFrame(temp);
		
		player = new snake();
		
		app1.loop();
		
	}
	
	private void snakeGrow(int dir) {
		
		if(player.getPeices().size() == 0) { // if its the first peice
			
			addPeice(player.getCord(), dir);
			
		} else {
			
			addPeice(player.getPeices().get(player.getPeices().size()-1).getCord(),
					player.getPeices().get(player.getPeices().size()-1).getDir());
			
		}
		
	}
	
	public boolean getIfSinglePeice() {
		
		if(player.getPeices().isEmpty()) {
			return true;
		} else {
			return false;
		}
			
	}
	
	private void addPeice(int[] oldPos, int dir) {
		
		int[] newPos = peiceMove(oldPos, dir);
		
		player.addPeice(newPos, dir);
		
	}
	
	private int[] peiceMove(int[] oldPos, int dir) {
		
		int[] newPos = {0,0};
		
		switch(dir) {
		case 1:
			newPos[0] = oldPos[0] + 25;
			newPos[1] = oldPos[1];
			break;
			
		case 2:
			newPos[0] = oldPos[0];
			newPos[1] = oldPos[1] - 25;
			break;
			
		case 3:
			newPos[0] = oldPos[0] - 25;
			newPos[1] = oldPos[1];
			break;
			
		case 4:
			newPos[0] = oldPos[0];
			newPos[1] = oldPos[1] + 25;
			break;
		
		}
		
		return newPos;
	}
	
	private void updateSquares() {
		
		for(int x = 0; x < squares.size(); x++) {
			
			if(squares.get(x)[3] == 3) { //find apple and save it
				
				int[] temp = squares.get(x);
				squares.removeAll(squares);
				
				drawSnake();
				squares.add(temp);
				
				squares.add(new int[] {0, 0, 19*25, 10}); // edge square
				
				break;
				
			}
			
		}
		
	}
	
	private void generateApple() { // Run last so it wont get drawn over
		
		int rX = (int)(Math.random() * 19);
		int rY = (int)(Math.random() * 19);
		
		int[] n = {rX * 25, rY * 25, 25, 3};
		
		int inc = 0;
		for(int x = 0; x < squares.size(); x++) {
			
			if(squares.get(x)[0] == n[0] && squares.get(x)[1] == n[1]) {
				inc++;
			}
			
		}
		
		if(inc == 0 && appleExist == false) {
			squares.add(n);
			appleExist = true;
		} else if (inc > 0) {
			generateApple();
		}
		
	}

	public List<int[]> getSquares() {
		return squares;
	}

}
