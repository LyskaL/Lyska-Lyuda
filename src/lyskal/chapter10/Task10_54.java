package lyskal.chapter10;
import java.util.Scanner;

public class Task10_54 {

	public static void main(final String[] args) {
		/*
		 * 10.54* Написать рекурсивную процедуру перевода
		 * натурального числа из десятичной системы в двоичную.
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите число: ");
		int number = scanner.nextInt();
		StringBuilder numberInBinarySystem = new StringBuilder("");
		numberInBinarySystem = convertNumberInBinarySystem(number, numberInBinarySystem);
		numberInBinarySystem.reverse();
		System.out.println("Число "+number+" в двоичной системе: "+numberInBinarySystem);
		scanner.close();
	}
	
	public static StringBuilder convertNumberInBinarySystem(final int number, 
			final StringBuilder ourString) {
		if (number == 0) {
			return ourString.append("0");
		} else if (number == 1) {
			return ourString.append("1");
		}
		if (number%2 == 0) {
			ourString.append("0");
			return convertNumberInBinarySystem(number/2, ourString);
		} else {
			ourString.append("1");
			return convertNumberInBinarySystem(number/2, ourString);
		}
	}
}