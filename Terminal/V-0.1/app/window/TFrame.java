package app.window;

import javax.swing.JFrame;

import app.window.terminal.TerminalManager;

@SuppressWarnings({ "serial" })
class TFrame extends JFrame {
	
	public TFrame(String title) {
		this.setTitle(title);
	}

	public void setKey(char k) {
		TerminalManager.addTerminalKey(k);
	}
	
}
