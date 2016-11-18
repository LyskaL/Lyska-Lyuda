package rin2016.module8.rubber_array;

public class Array {
	private int[] array;
	private int size;
	private int length;
	
	public final int SEARCH_ERROR = -1;
	
	public Array() {
		create(0);
		
	}
	
	public Array(final int size) {
		create(size);
	}
	
	private void create(final int size) {
		if (size >= 0) {
			this.array = new int[size];
			this.size = size;
			this.length = size;
		} else {
			this.array = new int[0];
			this.size = 0;
			this.length = 0;
		}
	}
	
	public int getElement(final int index) {
		if(index <= length && index >= 0) {
			return array[index];
		}
		return Integer.MIN_VALUE;
	}
	
	private int[] getArray() {
		return array;
	}
	
	public int length() {
		return this.length;
	}
	
	/*
	 * Добавляем элемент в конец массива
	 */
	public void add(final int element) {
		add(element, length);
	}
	
	/*
	 * Добавляем элемент в массив (по индексу)
	 */
	public void add(final int element, final int index) {
		if (index >= this.size) {
			int newSize = length*2;
			
			newSizeArray(newSize);
			this.array[index] = element;
		} else if (index >= array.length && index < this.size) {
			this.length++;
			this.array[index] = element;
		} else if(index < array.length && index >= 0) {
			this.array[index] = element;
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
		this.size = newSize;
		if(newSize >= length) {
			this.array = copy(result, array, length);
		} else {
			this.array = copy(result, array, newSize);
		}
	}
	
	/*
	 * Метод возвращает индекс найденного элемента,
	 * или возвращает -1, если такого элемента в массиве нет 
	 */
	public int getIndex(final int element) {
		for (int i = 0; i < length; i++) {
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
			for (int i = index; i < length; i++) {
				if (array[i] == element) {
					remove(i);
					i--;
				}
			}
		}
	}

	public void remove(final int index) {
		for (int i = index; i < length-1; i++) {
			array[i] = array[i+1];
		}
		this.length--;
	}
	
	/*
	 * Удаляем элементы из массива с первого 
	 * по второй индекс (не включая его).
	 */
	public void remove(final int fIndex, final int sIndex) {
		int temp = sIndex - fIndex;
		for (int i = fIndex; i < array.length-temp; i++) {
			array[i] = array[i+temp];
		}
		this.length -= temp;
	}
	
	public void remove(final int[] sArray) {
		int index = getIndex(sArray[0]);
		int counter = 0;
		if (index != SEARCH_ERROR) {
			for (int i = index; i < array.length; i++) {
				if(array[i] == sArray[counter]) {
					counter++;
					int sIndex = findLastIndex(sArray, i, counter);
					if(sIndex != SEARCH_ERROR) {
						remove(i, sIndex);
						counter = 0;
						i--;
					}
				}
			}
			
		}
	}
	
	public void concat(final Array secondArray) {
		concat(secondArray.getArray());
	}
	
	public void concat(final int[] secondArray) {
		int newLength = length + secondArray.length;
		int index = length;
		int counter = 0;
		
		if(newLength >= this.size) {
			newSizeArray(newLength*2);
		}
		
		this.length += secondArray.length;
		for (int i = index ; i < length; i++) {
			array[i] = secondArray[counter++];
		}
	}
	
	/*
	 * Находим подмассив в массиве и возвращаем индекс последнего элемента.
	 * Если подмассив не найден вернёт -1.
	 */
	private int findLastIndex(final int[] sArray, final int index, int counter) {
		for (int j = index+1; j < length+1; j++) {
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
		return SEARCH_ERROR;
	}
	
	/*
	 * Метод выполняет сортировку массива.
	 * 
	 * Если в метод передать 1, то сортирует по возрастанию.
	 * Если в метод передать (-1), то сортирует по убыванию.
	 */
	public void sort(final int arg) {
		for(int i = 0; i < length; i++){
			for (int j = length-1; j > i; j--) {
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
