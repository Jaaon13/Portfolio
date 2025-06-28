package app;

import display.display;

public class gameLoop {
	
	public boolean running = false;

	public Thread game = new Thread(new Runnable() {

		public void run() {
			
			running = true;
			
			app App = app.getAppObj();
			display dis = app.getDisplay();
			
			while(running) {
				
				try {
					
					Thread.sleep(125);
					
					App.moveSnake(dis.dir);
					dis.updateFrame(App);
					
				} catch (InterruptedException e) {
					System.out.println(e);
				}
				
			}
			
		}
	
	});
	
}
