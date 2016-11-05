package rin2016.chapter11;
import java.util.Arrays;

public class Task11_29 {
	public static void main(String[] args) {
		// 11.29 Дан массив целых чисел'
		final int SIZE = 10;
		int [] array = new int [SIZE];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random()*100)+1;
		}
		System.out.println(Arrays.toString(array));
		
		//a) верно ли, что сумма элементов массива есть четное число
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		
		if(sum%2 == 0) {
			System.out.println("Сумма элементов массива = " + sum + " - четное число.");
		} else {
			System.out.println("Сумма элементов массива = " + sum + " - нечетное число.");
		}
		
		//b) верно ли, что сумма квадратов эллементов массива есть пятизначное число
		int sumSquares = 0;
		final int numberDigits = 5;
		
		for (int i = 0; i < array.length; i++) {
			sumSquares += Math.pow(array[i], 2);
		}
		
		if((int)Math.log10(sumSquares)+1 == 5) {
			System.out.println("Сумма квадратов элементов массива = " 
								+ sumSquares + " - пятизначное число.");
		} else {
			System.out.println("Сумма квадратов элементов массива = " 
					+ sumSquares + " - не пятизначное число.");
		}
	}
}
