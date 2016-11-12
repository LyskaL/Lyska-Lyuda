package rin2016.chapter12;

public class Task12_24 {

	public static void main(final String[] args) {
		/* 12.24 Заполнить массив размером 6х6 следующим образом:
		 * A)
		 * 	1	1	1	1	1	1
		 * 	1	2	3	4	5	6
		 * 	1	3	6	10	15	21
		 * 	1	4	10	20	35	56
		 * 	1	5	15	35	70	126
		 * 	1	6	21	56	126	252
		*/
		
		final int SIZE_ARRAY = 6;
		int[][] array = createArray(SIZE_ARRAY, SIZE_ARRAY);
		
		// Инициализация/заполнение массива
		for(int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if(i == 0) {
					array[i][j] = 1;
				} else if (j == 0) {
					array[i][j] = 1;
				} else {
					array[i][j] = array[i][j-1] + array[i-1][j];
				}
			}
		}
		
		showArray(array);
		
	}
	
	//Создание двумерного масссива
	public static int[][] createArray(final int rows, final int cols) {
		int[][] array = new int[rows][];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = new int [cols];
		}
		
		return array;
	}
	
	// Вывод двумерного массива на экран
	public static void showArray(final int[][] array) {
		for(int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print("\t" + array[i][j]);
			}
			System.out.println();
		}
	}
}