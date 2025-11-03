package app.window;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

@SuppressWarnings("serial")
class TPanel extends JPanel {
	
	private List<String> lines = new ArrayList<>();
	
	private int printLineOffset = 0;
	
	private final Color purple = new Color(139, 0, 255);

	public void draw(List<String> l) {
		lines = l;
		if(lines.size() > 64+printLineOffset) {
			printLineOffset++;
		}
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(purple);
		
		int y = 15;
		
		for(int x = printLineOffset; x < lines.size(); x++) {
			g.drawString(lines.get(x), 0, y);
			y += 15;
		}
		
	}
	
}
