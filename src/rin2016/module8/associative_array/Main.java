package rin2016.module8.associative_array;

public class Main {
	
	public static void main(final String[] args) {
		Group bu32 = new Group("BU-32");
		try{
			Student iDenis = new Student("Ivanov", "Denis", "Vasilyevich", "23.03.1990");
			bu32.addStudent(iDenis);
		} catch(IllegalArgumentException ae) {
			System.err.println("Данные не валидны!");
		}

		try {
			Student zAlexey = new Student("Zubko", "Alexey", "Petrov", "02.05.1991");
			bu32.addStudent(zAlexey);
		} catch (IllegalArgumentException ae) {
			System.err.println("Данные не валидны!");
		}

		try {
			Student mMaria = new Student("Makarova", "Maria", "Ivanova", "12.11.1992");
			bu32.addStudent(mMaria);
		} catch (IllegalArgumentException ae) {
			System.err.println("Данные не валидны!");
		}
		
		show(bu32);
	}
	
	public static void show(final Group group) {
		if(group != null) {
			System.out.println("Number group: " + group.getNumber());
			System.out.println("Students in the group: " + group.size());
			for (int i = 0; i < group.size(); i++) {
				System.out.println((i+1) + ". " + group.getStudents(i).toString());
			}
		}
	}
}
