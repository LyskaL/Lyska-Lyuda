package rin2016.module8.our_string;

public class LineChars {
	private char[] array;
	private int length;
	
	
	public LineChars() {
		array = new char[]{};
		length = 0;
	}
	
	public LineChars(final int size) {
		array = createArrayChars(size);
		length = size;
	}
	
	public LineChars(final String string) {
		array = createArrayChars(string.length());
		copy(array, string.toCharArray(), string.length());
	}
	
	private char[] createArrayChars(final int SIZE) {
		length = SIZE;
		return new char[SIZE];
	}
	
	public void show() {
		for (int i = 0; i < length; i++) {
			System.out.print(array[i]);
		}
		System.out.println();
	}
	
	public char[] getLine() {
		return array;
	}
	
	public int length() {
		return length;
	}
	
	private char[] copyInArrayWithNewSize(final int newSize) {
		char[] result = new char [newSize];
		if (length <= newSize) {
			copy(result, array, length);
		} else {
			copy(result, array, newSize);
		}
		return result;
	}
	
	private void concat(final char[] string, final int sizeString) {
		int newSize = length+sizeString;
		char[] result = copyInArrayWithNewSize(length+sizeString);
		
		int counter = 0;
		for (int i = length; i < newSize; i++) {
			result[i] = string[counter++];
		}
		this.array = result;
		this.length += sizeString;
	}
	
	public void concat(final String string) {
		concat(string.toCharArray(), string.length());
	}
	
	public void concat(final LineChars string) {
		concat(string.getLine(), string.length());
	}
	
	/*
	 * newArray - массив символов, который мы копируем;
	 * array - массив куда копируем символы;
	 * size - количество копируемых сиволов, которые мы копируем из 1 во 2 массив
	 */
	private void copy(final char[] array, final char[] newArray, final int size) {
		for (int i = 0; i < size; i++) {
			array[i] = newArray[i];
		}
	}
	
	public int compare(final LineChars string) {
		return compare(string.getLine(), string.length());
	}
	
	public int compare(final String string) {
		return compare(string.toCharArray(), string.length());
	}
	
	/*
	 * Сравнение строк, возвращает:
	 * 1 - если наша строка больше пришежшей;
	 * 0 - если строки равны;
	 * -1 - если наша строка меньше пришедшей. 
	 */
	private int compare(final char[] string, final int size) {
		if (size == length) {
			for (int i = 0; i < length; i++) {
				if (array[i] < string[i]) {
					return 1;
				} else if (array[i] > string[i]){
					return -1;
				}
			}
			return 0;
		} else if (size > length) {
			return 1;
		} else {
			return -1;
		}
	}
	
	public void remove(final LineChars string) {
		remove(string.getLine(), string.length());
	}
	
	/*
	 * Метод удаляет из строки все подстроки string.
	 */
	public void remove(final String string) {
		remove(string.toCharArray(), string.length());
	}

	private void remove(final char[] string, final int size) {
		if (index(string[0]) != -1) {
			int fIndex = 0; // с какого индекса будет удалятся строка
			int sIndex = 0; // по какой индекс
			int counter = 0;
			for (int i = index(string[0]); i < length; i++) {
				if(array[i] == string[counter]) {
					counter++;
					fIndex = i; 
					sIndex = findLastIndexString(string, size, i);
					if (sIndex != -1) {
						remove(fIndex, sIndex);
					}
					fIndex = 0;
					sIndex = 0;
					counter = 0;
				}
			}
			removeExtraSpaces();
		}
	}
	
	/*
	 * Метод возвращает индекс символа (его первое вхождение)
	 * Если такого символа нет возвращает -1.
	 */
	public int index(final char element) {
		for (int i = 0; i < length; i++) {
			if(array[i] == element) {
				return i;
			}
		}
		return -1;
	}
	
	
	/*
	 * Метод удаляет подстроку с первого индекса(fIndex)
	 * по второй (sIndex) - не включая его.
	 */
	public void remove(final int fIndex, final int sIndex) {
		int counter = sIndex;
		int newSize = length-(sIndex-fIndex);
		for(int i = fIndex; i < newSize; i++) {
			array[i] = array[counter++];
		}
		this.array = copyInArrayWithNewSize(newSize);
		this.length = newSize;
	}
	
	/*
	 * char[] string - слово, которое мы ищем в нашей строке
	 * int index - индекс, с которого мы продолжаем поиск
	 * int size - длина удаляемого слова
	 * 
	 * Возвращаем индекс последнего символа удаляемого слова в нашей строке,
	 * или возвращаем -1, если слово не совпало.
	 */
	private int findLastIndexString(final char[] string, final int size, final int index) {
		int counter = 1;
		for (int j = index+1; j < length; j++) {
			if(counter == size) {
				return index+size;
			} else {
				if(array[j] == string[counter]) {
					counter++;
				} else {
					return -1;
				}
			}
		}
		return -1;
	}
	
	/*
	 * Если в строке идёт больше одного пробела подряд,
	 * то все лишние метод удалит, оставив только один.
	 */
	public void removeExtraSpaces() {
		int counter = 0;
		if (index(' ') != -1) {
			for (int i = index(' '); i < length-1-counter; i++) {
				if(array[i] == ' ' && array[i+1] == ' ') {
					for (int j = i; j < length-1; j++) {
						array[j] = array[j+1];
					}
					counter++;
				}
			}
			this.array = copyInArrayWithNewSize(length-counter);
			this.length = length-counter;
		}
	}
}
