package lyskal.chapter11;
import java.util.Scanner;

public class Task11_192 {

	public static void main(final String[] args) {
		/*
		 * 11.192 Дано натуральное число N.
		 * Определить количество различных цифр в нем.
		 * Например, в числе 1234 - 4 различных цифр,
		 * 22424 - 2 цифры, 333 - 1.
		 */
		Scanner scanner = new Scanner (System.in);
		System.out.print("Введите число: ");
		int number = scanner.nextInt();
		 
		int[] array = convertIntToArray(number);
		int counterDigits = howManyDifferentDigits(array);
		
		System.out.println("Разных цифр в числе " + number + " - " + counterDigits);
		scanner.close();
	}
	
	public static int[] convertIntToArray(int number) {
		int sizeArray = (int) Math.log10(number)+1; 
		int[] array = new int [sizeArray];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = number%10;
			number/=10;
		}
		return array;
	}
	
	public static int[] removeElementToIndex(final int[] array, final int index) {
		for (int i = index; i < array.length-1; i++) {
			array[i] = array[i+1];
		}
		return copyArray(array, array.length-1);
	}
	
	public static int[] copyArray(final int[] array, final int newSize) {
		int[] temp = new int [newSize];
		for(int i = 0; i < temp.length; i++) {
			temp[i] = array[i];
		}
		return temp;
	}
	
	public static int[] removeEqualElements(int[]array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i+1; j < array.length; j++) {
				if(array[i] == array[j]) {
					array = removeElementToIndex(array, j);
					--j;
				}
			}
		}
		return array;
	}
	
	public static int howManyDifferentDigits(final int[] array) {
		return removeEqualElements(array).length;
	}
}