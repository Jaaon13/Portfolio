package app.window;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class TKeyListener implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

		TFrame f = (TFrame) e.getSource();
		if(e.getKeyCode() != KeyEvent.VK_SHIFT)
			f.setKey(e.getKeyChar());
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
