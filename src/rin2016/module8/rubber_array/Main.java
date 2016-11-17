package rin2016.module8.rubber_array;

public class Main {

	public static void main(final String[] args) {
		final int size = 10;
		Array array = new Array(size);
		
		for (int i = 0; i < array.length(); i++) {
			array.add((int)(Math.random()*size), i);
		}
		array.show();
		System.out.println("Размер массива: " + array.length());
		
		int[] secondArray = new int[size];
		for(int i = 0; i < size; i++) {
			secondArray[i] = (int)(Math.random()*size);
		}
		array.concat(secondArray);
		array.show();
		
		array.sort(1);
		array.show();
		array.removeAllElements(array.getElement(0));
		array.show();
		
		
	}

}
