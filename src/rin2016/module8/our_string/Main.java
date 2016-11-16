package rin2016.module8.our_string;

public class Main {

	public static void main(final String[] args) {
		LineChars string = new LineChars("Только он сам");
		System.out.print("Изначальная строка: ");
		string.show();
		System.out.println("Размер строки: " + string.length());
		string.concat(" виноват в своих ошибках.");
		string.show();
		String delete = "сам";
		string.remove(delete);
		string.show();
		
	}

}
