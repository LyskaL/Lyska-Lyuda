package rin2016.module8.rectangle;

public class Test {

	public static void main(final String[] args) {
		Rectangle a = new Rectangle(2,4,2,4);
		
		System.out.println("1 точка. X = " + a.getTopLeft().getX() +
				", Y = " + a.getTopLeft().getY());
		System.out.println("2 точка. X = " + a.getBottomRight().getX() +
				", Y = " + a.getBottomRight().getY());
		
		
	}

}
