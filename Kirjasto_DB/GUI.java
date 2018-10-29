package Kirjasto_DB;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTable table;

	// Sarakkeiden nimet

	String[] sarakkeet = { "Teoksen nimi", "Tekij‰n nimi", "Julkaisuvuosi" };
	Object[][] data = {  { null, null, null }, };

	/**
	 * Create the frame.
	 */

	public GUI(Kirja[] kirjahylly) {

		table = new JTable();

		setTitle("Kirjasto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JScrollPane scrollPane = new JScrollPane(table);

		contentPane.add(scrollPane);

		// Taulukon alustaminen
		table.setModel(new DefaultTableModel(data, sarakkeet));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("Lis\u00E4\u00E4 rivi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Lis‰‰ kirjan taulukkoon
				lisaaKirja();

			}
		});
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Poista valittu rivi");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Poistaa kirjan taulukosta
				poistaValitutRivit(table);

			}
		});
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("P\u00E4ivit\u00E4 taulukko");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_2);

		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);

		JMenu mnNewMenu_1 = new JMenu("Tiedosto");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("Avaa");
		mnNewMenu_1.add(mntmNewMenuItem);

		JMenu mnNewMenu = new JMenu("Tallenna");
		mnNewMenu_1.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Poistu");
		mnNewMenu_1.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_2 = new JMenu("Tietoja ohjelmasta");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Versio");
		mnNewMenu_2.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("P\u00E4ivitykset");
		mnNewMenu_2.add(mntmNewMenuItem_3);

	}

	// protected void tiedotTaulukkoon(Kirja[] kirjahylly) {
	//
	// for (int row = 0; row < kirjahylly.length; row++) {
	//
	// table.setValueAt(kirjahylly[row].getTeoksenNimi(), row, 0);
	// table.setValueAt(kirjahylly[row].getTekija(), row, 1);
	// table.setValueAt(kirjahylly[row].getJulkaisuvuosi(), row, 2);
	//
	// }
	//
	// }

	// Lis‰t‰‰n kirja taulukkoon
	protected void lisaaKirja() {

		// Uusi tyhj‰ kirja
		Kirja uusi;

		// Luodaan uusi paneeli tietojen kysymist‰ varten

		JTextField nimi = new JTextField(10);
		JTextField tekij‰ = new JTextField(10);
		JTextField vuosi = new JTextField(10);
		JTextField ISBN = new JTextField(10); // Code added here

		JPanel myPanel = new JPanel();

		myPanel.add(new JLabel("Kirjan nimi:"));
		myPanel.add(nimi);

		myPanel.add(new JLabel("Tekij‰:"));
		myPanel.add(tekij‰);

		myPanel.add(new JLabel("Julkaisuvuosi:"));
		myPanel.add(vuosi);

		myPanel.add(new JLabel("ISBN:")); // Code added here
		myPanel.add(ISBN); // Code added here

		// Avataan uusi optionPane jossa k‰ytet‰‰n edell‰ luodun paneelin kentti‰

		int result = JOptionPane.showConfirmDialog(null, myPanel, "Lis‰‰ kirja: ", JOptionPane.OK_CANCEL_OPTION);

		
		// VAIHTOEHTOISESTI VOIDAAN LUODA ILMENTYMƒ KOKONAAN UUDESTA FRAMESTA JA LUKEA TIEDOT SEN AVULLA
		
		// JFrame uusiIkkuna = new KirjaPaneeliGUI();

		
		
		// Jos paluuarvona on OK napin painallus,
		if (result == JOptionPane.OK_OPTION) {

			// Luodaan kenttien tietojen
			// pohjalta uusi Kirja-olio

			String uusiNimi = nimi.getText();
			int uusiVuosi = Integer.parseInt(vuosi.getText());
			String uusiTekija = tekij‰.getText();

			// Sijoitetaan tiedot uuteen Kirja-olioon
			uusi = new Kirja(uusiNimi, uusiVuosi, uusiTekija); // Code
																// changed
			// Tulostetaan testimieless‰ uusi kirja konsoliin

			System.out.println(uusi);

			// Lis‰t‰‰n taulukkoon rivi, jossa taulukon tiedot ovat
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.addRow(new Object[] { uusi.getTeoksenNimi(), uusi.getTekija(), uusi.getJulkaisuvuosi() });

		}

	}

	// Poistaa valitut rivit
	private void poistaValitutRivit(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int[] rows = table.getSelectedRows();
		for (int i = 0; i < rows.length; i++) {
			model.removeRow(rows[i] - i);
		}
	}

}
