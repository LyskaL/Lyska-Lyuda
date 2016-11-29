package rin2016.module8.foreign_passport;

public class Visa {
	private TypeVisa _type;
	private String _dateOpening;
	private String _dateClose;
	
	public Visa () {
		
	}
	
	public TypeVisa get_type() {
		return _type;
	}
	
	public void set_type(final TypeVisa _type) {
		this._type = _type;
	}
	
	public String get_dateOpening() {
		return _dateOpening;
	}
	
	public void set_dateOpening(final String _dateOpening) {
		this._dateOpening = _dateOpening;
	}
	
	public String get_dateClose() {
		return _dateClose;
	}
	
	public void set_dateClose(final String _dateClose) {
		this._dateClose = _dateClose;
	}
	
}
