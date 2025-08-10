package event;

import java.util.Objects;

import app.app;

public class eventListener {
	
	private event currentEvent = null;
	
	private app ap;
	
	public void setApp(app ap2) {
		
		ap = ap2;
		
	}
	
	public void start() {
		
		try {
			waitLoop();
		} catch (InterruptedException e) {}
		
	}
	
	private void waitLoop() throws InterruptedException {
		
		while(true) {
			
			Thread.sleep(1000/100);
			
			if(Objects.nonNull(currentEvent)) {
				
				execUpdate();
				
			}
			
		}
		
	}
	
	private void execUpdate() {

		if(currentEvent.isKillThread()) {
			
			waitForEnterKey();
			
			ap.killThread();
			
		}
		
		if(currentEvent.isMakeThread()) {
			
			ap.createThread();
			
		}
		
		if(currentEvent.isReset()) {
			
			ap.resetAll();
			
		}
		
		currentEvent = null;
		
	}
	
	private boolean newStart;

	private void waitForEnterKey() {
		
		newStart = false;
		
		while(!newStart) {
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void setNewStart() {
		
		newStart = true;
		
	}

	public void update(event e) {
		
		this.currentEvent = e;
		
	}
	
}
