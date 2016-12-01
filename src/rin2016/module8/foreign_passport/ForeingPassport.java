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
		this(passport.getFirstName(), passport.getLastName(),
			 passport.getMiddleName(), passport.getBirthdate(),
			 passport.getAddress(), passport.getNationality());
	}
	
	private void setNumber() {
		if(_number == null) {
			int temp = (int)(Math.random()*90000 - 10000);
			_number = "AP" + Integer.toString(temp);
		}
	}

	public Visa getVisa(final int index) {
		if(index >= 0 && index < counterVisa) {
			return _visa[index];
		}
		return null;
	}

	public void setVisa(final Visa visa, final int index) {
		if(index >= 0 && index <= counterVisa) {
			_visa[index] = visa; //TODO копировать?
			counterVisa++;
		}
	}

	public String getNumber() {
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
