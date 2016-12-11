package lyskal.module8.wokers;

public class Main {

	public static void main(final String[] args) {
		Worker petya = new WorkerWithHourlyPay("Petya Ivanov", "13.05.2000", Worker.TRAINEE, 10);
		Worker irina = new WorkerOnRate("Irina Malinina", "20.11.1990", "lawyer", 5500);
		
		System.out.println(petya.toString());
		System.out.println(irina.toString());
	}

}
