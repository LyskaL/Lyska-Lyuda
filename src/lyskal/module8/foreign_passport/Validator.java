package lyskal.module8.foreign_passport;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	@SuppressWarnings("serial")
	private static final SimpleDateFormat DATE_FORMAT = 
			new SimpleDateFormat("dd.MM.yyyy") 
			{{ setLenient(false); }};
	
	public static boolean isValidName(final String string){
		return isValidString(string);
	}
	
	private static boolean isValidString(final String string){
		if (string == null) {
			return false;
		}
		Pattern p = Pattern.compile("[A-Яа-я]+");
		Matcher m = p.matcher(string);
		return m.matches();
	}
	
	public static boolean isValidDate(final String date) {
		if (date == null) {
			return false;
		}
		try {
			DATE_FORMAT.parse(date);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isValidPassport(final String firstName, 
										  final String lastName, 
										  final String middleName,
										  final String birthdate, 
										  final String address, 
										  final String nationality) {
		if (Validator.isValidName(firstName) && 
			Validator.isValidName(lastName) && 
			Validator.isValidName(middleName) && 
			Validator.isValidDate(birthdate) &&
			// TODO проверка на адресс
			Validator.isValidName(nationality)) {
			return true;
		}
		return false;
	}
}
