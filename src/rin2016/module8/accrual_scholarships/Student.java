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
	
	public Student (final String firstName, final String lastName, 
			final String middleName, final int group) {
		if (firstName == null || firstName == ""
				&& lastName == null || lastName == "" 
				&& middleName == null || middleName == ""
				&& group <= 0) {
			return;
		}
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
	
	public int getCounterEvaluations() {
		return this.counterEvaluations;
	}
	
	public int getEvaluation (final int index) {
		if (index >= 0) {
			return this.evaluations[index];
		} else {
			return -1;
		}
	}
}
