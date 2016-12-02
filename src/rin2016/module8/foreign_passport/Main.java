package rin2016.module8.foreign_passport;

public class Main {

	public static void main(final String[] args) {
		Passport p = null;
		try{
			p = new Passport("Lyska", "Lyuda", "Yuriivna", "13.02.1993", 
							 "Ukraine, Dnepr, Topol-2", "ukrainian");
		} catch (IllegalArgumentException err) {
			System.out.println("В конструктор паспорта "
					+ "переданы не валидные данные!");
		}
		
		Visa v1 = new Visa(TypeVisa.TRAVEL);
		Visa v2 = new Visa(TypeVisa.STUDENT);
		Visa v3 = new Visa(TypeVisa.WORKING);
		
		ForeingPassport fp = null;
		try{
			fp = new ForeingPassport(p);
			fp.setVisa(v1);
			fp.setVisa(null);
			fp.setVisa(v3);
			System.out.println(fp.toString());
		} catch (IllegalArgumentException err) {
			System.out.println("В конструктор загранпаспорта "
							+ "переданы не валидные данные!");
		}
	}
}