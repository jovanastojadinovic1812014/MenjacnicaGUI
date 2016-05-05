package menjacnica;

import java.util.LinkedList;

public class Valuta {
	private String nazivValute;
	private String skraceniNazivValute;
	private LinkedList<Kurs> kursevi = new LinkedList<Kurs>();

	public LinkedList<Kurs> getKursevi() {
		return kursevi;
	}

	public void setKursevi(LinkedList<Kurs> kursevi) {
		this.kursevi = kursevi;
	}

	public String getNazivValute() {
		return nazivValute;
	}

	public void setNazivValute(String nazivValute) {
		if (nazivValute == null || nazivValute.isEmpty()) {
			throw new RuntimeException("Greska prilikom unosa naziva valute!");
		}
		this.nazivValute = nazivValute;
	}

	public String getSkraceniNazivValute() {
		return skraceniNazivValute;
	}

	public void setSkraceniNazivValute(String skraceniNazivValute) {
		if (skraceniNazivValute == null || skraceniNazivValute.isEmpty()) {
			throw new RuntimeException("Greska prilikom unosa skracenog naziva valute!");
		}
		this.skraceniNazivValute = skraceniNazivValute;
	}

	@Override
	public String toString() {
		return "Valuta [nazivValute=" + nazivValute + ", skraceniNazivValute=" + skraceniNazivValute + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nazivValute == null) ? 0 : nazivValute.hashCode());
		result = prime * result + ((skraceniNazivValute == null) ? 0 : skraceniNazivValute.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Valuta other = (Valuta) obj;
		if (nazivValute == null) {
			if (other.nazivValute != null)
				return false;
		} else if (!nazivValute.equals(other.nazivValute))
			return false;
		if (skraceniNazivValute == null) {
			if (other.skraceniNazivValute != null)
				return false;
		} else if (!skraceniNazivValute.equals(other.skraceniNazivValute))
			return false;
		return true;
	}

}
