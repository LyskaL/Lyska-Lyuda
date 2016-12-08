package rin2016.module8.associative_array;

public class ElementArray {
	
	private String _numberGroup;
	private Student[] _students;
	private int _size;
	
	private static final int DEFAULT_SIZE_GROUP = 30;
	private static final int SEARCH_ERROR = -1;
	
	public ElementArray(final String numberGroup) {
		init(numberGroup, DEFAULT_SIZE_GROUP);
	}
	
	public ElementArray(final String numberGroup, final int sizeGroup) {
		init(numberGroup, sizeGroup);
	}
	
	public ElementArray(final int sizeGroup) {
		init("", sizeGroup);
	}
	
	private void init(String number, int sizeGroup) {
		if(number == null || "".equals(number)) {
			number = "00_00";
		}
		if (sizeGroup <= 0) {
			sizeGroup = DEFAULT_SIZE_GROUP;
		}
		_numberGroup = number;
		_students = new Student[sizeGroup];
	}
	
	public String getNumber() {
		return _numberGroup;
	}

	public Student getStudents(final int index) {
		if(index >= 0 && index < _size) {
			return _students[index];
		}
		return null;
	}

	public void addStudent(final Student student) {
		if(student != null) {
			if(_size < DEFAULT_SIZE_GROUP) {
				_students[_size] = student.getCopyStudent();
				_size++;
				sort();
			}
		} else {
			throw new IllegalArgumentException("Не валидные данные!");
		}
	}
	
	public int size(){
		return _size;
	}
	
	public int findStudent(final String lastName, final String firstName) {
		if(lastName != null && firstName != null) {
			for (int i = 0; i < _size; i++) {
				if(_students[i].getLastName().compareTo(lastName) == 0 &&
				   _students[i].getFirstName().compareTo(firstName) == 0) {
					return i;
				}
			}
		}
		return SEARCH_ERROR;
	}
	
	public void removeStudent(final String lastName, final String firstName) {
		int index = findStudent(lastName, firstName);
		if(index != SEARCH_ERROR) {
			for (int i = index; i < _size-1; i++) {
				_students[i] = _students[i+1];
			}
			_size--;
		}
	}

	private void sort() {
		for (int i = 0; i < _size; i++) {
			for(int j = _size-1; j > i; j--) {
				int temp = _students[i].getLastName().compareTo(_students[j].getLastName());
				if(temp > 0) {
					swap(i,j);
				}
			}
		}
	}
	
	private void swap(final int indexFirstEl, final int indexSecondEl) {
		if(indexFirstEl >= 0 && indexFirstEl < _size &&
		   indexSecondEl >= 0 && indexSecondEl < _size) {
			Student temp = _students[indexSecondEl];
			_students[indexSecondEl] = _students[indexFirstEl];
			_students[indexFirstEl] = temp;
		}
	}
	
	public ElementArray getCopyElementArray() {
		ElementArray temp = new ElementArray(_numberGroup, DEFAULT_SIZE_GROUP);
		for (int i = 0; i < _size; i++) {
			temp.addStudent(_students[i].getCopyStudent());
		}
		return temp;
	}
}