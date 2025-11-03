package app.window;

import java.awt.Color;

import app.window.terminal.TerminalManager;

class Window {
	
	private TFrame frame;
	private TPanel panel = new TPanel();
	private TKeyListener kl;

	Window(String title, int xSize, int ySize) {
		createFrame(title, xSize, ySize);
	}
	
	private void createFrame(String title, int xSize, int ySize) {
		
		frame = Generate.createFrame(title, xSize, ySize);
		
		createKeyListener();
		
		frame.requestFocus();
		frame.setBackground(Color.BLACK);
		
		panel.setBackground(Color.black);
		frame.add(panel);
		
		frame.setVisible(true);
		
	}

	private void createKeyListener() {
		
		kl = Generate.createTKeyListener();
		frame.addKeyListener(kl);
		
	}
	
	void update() {
		panel.draw(TerminalManager.getLines());
		panel.repaint();
	}
	
}
