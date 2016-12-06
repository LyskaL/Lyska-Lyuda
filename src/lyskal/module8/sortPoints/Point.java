package lyskal.module8.sortPoints;

public class Point {
	private String name;
	private int x;
	private int y;
	

	public Point() {
		name = "";
		x = 0;
		y = 0;
	}

	public Point(final String name, final int x, final int y) {
		setName(name);
		setX(x);
		setY(y);
	}
	
	public void setName(final String name) {
		this.name = name;
	}

	public void setX(final int x) {
		this.x = x;
	}

	public void setY(final int y) {
		this.y = y;
	}
	
	/*
	 * Формула для нахождения расстояние от точки до начала координат: 
	 * D = sqrt(x^2 + y^2)
	 */
	public int getDistance () {
		return (int)Math.sqrt(Math.pow(this.x, 2)+Math.pow(this.y, 2));
	}

	public String getName() {
		return name;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
