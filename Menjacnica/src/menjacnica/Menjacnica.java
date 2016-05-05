package menjacnica;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import menjacnica.interfejs.MenjacnicaInterfejs;

public class Menjacnica implements MenjacnicaInterfejs {

	LinkedList<Valuta> valute = new LinkedList<Valuta>();

	@Override
	public void dodajKurs(String nazivValute, Kurs kurs) {

		if (nazivValute == null || kurs == null) {
			throw new RuntimeException("Naziv valute i kurs ne smeju biti null vrednosti!");

		}
		for (int i = 0; i < valute.size(); i++) {
			if (valute.get(i).getNazivValute().equals(nazivValute)) {
				valute.get(i).getKursevi().add(kurs);
			}
		}
	}

	@Override
	public void obrisiKurs(String nazivValute, Kurs kurs) {

		if (nazivValute == null || kurs == null) {
			throw new RuntimeException("Naziv valute i kurs ne smeju biti null vrednosti!");
		}
		for (int i = 0; i < valute.size(); i++) {
			if (valute.get(i).getNazivValute().equals(nazivValute)) {
				valute.get(i).getKursevi().remove(kurs);
			}
		}
	}

	@Override
	public Kurs pronadjiKurs(String nazivValute, GregorianCalendar datum) {

		if (nazivValute == null || datum == null) {
			throw new RuntimeException("Naziv valute i datum ne smeju biti null vrednosti!");

		}
		for (int i = 0; i < valute.size(); i++) {

			if (valute.get(i).getNazivValute().equals(nazivValute)) {

				for (int j = 0; j < valute.get(i).getKursevi().size(); j++) {
					if (valute.get(i).getKursevi().get(j).getDatum().equals(datum)) {
						return valute.get(i).getKursevi().get(j);
					}
				}
			}
		}
		return null;
	}

	@Override
	public void ucitajIzFajla(String putanja) {
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(putanja)));

			LinkedList<Valuta> lista = (LinkedList<Valuta>) (in.readObject());
			valute.clear();
			valute.addAll(lista);

			in.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void sacuvajUFajl(String putanja) {

		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(putanja)));

			out.writeObject(valute);

			out.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
