package rin2016.module8.sortPoints;

public class SortPoints {

	public static void main(final String[] args) {
		final int SIZE = 5;
		Point[] points = new Point[SIZE];
		points[0] = new Point("A", -4, 6);
		points[1] = new Point("B", 9, 4);
		points[2] = new Point("C", 6, -2);
		points[3] = new Point("D", -9, 5);
		points[4] = new Point("E", 1, -3);
		
		sort(points);
		show(points);
	}
	
	public static void swap(final Point first, final Point second) {
		Point temp = new Point(first.getName(), first.getX(), first.getY());
		
		first.setName(second.getName());
		first.setX(second.getX());
		first.setY(second.getY());
		
		second.setName(temp.getName());
		second.setX(temp.getX());
		second.setY(temp.getY());
	}
	
	public static void sort(final Point[] points) {
		for (int i = 0; i < points.length; i++) {
			for (int j = points.length-1; j >= i; --j) {
				if (points[i].getDistance() > points[j].getDistance()) {
					swap(points[i], points[j]);
				}
			}
		}
	}
	
	public static void show(final Point[] points) {
		for (int i = 0; i < points.length; i++) {
			System.out.println("Point: " + points[i].getName()
					+ "     X: " + points[i].getX()
					+ "\tY: " + points[i].getY()
					+ "\tDistance: " + points[i].getDistance());
		}
	}
}
