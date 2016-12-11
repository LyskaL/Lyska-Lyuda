package lyskal.module8.wokers;

public class WorkerOnRate extends Worker{
	private final int MIN_RATE = 1000;
	private int _rate = MIN_RATE;

	public WorkerOnRate(final String name, final String birthday, 
						final String position, final int rate) {
		super(name, birthday, position);
		if(rate > MIN_RATE) {
			_rate = rate;
		}
	}
	
	@Override
	public int getWage() {
		return _rate;
	}

	public void setRate(int rate) {
		if(rate <= MIN_RATE) {
			rate = MIN_RATE;
		}
		_rate = rate;
	} 
	
}
