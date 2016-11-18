package rin2016.module8.rubber_array;

import java.util.Arrays;

public class Main {

	public static void main(final String[] args) {
		final int size = 10;
		Array array = new Array(size);
		
		for (int i = 0; i < array.length(); i++) {
			array.add((int)(Math.random()*size), i);
		}
		System.out.println("\nНаш массив: ");
		show(array);
		System.out.println("Размер массива: " + array.length());
		
		int[] secondArray = new int[size];
		for(int i = 0; i < size; i++) {
			secondArray[i] = (int)(Math.random()*size);
		}
		
		System.out.println("\nНовый массив: " + Arrays.toString(secondArray) 
				+ "\nПриклеили к старому, получили: ");
		
		array.concat(secondArray);
		show(array);
		
		System.out.println("\nОтсортировали массив по возрастанию: ");
		array.sort(1);
		show(array);
		
		System.out.println("\nУдалили элементы с 1 по 10 индексы: ");
		array.remove(1, 10);
		show(array);
		
		
	}
	
	public static void show(final Array array) {
		for (int i = 0; i < array.length(); i++) {
			System.out.print(array.getElement(i) + " ");
		}
		System.out.println();
	}

}
