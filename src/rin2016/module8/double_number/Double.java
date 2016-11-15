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
		howManyDigitFractional();
	}
	
	public void howManyDigitFractional() {
		// узнаём кол-во цифр после дробного знака(для дальнейших манипуляций с
		// дробью)
		if (numberZero == 0) {
			this.digitFractional = (int) (Math.log10(fractional) + 1);
		} else {
			if (fractional == 0) {
				this.digitFractional = numberZero;
			} else {
				this.digitFractional = (int)(Math.log10(fractional)+1) + numberZero;
			}
		}
	}
	
	/*
	 * Вывести число на экран
	 */
	public void show() {
		if(isNumberNegative && integer == 0) {
			//Если целая часть равна 0, но число отрицательное
			//выводим перед числом '-'
			System.out.print("-");
		}
		System.out.print(integer+".");
		if (numberZero > 0) {
			//Выводим количество нулей после '.'
			for (int i = 0; i < numberZero; i++) {
				System.out.print("0");
			}
		}
		// Выводим дробную часть
		if (fractional > 0) {
			System.out.print(fractional);
		}
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
		if(isNumberNegative) {
			if(number > 0) {
				ifLargerNumber(number);
			} else {
				//ifLessNumber(number);
				ifLargerNumber(number);
			}
		} else {
			if(number > 0) {
				this.integer+=number;
			} else {
				ifLessNumber(Math.abs(number));
			}
		}
	}
	
	public void difference(final int number) {
		if (isNumberNegative) {
			if(number > 0) {
				isOurNumberLess(number);
			} else {
				isOurNumberLarger(number);
			}
		} else {
			if(number > 0) {
				ifLessNumber(number);
			} else {
				ifLessNumber(number);
			}
		}
	}
	
	/*
	 * Высчитываем изменения в дробной части
	 */
	private void calculateFractional() {
		this.fractional = (1*(int)Math.pow(10, digitFractional)) - fractional;
		numberZero = digitFractional - (int)(Math.log10(fractional)+1);
	}
	
	/*
	 * Проверяем изменился ли знак у нашего числа
	 */
	private void isNumberNegative() {
		if (this.integer > 0) {
			isNumberNegative = false;
		} else {
			isNumberNegative = true;
		}
		
	}
	
	/*
	 * Если пришедшее число для сложения меньше нашего.
	 * Высчитываем целую часть и дробную (если необходимо)
	 */
	private void ifLargerNumber(final int number) {
		if(integer >= number) {
			this.integer += number;
		} else {
			this.integer += number;
			if (fractional > 0) {
				isNumberNegative();
				this.integer -= 1;
				calculateFractional();
			}
		}
	}
	
	/*
	 * Если пришедшее число для сложения больше нашего.
	 * Высчитываем целую часть и дробную (если необходимо)
	 */
	private void isOurNumberLarger(final int number) {
		if(integer <= number) {
			this.integer += Math.abs(number);
		} else {
			this.integer += Math.abs(number);
			isNumberNegative();
			this.integer -= 1;
			calculateFractional();
		}
	}
	
	/*
	 * Если пришедшее число для вычитания меньше нашего.
	 * Высчитываем целую часть и дробную (если необходимо)
	 */
	private void ifLessNumber(final int number) {
		if(integer >= number || integer == 0) {
			this.integer -= number;
		} else {
			this.integer -= number;
			if (fractional > 0) {
				isNumberNegative();
				this.integer += 1;
				calculateFractional();
			}
		}
	}
	
	/*
	 * Если пришедшее число для вычитания больше нашего.
	 * Высчитываем целую часть и дробную (если необходимо)
	 */
	private void isOurNumberLess(final int number) {
		if(integer <= number || integer == 0) {
			this.integer -= number;
		} else {
			this.integer -= number;
			isNumberNegative();
			this.integer += 1;
			calculateFractional();
		}
	}
}
