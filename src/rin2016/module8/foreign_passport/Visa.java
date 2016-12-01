package rin2016.module8.foreign_passport;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Visa {
	private TypeVisa _type;
	private String _dateOpening;
	private String _dateClose;
	
	private static final SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
	private static final int COUNTER_DAY_TRANSIT = 2;
	private static final int COUNTER_MONTH_TRAVEL = 3;
	private static final int COUNTER_MONTH_WORKING = 12;
	private static final int COUNTER_MONTH_STUDENT = 12;
	private static final int COUNTER_YEAR_IMMIGRATION = 5;
	
	public Visa (final TypeVisa type) {
		if(_type != null) {
			_type = type;
			setDateOpening();
			setDateClose();
		}
	}
	
	public TypeVisa getType() {
		return _type;
	}
	
	public String getDateOpening() {
		return _dateOpening;
	}
	
	public String getDateClose() {
		return _dateClose;
	}
	
	private void setDateOpening() {
		Date d = new Date();
		_dateOpening = formatDate.format(d);
	}
	
	private void setDateClose() {
		int day = Integer.parseInt(_dateOpening.substring(0, 2));
		int month = Integer.parseInt(_dateOpening.substring(3, 5));
		int year = Integer.parseInt(_dateOpening.substring(6, _dateOpening.length()));
		
		if(_type == TypeVisa.TRANSIT) {
			day += COUNTER_DAY_TRANSIT; 
		} else if(_type == TypeVisa.TRAVEL) {
			month += COUNTER_MONTH_TRAVEL;
		} else if (_type == TypeVisa.WORKING) {
			month += COUNTER_MONTH_WORKING;
		} else if (_type == TypeVisa.STUDENT) {
			month += COUNTER_MONTH_STUDENT;
		} else if (_type == TypeVisa.IMMIGRATION){
			year += COUNTER_YEAR_IMMIGRATION;
		}
		
		Calendar cal = new GregorianCalendar(year, month-1, day);
		_dateClose = formatDate.format(cal.getTime());
	}
}
