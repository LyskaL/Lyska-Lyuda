package rin2016.module8.double_number;

public class Double {
	
	private int integer;
	private int fractional;
	
	private int numberZero;
	private int digitFractional;
	private boolean isNumberNegative;
	
	public Double(final String number) {
		this.integer = extractAnInteger(number);
		this.fractional = extractFractionalPart(number);
		
		//узнаём кол-во цифр после дробного знака(для дальнейших манипуляций с дробью)
		if (numberZero == 0) {
			this.digitFractional = (int)(Math.log10(fractional)+1);
		} else {
			this.digitFractional = (int)(Math.log10(fractional)+1) + numberZero;
		}
	}
	
	/*
	 * Вывести число на экран
	 */
	public void show() {
		if(isNumberNegative && integer == 0) {
			System.out.print("-");
		}
		System.out.print(integer+".");
		if (numberZero > 0) {
			for (int i = 0; i < numberZero; i++) {
				System.out.print("0");
			}
		}
		System.out.print(fractional);
	}
	
	/*
	 * Извлекаем из строки number целое число 
	 */
	public int extractAnInteger(final String number) {
		String temp = number.substring(0, number.indexOf('.'));
		if(number.charAt(0) == '-') {
			isNumberNegative = true;
		}
		return Integer.parseInt(temp);
	}
	
	/*
	 * Извлекаем из строки number дробное число. 
	 * Если после запятой идут нули, считаем их кол-во.
	 */
	public int extractFractionalPart(final String number) {
		String temp = number.substring(number.indexOf('.')+1, number.length());
		if (temp.length() > 1) {
			int counterZero = 0;
			for (int i = 0; i < temp.length(); i++) {
				int newNumber = Integer.parseInt("" + temp.charAt(i));
				if (newNumber == 0 && i == counterZero) {
					numberZero++;
					counterZero++;
				}
			}
		}
		this.fractional = Integer.parseInt(temp);
		return Integer.parseInt(temp);
	}
	
	public void sum(final int number) {
		//программа считает не правильно, если передадут отрицательно число
		if(isNumberNegative && Math.abs(integer)<number) {
			this.integer += number;
			if (fractional > 0) {
				this.integer -= 1;
				this.fractional = (1*(int)Math.pow(10, digitFractional)) - fractional;
				numberZero = digitFractional - (int)(Math.log10(fractional)+1);
			}
		} else {
			this.integer += number;
			if (integer >= 0) {
				isNumberNegative = false;
			}
		}
	}
	
	public void difference(int number) {
		if(integer >=  number) {
			this.integer -= number;
		} else if (number < 0){
			// Если передали отрицательное число 
			// '-' на '-'даёт '+' вызываем метод сложения
//считает не правильно
			sum(Math.abs(number));
		} else {
			number -= integer;
			if (isNumberNegative) {
				this.integer = -number;
			} else {
				if (fractional > 0) {
					number -= 1;
					this.integer = -number;
					this.fractional = (1*(int)Math.pow(10, digitFractional)) - fractional;
					numberZero = digitFractional - (int)(Math.log10(fractional)+1);
				}
			}
		}
	}
	
	public void product(final int number) {
		this.integer *= number;
		this.fractional *= number;
		if ((int)(Math.log10(fractional)+1) > digitFractional) {
			this.integer += Math.round(fractional/(10*digitFractional));
		}
	}
	
	
}
