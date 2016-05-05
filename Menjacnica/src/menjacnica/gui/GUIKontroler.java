package menjacnica.gui;

import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GUIKontroler {
	private static MenjacnicaGUI gui;
	private static DodajKursGUI dodajKursGui;
	private static IzvrsiZamenuGUI izvrsiZamenuGui;

	public static void exit() {
		int izbor = JOptionPane.showConfirmDialog(gui.getContentPane(), "Da li zelite da izadjete iz programa?",
				"Izlaz", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

		if (izbor == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public static void about() {
		String poruka = "Autor: Jovana Stojadinovic";
		JOptionPane.showMessageDialog(gui.getContentPane(), poruka, "Podaci o autoru", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void zatvoriDodajKursGui() {
		if (dodajKursGui != null) {
			dodajKursGui.dispose();
			dodajKursGui = null;
		}
	}

	public static void dodajUPoljeZaIspis(String tekst) {
		gui.getTextArea().append(tekst);
	}

	public static void prikaziDodajKursGui() {
		if (otvorenDodajKursGui()) {
			dodajKursGui.toFront();
			return;
		}

		dodajKursGui = new DodajKursGUI();
		dodajKursGui.setLocationRelativeTo(null);
		dodajKursGui.setVisible(true);

	}

	private static boolean otvorenDodajKursGui() {
		return (dodajKursGui != null);
	}

	public static void dodajKurs(String sifra, String naziv, double prodajniKurs, double kupovniKurs,
			double srednjiKurs, String skraceniNaziv) {

		String tekst = "[Dodat kurs] Sifra: " + sifra + ", naziv: " + naziv + ", prodajni kurs: " + prodajniKurs
				+ ", kupovni kurs: " + kupovniKurs + ", srednji kurs: " + srednjiKurs + ", skraceni naziv: "
				+ skraceniNaziv + System.lineSeparator();

		dodajUPoljeZaIspis(tekst);

		DefaultTableModel dtm = (DefaultTableModel) gui.getTable().getModel();

		dtm.addRow(new Object[] { sifra, skraceniNaziv, prodajniKurs, srednjiKurs, kupovniKurs, naziv });

		zatvoriDodajKursGui();

	}

	public static void obrisiKurs(int index) {
		int obrisi = JOptionPane.showConfirmDialog(gui.getContentPane(),
				"Da li ste sigurni da zelite da obrisete izabrani kurs?", "Potvrda brisanja",
				JOptionPane.YES_NO_OPTION);

		if (obrisi == JOptionPane.YES_OPTION) {

			DefaultTableModel dtm = (DefaultTableModel) gui.getTable().getModel();
			dtm.removeRow(index);
			JOptionPane.showMessageDialog(gui.getContentPane(), "Kurs je uspesno obrisan", "Poruka",
					JOptionPane.INFORMATION_MESSAGE);

			String tekst = "Izbrisan je red sa indeksom: " + index + System.lineSeparator();
			dodajUPoljeZaIspis(tekst);

		} else {
			JOptionPane.showMessageDialog(gui.getContentPane(), "Kurs nije obrisan", "Poruka",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void prikaziIzvrsiZamenuGui() {
		if (otvorenIzvrsiZamenuGui()) {
			izvrsiZamenuGui.toFront();
			return;
		}

		izvrsiZamenuGui = new IzvrsiZamenuGUI();
		izvrsiZamenuGui.setLocationRelativeTo(null);
		izvrsiZamenuGui.setVisible(true);
	}

	public static void zatvoriIzvrsiZamenuGui() {
		if (otvorenIzvrsiZamenuGui()) {
			izvrsiZamenuGui.dispose();
			izvrsiZamenuGui = null;
		}

	}

	private static boolean otvorenIzvrsiZamenuGui() {
		return (izvrsiZamenuGui != null);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui = new MenjacnicaGUI();
					gui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
