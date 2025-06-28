package display;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class snakePanel extends JPanel {
	
	private List<int[]> squares;
	
	public snakePanel(List<int[]> squares) {
		
		this.squares = squares;
		
	}
	
	public void updateSquares(List<int[]> squares) {
		this.squares = squares;
	}
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		for(int x = 0; x < squares.size(); x++) {
			
			drawSquare(g, squares.get(x), 0);
			
		}
		
	}
	
	private void drawSquare(Graphics g, int[] square, int z) {
		
		switch(square[3]) {
			
		case 1:
			g.setColor(Color.GREEN);
			break;
			
		case 2:
			g.setColor(Color.GREEN);
			break;
			
		case 3:
			g.setColor(Color.RED);
			break;
			
		case 10:
			g.setColor(Color.WHITE);
			break;
			
		default:
			g.setColor(Color.BLUE);
			break;
			
		}
		
		
		g.drawRect(square[0], square[1], square[2], square[2]);
		
	}
	
}
