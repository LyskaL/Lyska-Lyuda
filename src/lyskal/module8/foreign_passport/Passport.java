package lyskal.module8.foreign_passport;


public class Passport {
	private String _firstName;
	private String _lastName;
	private String _middleName;
	private String _birthdate;
	private String _address;
	private String _nationality;
	
	public Passport() {}
	
	public Passport (final String firstName,
					 final String lastName,
					 final String middleName,
					 final String birthdate,
					 final String address,
					 final String nationality) {
		
		init(firstName, lastName, middleName, birthdate, address, nationality);
	}
	
	protected void init(final String firstName,
			 			final String lastName,
			 			final String middleName,
			 			final String birthdate,
			 			final String address,
			final String nationality) {
		if (Validator.isValidPassport(firstName, lastName, middleName, birthdate, address, nationality)) {
			_firstName = firstName;
			_lastName = lastName;
			_middleName = middleName;
			_birthdate = birthdate;
			_address = address;
			_nationality = nationality;
		} else {
			throw new IllegalArgumentException("Не валидный аргумент!");
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

	public String getBirthdate() {
		return _birthdate;
	}

	public String getAddress() {
		return _address;
	}

	public String getNationality() {
		return _nationality;
	}

	@Override
	public String toString() {
		return "\nFull name: " +_lastName + " " + _firstName + " " + _middleName + 
			   "\nBirthdate: " + _birthdate + "\nNationality: " + _nationality + 
			   "\nAddress: " + _address;
	}
}