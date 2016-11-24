package rin2016.module8.readers_of_library;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReaderValidator {

	private static final String REGEX_FOR_NAME = "^[А-Я][а-я]+";
	private static final String REGEX_FOR_PHONE = "^\\+380[0-9]{9}$";
	
	public static boolean isValidationName(final String name) {
		return isValidationString(REGEX_FOR_NAME, name);
	}
	
	public static boolean isValidationPhone(final String phone) {
		return isValidationString(REGEX_FOR_PHONE, phone);
	}
	
	private static boolean isValidationString(final String regex, final String string) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(string);
		return m.matches();
	}
}
