package MySQL_GUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class KirjaPaneeliGUI extends JFrame {
	private JTextField nimiKentta;
	private JTextField tekijaKentta;
	private JTextField julkaisuKentta;


	/**
	 * Create the panel.
	 *
	 */
	public KirjaPaneeliGUI() throws ParseException {
		setTitle("Kirjan sy\u00F6tt\u00F6-ohjelma");
		getContentPane().setLayout(null);

		JLabel lblKirjanSytt = new JLabel("Kirjan hallinta");
		lblKirjanSytt.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblKirjanSytt.setBounds(34, 27, 195, 20);
		getContentPane().add(lblKirjanSytt);

		JLabel lblKirjanNimi = new JLabel("Kirjan nimi:");
		lblKirjanNimi.setBounds(34, 94, 111, 20);
		getContentPane().add(lblKirjanNimi);

		JLabel lblTekij = new JLabel("Tekij\u00E4:");
		lblTekij.setBounds(34, 139, 111, 20);
		getContentPane().add(lblTekij);

		JLabel lblJulkaisuvuosi = new JLabel("Julkaisuvuosi:");
		lblJulkaisuvuosi.setBounds(34, 189, 111, 20);
		getContentPane().add(lblJulkaisuvuosi);

		nimiKentta = new JTextField();
		nimiKentta.setBounds(148, 91, 146, 26);
		getContentPane().add(nimiKentta);
		nimiKentta.setColumns(10);

		tekijaKentta = new JTextField();
		tekijaKentta.setColumns(10);
		tekijaKentta.setBounds(148, 136, 146, 26);

		getContentPane().add(tekijaKentta);

		julkaisuKentta = new JTextField();
		julkaisuKentta.setColumns(10);
		julkaisuKentta.setBounds(148, 186, 146, 26);
		getContentPane().add(julkaisuKentta);

		JButton lisaaNappi = new JButton("Lis\u00E4\u00E4 kirja");
		lisaaNappi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				tallennaKirja();
			}
		});
		lisaaNappi.setBounds(34, 244, 115, 29);
		getContentPane().add(lisaaNappi);

		JButton tyhjennaNappi = new JButton("Tyhjenn\u00E4");
		tyhjennaNappi.setBounds(192, 244, 115, 29);
		getContentPane().add(tyhjennaNappi);
		JFormattedTextField formattedTextField = null;

		
	
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\miksten\\Downloads\\old-book.jpg"));
		lblNewLabel.setBounds(322, 78, 162, 181);
		getContentPane().add(lblNewLabel);

	}

	protected void tallennaKirja() {

		String nimi = nimiKentta.getText();
		String tekija = tekijaKentta.getText();
		String vuosi = julkaisuKentta.getText();

			Kirja uusiKirja = new Kirja(nimi, Integer.parseInt(vuosi), tekija);

		JDBCExample.tallennaKirja(uusiKirja);
		JOptionPane.showMessageDialog(this, "Tallennettu");
		JDBCExample.lataaKirjat();

	}

	public static void main(String[] args) {

		try {
			JFrame uusi = new KirjaPaneeliGUI();
			uusi.setSize(800,400);
			uusi.setVisible(true);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
