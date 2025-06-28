package snake;

public class peice {
	
	private int[] cord;
	private int dir;
	
	public peice(int[] cord, int dir) {
		this.setCord(cord);
		this.setDir(dir);
	}

	public int[] getCord() {
		return cord;
	}

	public void setCord(int[] cord) {
		this.cord = cord;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}
	
}
