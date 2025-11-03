package app.window;

class Generate {

	public static TFrame createFrame(String title, int xSize, int ySize) {
		
		TFrame frame = new TFrame(title);
		frame.setSize(xSize, ySize);
		frame.setDefaultCloseOperation(TFrame.EXIT_ON_CLOSE);
		
		return frame;
	}
	
	public static TKeyListener createTKeyListener() {
		return new TKeyListener();
	}

	
	
}
