package lyskal.chapter11;

public class Task11_34 {
	public static void main(String[] args) {
		//11.34 В массиве хранятся сведения о количестве осадков,
		//выпавших за каждый день июня. Определить: 
		//a) в какой период выпало больше осадков: в первой или во второй.
		final int numberOfDaysInJune = 30;
		int[] rainfallInJune = new int [numberOfDaysInJune];
		for (int i = 0; i < numberOfDaysInJune; i++) {
			rainfallInJune[i] = (int)(Math.random()*100);
		}
		
		int sumRainfallFirstPartMonth = 0;
		int sumRainfallSecondPartMonth = 0;
		for (int i = 0; i < numberOfDaysInJune; i++) {
			if (numberOfDaysInJune/2 >= i) {
				sumRainfallFirstPartMonth += rainfallInJune[i];
			} else {
				sumRainfallSecondPartMonth += rainfallInJune[i];
			}
		}
		//Выводим на экран результат
		System.out.println("В первой половине месяца - " + sumRainfallFirstPartMonth
							+ " осадков.\nВо второй - " + sumRainfallSecondPartMonth + " осадков.");
		if (sumRainfallFirstPartMonth > sumRainfallSecondPartMonth) {
			System.out.println("Большее количество осадков выпало в первой половине месяца.");
		} else if (sumRainfallFirstPartMonth < sumRainfallSecondPartMonth) {
			System.out.println("Большее количество осадков выпало во второй половине месяца.");
		} else {
			System.out.println("В первой и во второй половине месяца выпало равное количество осадков.");
		}
		
		// b) в какую декаду месяца выпало больше осадков.
		int firstDecadeInMonth = 0;
		int secondDecadeInMonth = 0;
		int threeDecadeInMonth = 0;
		
		final int dayInDecade = 10;
		//Считаем сколько осадков выпадо к каждой декаде месяца
		for (int i = 0; i < numberOfDaysInJune; i++) {
			if (i <= dayInDecade) {
				firstDecadeInMonth += rainfallInJune[i];
			} else if (i > dayInDecade && i < dayInDecade*2){
				secondDecadeInMonth += rainfallInJune[i];
			} else {
				threeDecadeInMonth += rainfallInJune[i];
			}
		}
		//Выводим результат на экран
		System.out.println("\n1 декада- " + firstDecadeInMonth + "\n2 декада - " 
							+ secondDecadeInMonth + "\n3 декада - " + threeDecadeInMonth);
		if (firstDecadeInMonth > secondDecadeInMonth &&
			firstDecadeInMonth > threeDecadeInMonth) {
			System.out.println("Большее количество осадков выпало в первой декаде месяца.");
		} else if (firstDecadeInMonth < secondDecadeInMonth &&
				secondDecadeInMonth > threeDecadeInMonth) {
			System.out.println("Большее количество осадков выпало во второй декаде месяца.");
		} else if (firstDecadeInMonth < threeDecadeInMonth &&
					secondDecadeInMonth < threeDecadeInMonth) {
			System.out.println("Большее количество осадков выпало в третьей декаде месяца.");
		} else if (firstDecadeInMonth == secondDecadeInMonth) {
			System.out.println("Большее количество осадков выпало в первой и во второй декаде месяца.");
		} else if (secondDecadeInMonth == threeDecadeInMonth) {
			System.out.println("Большее количество осадков выпало во второй и в третьей декаде месяца.");
		} else if (firstDecadeInMonth == threeDecadeInMonth) {
			System.out.println("Большее количество осадков выпало в первой и третьей декаде месяца.");
		} else {
			System.out.println("Во все три жекады месяца выпало равное количество осадков.");
		}
		
	}
}