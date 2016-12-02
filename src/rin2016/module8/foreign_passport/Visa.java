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
	private static final int COUNTER_DAY_TRAVEL = 90;
	private static final int COUNTER_DAY_STUDENT = 180;
	private static final int COUNTER_DAY_WORKING = 360;
	private static final int COUNTER_YEAR_IMMIGRATION = 3;
	
	public Visa (final TypeVisa type) {
		if(type != null) {
			_type = type;
			countDateOpening();
			countDateClose();
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
	
	private void countDateOpening() {
		Date d = new Date();
		_dateOpening = formatDate.format(d);
	}
	
	private void countDateClose() {
		int day = Integer.parseInt(_dateOpening.substring(0, 2));
		int month = Integer.parseInt(_dateOpening.substring(3, 5));
		int year = Integer.parseInt(_dateOpening.substring(6, _dateOpening.length()));

		if (_type == TypeVisa.TRANSIT) {
			day += COUNTER_DAY_TRANSIT;
		} else if (_type == TypeVisa.TRAVEL) {
			day += COUNTER_DAY_TRAVEL;
		} else if (_type == TypeVisa.WORKING) {
			day += COUNTER_DAY_WORKING;
		} else if (_type == TypeVisa.STUDENT) {
			day += COUNTER_DAY_STUDENT;
		} else if (_type == TypeVisa.IMMIGRATION) {
			year += COUNTER_YEAR_IMMIGRATION;
		}

		Calendar cal = new GregorianCalendar(year, month-1, day);
		_dateClose = formatDate.format(cal.getTime());
	}

	protected void setDateOpening(final String dateOpening) {
		if(dateOpening != null) {
			_dateOpening = dateOpening;
		}
	}
	
	protected void setDateClose(final String dateClose) {
		if(dateClose != null) {
			_dateClose = dateClose;
		}
	}
	
	public Visa getVisa(){
		Visa v = new Visa(_type);
		v.setDateClose(_dateClose);
		v.setDateOpening(_dateOpening);
		return v;
	}

	@Override
	public String toString() {
		return "\nType Visa: " + _type + "\tOpening: " + _dateOpening + "\tClose: " + _dateClose;
	}
	
	
}
