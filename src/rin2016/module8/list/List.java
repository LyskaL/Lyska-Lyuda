package rin2016.module8.list;

/**
 * Односвязным списком называют набор элементов, 
 * каждый из которых содержит собственно полезные 
 * данные, и ссылку на следующий элемент. Создать 
 * такой список и реализовать для него CRUD операции.
 * 
 * @author Люся
 *
 */

public class List {
	private ListElement _head;
	private ListElement _tail;
	
	private int _size;
	private static final int SEARCH_ERROR = -1;
	
	public List() {}
	
	/**
	 * Добавляем элемент в конец списка
	 * Для добавления элемента в список, 
	 * он не должен быть равен null.
	 * 
	 * @param data - информация для добавления.
	 */
	public void add(final Integer data) {
		if(data != null) {
			ListElement temp = new ListElement(data);
			if(_tail == null) {
				_head = temp;
				_tail = temp;
			} else {
				_tail.setNext(temp);
				_tail = temp;
			}
			_size++;
		}
	}
	
	/**
	 * Добавляем элемент в список по индексу.
	 * 
	 * @param data - информация для добавления.
	 * @param index - куда вставляем элемент в список. 
	 */
	public void add(final Integer data, final int index) {
		if (data != null) {
			ListElement result = new ListElement(data);
			if (index > 0 && index < _size && data != null) {
				ListElement prev = findElement(index - 1);
				ListElement next = findElement(index);

				prev.setNext(result);
				result.setNext(next);
				_size++;
			} else if (index == _size) {
				//Добавляем в конец списка и выходим из метода
				add(data);
				return;
			} else if (index == 0) {
				//Добавляем в начало списка
				result.setNext(_head);
				_head = result;
				_size++;
			}
		}
	}
	
	/**
	 * Найти элемент в списке по индексу и вернуть его.
	 * 
	 * @param index - индекс элемента для поиска.
	 * @return 
	 * - найденный элемент;
	 * - null, если элемента с таким индексом нет.
	 */
	private ListElement findElement(final int index) {
		if (index >= 0 && index < _size) {
			ListElement temp = _head;
			int counter = 0;
			while(temp != null) {
				if(counter == index) {
					return temp;
				}
				counter++;
				temp = temp.getNext();
			}
		}
		return null;
	}
	
	/**
	 * Найти индекс элемента в списке по значению.
	 * Метод находит индекс только первого совпадения.
	 * 
	 * @param data - значение элемента.
	 * @return 
	 * - индекс найденного элемента;
	 * - -1, если элемент не найден.
	 */
	public int findIndexElement(final Integer data) {
		if (data != null) {
			ListElement temp = _head;
			int counter = 0;
			while(temp != null) {
				if(data == temp.getData()) {
					return counter;
				}
				counter++;
				temp = temp.getNext();
			}
		}
		return SEARCH_ERROR;
	}
	
	/**
	 * Изменяем данные в списке по индексу элемента.
	 * 
	 * @param data - новые данные для записи.
	 * @param index - индекс элемента 
	 * в который мы записываем новые данные.
	 */
	public void setElement(final Integer newData, final int index) {
		if(newData!=null){
			ListElement temp = findElement(index);
			if(temp!= null) {
				temp.setData(newData);
			}
		}
	}
	
	/**
	 * Возвращаем данные элемента по индексу.
	 * 
	 * @param index - индекс элемента.
	 * @return 
	 * - начение найденого элемента.
	 * - null,eсли элемент в списке не найден.
	 */
	public Integer getElement(final int index) {
		if(_size > 0) {
			if(index >= 0 && index < _size) {
				ListElement temp = findElement(index);
				return temp.getData();
			}
		}
		return null;
	}
	
	/**
	 * Метод удаляет элемент списка по индексу.
	 * 
	 * @param index - индекс элемента для удаления
	 */
	public void delete(final int index) {
		if (_size > 0) {
			if (index >= 0 && index < _size) {
				if (_size == 1) {
					//Если в списке только один элемент,
					//то обнуляем все значения
					_head = null;
					_tail = null;
					_size = 0;
					return;
				} else if (index == 0 && index != _size - 1) {
					//Если индекс равен первому элементу списка,
					//то head-у присваиваем сл.элемент списка 
					_head = findElement(index + 1);
				} else if (index == _size - 1) {
					//Если индекс равен последнему элементу списка,
					//то tail-у присваеваем предыдущий элемент
					_tail = findElement(_size - 1);
				} else {
					//Если элемент в середине списка, то полю next
					//предыдущего элемента присваеваем ссылку на следующий.
					ListElement prev = findElement(index - 1);
					ListElement next = findElement(index + 1);
					prev.setNext(next);
				}
				_size--;
			}
		}
	}

	/**
	 * Выводим информацию списка на консоль.
	 */
	public void printList () {
		if(_size > 0){
			ListElement temp = _head;
			while (temp != null) {
				System.out.print(temp.getData() + " ");
			}
			System.out.println();
		}
	}
	
	public int size() {
		return _size;
	}
	
}
