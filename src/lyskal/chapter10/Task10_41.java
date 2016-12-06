package lyskal.chapter10;
import java.util.Scanner;

public class Task10_41 {

	public static void main(final String[] args) {
		/*
		 * 10.41 Написать рекурсивную функцию для вычисления
		 * факториала натурального числа n.
		 */
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите число: ");
		int n = scanner.nextInt();
		if (n >= 0) {
			int factorial = factorial(n);
			System.out.println("Факториал числа " + n + " равен: " + factorial);
		} else {
			System.out.println("Факториала от целых отрицательных чисел не существует.");
		}
		scanner.close();
	}
	
	public static int factorial(final int number) {
		if (number == 1) {
			return number;
		} else if (number == 0) {
			return 1;
		} else {
			return number*factorial(number-1);
		}
	}
}