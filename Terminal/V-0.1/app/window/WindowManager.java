package app.window;

public class WindowManager {

	private static Window w;
	
	public static void createWindow(String title, int xSize, int ySize) {
		w = new Window(title, xSize, ySize);
	}
	
	public static void updateWindow() {
		w.update();
	}
	
}
