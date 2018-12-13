package TableDemo;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableDemo {

	public static void main(String[] args) {

		JScrollPane scrollPane = new JScrollPane();

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Code");
		model.addColumn("Name");
		model.addColumn("Quantity");
		model.addColumn("Unit Price");
		model.addColumn("Price");

		JTable table = new JTable(model);
		

		model.addRow(new Object[] { "1", "Column 2", "Column 3", "Column 4", "Column 5" });
		model.addRow(new Object[] { "2", "Column 2", "Column 3", "Column 4", "Column 5" });
		model.addRow(new Object[] { "3", "Column 2", "Column 3", "Column 4", "Column 5" });
		model.addRow(new Object[] { "4", "Column 2", "Column 3", "Column 4", "Column 5" });
		model.addRow(new Object[] { "5", "Column 2", "Column 3", "Column 4", "Column 5" });

		model.setValueAt("Uusi tietoalkio", 1, 1);
		
		
		model.removeRow(2);

		JFrame ikkuna = new JFrame();
		ikkuna.setTitle("Taulukkodemo");
		
		ikkuna.add(scrollPane);
		scrollPane.setViewportView(table);
		
		

		
		ikkuna.pack();
		ikkuna.setVisible(true);

	}

}
