package lyskal.module8.wokers;

public class Interface {
	
	public static void show(final Workers workers) {
		for (Worker worker : workers.getWorkers()) {
			System.out.println(worker.toString());
		}
	}
	
	
}
