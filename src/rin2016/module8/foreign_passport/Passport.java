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
		try {
			if (ReaderValidator.isValidName(firstName) && 
				ReaderValidator.isValidName(lastName) && 
				ReaderValidator.isValidName(middleName) && 
				ReaderValidator.isValidDate(birthdate) &&
				// проверка на адресс
				ReaderValidator.isValidName(nationality)) {

			} else {
				throw new IllegalArgumentException("Не валидный аргумент!");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.toString());
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
}