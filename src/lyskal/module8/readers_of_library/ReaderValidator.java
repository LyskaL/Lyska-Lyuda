package lyskal.module8.readers_of_library;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReaderValidator {

	private static final String REGEX_FOR_NAME = "^[А-Я][а-я]+";
	private static final String REGEX_FOR_PHONE = "^\\+380[0-9]{9}$";
	@SuppressWarnings("serial")
	private static final SimpleDateFormat DATE_FORMAT = 
			new SimpleDateFormat("dd.MM.yyyy") {{ setLenient(false); }};
	
	public static boolean isValidName(final String name) {
		return isValidString(REGEX_FOR_NAME, name);
	}
	
	public static boolean isValidPhone(final String phone) {
		return isValidString(REGEX_FOR_PHONE, phone);
	}
	
	private static boolean isValidString(final String regex, final String string) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(string);
		return m.matches();
	}

	public static boolean isValidDate(final String date) {
		try {
			DATE_FORMAT.parse(date);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}