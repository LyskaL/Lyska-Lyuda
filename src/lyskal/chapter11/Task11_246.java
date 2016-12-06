package lyskal.chapter11;
import java.util.Arrays;

public class Task11_246 {

	public static void main(final String[] args) {
		/* 11.246* Дан массив. Переписать его элементы в другой массив
		 * такого же размера следующим образом: сначала должны идти
		 * все отрицательные элементы, а затем все остальные.
		 * Использовать только один проход по исходному массиву.
		*/
		final int SIZE_ARRAY = 10;
		
		int[] firstArray = new int [SIZE_ARRAY];
		int[] secondArray = new int [firstArray.length];
		generateNumbers(firstArray);
		System.out.println("Изначальный массив: " + Arrays.toString(firstArray));
		
		int counterNegativeNumber = 0;
		int counterPositiveNumber = firstArray.length-1;
		
		for(int i = 0; i < firstArray.length; ++i) {
			if(firstArray[i] < 0) {
				secondArray[counterNegativeNumber++] = firstArray[i];
			} else {
				secondArray[counterPositiveNumber--] = firstArray[i];
			}
		}
		
		System.out.println("Новый массив: " + Arrays.toString(secondArray));
	}
	
	public static void generateNumbers(final int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)((Math.random()*30)-10);
		}
	}
}