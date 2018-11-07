package Kirjasto_DB_retrieve;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

import java.awt.BorderLayout;
import java.awt.Color;

public class KirjaPaneeliGUI extends JFrame {

	// Esitell‰‰n kapseloidut GUI komponentit
	private JTextField nimiKentta;
	private JTextField tekijaKentta;
	private JTextField julkaisuKentta;
	private JPanel kuvaKehys;
	private JLabel kuvanRaamit;

	private final String vakioKuva = "C:\\Users\\miksten\\Downloads\\old-book.jpg";
	private static final String basePath = "C:\\Users\\Public\\Pictures\\Sample Pictures";

	private File targetFile;
	private BufferedImage targetImg;

	/**
	 * Konstruktori alustaa luokan ja asettaa komponentit paikoilleen.
	 *
	 */
	public KirjaPaneeliGUI() {

		setTitle("Kirjan sy\u00F6tt\u00F6ohjelma");
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

		lisaaNappi.setBounds(34, 244, 115, 29);
		getContentPane().add(lisaaNappi);

		JButton tyhjennaNappi = new JButton("Tyhjenn\u00E4");
		tyhjennaNappi.setBounds(192, 244, 115, 29);
		getContentPane().add(tyhjennaNappi);
		JFormattedTextField formattedTextField = null;

		kuvaKehys = new JPanel();
		kuvaKehys.setBorder(new LineBorder(new Color(0, 0, 0)));
		kuvaKehys.setBounds(380, 57, 180, 181);
		kuvanRaamit = new JLabel();
		kuvaKehys.add(kuvanRaamit);

		getContentPane().add(kuvaKehys);
		kuvanRaamit.setIcon(new ImageIcon(vakioKuva));

		JButton button = new JButton("Valitse kuva...");
		button.setBounds(380, 244, 180, 29);
		getContentPane().add(button);

		///////////////////////////////////////////////////////////////////////////////////////////////////////
		// Nappien tapahtumakuuntelijat
		///////////////////////////////////////////////////////////////////////////////////////////////////////

		lisaaNappi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				tallennaKirja();
			}
		});

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valitseKuva(e);
			}
		});

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Seuraavat metodit kuvatiedoston lataamista ja pienent‰mist‰ varten
	////////////////////////////////////////////////////////////////////////////////////////////////////////

	protected void valitseKuva(ActionEvent e) {

		// Luodaan valintalaatikko kuvan valintaa varten
		JFileChooser fc = new JFileChooser(basePath);
		FileFilter filter = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg");
		fc.setFileFilter(filter);

		int res = fc.showOpenDialog(null);

		// Kokeillaan valita kuva
		try {
			if (res == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				// Asetetaan valittu kuva uudeksi kuvaksi
				setTarget(file);
			}
			// Jos jokin menee mieleen
			else {
				JOptionPane.showMessageDialog(null, "You must select one image to be the reference.", "Aborting...",
						JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception iOException) {
		}

	}

	// Muutetaan kuvakoko sopivaksi
	public BufferedImage rescale(BufferedImage originalImage) {

		// Uuden kuvan mitat
		int width = 160;
		int height = 200;

		BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, width, height, null);
		g.dispose();
		System.out.println(resizedImage);
		return resizedImage;
	}

	// Asetetaan GUI;hin uusi kuva
	private void setTarget(File file) {
		{
			// Yritet‰‰n pienent‰‰ kuva
			try {
				targetFile = file;
				targetImg = rescale(ImageIO.read(file));
			} catch (IOException ex) {
				System.out.println("Error: " + ex);
			}

			// Mink‰ j‰lkeen asetetaan se GUI:hin
			System.out.println("Asetetaan kuva: " + targetFile);
			kuvanRaamit.setIcon(new ImageIcon(targetImg));
			setVisible(true);
		}

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Kirjan tiedot talteen
	///////////////////////////////////////////////////////////////////////////////////////////////////////

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
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			
			
//			try {
//				UIManager.setLookAndFeel(new MetalLookAndFeel());
//				MetalLookAndFeel.setCurrentTheme(new OceanTheme());
//			} catch (Exception e) {
//				System.err.println(e);
//			}

			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);

			UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
			for (UIManager.LookAndFeelInfo look : looks) {
				System.out.println(look.getClassName());
			}

			JFrame uusi = new KirjaPaneeliGUI();
			uusi.setSize(800, 400);

			uusi.setVisible(true);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
