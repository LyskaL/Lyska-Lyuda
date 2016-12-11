package lyskal.module8.wokers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Workers {
	private List<Worker> _workers;
	
	public Workers(){
		_workers = new ArrayList<>();
	}
	
	public void add(final Worker worker) {
		if(worker != null) {
			_workers.add(worker);
		}
	}
	
	public void remove(final Worker worker) {
		if(worker != null) {
			_workers.remove(worker);
		}
	}
	
	public List<Worker> getWorkers(){
		return Collections.unmodifiableList(_workers);
	}
	
	public int size(){
		return _workers.size();
	}
	
	public void sort(){
		Collections.sort(_workers);
	}
}
