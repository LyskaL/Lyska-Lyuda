package lyskal.module8.associative_array;

public class Student extends Person {

	public Student(final String lastName, 
				   final String firstName, 
				   final String middleName, 
				   final String birthday) {
		super(lastName, firstName, middleName, birthday);
	}
	
	public Student getCopyStudent() {
		return new Student(getLastName(), getFirstName(), getMiddleName(), getBirthday());
	}

	@Override
	public String toString() {
		return "" + getLastName() + 
			   " " + getFirstName() +
			   " " + getMiddleName() +
			   " " + getBirthday();
	}
	
	
}
