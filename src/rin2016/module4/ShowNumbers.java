package rin2016.module4;
import java.util.Scanner;

public class ShowNumbers {

	public static void main(String[] args) {
		//������� ����� ��������� ����� �� �������
		Scanner s = new Scanner(System.in);
		System.out.print("������� �����, ������� �� �������� �� �����: ");
		int numberFromUser = s.nextInt();
		
		if (numberFromUser < 10) {
			System.out.println("� ����� " + numberFromUser + " ���� �����.");
		} else if (numberFromUser >= 10) {
			//������� ���������� ���� � ��������� �����
			int numberDigits = (int) Math.log10(numberFromUser)+1; 
			int digitNumber = 0;
			
			while (numberDigits != 0) {
				int firstDigit = numberFromUser /(int) Math.pow(10, --numberDigits);
				firstDigit = firstDigit % 10;

				System.out.println(++digitNumber + "-� ����� ����� " + 
							numberFromUser + " = " + firstDigit);
			}
		}
		s.close();
	}
}
