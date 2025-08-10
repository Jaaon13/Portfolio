package display;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class tetrisPanel extends JPanel  {
	
	private List<int[]> squares;
	
	/*
	 * square format:
	 * x, y, width, height, color
	 */
	
	private Map<char[], int[]> text;
	
	/*
	 *  the char array is the text and the int array is the coordinates
	 */
	
	public tetrisPanel(List<int[]> squares) {
		
		this.squares = squares;
		
	}
	
	public void updateSquares(List<int[]> squares) {
		this.squares = squares;
	}

	public void updateText(Map<char[], int[]> text) {
		this.text = text;
	}
	
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.setFont(new Font("Impact", Font.PLAIN, 30));
		
		draw(g);
		
	}
	
	private void draw(Graphics g) {
		if(Objects.nonNull(squares) && Objects.nonNull(text)) {
			
			for(int x = 0; x < squares.size(); x++) {
				
				drawSquare(g, squares.get(x), 0);
				
			}
			
			drawText(g, text);
			
		}
	}
	
	private void drawText(Graphics g, Map<char[], int[]> text) {
		
		g.setColor(Color.WHITE);
		
		for(char[] string : text.keySet()) {
			
			int[] xy = text.get(string);
			
			g.drawChars(string, 0, string.length, xy[0], xy[1]);
			
		}
		
	}
	
	private void drawSquare(Graphics g, int[] square, int z) {
		
		switch(square[4]) {
			
		case 1:
			g.setColor(Color.GRAY);
			break;
			
		case 2: // line piece
			g.setColor(Color.RED);
			break;
			
		case 3: // L piece
			Color c = new Color(118, 5, 255);
			g.setColor(c);
			break;
			
		case 4: // S piece
			g.setColor(Color.GREEN);
			break;
			
		case 5: // Z piece
			g.setColor(Color.CYAN);
			break;
			
		case 6: // Square piece
			g.setColor(Color.BLUE);
			break;
			
		case 7: // J piece
			g.setColor(Color.WHITE);
			break;
			
		case 8: // T piece
			g.setColor(Color.ORANGE);
			break;
			
		default:
			g.setColor(Color.WHITE);
			break;
			
		}
		
		if(g.getColor() != Color.GRAY) {
			g.fillRect(square[0], square[1], square[2], square[3]);
		} else {
			g.drawRect(square[0], square[1], square[2], square[3]);
		}
		
	}
	
}
