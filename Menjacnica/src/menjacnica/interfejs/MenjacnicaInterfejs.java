package menjacnica.interfejs;

import java.util.GregorianCalendar;

import menjacnica.Kurs;

public interface MenjacnicaInterfejs {
	public void dodajKurs(String nazivValute, Kurs kurs);

	public void obrisiKurs(String nazivValute, Kurs kurs);

	public Kurs pronadjiKurs(String nazivValute, GregorianCalendar datum);

}
