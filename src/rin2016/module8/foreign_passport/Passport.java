package rin2016.module8.foreign_passport;


public class Passport {
	private String _firstName;
	private String _lastName;
	private String _middleName;
	private String _birthdate;
	private String _address;
	private String _nationality;
	
	public Passport (final String firstName,
					 final String lastName,
					 final String middleName,
					 final String birthdate,
					 final String address,
					 final String nationality) {
		
		if (ReaderValidator.isValidPassport(firstName, lastName, middleName, 
											birthdate, address, nationality)) {
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

	public String get_firstName() {
		return _firstName;
	}

	public String get_lastName() {
		return _lastName;
	}

	public String get_middleName() {
		return _middleName;
	}

	public String get_birthdate() {
		return _birthdate;
	}

	public String get_address() {
		return _address;
	}

	public String get_nationality() {
		return _nationality;
	}

	@Override
	public String toString() {
		return "\nFull name: " +_lastName + " " + _firstName + " " + _middleName + 
			   "\nBirthdate: " + _birthdate + "\nNationality: " + _nationality + 
			   "\nAddress: " + _address;
	}
	
	
}