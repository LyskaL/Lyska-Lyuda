package rin2016.module8.foreign_passport;

public class ForeingPassport extends Passport {
	private Visa[] _visa;
	private int counterVisa;
	private String _number;
	
	public ForeingPassport(final String firstName,
			 final String lastName,
			 final String middleName,
			 final String birthdate,
			 final String address,
			 final String nationality) {
		super(firstName, lastName, middleName, 
			  birthdate, address, nationality);
		setNumber();
	}

	public ForeingPassport(final Passport passport) {
		//TODO проверить на null?
		this(passport.get_firstName(), passport.get_lastName(),
			 passport.get_middleName(), passport.get_birthdate(),
			 passport.get_address(), passport.get_nationality());
	}
	
	private void setNumber() {
		if(_number == null) {
			int temp = (int)(Math.random()*90000 - 10000);
			_number = "AP" + Integer.toString(temp);
		}
	}

	public Visa get_visa(final int index) {
		//проверка
		return _visa[index];
	}

	public void set_visa(final Visa _visa, final int index) {
		//проверка
		this._visa[index] = _visa;
	}

	public String get_number() {
		return _number;
	}

	public int getCounterVisa() {
		return counterVisa;
	}
	
	public String toStringForeingPassport() {
		StringBuilder text = new StringBuilder(toString());
		text = text.append("\nForeingPassport number: " + _number);
		return text.toString();
	}

}
