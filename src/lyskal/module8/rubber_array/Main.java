package lyskal.module8.rubber_array;

import java.util.Arrays;

public class Main {

	public static void main(final String[] args) {
		final int size = 15;
		Array array = new Array(size);
		
		for (int i = 0; i < size; i++) {
			array.add((int)(Math.random()*size));
		}
		System.out.println("\nНаш массив: ");
		show(array);
		System.out.println("Размер массива: " + array.size());
		
		int[] secondArray = new int[5];		
		for(int i = 0; i < secondArray.length; i++) {
			secondArray[i] = (int)(Math.random()*size);
		}
		
		System.out.println("\nНовый массив: " + Arrays.toString(secondArray) 
				+ "\nПриклеили к старому, получили: ");
		array.concat(secondArray);
		show(array);
		
		System.out.println("\nДобавили 100 в середину массива: ");
		array.add(100, (array.size()/2));
		show(array);
		
		System.out.println("\nОтсортировали массив по возрастанию: ");
		array.sort(1);
		show(array);
		
		System.out.println("\nУдалили элементы с 4 по 12 индексы: ");
		array.remove(4, 12);
		show(array);
		
		
	}
	
	public static void show(final Array array) {
		for (int i = 0; i < array.size(); i++) {
			System.out.print(array.getElement(i) + " ");
		}
		System.out.println();
	}

}
