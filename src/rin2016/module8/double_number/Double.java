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
	
	private void howManyDigitFractional() {
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
	private int extractAnInteger(final String number) {
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
	private int extractFractionalPart(final String number) {
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
			ifLargerNumber(number);
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
				ifOurNumberLess(number);
			} else {
				ifOurNumberLarger(number);
			}
		} else {
			ifLessNumber(number);
		}
	}
	
	public void multiplication(final int number) {
		if(number != 0){
			if(integer != 0) {
				this.integer *= number;
				if(fractional != 0) {
					this.fractional *= number;
					if((int)(Math.log10(fractional)+1) != digitFractional) {
						int index = fractional/(1*(int)Math.pow(10, digitFractional));
						this.integer += index;
						this.fractional = Math.abs((index*(int)Math.pow(10, digitFractional)) - fractional);
						numberZero = digitFractional - (int)(Math.log10(fractional)+1);
					}
				}
			}
		} else {
			this.integer = 0;
			this.fractional = 0;
			numberZero = 2;
			digitFractional = 2;
		}
	}
	
	/*
	 * Спавниваем наше число с пришедшим. Возвращаем:
	 * 1 - если integer больше number;
	 * 0 - если числа равны;
	 * -1 - если integer меньше number.
	 */
	private int compare(final int number) {
		if (integer > number) {
			return 1;
		} else if (integer == number && fractional == 0) {
			return 0;
		} else {
			return -1;
		}
	}
	
	public void showCompare(final int number) {
		int result = compare(number);
		if(result > 0) {
			show();
			System.out.println(" больше " + number);
		} else if (result < 0) {
			show();
			System.out.println(" меньше " + number);
		} else {
			System.out.println("Числа равны!");
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
	private void checkNumberNegative() {
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
			additionFractions(number);
		}
	}
	
	/*
	 * Если пришедшее число для сложения больше нашего.
	 * Высчитываем целую часть и дробную (если необходимо)
	 */
	private void ifOurNumberLarger(final int number) {
		if(integer <= number) {
			this.integer += Math.abs(number);
		} else {
			this.integer += Math.abs(number);
			additionFractions(number);
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
			subtractionFractions(number);
		}
	}
	
	/*
	 * Если пришедшее число для вычитания больше нашего.
	 * Высчитываем целую часть и дробную (если необходимо)
	 */
	private void ifOurNumberLess(final int number) {
		if(integer <= number || integer == 0) {
			this.integer -= number;
		} else {
			subtractionFractions(number);
		}
	}
	
	/*
	 * Высчитываем целую часть и новую дробную при вычитании
	 */
	private void subtractionFractions(final int number) {
		this.integer -= number;
		if (fractional > 0) {
			checkNumberNegative();
			this.integer += 1;
			calculateFractional();
		}
	}
	
	/*
	 * Высчитываем новую дробную часть при сложении
	 */
	private void additionFractions(final int number) {
		if (fractional > 0) {
			checkNumberNegative();
			this.integer -= 1;
			calculateFractional();
		}
	}
}
