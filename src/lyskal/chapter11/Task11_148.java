package lyskal.chapter11;
import java.util.Arrays;

public class Task11_148 {

	public static void main(final String[] args) {
		/*
		 * 11.148 Поменять местами первый отрицательный и последний 
		 * положительный элементы массива. Учесть возможность того, 
		 * что отрицательных или положительных элементов  в массиве 
		 * может не быть. */
		final int[] array = new int[] {4, 6, -2, 0, 5, 8, -1};
		System.out.println("Наш изначальный массив: \n" 
				+ Arrays.toString(array));
		
		int indexNegativeElement = findIndexFirstNegativeElement(array);
		int indexPositiveElement = findIndexLastPositiveElement(array);
		
		if (indexNegativeElement >= 0) {
			if (indexPositiveElement >= 0) {
				swap(array, indexNegativeElement, indexPositiveElement);
			} else {
				System.out.println("В массиве нет положительных чисел!");
			}
		} else {
			System.out.println("В массиве нет отрицательных числел!");
		}
		
		System.out.println("Массив после замены элементов: \n" 
				+ Arrays.toString(array));
		
	}
	
	/*
	 * Метод меняет местами два элемента в массиве по индексам
	*/
	public static void swap(final int[] array, final int firstIndex, final int secondIndex) {
		if (array[firstIndex] != array[secondIndex]) {
			final int temp = array[firstIndex];
			array[firstIndex] = array[secondIndex];
			array[secondIndex] = temp;
		}
	}
	/*
	 * Найти индекс первого отрицательного элемента в массиве и вернуть его
	*/
	public static int findIndexFirstNegativeElement (final int[] array) {
		int result = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < 0) {
				result = i;
				break;
			}
		}
		return result;
	}
	/*
	 * Найти индекс последнего положительного элемента массива и вернуть его
	*/
	public static int findIndexLastPositiveElement (final int[] array) {
		int result = -1;
		for (int i = array.length-1; i >= 0; --i) {
			if (array[i] > 0) {
				result = i;
				break;
			}
		}
		return result;
	}

}