package piece;

import java.util.List;

public class tetris {
	
	private List<int[]> pieceCords;
	private int color;
	private int type;
	private int rotation;
	
	public tetris(List<int[]> cords, int color, int type) {
		this.setPieceCords(cords);
		this.setColor(color);
		this.setType(type);
		this.setRotation(0);
	}

	private void setType(int type) {
		this.type = type;
	}

	public List<int[]> getPieceCords() {
		return pieceCords;
	}

	public void setPieceCords(List<int[]> pieceCords) {
		this.pieceCords = pieceCords;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getType() {
		return type;
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}
	
}
