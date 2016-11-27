package rin2016.module8.readers_of_library;

public class MainReaders {

	public static void main(final String[] args) {
		ListReaders list = new ListReaders(5);
		list.addReader("Лыска", "Людмила", "Юрьевна", "13.04.1993");
		list.getReader(list.size()-1).setFaculty("Компьютерных технологий");
		list.getReader(list.size()-1).setPhoneNumber("+380631000703");
		
		list.addReader("Ищенко", "Денис", "Петрович", "18.11.1991");
		list.getReader(list.size()-1).setFaculty("Юридический");
		
		
		list.addReader("Ищенко", "Юлия", "Петровна", "10.01.1996");
		list.getReader(list.size()-1).setFaculty("Юридический");
		list.getReader(list.size()-1).setPhoneNumber("+38097435591");
		
		
		showList(list);
		System.out.println("Нашли читателя: ");
		showList(list.search("Ищенко"));
	}

	public static void showList(final ListReaders list) {
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				if (list.getReader(i) != null) {
					System.out.println(i + 1 + ".");
					showReader(list.getReader(i));
				}
			}
		}
	}
	
	public static void showReader(final Reader reader) {
		if (reader != null) {
			System.out.println(reader.getLastName() 
					+ " " + reader.getFirstName() 
					+ " " + reader.getMiddleName() 
					+ "\nбилет №"+ reader.getNumberOfLibraryCard()
					+ "\nфакультет: " + reader.getFaculty()
					+ "\nтелефон:" + reader.getPhoneNumber());
			System.out.println();
		}
	}
}
