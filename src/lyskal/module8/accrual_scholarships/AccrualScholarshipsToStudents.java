package lyskal.module8.accrual_scholarships;

public class AccrualScholarshipsToStudents {
	final static int FIRST_GROUP = 1;
	final static int SECOND_GROUP = 2;
	final static int SIZE = 10;
	
	final static int EXCELLENT_EVALUATION = 5;
	final static int GOOD_EVALUATTION = 4;
	final static int SATISFACTORY_EVALUATTION = 3;

	public static void main(final String[] args) {
		Student[] students = new Student[SIZE];
		students[0] = new Student("Людмила", "Лыска", "Юрьевна", FIRST_GROUP);
		students[1] = new Student("Юрий", "Ющенко", "Витальевич", SECOND_GROUP);
		students[2] = new Student("Ирина", "Герасименко", "Игоревна", SECOND_GROUP);
		students[3] = new Student("Петр", "Самсонов", "Александрович", FIRST_GROUP);
		students[4] = new Student("Лариса", "Ющенко", "Витальевна", SECOND_GROUP);
		students[5] = new Student("Татьяна", "Денисова", "Викторовна", SECOND_GROUP);
		students[6] = new Student("Марина", "Верена", "Александровна", FIRST_GROUP);
		students[7] = new Student("Александр", "Чернышев", "Юрьевич", FIRST_GROUP);
		students[8] = new Student("Юрий", "Иващенко", "Денисов", FIRST_GROUP);
		
		generateEvaluations(students);
		sort(students);
		showStudents(students);
		
		Student[] firstGroup = new Student[SIZE];
		Student[] secondGroup = new Student[SIZE];
		
		createNewListStudentsReceivedScholarship(students, FIRST_GROUP, firstGroup);
		createNewListStudentsReceivedScholarship(students, SECOND_GROUP, secondGroup);
		
		showStudents(firstGroup);
		showStudents(secondGroup);
	}
	
	/*
	 * Выводим на экран информацию о студентах переданных в массиве - students
	 */
	public static void showStudents(final Student[] students) {
		System.out.println("\tФ.И.О\t\t\t   Номер группы:\t Степендия:\t\t  Оценки:");
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				System.out.print(i+1 + ".");
				showStudent(students[i]);
			}
		}
		System.out.println();
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
	
	/*
	 * Создаём массив студентов вышедших на степендию в одной группе:
	 * 
	 * Student[] students - общий список студентов;
	 * 
	 * int number_group - номер интересующей нас группы;
	 * 
	 * Student[] newList - массив в который сохраняются студенты
	 * сдавшие экзамен на удвалитворительно в number_group
	 */
	public static void createNewListStudentsReceivedScholarship(
			final Student[] students, final int NUMBER_GROUP, final Student[] newList) {
		int counter = 0;
		for (int i = 0; i < students.length; i++) {
			if(students[i] != null) {
				if (getAllowance(students[i]) >= 0) {
					if(NUMBER_GROUP == students[i].getGroup()) {
						newList[counter++] = students[i];
					}
				}
			}
		}
	}
	
	/*
	 * Меняем местами два объекта в массиве:
	 * - Student[] students - массив студентов;
	 * - int firstIndex & int secondIndex - индекса объектов,
	 * 	 которые меняем местами.
	 */
	public static void swap(final Student[] students, 
			final int firstIndex, final int secondIndex) {
		Student temp = students[firstIndex];
		students[firstIndex] = students[secondIndex];
		students[secondIndex] = temp;
	}
	
	public static void sort(final Student[] students) {
		for (int i = 0; i < students.length; i++) {
			for (int j = students.length-1; j > i; --j) {
				if (students[j] != null) {
					String fLastName = students[i].getLastName();
					String sLastName = students[j].getLastName();
					int result = fLastName.compareTo(sLastName);
					if (result > 0) {
						swap(students, i, j);
					}
				}
			}
		}
	}
	
	/*
	 * Вернуть надбавку, которую получил студент по итоговым оценкам:
	 * 
	 * - Если сдал все на "отлично"(5) - возвращаем 100;
	 * - Если сдал на "отлично" и "хорошо" (5 и 4) - возвращаем 50;
	 * - Если сдал все на "хорошо" (4) - возвращаем 25;
	 * - Если у студента две и меньше "удволитворительные"(3) оценки - возвращаем 0;  
	 * - Если больше двух "удволитворительных" (3) оценок - возвращаем -1
	 * 	 студент не получает степендию.
	 */
	public static int getAllowance(final Student student) {
		if (student.getCounterEvaluations() >= Student.MIN_NUMBER) {
			int excellent = 0;
			int good = 0;
			int satisfactory = 0;
			
			for (int i = 0; i < student.getCounterEvaluations(); i++) {
				switch(student.getEvaluation(i)) {
				case EXCELLENT_EVALUATION: 
					excellent++;
					break;
				case GOOD_EVALUATTION:
					good++;
					break;
				case SATISFACTORY_EVALUATTION:
					satisfactory++;
					break;
				}
			}
			
			if (excellent == student.getCounterEvaluations()) {
				return 100;
			} else if (excellent + good == student.getCounterEvaluations()) {
				if (good == student.getCounterEvaluations()) {
					return 25;
				} else {
					return 50;
				}
			} else if(excellent+good+satisfactory == student.getCounterEvaluations()
					&& satisfactory <= 2) {
				return 0;
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}
	
	public static void showStudent(final Student student) {
		System.out.print(student.getLastName() + " " + student.getFirstName() + " "
				+ student.getMiddleName() + " " + "\t\t" + student.getGroup());
		showAllowance(student);
		showEvaluationsToStudent(student);
		System.out.println();
	}
	
	public static void showAllowance(final Student student) {
		int allowance = getAllowance(student);
		if (allowance > 0) {
			System.out.print("\t\tнадбавка:" + allowance + "%");
		} else if (allowance == 0) {
			System.out.print("\t\tбез надбавки");
		} else if (allowance < 0) {
			System.out.print("\t\t      -\t");
		}
	}
	
	public static void showEvaluationsToStudent(final Student student) {
		System.out.print("\t\t");
		for (int i = 0; i < student.getCounterEvaluations(); i++) {
			if(student.getEvaluation(i) > 0) {
				System.out.print(" " + student.getEvaluation(i));
			}
		}
	}
}
