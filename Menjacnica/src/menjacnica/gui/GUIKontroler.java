package menjacnica.gui;

import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GUIKontroler {
	private static MenjacnicaGUI gui;
	private static DodajKursGUI dodajKursGui;

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
