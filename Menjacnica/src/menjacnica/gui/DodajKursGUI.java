package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DodajKursGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblSifra;
	private JLabel lblNaziv;
	private JTextField textFieldSifra;
	private JTextField textFieldNaziv;
	private JLabel lblNewLabel;
	private JTextField textFieldProdajniKurs;
	private JTextField textFieldKupovniKurs;
	private JLabel lblKupovniKurs;
	private JLabel lblSrednjiKurs;
	private JTextField textFieldSrednjiKurs;
	private JLabel lblSkraceniNaziv;
	private JTextField textFieldSkraceniNaziv;
	private JButton btnDodaj;
	private JButton btnOdustani;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajKursGUI frame = new DodajKursGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public DodajKursGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GUIKontroler.zatvoriDodajKursGui();
			}
		});
		setResizable(false);
		setTitle("Dodaj kurs");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 219, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblSifra());
			panel.add(getLblNaziv());
			panel.add(getTextFieldSifra());
			panel.add(getTextFieldNaziv());
			panel.add(getLblNewLabel());
			panel.add(getTextFieldprodajniKurs());
			panel.add(getTextFieldKupovniKurs());
			panel.add(getLblKupovniKurs());
			panel.add(getLblSrednjiKurs());
			panel.add(getTextFieldSrednjiKurs());
			panel.add(getLblSkraceniNaziv());
			panel.add(getTextFieldSkraceniNaziv());
			panel.add(getBtnDodaj());
			panel.add(getBtnOdustani());
		}
		return panel;
	}

	private JLabel getLblSifra() {
		if (lblSifra == null) {
			lblSifra = new JLabel("Sifra");
			lblSifra.setBounds(8, 8, 86, 14);
		}
		return lblSifra;
	}

	private JLabel getLblNaziv() {
		if (lblNaziv == null) {
			lblNaziv = new JLabel("Naziv");
			lblNaziv.setBounds(104, 8, 89, 14);
		}
		return lblNaziv;
	}

	private JTextField getTextFieldSifra() {
		if (textFieldSifra == null) {
			textFieldSifra = new JTextField();
			textFieldSifra.setBounds(8, 33, 86, 20);
			textFieldSifra.setColumns(10);
		}
		return textFieldSifra;
	}

	private JTextField getTextFieldNaziv() {
		if (textFieldNaziv == null) {
			textFieldNaziv = new JTextField();
			textFieldNaziv.setBounds(104, 33, 86, 20);
			textFieldNaziv.setColumns(10);
		}
		return textFieldNaziv;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Prodajni kurs");
			lblNewLabel.setBounds(8, 77, 86, 14);
		}
		return lblNewLabel;
	}

	private JTextField getTextFieldprodajniKurs() {
		if (textFieldProdajniKurs == null) {
			textFieldProdajniKurs = new JTextField();
			textFieldProdajniKurs.setBounds(8, 99, 86, 20);
			textFieldProdajniKurs.setColumns(10);
		}
		return textFieldProdajniKurs;
	}

	private JTextField getTextFieldKupovniKurs() {
		if (textFieldKupovniKurs == null) {
			textFieldKupovniKurs = new JTextField();
			textFieldKupovniKurs.setBounds(104, 99, 86, 20);
			textFieldKupovniKurs.setColumns(10);
		}
		return textFieldKupovniKurs;
	}

	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
			lblKupovniKurs.setBounds(104, 77, 86, 14);
		}
		return lblKupovniKurs;
	}

	private JLabel getLblSrednjiKurs() {
		if (lblSrednjiKurs == null) {
			lblSrednjiKurs = new JLabel("Srednji kurs");
			lblSrednjiKurs.setBounds(8, 143, 86, 14);
		}
		return lblSrednjiKurs;
	}

	private JTextField getTextFieldSrednjiKurs() {
		if (textFieldSrednjiKurs == null) {
			textFieldSrednjiKurs = new JTextField();
			textFieldSrednjiKurs.setBounds(8, 168, 86, 20);
			textFieldSrednjiKurs.setColumns(10);
		}
		return textFieldSrednjiKurs;
	}

	private JLabel getLblSkraceniNaziv() {
		if (lblSkraceniNaziv == null) {
			lblSkraceniNaziv = new JLabel("Skraceni naziv");
			lblSkraceniNaziv.setBounds(104, 143, 86, 14);
		}
		return lblSkraceniNaziv;
	}

	private JTextField getTextFieldSkraceniNaziv() {
		if (textFieldSkraceniNaziv == null) {
			textFieldSkraceniNaziv = new JTextField();
			textFieldSkraceniNaziv.setBounds(104, 168, 86, 20);
			textFieldSkraceniNaziv.setColumns(10);
		}
		return textFieldSkraceniNaziv;
	}

	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String sifra = getTextFieldSifra().getText();
					String naziv = getTextFieldNaziv().getText();
					double prodajniKurs = Double.parseDouble(getTextFieldprodajniKurs().getText());
					double kupovniKurs = Double.parseDouble(getTextFieldKupovniKurs().getText());
					double srednjiKurs = Double.parseDouble(getTextFieldSrednjiKurs().getText());
					String skraceniNaziv = getTextFieldSkraceniNaziv().getText();
					GUIKontroler.dodajKurs(sifra, naziv, prodajniKurs, kupovniKurs, srednjiKurs, skraceniNaziv);
				}
			});
			btnDodaj.setBounds(0, 240, 89, 23);
		}
		return btnDodaj;
	}

	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.zatvoriDodajKursGui();
				}
			});
			btnOdustani.setBounds(104, 240, 89, 23);
		}
		return btnOdustani;
	}
}
