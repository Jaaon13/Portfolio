package display;

import java.awt.Color;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Objects;

import javax.swing.JFrame;

import app.app;

public class display{
	
	private app ap;
	
	private final String frameName = "Snake";
	private final int frameSize = (21*25)-8; // Square Screen
	
	public int dir;
	
	private KeyListener sL;
	
	JFrame frame;
	snakePanel Sp;
	
	public void dMain(List<int[]> squares) {
		
		Sp = new snakePanel(squares);
		Sp.setBackground(Color.black);
		
		if(Objects.isNull(frame)) {
			createFrame(true);
		} else if (!frame.isVisible()) {
			createFrame(false);
		}
		
	}
	
	public void updateFrame(app ap2) {
		
		ap = ap2;
		
		Sp.requestFocus();
		
		if(Objects.nonNull(ap)) {
			
			Sp.updateSquares(ap.getSquares());
			
		}
		
		Sp.repaint();
		
	}

	private void createFrame(boolean makeNewFrame) {
		
		frame = new JFrame(frameName);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(frameSize-25, frameSize);
		
		frame.setVisible(true);
		
		sL = new snakeListener();
		Sp.addKeyListener(sL);
		
		frame.add(Sp);
		
		updateFrame(null);
		
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void setFrame(JFrame j) {
		this.frame = j;
	}
	
	public KeyListener getKeyListener() {
		return sL;
	}

	public boolean getIfSinglePeice() {
		return ap.getIfSinglePeice();
	}
	
}
