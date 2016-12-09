package lyskal.module8.associative_array;

public abstract class Person {
	private String _firstName;
	private String _lastName;
	private String _middleName;
	private String _birthday;

	public Person(final String lastName,
				  final String firstName,
				  final String middleName, 
				  final String birthday) {
		if(Validator.isValidName(firstName) &&
		   Validator.isValidName(lastName) &&
		   Validator.isValidName(middleName) &&
		   Validator.isValidDate(birthday)) {
			_firstName = firstName;
			_lastName = lastName;
			_middleName = middleName;
			_birthday = birthday;
		} else {
			throw new IllegalArgumentException("Не валидные данные!");
		}
	}

	public String getFirstName() {
		return _firstName;
	}
	
	public String getLastName() {
		return _lastName;
	}
	
	public String getMiddleName() {
		return _middleName;
	}
	
	public String getBirthday() {
		return _birthday;
	}
}
