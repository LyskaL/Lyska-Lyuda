package lyskal.module8.associative_array;

public class Main {
	
	public static void main(final String[] args) {
		ElementArray groupBU32 = new ElementArray("BU-32", 10);
		ElementArray groupLaw2 = new ElementArray("Law-2", 5);
		try{
			Student iDenis = new Student("Ivanov", "Denis", "Vasilyevich", "23.03.1990");
			groupBU32.addStudent(iDenis);
		} catch(IllegalArgumentException ae) {
			System.err.println("Данные не валидны!");
		}

		try {
			Student zAlexey = new Student("Zubko", "Alexey", "Petrov", "02.05.1991");
			groupBU32.addStudent(zAlexey);
			groupLaw2.addStudent(zAlexey);
		} catch (IllegalArgumentException ae) {
			System.err.println("Данные не валидны!");
		}

		try {
			Student mMaria = new Student("Makarova", "Maria", "Ivanova", "12.11.1992");
			groupLaw2.addStudent(mMaria);
		} catch (IllegalArgumentException ae) {
			System.err.println("Данные не валидны!");
		}
		AssociativeArray groups = new AssociativeArray(1);
		groups.add(groupBU32);
		groups.add(groupLaw2);
		show(groups);
		groups.search("Law-2").removeStudent("Zubko", "Alexey");
		
		show(groups);
	}
	public static void show(final AssociativeArray groups){
		if(groups != null) {
			System.out.println("Groups: " + groups.size());
			for (int i = 0; i < groups.size(); i++) {
				show(groups.getElementArray(i));
				System.out.println();
			}
			System.out.println("_______________________________________");
		}
	}
	
	public static void show(final ElementArray group) {
		if(group != null) {
			System.out.println("Number group: " + group.getNumber());
			System.out.println("Students in the group: " + group.size());
			for (int i = 0; i < group.size(); i++) {
				System.out.println((i+1) + ". " + group.getStudents(i).toString());
			}
		}
	}
}
