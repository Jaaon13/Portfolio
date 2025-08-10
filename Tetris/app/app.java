package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.fileSystem.ReadWriteFile;
import app.fileSystem.createFile;
import display.display;
import event.event;
import event.eventListener;
import piece.translocation.pieceMovement;

public class app {
	
	private eventListener events = new eventListener();
	
	private Thread tetrisLoop;
	
	private display dis = new display();
	private static app ap = new app();
	private pieceMovement pM = new pieceMovement();
	
	public boolean threadAlive = false;
	
	public final int xOffSet = 200;
	private final int gameSpeed = 310;
	
	private Map<char[], int[]> text = new HashMap<>();
	private List<int[]> squares = new ArrayList<>();
	private List<int[]> tetrisPieces = new ArrayList<>();
	
	public int level = 1;
	private int highScore;
	
	public static void main(String[] args) {
		
		ap.fileInt();
		
		ap.drawDisplay();
		
		ap.events.setApp(ap);
		ap.events.update(new event(true, false, false));
		ap.events.start();
	
	}
	
	private void fileInt() {
		
		if(new createFile().findFile()) {
			
			highScore = new ReadWriteFile().readFile();
			
		}
		
	}
	
	private void updateHighScore() {
		
		int newi = pM.getScore() + ((level * 1000) - 1000);
		
		if(newi > highScore) {
		
			new ReadWriteFile().writeFile(newi);
			
		}
		
	}
	
	public void createThread() {
		
		ap.tetrisLoop = new Thread(new gameLoop());
		
		ap.tetrisLoop.start();
		
	}
	
	public void killThread() {
		
		ap.tetrisLoop.interrupt();
		
	}
	
	public void resetAll() {
		
		reset();
		pM.reset();
		
	}
	
	private void reset() {
		
		ap.fileInt();
		
		text = new HashMap<>();
		squares = new ArrayList<>();
		tetrisPieces = new ArrayList<>();
		level = 1;
		
	}
	
	public static app getApp() {
		return ap;
	}
	
	public display getDisplay() {
		return dis;
	}
	
	public int getGameSpeed() {
		return gameSpeed - (level * 10);
	}
	
	public void drawDisplay() {
		
		if(!lose()) {
		
			squares = new ArrayList<>();
			
			intText();
	
			background();
		
			pM.clearLines();
		
			drawPieces();
		
			dis.updatePanel(squares, text);
			
		}
		
	}
	
	private void intText() {
		
		text = new HashMap<>();
		
		if(pM.getScore() > 1000) {
			
			level++;
			pM.setScore(pM.getScore() - 1000);
			
		}
		
		String temp = "Score: " + (pM.getScore() + ((level * 1000) - 1000));
		text.put(temp.toCharArray(), new int[] {0, 200});
		temp = "Level: " + level;
		text.put(temp.toCharArray(), new int[] {0, 100});
		temp = "High Score: " + highScore;
		text.put(temp.toCharArray(), new int[] {0, 300});
		
	}
	
	private boolean lose() {
		if(pM.lose()) {
			
			
			
			String temp = "LOST";
			text.put(temp.toCharArray(), new int[] {375, 50});
			temp = "'Enter' To Restart";
			text.put(temp.toCharArray(), new int[] {300, 100});
			
			dis.updatePanel(squares, text);
			
			updateHighScore();
			
			events.update(new event(true, true, true));
			
			return true;
			
		} else {
			return false;
		}
	}
	
	public List<int[]> getSquares() {
		return squares;
	}

	public boolean getPieceExists() {
		
		return pM.getPieceExists();
		
	}
	
	public void moveTetris(char c) {
		
		pM.moveTetris(c);
		
	}
	
	
	public void genPiece() {
		
		pM.genPiece();
		
	}

	public void drawPieces() {
		
		tetrisPieces = pM.getAllSquares();
		
		if(tetrisPieces.size() > 1) {
			for(int z = 0; z < tetrisPieces.size(); z++) {
			
				
				int[] c = tetrisPieces.get(z);
				
				squares.add(new int[] {c[0]+1, c[1]+1, 38, 38, c[2]});
				
			
			}
		}
			
	}

	private void background() {
		
		squares.add(new int[] {640, 40, 160, 160, 1}); // Next Piece Square
		
		for(int y = 0; y < 20; y++) {
			
			for(int x = 0; x < 10; x++) {
				
				int[] temp = new int[] {xOffSet + (x*40),0 + (y*40),40,40,1};
				
				squares.add(temp);
				
			}
			
		}
		
	}

	public eventListener getEvents() {
		return events;
	}
	
}
