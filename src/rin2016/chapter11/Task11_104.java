package rin2016.chapter11;
import java.util.Arrays;

public class Task11_104 {
	public static void main(String[] args) {
		/* 11.104* В массиве из 20 элементов числа образуют неубывающую
		 * последовательность. Несколько элементов, идущих подряд, равны
		 * между собой. Найти количество таких элементов.
		 * Сколько различных чисел имеется в массиве?
		*/
		final int SIZE_ARRAY = 20;
		final int MIN_RANGE = 7;
		final int MAX_RANGE = 100;
		
		int[] array = new int [SIZE_ARRAY];
		generateNumbersInAscending(array, MIN_RANGE, MAX_RANGE);
		int[] equalDigits = numberEqualDigitsInArray(array);
		
		System.out.println(Arrays.toString(array) + "\n");
		
		for(int i=0;;i++) {
			if (equalDigits[i] > 0) {
				System.out.println(i+1 + " повторяющееся число: " + equalDigits[i]);
			} else {
				break;
			}
		}
		
		System.out.println("\nКоличество не повторяющихся элементов: " 
		+ numberOfDifferentDigits(array));
	}
	
	/*
	 * Заполняем массив (array) случайными  числами в порядке возрастания: 
	 * MIN_RANGE - минимальный диапазон;
	 * MAX_RANGE - максимальный диапазон;
	*/
	public static void generateNumbersInAscending (int [] array, final int MIN_RANGE, 
			final int MAX_RANGE) {
		
		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				array[i] = (int)(Math.random()*MIN_RANGE)+1;
			} else {
				// С каждой итерацией цикла увеличиваем диапазон
				// и так до максимального значения 
				int newRange = MIN_RANGE*i>MAX_RANGE ? MAX_RANGE : MIN_RANGE*i;
				//Генерируем число в диапазоне больше или равно предыдущему числу,
				//но меньше нового диапазона
				array[i] = (int)(Math.random()*(newRange-array[i-1]))+array[i-1];
			}
		}
	}
	
	/*
	 * Найти в массиве числа, которые повторяются несколько раз.
	 * Записываем их в новый массив и возвращаем его.
	 */
	public static int[] numberEqualDigitsInArray(int[]array) {
		int[] result = new int [array.length/2];
		boolean isNumberOfRepeats = false;
		int counter = 0;
		
		for (int i = 1; i < array.length; i++) {
			if ((array[i] == array[i-1]) && !isNumberOfRepeats) {
				isNumberOfRepeats = true;
				result[counter++] = array[i];
			} else if (array[i] != array[i-1]) {
				isNumberOfRepeats = false;
			}
		}
		return result;
	}
	
	/*
	 * Считаем сколько в массиве различных элементов и возвращаем значение.
	*/
	public static int numberOfDifferentDigits (int[] array) {
		int result = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] != array[i-1]) {
				++result;
			}
		}
		return result+1;
	}
}