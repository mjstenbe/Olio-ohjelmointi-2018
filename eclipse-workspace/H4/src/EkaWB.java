import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.JSlider;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class EkaWB extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField ekaLuku;
	private JTextField tokaluku;
	private JTextField tuloskentta;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EkaWB frame = new EkaWB();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EkaWB() {
		setTitle("T\u00E4h\u00E4n ikkunan otsikko!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnOmaNappi = new JButton("Oma nappi");
		btnOmaNappi.setBounds(5, 233, 424, 23);
		contentPane.add(btnOmaNappi);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 424, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLmptilamuunnin = new JLabel("L\u00E4mp\u00F6tilamuunnin");
		lblLmptilamuunnin.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblLmptilamuunnin.setBounds(10, 11, 223, 22);
		panel.add(lblLmptilamuunnin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 38, 206, 195);
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("Uusi nappi");
		btnNewButton.setFont(new Font("Tekton Pro Cond", Font.PLAIN, 16));
		btnNewButton.setIcon(new ImageIcon(EkaWB.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_1.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnEkaNappi = new JButton("Eka nappi");
		btnEkaNappi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Hoi Maailma!");
			}
		});
		btnEkaNappi.setBounds(234, 49, 89, 23);
		contentPane.add(btnEkaNappi);
		
		ekaLuku = new JTextField();
		ekaLuku.setBounds(333, 49, 86, 20);
		contentPane.add(ekaLuku);
		ekaLuku.setColumns(10);
		
		JButton btnTokaNoppi = new JButton("Toka noppi");
		btnTokaNoppi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String eka = ekaLuku.getText();
				String toka = tokaluku.getText();
				
				int ek = Integer.parseInt(eka);
				int t = Integer.parseInt(toka);
				
				int tulos = ek + t;
				
				tuloskentta.setText(""+tulos);
				
				
			}
		});
		btnTokaNoppi.setBounds(234, 83, 89, 23);
		contentPane.add(btnTokaNoppi);
		
		tokaluku = new JTextField();
		tokaluku.setBounds(333, 80, 86, 20);
		contentPane.add(tokaluku);
		tokaluku.setColumns(10);
		
		tuloskentta = new JTextField();
		tuloskentta.setBounds(333, 111, 86, 20);
		contentPane.add(tuloskentta);
		tuloskentta.setColumns(10);
		
		table = new JTable();
		table.setBounds(253, 210, 89, -32);
		contentPane.add(table);
	}
}
