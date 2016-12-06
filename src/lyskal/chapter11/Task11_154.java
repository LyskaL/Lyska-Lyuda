package lyskal.chapter11;
import java.util.Arrays;

public class Task11_154 {

	public static void main(final String[] args) {
		/*
		 * 11.154 Удалить из массива в котором все элементы
		 * различны, максимальный и минимальный элементы.
		 */
		final int SIZE = 10;
		int[] array = new int[SIZE];
		generateNumbers(array);
		System.out.println("Наш изначальный массив: \n" 
				+ Arrays.toString(array));
		
		int max = maxNumber(array);
		int min = minNumber(array);
		
		array = removeElementWithArray(array, findIndexNumber(array, max));
		array = removeElementWithArray(array, findIndexNumber(array, min));
		
		System.out.println("\nМассив после удаления MAX и MIN элементов: \n" 
				+ Arrays.toString(array));
	}
	
	public static void generateNumbers (final int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = generateNumber(array, i);
		}
	}
	
	/*
	 * Сгенерировать число, которого нет в массиве.
	 * array - массив, который заполняется числами 
	 * index - индекс текущего элемента
	*/
	public static int generateNumber (final int[] array, final int index) {
		int result = (int) (Math.random()*50);
		for(int i = 0; i < index; i++) {
			if (array[i] == result) {
				result = generateNumber(array, index);
			}
		}
		return result;
	}
	
	/*
	 * Найти в массиве минимальный элемент и вернуть его
	*/
	public static int minNumber (final int[] array) {
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < result){
				result = array[i];
			}
		}
		return result;
	}
	
	/*
	 * Найти в массиве максимальный элемент и вернуть его
	*/
	public static int maxNumber(final int[] array) {
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > result){
				result = array[i];
			}
		}
		return result;
	}
	
	/*
	 * Найти в массиве индекс элемента и вернуть его
	*/
	public static int findIndexNumber(final int[] array, final int number) {
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == number){
				result = i;
				break;
			}
		}
		return result;
	}
	
	/*
	 * Удаляет из массива елемент по индексу
	*/
	public static int[] removeElementWithArray(final int[] array, final int index) {
		for (int i = index; i < array.length-1; i++) {
			array[i] = array[i+1];
		}
		return copyArray(array, array.length-1);
	}
	
	/*
	 * Создаём новый массив (размер передаём в аргументе),
	 * копируем данные из старого массива в новый и возвращаем его
	*/
	public static int[] copyArray(final int[] array, final int size) {
		int[] temp = new int[size];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = array[i];
		}
		return temp;
	}
}