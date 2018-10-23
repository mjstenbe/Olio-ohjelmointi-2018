package Kirja;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class KirjaDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			KirjaDialog dialog = new KirjaDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public KirjaDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("Kirjan hallinta");
			label.setFont(new Font("Tahoma", Font.PLAIN, 19));
			label.setBounds(15, 0, 195, 20);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Kirjan nimi:");
			label.setBounds(15, 67, 111, 20);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Tekij\u00E4:");
			label.setBounds(15, 112, 111, 20);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Julkaisuvuosi:");
			label.setBounds(15, 162, 111, 20);
			contentPanel.add(label);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(129, 64, 146, 26);
			contentPanel.add(textField_1);
		}
		{
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(129, 109, 146, 26);
			contentPanel.add(textField_2);
		}
		{
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(129, 159, 146, 26);
			contentPanel.add(textField_3);
		}
		{
			JButton button = new JButton("Lis\u00E4\u00E4 kirja");
			button.setBounds(15, 217, 115, 29);
			contentPanel.add(button);
		}
		{
			JButton button = new JButton("Tyhjenn\u00E4");
			button.setBounds(173, 217, 115, 29);
			contentPanel.add(button);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
