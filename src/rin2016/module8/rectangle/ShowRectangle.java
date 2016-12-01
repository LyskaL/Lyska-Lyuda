package rin2016.module8.rectangle;

/**
 * В классе содержатся статические методы
 * для вывода фигуры на консоль.
 * 
 * @author Люся
 */
public class ShowRectangle {
	
	public static void show(final Rectangle rectangle) {
		if (rectangle != null) {
			showHorizontalLine(rectangle);
			showVerticallyLines(rectangle);
			showHorizontalLine(rectangle);
		}
	}
	
	private static void showVerticallyLines(final Rectangle a) {
		for (int j = 0; j < a.width()-2; j++) {
			for (int i = 0; i < a.length(); i++) {
				if (i == 0 || i == a.length() - 1) {
					System.out.print("+");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	private static void showHorizontalLine(final Rectangle a) { 
		for (int i = 0; i < a.length(); i++) {
			System.out.print("+");
		}
		System.out.println();
	}
}
