package lyskal.chapter10;
import java.util.Scanner;

public class Task10_55 {
	static final int BINARY_SYSTEM = 2;
	static final int HERADECIMAL_SYSTEM = 16;

	public static void main(final String[] args) {
		/*
		 * 10.55* Написать рекурсивную процедуру перевода
		 * натурального числа из десятичной системы счисления
		 * в N-ричную.
		 * Значение N в основной программе вводится с клавиатуры
		 * (2<=N<=16).
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите число: ");
		int number = scanner.nextInt();
		System.out.print("В какую систему переводим число (2<=N<=16): ");
		int n = scanner.nextInt();
		
		if (n >= BINARY_SYSTEM && n <= HERADECIMAL_SYSTEM) {
			StringBuilder convertNumber = new StringBuilder("");
			convertNumber = convertInNSystem(number, convertNumber, n) ;
			convertNumber.reverse();
			System.out.println("Число "+ number +
					" в " + n + "-й системе: " + convertNumber);
		}
		scanner.close();
	}
	
	/*
	 * N - в какую систему конвертируем число;
	 * number - число, которое мы конвертируем;
	 * ourString - записываем в строку преобразованное число.
	 */
	public static StringBuilder convertInNSystem(final int number, 
			final StringBuilder ourString, final int N) {
		
		if (number < 10 && number < N) {
			return ourString.append(number);
		}
		//Находим остаток от деления
		int remainder = number-(N*(number/N));
		saveValue(remainder, ourString);
		
		return convertInNSystem(number/N, ourString, N);
	}
	
	
	// Записываем в строку значение соответствующее остатку
	public static void saveValue (final int number,
			final StringBuilder ourString) {
		switch(number){
		case 0:
			ourString.append("0");
			break;
		case 1:
			ourString.append("1");
			break;
		case 2:
			ourString.append("2");
			break;
		case 3:
			ourString.append("3");
			break;
		case 4:
			ourString.append("4");
			break;
		case 5:
			ourString.append("5");
			break;
		case 6:
			ourString.append("6");
			break;
		case 7:
			ourString.append("7");
			break;
		case 8:
			ourString.append("8");
			break;
		case 9:
			ourString.append("9");
			break;
		case 10:
			ourString.append("A");
			break;
		case 11:
			ourString.append("B");
			break;
		case 12:
			ourString.append("C");
			break;
		case 13:
			ourString.append("D");
			break;
		case 14:
			ourString.append("E");
			break;
		case 15:
			ourString.append("F");
			break;
		}
	}
}