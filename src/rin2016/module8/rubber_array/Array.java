package rin2016.module8.rubber_array;

public class Array {
	private int[] array;
	
	private int size;
	
	public final static int SEARCH_ERROR = -1;
	private final int DEFAULT_SIZE = 5;
	
	public Array() {
		create(DEFAULT_SIZE);
		
	}
	
	public Array(final int size) {
		create(size);
	}
	
	private void create(final int size) {
		if (size >= 0) {
			this.array = new int[size];
			this.size = 0;
		} else {
			this.array = new int[DEFAULT_SIZE];
			this.size = 0;
		}
	}
	
	public int getElement(final int index) {
		if(index <= size && index >= 0) {
			return array[index];
		}
		return Integer.MIN_VALUE;
	}
	
	private int[] getArray() {
		return array;
	}
	
	public int size() {
		return this.size;
	}
	
	/*
	 * Добавляем элемент в конец массива
	 */
	public void add(final int element) {
		this.array[size++] = element;
	}
	
	/*
	 * Добавляем элемент в массив (по индексу)
	 */
	public void add(final int element, final int index) {
		if (index > 0 && index <= size) {
			int sizeArray = array.length-1;
			if (index >= sizeArray) {
				int newSize = array.length * 2;
				newSizeArray(newSize);
			}
			for (int i = size; i >= index; i--) {
				this.array[i + 1] = array[i];
			}
			this.array[index] = element;
			this.size++;
		}
	}
	
	
	
	private int[] copy(final int[] firstArray, 
			final int[] secondArray, final int size) {
		if (secondArray.length != 0) {
			int counter = 0;
			for (int i = 0; i < size; i++) {
				firstArray[i] = secondArray[counter++];
			}
		}
		return firstArray;
	}
	
	private void newSizeArray(final int newSize) {
		int[] result = new int[newSize];
		if(newSize >= this.size) {
			this.array = copy(result, array, this.size);
		} else {
			this.array = copy(result, array, newSize);
		}
	}
	
	/*
	 * Метод возвращает индекс найденного элемента,
	 * или возвращает -1, если такого элемента в массиве нет.
	 */
	public int getIndex(final int element) {
		for (int i = 0; i < this.size; i++) {
			if(array[i] == element) {
				return i;
			}
		}
		return SEARCH_ERROR;
	}
	
	/*
	 * Удаляем из массиве все element
	 */
	public void removeAllElements(final int element) {
		int index = getIndex(element);
		if (index != SEARCH_ERROR) {
			for (int i = index; i < this.size; i++) {
				if (array[i] == element) {
					remove(i);
					i--;
				}
			}
		}
	}

	public void remove(final int index) {
		if(index < size) {
			for (int i = index; i < size-1; i++) {
				array[i] = array[i+1];
			}
			this.size--;
		}
	}
	
	/*
	 * Удаляем элементы из массива с первого 
	 * по второй индекс (не включая его).
	 */
	public void remove(final int fIndex, final int sIndex) {
		if (fIndex >= 0 && sIndex >= 0 
				&& fIndex < this.size && sIndex < this.size) {
			int temp = sIndex - fIndex;
			for (int i = fIndex; i < size-temp; i++) {
				array[i] = array[i+temp];
			}
			this.size -= temp;
		}
	}
	
	public void remove(final int[] sArray) {
		if (sArray != null) {
			int index = getIndex(sArray[0]);
			int counter = 0;
			if (index != SEARCH_ERROR) {
				for (int i = index; i < size; i++) {
					if (array[i] == sArray[counter]) {
						counter++;
						int sIndex = findLastIndex(sArray, i, counter);
						if (sIndex != SEARCH_ERROR) {
							remove(i, sIndex);
							counter = 0;
							i--;
						}
					}
				}
			}
		}
	}
	
	public void concat(final Array secondArray) {
		concat(secondArray.getArray());
	}
	
	public void concat(final int[] secondArray) {
		if(secondArray != null) {
			int newLength = size + secondArray.length;
			int index = size;
			int counter = 0;
			
			if(newLength >= this.array.length) {
				newSizeArray(newLength*2);
			}
			
			this.size += secondArray.length;
			for (int i = index ; i < size; i++) {
				array[i] = secondArray[counter++];
			}
		}
	}
	
	/*
	 * Находим подмассив в массиве и возвращаем индекс последнего элемента.
	 * Если подмассив не найден вернёт -1.
	 */
	private int findLastIndex(final int[] sArray, final int index, int counter) {
		if (sArray != null){
			for (int j = index+1; j < size+1; j++) {
				if(counter == sArray.length) {
					return index+counter;
				} else {
					if(array[j] == sArray[counter]) {
						counter++;
					} else {
						return SEARCH_ERROR;
					}
				}
			}
		}
		return SEARCH_ERROR;
	}
	
	/*
	 * Метод выполняет сортировку массива.
	 * 
	 * Если в метод передать 1, то сортирует по возрастанию.
	 * Если в метод передать (-1), то сортирует по убыванию.
	 */
	public void sort(final int arg) {
		for(int i = 0; i < size; i++){
			for (int j = size-1; j > i; j--) {
				if(arg == 1) {
					if (array[i] > array[j]) {
						swap(i, j);
					}
				}
				if (arg == -1) {
					if ((array[i] < array[j])) {
						swap(i, j);
					}
				}
			}
		}
	}
	
	private void swap(final int fIndex, final int sIndex) {
		int temp = array[fIndex];
		array[fIndex] = array[sIndex];
		array[sIndex] = temp;
	}
}
