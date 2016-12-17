package lyskal.module8.wokers.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The class contains information on the workers of the company.
 * 
 * @author LyskaL
 */
public class Workers {
	private List<Worker> _workers;
	
	public Workers(){
		_workers = new ArrayList<>();
	}
	
	/**
	 * Add the worker to the database.
	 * 
	 * @param worker - whom we add.
	 */
	public void add(final Worker worker) {
		if(worker != null) {
			_workers.add(worker);
		}
	}
	
	/**
	 * Remove the worker to the database.
	 * 
	 * @param worker - whom we remove.
	 */
	public void remove(final Worker worker) {
		if(worker != null) {
			_workers.remove(worker);
		}
	}
	
	/**
	 * Get the list of workers.
	 * 
	 * @return unmodifiable copy of database
	 */
	public List<Worker> getWorkers(){
		return Collections.unmodifiableList(_workers);
	}
	
	/**
	 * Get the list size.
	 * 
	 * @return size of list
	 */
	public int size(){
		return _workers.size();
	}
	
	/**
	 * The sort the database of workers.
	 */
	public void sort(){
		Collections.sort(_workers);
	}
}
