package lyskal.module8.rectangle;
/**
 * Класс прямоугольник.
 * 
 * Координаты:
 * topLeft(объект типа Point) - левая верхняя точка прямоугольника.
 * bottomRight(объект типа Point) - правая нижняя точка прямоугольника.
 * 
 * Методы класса:
 * - пересечение с другим прямоугольником;
 * - попадает ли точка в данный прямоугольник;
 * - масштабировать при условии неподвижности
 * 	 левого верхнего угла;
 * - передвинуть по плоскости без вращения;
 * - возвратить ширину прямоугольника;
 * - возвратить длину прямоугольника.
 * 
 * @author Люся
 *
 */
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
		if (topLeft == null || bottomRight == null) {
			init(0, 0, 0, 0);
		} else {
			init(topLeft.getX(), topLeft.getY(), bottomRight.getX(), bottomRight.getY());
		}
	}
	/**
	 * Метод инициализирует точки прямоугольника 
	 * значениями прищедшими в аргументе.
	 * 
	 * @param x1 - координата левой верхней точки по оси X
	 * @param y1 - координата левой верхней точки по оси Y
	 * @param x2 - координата правой нижней точки по оси X
	 * @param y2 - координата правой нижней точки по оси Y
	 */
	private void init(final int x1, final int y1,
			final int x2, final int y2) {
		setTopLeft(new Point(x1, y1));
		setBottomRight(new Point(x2, y2));
	}
	/**
	 * Метод возвращает левую верхнюю точку прямоугольника.
	 * 
	 * @return левую верхнюю точку прямоугольника.
	 */
	public Point getTopLeft() {
		return copy(topLeft);
	}
	/**
	 * Метод изменяет координаты левой верхней точки.
	 * 
	 * @param topLeft - новые координаты точки.
	 */
	public void setTopLeft(final Point topLeft) {
		if(topLeft == null) {
			System.err.print("Некорректный Point!");
			return;
		}
		this.topLeft = copy(topLeft);
	}
	/**
	 * Метод возвращает правую нижнюю точку прямоугольника.
	 * 
	 * @return правую нижнюю точку прямоугольника.
	 */
	public Point getBottomRight() {
		return copy(bottomRight);
	}
	/**
	 * Метод изменяет координаты правой нижней точки.
	 * 
	 * @param bottomRight - новые координаты точки.
	 */
	public void setBottomRight(final Point bottomRight) {
		if(bottomRight == null) {
			System.err.print("Некорректный Point!");
			return;
		}
		this.bottomRight = copy(bottomRight);
	}
	/**
	 * Метод создаёт новую точку и копирует в неё
	 * данные из точки - copy.
	 * 
	 * @param copy - точка, которую необходимо копировать.
	 * @return Point - точку в которую перекопировали данные.
	 * Если нам пришел null в аргументе возвращаем его.
	 */
	private Point copy(final Point copy) {
		if(copy == null){
			return null;
		}
		return new Point(copy.getX(), copy.getY());
	}

	/**
	 * Метод высчитывает и возвращает длину прямоугольника.
	 * 
	 * @return длину прямоугольника.
	 */
	public int length() {
		return Math.abs((topLeft.getX() - bottomRight.getX()));
	}
	
	/**
	 * Метод высчитывает и возвращает ширину прямоугольника.
	 * 
	 * @return ширину прямоугольника.
	 */
	public int width() {
		return Math.abs((topLeft.getY() - bottomRight.getY()));
	}
	
	/**
	 * Метод проверяет пересикаются ли прямоугольники.
	 * 
	 * @param rectangle - прямоугольник для сравнения
	 * 
	 * @return true - если прямоугольники пересекаются;
	 * false - если не пересекаются.
	 */
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
	
	/**
	 * Метод определяет попадает ли point в прямоугольник 
	 * 
	 * @param point - точка с координатами (x,y)
	 * 
	 * @return true - если точка в прямоугольнике;
	 * false - если точка за пределами прямоугольника.
	 * 
	 */
	public boolean isPointInRectangle(final Point point){
		if(point == null) {
			return false;
		}
		
		return isPointInRectangle(point.getX(), point.getY());
	}
	
	/**
	 * Метод определяет попадает ли точка(x,y) в прямоугольник 
	 * 
	 * @param x - координата точки по оси X
	 * @param y - координата точки по оси Y
	 * 
	 * @return true - если точка в прямоугольнике;
	 * false - если точка за пределами прямоугольника.
	 * 
	 */
	public boolean isPointInRectangle(final int x, final int y){
		boolean compareX = (x <= bottomRight.getX() && x >= topLeft.getX());
		boolean compareY = (y >= bottomRight.getY() && y <= topLeft.getY());
		if (compareX && compareY) {
					return true;
				} else {
					return false;
				}
	}

	/**
	 * Метод выполняет смещение прямоугольника.
	 * Не передавать в метод отрицательные числа.
	 * 
	 * @param up - насколько смещается прямоугольник вверх.
	 * @param down - насколько смещается прямоугольник вниз.
	 * @param right - насколько смещается прямоугольник вправо.
	 * @param left - насколько смещается прямоугольник влево.
	 */
	public void offset(final int up, final int down, 
			final int right, final int left) {
		if(up > 0){
			offsetY(up);
		}
		if(down > 0){
			offsetY(-down);
		}
		if(right > 0){
			offsetX(right);
		}
		if (left > 0){
			offsetX(-left);
		}
	}
	
	/**
	 * Метод смещает прямоугольник по оси X.
	 * 
	 * @param index - насколько идёт смещение.
	 * Если передаётся число > 0 - смещение вправо.
	 * Если передаётся число < 0 - смещение влево.
	 */
	private void offsetX(final int index) {
		topLeft.setX(topLeft.getX() + index);
		bottomRight.setX(bottomRight.getX() + index);
	}
	
	/**
	 * Метод смещает прямоугольник по оси Y.
	 * 
	 * @param index - насколько идёт смещение.
	 * Если передаётся число > 0 - смещение вверх.
	 * Если передаётся число < 0 - смещение вниз.
	 */
	private void offsetY(final int index) {
		topLeft.setY(topLeft.getY() + index);
		bottomRight.setY(bottomRight.getY() + index);
	}
	/**
	 * Масштабирование нашего прямоугольника на index
	 * 
	 * @param index - коэффициент масштабирования.
	 * Если index > 1 - прямоугольник увеличивается.
	 * Если index > 0 && index < 1 - уменьшается.
	 */
	public void scale(final double index) {
		int offsetX2 = (int)(Math.abs(bottomRight.getX() - topLeft.getX()) * index);
		int offsetY2 = (int)(Math.abs(bottomRight.getY() - topLeft.getY()) * index);
		if (index < 1) {
			bottomRight.setX(bottomRight.getX()-offsetX2);
			bottomRight.setY(bottomRight.getY()+offsetY2);
		} else if (index > 0 && index < 1){
			bottomRight.setX(bottomRight.getX()+offsetX2);
			bottomRight.setY(bottomRight.getY()-offsetY2);
		}
	}
}
