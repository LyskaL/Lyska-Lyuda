package rin2016.module8.double_number;
import java.util.Scanner;

public class DoubleMain {

	public static void main(final String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите дробное число: ");
		String number = scanner.nextLine();
		
		Double ourNumber = new Double(number);
		ourNumber.sum(15);
		ourNumber.show();
		
		scanner.close();
	}

}
