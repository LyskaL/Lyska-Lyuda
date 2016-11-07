package rin2016.chapter11;
import java.util.Arrays;
import java.util.Scanner;

public class Task11_144 {

	public static void main(final String[] args) {
		// 11.144 Дан массив. Поменять местами:
		final int SIZE = 10;
		final int[] array = new int[SIZE];
		generateNumbers(array);
		System.out.println("Наш изначальный массив: \t" + Arrays.toString(array));

		// a) второй и пятый элементы;
		final int oneIndex = 2;
		final int twoIndex = 5;
		swap(array, oneIndex, twoIndex);
		System.out.println("\nПоменяли местами " + oneIndex + 
				"й и " + twoIndex + "й элементы: " + Arrays.toString(array));

		/*
		 * b) Меняем третий и максимальный элементы. Если элементов с
		 * максимальным значением несколько, то в обмене должен участвовать
		 * первый из них.
		 */
		final int threeIndex = 3;
		swap(array, threeIndex, findIndextElementFromBegin(array, findMaxElement(array)));
		System.out.println("\nПоменяли местами " + threeIndex + 
				"й и MAX элементы: " + Arrays.toString(array));

		/*
		 * c) первый и минимальный элементы. Если элементов с минимальным
		 * значением несколько, то в обмене должен участвовать последний из них.
		 */
		final int fourIndex = 1;
		swap(array, fourIndex, findIndextElementFromEnd(array, findMinElement(array)));
		System.out.println("\nПоменяли местами " + fourIndex + 
				"й и MIN элементы: " + Arrays.toString(array));

		// d) m-й и n-й элементы;
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nВведите индексы элементов массива, которые нужно" + 
				" поменять местами.\nПервый: ");
		int m = scanner.nextInt();
		System.out.print("Второй: ");
		int n = scanner.nextInt();

		if (isCorrectIndexArray(array, m, n)) {
			swap(array, m, n);
			System.out.println("Поменяли местами " + m + "й и " + n + 
					"й элементы: " + Arrays.toString(array));
		} else {
			System.out.println("Введён неверный индекс!");
		}
		scanner.close();
	}
	
	/*
	 * Заполняем массив случайными значениями от 0 до 50
	*/
	public static void generateNumbers(final int[] array){
		for (int i=0; i < array.length; i++) {
			array[i] = (int) (Math.random()*50);
		}
	}

	/*
	 * Метод меняет местами два элемента массива
	 */
	public static void swap(final int[] array, final int firstIndex, final int secondIndex) {
		if (array[firstIndex] != array[secondIndex]) {
			if (isCorrectIndexArray(array, firstIndex, secondIndex)) {
				final int temp = array[firstIndex];
				array[firstIndex] = array[secondIndex];
				array[secondIndex] = temp;
			}
		}
	}

	/*
	 * Метод проверяет корректы ли индексы массива
	 */
	public static boolean isCorrectIndexArray(final int[] array, final int firstIndex, final int secondIndex) {
		if (firstIndex < array.length && firstIndex >= 0 && secondIndex < array.length && secondIndex >= 0) {
			return true;
		} else {
			return false;
		}

	}

	/*
	 * Найти максимальный элемент в массиве и вернуть его.
	 */
	public static int findMaxElement(final int[] array) {
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > result) {
				result = array[i];
			}
		}
		return result;
	}

	/*
	 * Найти минимальный элемент в массиве и вернуть его.
	 */
	public static int findMinElement(final int[] array) {
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < result) {
				result = array[i];
			}
		}
		return result;
	}

	/*
	 * Найти индекс переданого элемента, первого с начала массива
	 */
	public static int findIndextElementFromBegin(final int[] array, final int element) {
		int result = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == element) {
				result = i;
				break;
			}
		}
		return result;
	}

	/*
	 * Найти индекс переданого элемента, первого с конца массива
	 */
	public static int findIndextElementFromEnd(final int[] array, final int element) {
		int result = -1;
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] == element) {
				result = i;
				break;
			}
		}
		return result;
	}
}