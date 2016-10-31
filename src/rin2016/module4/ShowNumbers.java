package rin2016.module4;
import java.util.Scanner;

public class ShowNumbers {

	public static void main(String[] args) {
		//Вывести цифры введённого числа по порядку
		Scanner s = new Scanner(System.in);
		System.out.print("Введите число, которое мы разобьем на цифры: ");
		int numberFromUser = s.nextInt();
		
		if (numberFromUser < 10) {
			System.out.println("В числе " + numberFromUser + " одна цифра.");
		} else if (numberFromUser >= 10) {
			//Находим количество цифр в введенном числе
			int numberDigits = (int) Math.log10(numberFromUser)+1; 
			int digitNumber = 0;
			
			while (numberDigits != 0) {
				int firstDigit = numberFromUser /(int) Math.pow(10, --numberDigits);
				firstDigit = firstDigit % 10;

				System.out.println(++digitNumber + "-я цифра числа " + 
							numberFromUser + " = " + firstDigit);
			}
		}
		s.close();
	}
}
