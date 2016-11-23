package rin2016.chapter11;
import java.util.Arrays;

public class Task11_158 {

	public static void main(final String[] args) {
		/*
		 * 11.158 Удалить из массива все повторяющиеся элементы,
		 * оставив их первые вхождения, то есть в массиве должны,
		 * остаться только различные элементы
		 */
		final int SIZE = 20;
		int[] array = new int[SIZE];
		generateNumbers(array);
		System.out.println("Наш изначальный массив: \n" 
				+ Arrays.toString(array));
		
		int counterRemove = 0;
		for (int i = 0; i < array.length-counterRemove; i++) {
			for (int j = i+1; j < array.length-counterRemove; j++) {
				if (array[i] == array[j]) {
					removeElementWithArray(array, j);
					//Ставим дикримент для того, чтобы цикл при удалении 
					//элемента не пропустил два повторяющихся числа подряд
					--j;
					++counterRemove;
				}
			} 
		}
		if (counterRemove > 0) {
			array = copyArray(array, array.length-counterRemove);
		}
		System.out.println("\nМассив после удаления повторяющихся элементов: \n" 
				+ Arrays.toString(array));
	}
	
	/*
	 * Заполняем массив случайными числами в диапазоне от 5 до 24
	*/
	public static void generateNumbers (final int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random()*20)+5;
		}
	}
	
	/*
	 * Удаляет из массива елемент по индексу
	*/
	public static void removeElementWithArray(final int[] array, final int index) {
		for (int i = index; i < array.length-1; i++) {
			array[i] = array[i+1];
		}
	}
	
	/*
	 * Создаём новый массив (размер передаём в аргументе),
	 * копируем данные из старого массива в новый и возвращаем его
	*/
	public static int[] copyArray(final int[] array, final int newSize) {
		int[] temp = new int[newSize];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = array[i];
		}
		return temp;
	}
}