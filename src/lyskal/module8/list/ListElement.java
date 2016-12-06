package lyskal.module8.list;

public class ListElement {
	private ListElement _next;
	private Integer _data;
	
	public ListElement () {}

	public ListElement(final Integer data) {
		_data = data;
	}

	public ListElement getNext() {
		return _next;
	}
	
	public void setNext(final ListElement next) {
		_next = next;
	}
	
	public Integer getData() {
		return _data;
	}
	
	public void setData(final Integer data) {
		_data = data;
	}
	
	
}
