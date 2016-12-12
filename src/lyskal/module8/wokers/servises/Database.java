package lyskal.module8.wokers.servises;

import java.util.Iterator;

import lyskal.module8.wokers.entities.Worker;
import lyskal.module8.wokers.entities.Workers;

/**
 * The class carries out operations over the
 * database of workers.
 * 
 * @author LyskaL
 */
public class Database{
	/**
	 * To get the list with the set displace of
	 * workers and to return it.
	 * 
	 * @param workers - database of workers.
	 * @param displace - shift on base from the beginning.
	 * 
	 * @return new list the found workers.
	 */
	public static Workers getWorkers(final Workers workers, final int displace) {
		return getWorkers(workers, displace, workers.size()-displace);
	}
	
	/**
	 * To get the list with the necessary number of
	 * workers and to return it.
	 * 
	 * @param workers - database of workers.
	 * @param displace - shift on base from the beginning.
	 * @param number - the number of workers for return.
	 * 
	 * @return new list the found workers.
	 */
	public static Workers getWorkers(final Workers workers, int displace, int number) {
		//if negative numbers
		displace = Math.abs(displace);
		number = Math.abs(number);
		//To check exit abroad
		if(displace >= workers.size() && number < workers.size()) {
			displace = workers.size()-number;
		} else if (displace + number >= workers.size()){
			number = workers.size() - displace;
		}
		
		Workers temp = new Workers();
		Iterator<Worker> iterator = workers.getWorkers().listIterator(displace);
		int counter = 0;
		while(number != counter){
			temp.add(iterator.next());
			counter++;
		}
		return temp;
	}

}
