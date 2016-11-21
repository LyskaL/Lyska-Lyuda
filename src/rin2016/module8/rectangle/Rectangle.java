package rin2016.module8.rectangle;

public class Rectangle {
	private Point topLeft;
	private Point bottomRight;

	public Rectangle() {
		this(0, 0, 0, 0);
	}

	public Rectangle(final int x1, final int x2,
			final int y1, final int y2) {
		init(x1, x2, y1, y2);
	}
	
	public Rectangle(final Point topLeft, final Point bottomRight) {
		if (topLeft == null && bottomRight == null) {
			init(0, 0, 0, 0);
		} else {
			init(topLeft.getX(), topLeft.getY(), bottomRight.getX(), bottomRight.getY());
		}
	}
	
	private void init(final int x1, final int y1,
			final int x2, final int y2) {
		setTopLeft(new Point(x1, y1));
		setBottomRight(new Point(x2, y2));
	}

	public Point getTopLeft() {
		return copy(topLeft);
	}

	public void setTopLeft(final Point topLeft) {
		if(topLeft == null) {
			System.err.print("Некорректный Point!");
			return;
		}
		this.topLeft = copy(topLeft);
	}

	public Point getBottomRight() {
		return copy(bottomRight);
	}

	public void setBottomRight(final Point bottomRight) {
		if(bottomRight == null) {
			System.err.print("Некорректный Point!");
			return;
		}
		this.bottomRight = copy(bottomRight);
	}
	
	private Point copy(final Point copy) {
		if(copy == null){
			return null;
		}
		return new Point(copy.getX(), copy.getY());
	}
	
	public int length() {
		return Math.abs((topLeft.getX() - bottomRight.getX()));
	}
	
	public int width() {
		return (topLeft.getY() - bottomRight.getY());
	}
	
	public boolean isIntersect(final Rectangle rectangle) {
		if(rectangle == null) {
			return false;
		}
		int recBottomLeftX = rectangle.getBottomRight().getX() - rectangle.length();
		int recTopRightY = rectangle.width() + rectangle.getBottomRight().getY();
		
		if (isPointInRectangle(recBottomLeftX, rectangle.getBottomRight().getY()) ||
				isPointInRectangle(rectangle.getBottomRight().getX(), recTopRightY)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isPointInRectangle(final Point point){
		if(point == null) {
			return false;
		}
		
		return isPointInRectangle(point.getX(), point.getY());
	}
	
	public boolean isPointInRectangle(final int x, final int y){
		boolean compareX = (x <= bottomRight.getX() && x >= topLeft.getX());
		boolean compareY = (y >= bottomRight.getY() && y <= topLeft.getY());
		if (compareX && compareY) {
					return true;
				} else {
					return false;
				}
	}
}
