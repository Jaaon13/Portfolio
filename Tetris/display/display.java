package display;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

public class display {
	
	private final int frameSizeX = 840;
	private final int frameSizeY = 842;
	
	private JFrame frame;
	private keyListener kL;
	private tetrisPanel tP;

	public display() {
		
		frame = new JFrame("Tetris");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addPanel();
		
		frame.pack();
		
		frame.setSize(frameSizeX, frameSizeY);
		
		frame.setVisible(true);
		
	}
	
	private void addPanel() {
		
		tP = new tetrisPanel(null);
		
		kL = new keyListener();
		tP.addKeyListener(kL);
		
		tP.setBackground(Color.black);
		
		frame.add(tP);
		
		
	}
	
	public void updatePanel(List<int[]> squares, Map<char[], int[]> text) {
		
		tP.requestFocus();
		
		tP.updateText(text);
		tP.updateSquares(squares);
		
		tP.repaint();
		
	}
	
	public keyListener getKL() {
		return kL;
	}
	
}
