package rin2016.module8.double_number;
import java.util.Scanner;

public class DoubleMain {
	final static int PLUS = 1;
	final static int MINUS = 2;
	final static int MULTIPLY = 3;
	final static int EQUAL = 4;

	public static void main(final String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите дробное число: ");
		String firstNumber = scanner.nextLine();
		
		Double ourNumber = new Double(firstNumber);
		System.out.print("Введите целое число: ");
		int secondNumber = scanner.nextInt();
		
		System.out.println("\nЧто вы желаете сделать с цифрами?\n"
				+ PLUS + ". Сложить\n"
				+ MINUS + ". Вычесть\n" 
				+ MULTIPLY + ". Умножить\n"
				+ EQUAL + ". Сравнить");
		
		switch(scanner.nextInt()) {
		case PLUS:
			ourNumber.sum(secondNumber);
			break;
		case MINUS:
			ourNumber.difference(secondNumber);
			break;
		case MULTIPLY:
			ourNumber.multiplication(secondNumber);
			break;
		case EQUAL:
			ourNumber.showCompare(secondNumber);
			break;
		}
		System.out.println("Результат вычисления: ");
		ourNumber.show();
		scanner.close();
	}

}
