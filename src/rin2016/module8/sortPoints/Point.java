package rin2016.module8.sortPoints;

public class Point {
	private String name;
	private int x;
	private int y;
	
	private int distance;

	public Point() {
		name = "";
		x = 0;
		y = 0;
		distance = 0;
	}

	public Point(final String name, final int x, final int y) {
		setName(name);
		setX(x);
		setY(y);
		setDistance();
	}
	
	public void setName(final String name) {
		this.name = name;
	}

	public void setX(final int x) {
		this.x = x;
		setDistance();
	}

	public void setY(final int y) {
		this.y = y;
		setDistance();
	}
	
	/*
	 * Расстояние не задаётся вручную, высчитывает при каждом изменении X и Y.
	 * 
	 * Формула для нахождения расстояние от точки до начала координат: 
	 * D = sqrt(x^2 + y^2)
	 */
	private void setDistance () {
		this.distance = (int)Math.sqrt(Math.pow(this.x, 2)+Math.pow(this.y, 2));
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
	
	public int getDistance() {
		return distance;
	}
}
