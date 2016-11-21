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
	
	private void init(final int x1, final int x2,
			final int y1, final int y2) {
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
		return (topLeft.getX() - bottomRight.getX());
	}
	
	public int width() {
		return (topLeft.getY() - bottomRight.getY());
	}
	
	public boolean isIntersect(final Rectangle rectangle) {
		if(rectangle == null) {
			return false;
		}
		int recX1 = rectangle.getTopLeft().getX();
		int recY1 = rectangle.getTopLeft().getX();
		int recX2 = rectangle.getBottomRight().getX();
		int recY2 = rectangle.getBottomRight().getX();
		
		//TODO
		
		return true;
	}
	
	
}
