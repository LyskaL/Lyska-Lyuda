package lyskal.module8.wokers;

import lyskal.module8.wokers.entities.Worker;
import lyskal.module8.wokers.entities.WorkerOnRate;
import lyskal.module8.wokers.entities.WorkerWithHourlyPay;
import lyskal.module8.wokers.entities.Workers;
import lyskal.module8.wokers.servises.Interface;

public class Main {

	public static void main(final String[] args) {
		Worker petya = new WorkerWithHourlyPay("Ivanov Petya", "13.05.2000", Worker.TRAINEE, 10);
		Worker irina = new WorkerOnRate("Malinina Irina", "20.11.1990", "lawyer", 5500);
		Worker mikola = new WorkerOnRate("Larin Mikola", "02.02.1992", "accountant", 3000);
		Worker alex = new WorkerOnRate("Denisko Alex", "29.08.1992", "cook", 3000);
		Worker max = new WorkerWithHourlyPay("Korol Maxim", "05.04.1994", "seller", 14);
		
		Workers workers = new Workers();
		workers.add(irina);
		workers.add(petya);
		workers.add(alex);
		workers.add(mikola);
		workers.add(max);
		workers.sort();
		Interface.welcomeWithUser(workers);
	}
}
