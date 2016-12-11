package lyskal.module8.wokers;

import java.util.Iterator;

public class Database{

	public static Workers getWorkers(final Workers workers, final int displace) {
		return getWorkers(workers, displace, workers.size()-displace);
	}

	public static Workers getWorkers(final Workers workers, int displace, int numbers) {
		//if negative numbers
		displace = Math.abs(displace);
		numbers = Math.abs(numbers);
		//To check exit abroad
		if(displace >= workers.size() && numbers < workers.size()) {
			displace = workers.size()-numbers;
		} else if (displace + numbers >= workers.size()){
			numbers = workers.size() - displace;
		}
		
		Workers temp = new Workers();
		Iterator<Worker> iterator = workers.getWorkers().listIterator(displace);
		int counter = 0;
		while(numbers != counter){
			temp.add(iterator.next());
			counter++;
		}
		return temp;
	}

}
