package lyskal.module8.rectangle;

public class Point {
	private int x;
	private int y;
	
	Point () {
		this(0, 0);
	}
	
	Point(final int x, final int y) {
		this.setX(x);
		this.setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(final int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(final int y) {
		this.y = y;
	}
}
