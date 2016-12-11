package lyskal.module8.wokers;

public abstract class Worker extends Person{
	private String _position;
	public static final String TRAINEE = "trainee";
	
	public Worker(final String name, final String birthday, final String position) {
		super(name, birthday);
		setPosition(position);
	}

	public Worker(final String name, final String birthday) {
		this(name, birthday, TRAINEE);
	}

	public String getPosition() {
		return _position;
	}

	public void setPosition(final String position) {
		try {
			if(Validator.isValidName(position)){
				_position = position;
			}
		} catch (IllegalArgumentException e) {
			System.err.println("Position not valid");
		}
	}
	
	public abstract int getWage();

	@Override
	public String toString() {
		return "Worker: " + super.toString() +"\t"+ _position + "\t"+ getWage() + "\n";
	}
	
}
