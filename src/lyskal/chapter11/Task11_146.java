package lyskal.chapter11;
import java.util.Arrays;

public class Task11_146 {

	public static void main(final String[] args) {
		// 11.146 Дан одномерный массив из 20 элементов.
		// Переставить певрые три и последние три элемента в массиве,
		// сохранив порядок их следования.
		final int SIZE = 20;
		final int[] array = new int[SIZE];
		generateNumbers(array);
		System.out.println("Наш изначальный массив: \n" 
				+ Arrays.toString(array));
		
		final int howManyElementsChange = 3; 
		swapFirstElements(array, howManyElementsChange);
		
		System.out.println("Меняем первые три элемента с последними:\n" 
				+ Arrays.toString(array));
		
	}
	
	// Заполняем массив случайными значениями от 0 до 50
	public static void generateNumbers(final int[] array){
		for (int i=0; i < array.length; i++) {
			array[i] = (int) (Math.random()*50);
		}
	}

	// Метод меняет местами два элемента массива
	public static void swap(final int[] array, final int firstIndex, final int secondIndex) {
		if (array[firstIndex] != array[secondIndex]) {
			final int temp = array[firstIndex];
			array[firstIndex] = array[secondIndex];
			array[secondIndex] = temp;
		}
	}

	// Меняем первые элементы массива с посделними (соблюдая порядок сдедования)
	public static void swapFirstElements (final int [] array, final int howManyElementsChange) {
		for (int i = 0; i < howManyElementsChange; i++) {
			int index = (array.length-howManyElementsChange)+i;
			swap(array, i, index);
		}
	}
}
