package lyskal.module8.wokers.servises;

import java.util.Scanner;

import lyskal.module8.wokers.entities.Worker;
import lyskal.module8.wokers.entities.Workers;

public class Interface {
	
	public static void show(final Workers workers) {
		for (Worker worker : workers.getWorkers()) {
			System.out.println(worker.toString());
		}
	}
	
	public static void welcomeWithUser(final Workers workers){
		System.out.println("To output the database about workers?");
		System.out.println("1. To display all.\n2. Choose whom to display.\n3. No.");
		Scanner scanner = new Scanner(System.in);
		int answer = scanner.nextInt();
		switch (answer) {
		case 1: 
			show(workers);
			break;
		case 2: 
			System.out.print("How many workers to display? ");
			int numbers = scanner.nextInt();
			System.out.print("How many to displace to the database? ");
			int displace = scanner.nextInt();
			show(Database.getWorkers(workers, displace, numbers));
			break;
		}
		scanner.close();
	}
}
