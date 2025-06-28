package snake;

import java.util.List;
import java.util.ArrayList;

public class snake {
	
	private int size;
	private int[] cord;
	private int dir;
	
	private List<peice> peices = new ArrayList<>(); // Should be all peices excluding the head peice
	
	public snake() {
		this.size = 1;
		this.cord = new int[] {9 * 25, 9 * 25};
	}
	
	public int getSize() {
		return size;
	}
	
	private void incSize() {
		this.size++;
	}
	
	public int[] getCord() {
		return cord;
	}
	
	public void setCord(int[] newCord) {
		this.cord = newCord;
	}

	public List<peice> getPeices() {
		return peices;
	}
	
	public void addPeice(int[] cord2, int dir) {
		incSize();
		peice np = new peice(cord2, dir);
		peices.add(np);
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}
	
}
