package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JButton;

public class IzvrsiZamenuGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblKupovniKurs;
	private JLabel lblProdajniKurs;
	private JTextField textFieldKupovniKurs;
	private JTextField textFieldProdajniKurs;
	private JComboBox comboBox;
	private JLabel lblIznos;
	private JTextField textFieldIznos;
	private JLabel lblVrstaTransakcije;
	private JRadioButton rdbtnKupovina;
	private JRadioButton rdbtnProdaja;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JSlider slider;
	private JButton btnIzvrsiZamenu;
	private JButton btnOdustani;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { IzvrsiZamenuGUI frame = new
	 * IzvrsiZamenuGUI(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */
	/**
	 * Create the frame.
	 */
	public IzvrsiZamenuGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GUIKontroler.zatvoriIzvrsiZamenuGui();
			}
		});
		setResizable(false);
		setTitle("Izvrsi zamenu");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 399, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblKupovniKurs());
			panel.add(getLblProdajniKurs());
			panel.add(getTextFieldKupovniKurs());
			panel.add(getTextFieldProdajniKurs());
			panel.add(getComboBox());
			panel.add(getLblIznos());
			panel.add(getTextFieldIznos());
			panel.add(getLblVrstaTransakcije());
			panel.add(getRdbtnKupovina());
			panel.add(getRdbtnProdaja());
			panel.add(getSlider());
			panel.add(getBtnIzvrsiZamenu());
			panel.add(getBtnOdustani());
		}
		return panel;
	}

	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
			lblKupovniKurs.setBounds(10, 11, 95, 14);
		}
		return lblKupovniKurs;
	}

	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
			lblProdajniKurs.setBounds(257, 11, 84, 14);
		}
		return lblProdajniKurs;
	}

	private JTextField getTextFieldKupovniKurs() {
		if (textFieldKupovniKurs == null) {
			textFieldKupovniKurs = new JTextField();
			textFieldKupovniKurs.setEditable(false);
			textFieldKupovniKurs.setBounds(20, 32, 86, 20);
			textFieldKupovniKurs.setColumns(10);
		}
		return textFieldKupovniKurs;
	}

	private JTextField getTextFieldProdajniKurs() {
		if (textFieldProdajniKurs == null) {
			textFieldProdajniKurs = new JTextField();
			textFieldProdajniKurs.setEditable(false);
			textFieldProdajniKurs.setBounds(246, 32, 86, 20);
			textFieldProdajniKurs.setColumns(10);
		}
		return textFieldProdajniKurs;
	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] { "EUR", "USD", "CHF" }));
			comboBox.setBounds(128, 32, 84, 20);
		}
		return comboBox;
	}

	private JLabel getLblIznos() {
		if (lblIznos == null) {
			lblIznos = new JLabel("Iznos");
			lblIznos.setBounds(10, 72, 46, 14);
		}
		return lblIznos;
	}

	private JTextField getTextFieldIznos() {
		if (textFieldIznos == null) {
			textFieldIznos = new JTextField();
			textFieldIznos.setText("50");
			textFieldIznos.setBounds(10, 94, 147, 20);
			textFieldIznos.setColumns(10);
		}
		return textFieldIznos;
	}

	private JLabel getLblVrstaTransakcije() {
		if (lblVrstaTransakcije == null) {
			lblVrstaTransakcije = new JLabel("Vrsta transakcije");
			lblVrstaTransakcije.setBounds(221, 83, 122, 14);
		}
		return lblVrstaTransakcije;
	}

	private JRadioButton getRdbtnKupovina() {
		if (rdbtnKupovina == null) {
			rdbtnKupovina = new JRadioButton("Kupovina");
			rdbtnKupovina.setSelected(true);
			buttonGroup.add(rdbtnKupovina);
			rdbtnKupovina.setBounds(221, 104, 109, 23);
		}
		return rdbtnKupovina;
	}

	private JRadioButton getRdbtnProdaja() {
		if (rdbtnProdaja == null) {
			rdbtnProdaja = new JRadioButton("Prodaja");
			buttonGroup.add(rdbtnProdaja);
			rdbtnProdaja.setBounds(221, 130, 109, 23);
		}
		return rdbtnProdaja;
	}

	private JSlider getSlider() {
		if (slider == null) {
			slider = new JSlider();

			slider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					int val = slider.getValue();
					getTextFieldIznos().setText(val + "");
				}
			});
			slider.setPaintTicks(true);
			slider.setMinorTickSpacing(5);
			slider.setPaintLabels(true);
			slider.setMajorTickSpacing(10);

			slider.setBounds(49, 160, 292, 45);
		}
		return slider;
	}

	private JButton getBtnIzvrsiZamenu() {

		if (btnIzvrsiZamenu == null) {

			btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
			btnIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String valuta = getComboBox().getSelectedItem().toString();
					double iznos = Double.parseDouble(getTextFieldIznos().getText());
					String kupovinaIliProdaja;

					if (getRdbtnKupovina().isSelected()) {
						kupovinaIliProdaja = "kupovina";
					} else {
						kupovinaIliProdaja = "prodaja";
					}

					String tekst = "[Izvrsena zamena] Valuta: " + valuta + ", iznos: " + iznos + ", kupovina/prodaja: "
							+ kupovinaIliProdaja + System.lineSeparator();
					GUIKontroler.dodajUPoljeZaIspis(tekst);

				}
			});
			btnIzvrsiZamenu.setBounds(10, 228, 130, 23);
		}
		return btnIzvrsiZamenu;
	}

	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.zatvoriIzvrsiZamenuGui();
				}
			});
			btnOdustani.setBounds(246, 226, 114, 23);
		}
		return btnOdustani;
	}
}
