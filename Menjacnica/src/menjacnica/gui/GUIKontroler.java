package menjacnica.gui;
import java.awt.EventQueue;
import javax.swing.JOptionPane;

public class GUIKontroler {
	private static MenjacnicaGUI gui;
	
	
	public static void exit() {
		int izbor = JOptionPane.showConfirmDialog(gui.getContentPane(), "Da li zelite da izadjete iz programa?", "Izlaz", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (izbor == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public static void about() {
		String poruka = "Autor: Jovana Stojadinovic";
		JOptionPane.showMessageDialog(gui.getContentPane(), poruka, "Podaci o autoru", JOptionPane.INFORMATION_MESSAGE);
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
