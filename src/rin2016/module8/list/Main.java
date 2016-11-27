package rin2016.module8.list;

public class Main {

	public static void main(final String[] args) {
		final int SIZE = 10;
		List list = new List();
		for (int i = 0; i < SIZE; i++) {
			list.add(i+1);
		}
		System.out.println("Создаём список, добавляя в цикле элементы в конец: ");
		printList(list);
		System.out.println("Размер массива: " + list.size() + "\n");
		
		System.out.println("Добавляем 100 в середину списка: ");
		list.add(100, list.size()/2);
		printList(list);
		System.out.println("Размер массива: " + list.size() + "\n");
		
		System.out.println("Удаляем 0 элемент из списка: ");
		list.delete(0);
		printList(list);
		System.out.println("Размер массива: " + list.size() + "\n");
		
		System.out.println("Удаляем последний элемент из списка: ");
		list.delete(list.size()-1);
		printList(list);
		System.out.println("Размер массива: " + list.size() + "\n");
		
		System.out.println("Найти в списке элемент со значением 100 и удалить его: ");
		list.delete(list.findIndexElement(100));
		printList(list);
		System.out.println("Размер массива: " + list.size() + "\n");
		
		System.out.println("Изменим значение элемента c индексом 5 в списке на 99: ");
		list.setElement(99, 5);
		printList(list);
		System.out.println("Размер массива: " + list.size() + "\n");
		
		System.out.println("Запускаем цикл на кол-во элементов в списке и удаляем их все: ");
		for (int i = 0; i < list.size(); i++) {
			list.delete(i);
			i--;
		}
		System.out.println("Размер массива: " + list.size() + "\n");
	}
	
	
	/**
	 * Выводим информацию списка на консоль.
	 */
	public static void printList(final List list) {
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.getElement(i) + " ");
			}
			System.out.println();
		}
	}
}
