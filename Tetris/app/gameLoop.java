package app;

public class gameLoop implements Runnable {
		
		private int inc;
	
		public void run() {
			
			inc = 0;
			app.getApp().threadAlive = true;
			
			while(!Thread.currentThread().isInterrupted()) {
				
				try {
					
					loop();
					
				} catch (InterruptedException e) {
					
					Thread.currentThread().interrupt();
					break;
					
				}

			}
			
			app.getApp().threadAlive = false;
			
		}
		
		private void loop() throws InterruptedException {
			
			int key = app.getApp().getDisplay().getKL().key;
			
			if(key != -2) {
			
				if(!app.getApp().getPieceExists()) {
				
					app.getApp().genPiece();
					
				}
				
				if(inc == 18) {
					inc = 0;
					switchCases(2);
				}
				
				inc++;
				
				switchCases(key);
			
				app.getApp().drawDisplay();
				
				app.getApp().getDisplay().getKL().key = -1;
				
				Thread.sleep(app.getApp().getGameSpeed()/6);
				
			} else {
				
				Thread.currentThread().interrupt();
				
			}
			
		}

		private void switchCases(int key) {
			
			switch(key) {
			
			case 1:
				app.getApp().moveTetris('l');
				break;
				
			case 2:
				app.getApp().moveTetris('d');
				break;
				
			case 3:
				app.getApp().moveTetris('r');
				break;
				
			case 4:
				app.getApp().moveTetris('u');
				break;
			
			}
			
		}
	
}
