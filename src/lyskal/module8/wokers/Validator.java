package lyskal.module8.wokers;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	private static final String REGEX_FOR_NAME = "^[A-za-z .]+";
	
	@SuppressWarnings("serial")
	private static final SimpleDateFormat DATE_FORMAT = 
			new SimpleDateFormat("dd.MM.yyyy") {{setLenient(false);}};

	public static boolean isValidName(final String name) {
		return isValidString(REGEX_FOR_NAME, name);
	}

	private static boolean isValidString(final String regex, final String string) {
		if(string == null) {
			return false;
		}
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