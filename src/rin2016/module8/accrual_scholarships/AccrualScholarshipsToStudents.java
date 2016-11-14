package rin2016.module8.accrual_scholarships;

public class AccrualScholarshipsToStudents {

	public static void main(final String[] args) {
		final int SIZE = 5;
		Student[] students = new Student[SIZE];
		students[0] = new Student("Людмила", "Лыска", "Юрьевна", 30);
		students[1] = new Student("Юрий", "Ющенко", "Витальевич", 5);
		students[2] = new Student("Ирина", "Герасименко", "Игоревна", 5);
		students[3] = new Student("Петр", "Самсонов", "Александрович", 30);
		students[4] = new Student("Лариса", "Ющенко", "Витальевна", 8);
		
		generateEvaluations(students);
		showStudents(students);
	}
	
	/*
	 * Выводим на экран информацию о студентах переданных в массиве - students
	 */
	public static void showStudents(final Student[] students) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				System.out.print(i+1 + ". ");
				students[i].show();
				System.out.println();
			}
		}
	}
	
	/*
	 * Генерируем количестов оценок у каждого ученика (диапазон: от 3 до 5).
	 * Генерируем оценки студентов (диапазон: от 3 до 5) и записываем их в массив.
	 */
	public static void generateEvaluations (final Student[] students) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				// Генерируем оценки в диапазоне от минимального до максимального количества экзаменов
				int counter = (int)(Math.random() * 
						(Student.MAX_NUMBER - (Student.MIN_NUMBER-1))) 
						+ Student.MIN_NUMBER;
				for (int j = 0; j < counter; j++) {
					students[i].setEvaluation((int)(Math.random() * 
							(Student.MAX_NUMBER - (Student.MIN_NUMBER-1))) 
							+ Student.MIN_NUMBER);
				}
			}
		}
	}
}
