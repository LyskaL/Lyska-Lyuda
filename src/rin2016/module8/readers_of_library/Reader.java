package rin2016.module8.readers_of_library;

public class Reader {
	private String firstName;
	private String lastName;
	private String middleName;
	private String birthDate;
	
	private String numberOfLibraryCard;
	private String faculty;
	private String phoneNumber;

	public Reader (final String lastName, final String firstName, 
			final String middleName, final String birthDate) {
		if (lastName != null && firstName != null 
				&& middleName != null && birthDate != null) {
			if(ReaderValidator.isValidName(lastName)
					&& ReaderValidator.isValidName(firstName)
					&& ReaderValidator.isValidName(middleName)
					&& ReaderValidator.isValidDate(birthDate)) {
				this.lastName = lastName;
				this.firstName = firstName;
				this.middleName = middleName;
				this.birthDate = birthDate;
			} else {
				return;
			}
		} else {
			return;
		}
		
		this.faculty = "";
		this.phoneNumber = "";
	}
	
	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}
	
	public String getNumberOfLibraryCard() {
		return numberOfLibraryCard;
	}
	
	public void setNumber(final String number) {
		if(numberOfLibraryCard == null){
			numberOfLibraryCard = number;
		}
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(final String faculty) {
		if(faculty != null) {
			this.faculty = faculty;
		}
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(final String phoneNumber) {
		if(phoneNumber != null){
			if(ReaderValidator.isValidPhone(phoneNumber)) {
				this.phoneNumber = phoneNumber;
			}
		}
	}

	public String getBirthDate() {
		return birthDate;
	}
}
