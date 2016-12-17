package lyskal.module8.wokers.servises;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The class carry out check of the strings 
 * on a validity. 
 * 
 * @author LyskaL
 */
public class Validator {
	private static final String REGEX_FOR_NAME = "^[A-za-z .]+";
	
	@SuppressWarnings("serial")
	private static final SimpleDateFormat DATE_FORMAT = 
			new SimpleDateFormat("dd.MM.yyyy") {{setLenient(false);}};
	
	/**
	 * Check correctness of input of a name of the worker.
	 * 
	 * @param name - name of worker
	 * @return
	 * true - if name is correct;
	 * false - name is not correct.
	 */
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
	
	/**
	 * Check a date correctness.
	 * 
	 * @param date - birth date of workers
	 * @return 
	 * true - date is correct;
	 * false - date is not correct.
	 */
	public static boolean isValidDate(final String date) {
		try {
			DATE_FORMAT.parse(date);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}