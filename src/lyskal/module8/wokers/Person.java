package lyskal.module8.wokers;

public abstract class Person {
	private String _name;
	private String _birthday;
	
	public Person(final String name, final String birthday) {
		if(Validator.isValidName(name) && Validator.isValidDate(birthday)) {
			_name = name;
			_birthday = birthday;
		} else {
			throw new IllegalArgumentException("Data not valid");
		}
	}

	public String getName() {
		return _name;
	}

	public String getBirthday() {
		return _birthday;
	}

	@Override
	public String toString() {
		return " " + _name + "\t" + _birthday;
	}
	
}