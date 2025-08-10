package display;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import app.app;

public class keyListener implements KeyListener {

	public int key = -1;
	
	/*
	 *  Code: 10 is Enter
	 *  
	 *  Code: 27 is Escape
	 * 
	 *  Codes: 65 and 37 is left
	 *  Codes: 83 and 40 is down
	 *  Codes: 68 and 39 is right
	 *  Codes: 87 and 38 is up
	 *  
	 *  Key Codes:
	 *  -2 is quit
	 *  -1 is null
	 *  0 is enter
	 *  1 is left
	 *  2 is down
	 *  3 is right
	 *  4 is up
	 */
	
	private void keyPress(int keyCode){
		
		switch(keyCode) {
		
		case 10:
			key = 0;
			app.getApp().getEvents().setNewStart();
			break;
		case 27:
			key = -2;
			break;
			
		case 65, 37:
			key = 1;
			break;
			
		case 83, 40:
			key = 2;
			break;
			
		case 68, 39:
			key = 3;
			break;
			
		case 87, 38:
			key = 4;
			break;
		
		}
		
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
