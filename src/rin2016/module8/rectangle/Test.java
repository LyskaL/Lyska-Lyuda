package rin2016.module8.rectangle;

public class Test {

	public static void main(final String[] args) {
		Rectangle a = new Rectangle(-8,3,0,-1);
		Rectangle b = new Rectangle(-5,5,3,3);
		
		if (a.isIntersect(b)) {
			System.out.println("Прямоугольники пересекаются!");
		} else {
			System.out.println("Прямоугольники не пересекаются!");
		}
		ShowRectangle.show(a);
		
	}

}
