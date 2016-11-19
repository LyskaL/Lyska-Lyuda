package rin2016.module8.readers_of_library;

public class ListReaders {
	private Reader[] readers;
	
	private int size;
	private final static int DEFAULT_SIZE = 1;
	
	public ListReaders() {
		this(DEFAULT_SIZE);
	}
	
	public ListReaders(final int sizeList) {
		int size = sizeList;
		if(size <= 0) {
			size = DEFAULT_SIZE;
		}
		readers = new Reader[size];
		this.size = 0;
	}

	private String generateNumberOfLibraryCard() {
		String number = String.valueOf((int)(Math.random()*(999999-100000))+100000);
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				//Проверяем, чтобы не сгенирировался номер, который уже
				//присвоен одному из читателей
				if (readers[i].getNumberOfLibraryCard().compareTo(number) == 0) {
					generateNumberOfLibraryCard();
				}
			}
		}
		return number;
	}
	
	public Reader getReader(final int index) {
		if (index >= 0 && index < size && size != 0) {
			return readers[index];
		}
		return null;
	}

	public void addReader(final String lastName, final String firstName, 
			final String middleName, final String birthDate) {
		if(size > 0) {
			for (int i = 0; i < size; i++) {
				if(equalReaders(readers[i], lastName, firstName, middleName, birthDate)) {
					return;
				}
			}
		}
		if(size >= readers.length-1) {
			changeSizeOfArray(readers, readers.length*2);
		}
		readers[size] = new Reader(lastName, firstName, middleName, birthDate);
		readers[size].setNumber(generateNumberOfLibraryCard());
		size++;
	}
	
	private boolean equalReaders(final Reader reader, final String lastName, 
			final String firstName, final String middleName, final String birthDate) {
		if(reader.getLastName().compareTo(lastName) == 0 
				&& reader.getFirstName().compareTo(firstName) == 0 
				&& reader.getMiddleName().compareTo(middleName) == 0
				&& reader.getBirthDate().compareTo(birthDate) == 0) {
				return true;
			} else {
				return false;
			}
	}
	
	private void changeSizeOfArray(final Reader[] copyReaders, final int newSize) {
		Reader[] result = new Reader[newSize];
		if(newSize >= readers.length) {
			readers = copy(result, readers.length);
		} else {
			readers = copy(result, newSize);
		}
	}

	private Reader[] copy(final Reader[] newReaders, final int newSize) {
		for (int i = 0; i < newSize; i++) {
			newReaders[i] = readers[i];
		}
		return newReaders;
		
	}

	public void addReader(final Reader reader) {
		if (reader != null) {
			addReader(reader.getLastName(), reader.getFirstName(),
					reader.getMiddleName(), reader.getBirthDate());
			if(size > 0) {
				readers[size-1].setFaculty(reader.getFaculty());
				readers[size-1].setPhoneNumber(reader.getPhoneNumber());
			} else {
				readers[size].setFaculty(reader.getFaculty());
				readers[size].setPhoneNumber(reader.getPhoneNumber());
			}
		}
	}
	
	public int size() {
		return size;
	}

	public ListReaders search(final String lastName) {
		ListReaders temp = new ListReaders();
		for (int i = 0; i < size; i++) {
			if(readers[i].getLastName().compareTo(lastName) == 0) {
				temp.addReader(readers[i]);
				
			}
		}
		if (temp.size() > 0) {
			return temp;
		} else {
			return null;
		}
	}
}