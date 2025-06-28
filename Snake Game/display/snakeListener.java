package display;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import app.app;
import app.gameLoop;

public class snakeListener implements KeyListener {
	
	private gameLoop gl = new gameLoop();
	
	/*
	 *  Code: 10 is Enter
	 * 
	 *  Codes: 65 and 37 is left
	 *  Codes: 83 and 40 is down
	 *  Codes: 68 and 39 is right
	 *  Codes: 87 and 38 is up
	 */
	
	public void keyPress(int key) {
		
		display d = app.getDisplay();
		
		// dir:  0 is null, 1 is left, 2 is down, 3 is right, 4 is up
		
		switch(key) {
		
		case 10: // Start
			d.dir = 3;
			
			if(gl.running == false) {
				gl.game.start();
			}
			
			break;
			
		case 27: // Stop
			d.getFrame().dispatchEvent(new WindowEvent(d.getFrame(), WindowEvent.WINDOW_CLOSING));
			break;
		
		case 65, 37:
			if(d.dir != 3 && d.getIfSinglePeice() != true) {
				d.dir = 1;
			} else if (d.getIfSinglePeice()) {
				d.dir = 1;
			}
			break;
			
		case 83, 40:
			if(d.dir != 4 && d.getIfSinglePeice() != true) {
				d.dir = 2;
			} else if (d.getIfSinglePeice()) {
				d.dir = 2;
			}
			break;
			
		case 68, 39:
			if(d.dir != 1 && d.getIfSinglePeice() != true) {
				d.dir = 3;
			} else if (d.getIfSinglePeice()) {
				d.dir = 3;
			}
			break;
			
		case 87, 38:
			if(d.dir != 2 && d.getIfSinglePeice() != true) {
				d.dir = 4;
			} else if (d.getIfSinglePeice()) {
				d.dir = 4;
			}
			break;
			
			
			default:
				d.dir = 0;
				break;
		
		}
		
	}
	
	public void killSnake() {
		gl.game.interrupt();
		gl.running = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	
	public void keyPressed(KeyEvent e) { 
		
		keyPress(e.getKeyCode());
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
