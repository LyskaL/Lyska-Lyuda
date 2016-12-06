package lyskal.module8.foreign_passport;

public class ForeingPassport extends Passport {
	private Visa[] _visa;
	private int counterVisa;
	private static final int MAX_SIZE_VISA = 10;
	private String _number;
	
	public ForeingPassport(final String firstName,
			 			   final String lastName,
			 			   final String middleName,
			 			   final String birthdate,
			 			   final String address,
			 			   final String nationality) {
		super(firstName, lastName, middleName, 
			  birthdate, address, nationality);
		init();
		
	}

	public ForeingPassport(final Passport passport) {
		if(passport != null) {
			super.init(passport.getFirstName(),
					   passport.getLastName(),
					   passport.getMiddleName(),
					   passport.getBirthdate(),
					   passport.getAddress(),
					   passport.getNationality());
			init();
		} else {
			throw new IllegalArgumentException("Не валидный аргумент!");
		}
	}
	
	private void init() {
		setNumber();
		_visa = new Visa[MAX_SIZE_VISA];
	}
	
	private void setNumber() {
		if(_number == null) {
			int temp = (int)(Math.random() * (9000 - 1000)) + 1000;
			_number = "AP" + Integer.toString(temp);
		}
	}

	public Visa getVisa(final int index) {
		if(index >= 0 && index < counterVisa) {
			return _visa[index];
		}
		return null;
	}

	public void setVisa(final Visa visa) {
		if(visa != null && counterVisa < MAX_SIZE_VISA) {
			_visa[counterVisa] = visa.getVisa(); //copy Visa
			counterVisa++;
		}
	}

	public String getNumber() {
		return _number;
	}

	public int getCounterVisa() {
		return counterVisa;
	}
	
	@Override
	public String toString() {
		StringBuilder text = new StringBuilder(super.toString());
		text = text.append("\nForeingPassport №" + _number);
		for (int i = 0; i < counterVisa; i++) {
			text = text.append(_visa[i].toString());
		}
		return text.toString();
	}

}
