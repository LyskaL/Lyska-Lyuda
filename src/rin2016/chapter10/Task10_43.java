package rin2016.chapter10;
import java.util.Scanner;

public class Task10_43 {

	public static void main(final String[] args) {
		/*
		 * 10.43 Написать рекурсивную функцию:
		 * a) вычисление суммы цифр натурального числа;
		 * b) вычисление колличество цифр натурального числа.
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите число: ");
		int number = scanner.nextInt();
		
		int sum = sumDigitsNumber(number);
		System.out.println("a.) Сумма цифр числа " + number + " равна: " + sum);
		
		int counter = counterDigitsNumber(number);
		System.out.println("b.)Кол-во цифр в числе " + number + " равна: " + counter);
		scanner.close();
	}
	
	public static int sumDigitsNumber (final int number) {
		if (number < 10 && number > -10) {
			return number;
		} else if (number <= -10) {
			// Узнаём сколько цифр в отрицательном числе
			int counterDigits = counterDigitsNumber(number);
			// Отдельно сохраняем первое число (с отрицательным знаком)
			int firstDigit = number/(int)(Math.pow(10, counterDigits-1));
			/* Обрезаем число. Удаляем из него первую цифру с отрицательным знаком.
			 * Например: было -320, стало 20.*/
			int newNumber = Math.abs(number-(firstDigit*((int)(Math.pow(10, counterDigits-1)))));
			
			return firstDigit+sumDigitsNumber(newNumber);
		} else {
			return (number%10)+sumDigitsNumber(number/10);
		}
	}
	
	public static int counterDigitsNumber (final int number) {
		int i = 1; 
		if (number < 10 && number > -10) {
			return i;
		} else {
			return i+counterDigitsNumber(number/10);
		}
	}
}