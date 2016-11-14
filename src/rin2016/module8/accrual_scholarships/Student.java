package rin2016.module8.accrual_scholarships;

public class Student {
	private String firstName;
	private String lastName;
	private String middleName;
	private int group;
	private int[] evaluations;
	
	private int counterEvaluations;
	public static final int MAX_NUMBER = 5;
	public static final int MIN_NUMBER = 3;
	
	private final int EXCELLENT_EVALUATION = 5;
	private final int GOOD_EVALUATTION = 4;
	private final int SATISFACTORY_EVALUATTION = 3;
	
	public Student (final String firstName, final String lastName, 
			final String middleName, final int group) {
		setFirstName(firstName);
		setLastName(lastName);
		setMiddleName(middleName);
		setGroup(group);
		evaluations = new int [MAX_NUMBER];
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddleName(final String middleName) {
		this.middleName = middleName;
	}
	
	public int getGroup() {
		return group;
	}
	
	public void setGroup(final int group) {
		this.group = group;
	}
	
	public void setEvaluation (final int evaluation) {
		if (counterEvaluations < MAX_NUMBER) {
			this.evaluations[counterEvaluations++] = evaluation;
		}
	}
	
	public int getEvaluation (final int index) {
		if (index >= 0) {
			return this.evaluations[index];
		} else {
			return -1;
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
	public int getAllowance() {
		if (counterEvaluations >= MIN_NUMBER) {
			int excellent = 0;
			int good = 0;
			int satisfactory = 0;
			
			for (int i = 0; i < counterEvaluations; i++) {
				switch(evaluations[i]) {
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
			
			if (excellent == counterEvaluations) {
				return 100;
			} else if (excellent + good == counterEvaluations) {
				if (good == counterEvaluations) {
					return 25;
				} else {
					return 50;
				}
			} else if(excellent+good+satisfactory == counterEvaluations
					&& satisfactory <= 2) {
				return 0;
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}
	
	public void showStudent() {
		System.out.print(getLastName() + " " + getFirstName() + " "
				+ getMiddleName() + " " + "\t\t" + getGroup());
		showAllowance();
		showEvaluationsToStudent();
		System.out.println();
	}
	
	public void showAllowance() {
		int allowance = getAllowance();
		if (allowance > 0) {
			System.out.print("\t\tнадбавка:" + allowance + "%");
		} else if (allowance == 0) {
			System.out.print("\t\tбез надбавки");
		} else if (allowance < 0) {
			System.out.print("\t\t      -\t");
		}
	}

	public void showEvaluationsToStudent() {
		System.out.print("\t\t");
		for (int i = 0; i < counterEvaluations; i++) {
			if(getEvaluation(i) > 0) {
				System.out.print(" " + getEvaluation(i));
			}
		}
	}
}
