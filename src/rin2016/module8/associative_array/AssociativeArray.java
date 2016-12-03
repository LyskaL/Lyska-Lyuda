package rin2016.module8.associative_array;

public class AssociativeArray {
	ElementArray[] _groups;
	private int _size;
	private static final int DEFAULT_SIZE = 10;
	private static final int SEARCH_ERROR = -1;
	
	public AssociativeArray(int counterGroups) {
		if(counterGroups <= 0){
			counterGroups = DEFAULT_SIZE;
		} 
		_groups = new ElementArray[counterGroups];
	}
	
	public void add(final ElementArray group) {
		if(_size >= _groups.length) {
			_groups = increaseSize();
		}
		_groups[_size] = group.getCopyElementArray();
		_size++;
	}
	
	private ElementArray[] increaseSize() {
		ElementArray[] temp = new ElementArray[_groups.length+10];
		for (int i = 0; i < _size; i++) {
			temp[i] = _groups[i];
		}
		return temp;
	}
	
	public ElementArray search(final String key) {
		int index = searchIndexElement(key);
		if(index != SEARCH_ERROR){
			return _groups[index];
		}
		return null;
	}
	
	private int searchIndexElement(final String key) {
		if(key != null){
			for (int i = 0; i < _size; i++) {
				if(key.equals(_groups[i].getNumber())) {
					return i;
				}
			}
		}
		return SEARCH_ERROR;
	}
	
	public void remove(final String key) {
		int index = searchIndexElement(key);
		if(index != SEARCH_ERROR){
			for (int i = index; i < _size; i++) {
				_groups[i] = _groups[i+1];
			}
			_size--;
		}
	}
	
	public int size(){
		return _size;
	}
	
	public ElementArray getElementArray(final int index){
		if(index >= 0 && index < _size){
			return _groups[index];
		}
		return null;
	}
}
