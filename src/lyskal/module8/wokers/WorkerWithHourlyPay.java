package lyskal.module8.wokers;

public class WorkerWithHourlyPay extends Worker {
	private static int MIN_PAY_FOR_HOUR = 12;
	private int _payForHour = MIN_PAY_FOR_HOUR;
	
	public WorkerWithHourlyPay(final String name, final String birthday, 
							   final String position, final int payForHour) {
		super(name, birthday, position);
		if(payForHour > MIN_PAY_FOR_HOUR) {
			_payForHour = payForHour;
		}
	}
	
	public void setPayForHour(int payForHour) {
		if(payForHour <= MIN_PAY_FOR_HOUR) {
			payForHour = MIN_PAY_FOR_HOUR;
		}
		_payForHour = payForHour;
	}
	
	@Override
	public int getWage() {
		return (int)(20.8 * 8 * _payForHour);
	}
	
}
