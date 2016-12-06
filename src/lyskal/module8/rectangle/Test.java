package lyskal.module8.rectangle;

/*import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import rin2016.module8.our_string.Main;
import sun.reflect.misc.MethodUtil;*/

public class Test {

	public static void main(final String[] args){
		/*Method[] methods = Main.class.getMethods();
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].getName().startsWith("test")) {
				methods[i].invoke(null, null);
			}
		}*/
		
		testInit();
	}
	
	public static void testInit() {
		Rectangle a = new Rectangle();
		
		if(a.getTopLeft() != null && a.getBottomRight() != null) {
			System.out.println("Конструктор работает правильно!");
		} else {
			System.err.println("Конструктор работает НЕ правильно!");
		}
	}
	
}
