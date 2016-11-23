package rin2016.module8.readers_of_library;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {
	private String firstName;
	private String lastName;
	private String middleName;
	private String birthDate;
	
	private String numberOfLibraryCard;
	private String faculty;
	private String phoneNumber;
	
	private static final String REGEX_FOR_NAME = "^[А-Я][а-я]+";
	private static final String REGEX_FOR_PHONE = "^[+380][0-9]{11}";
	
	public Reader (final String lastName, final String firstName, 
			final String middleName, final String birthDate) {
		if (lastName != null) {
			if(isValidationString(REGEX_FOR_NAME, lastName)) {
				this.lastName = lastName;
			}
		}
		if (firstName != null) {
			if(isValidationString(REGEX_FOR_NAME, firstName)) {
				this.firstName = firstName;
			}
		}
		if (middleName != null) {
			if(isValidationString(REGEX_FOR_NAME, middleName)) {
				this.middleName = middleName;
			}
		}
		this.setBirthDate(birthDate);
		this.faculty = "";
		this.phoneNumber = "";
	}
	
	private boolean isValidationString(final String regex, final String string) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(string);
		return m.matches();
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
			//TODO валидность номера телефона
			if(isValidationString(REGEX_FOR_PHONE, phoneNumber)) {
				this.phoneNumber = phoneNumber;
			}
		}
	}

	public String getBirthDate() {
		return birthDate;
	}

	private void setBirthDate(final String birthDate) {
		//TODO валидность даты
		this.birthDate = birthDate;
	}
	
}
