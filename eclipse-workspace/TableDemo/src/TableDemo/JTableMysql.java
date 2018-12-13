package TableDemo;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;

public class JTableMysql {

	public static void main(String[] args) {

		// Luodaan tietorakenne, jonne tietokannasta haetut rivit voidaan tallentaa
		ArrayList<Object[]> data = new ArrayList<Object[]>();

		try {

			// Luodaan tietokantayhteys
			Connection con = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7265083",
					"sql7265083", "UU8TSn6Z6G");

			// Luodaan Statement-olio, joka keskustelee tietokannan kanssa
			Statement stmt = con.createStatement();

			// Luodaan tulosjoukko, johon sijoitetaan kyselyn tulos
			ResultSet rs = stmt.executeQuery("SELECT * FROM kirja");

			// Tulosjoukko k‰yd‰‰n silmukassa l‰pi

			while (rs.next()) {
				System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getInt(3));

				data.add( new Object[] { rs.getString(1), rs.getString(2), rs.getString(3) } );
				
				// model.addRow(new Object[] { "1", "Column 2", "Column 3" });
			
			}
			con.close();

			// Varaudutaan virheisiin
		} catch (Exception e) {
			System.out.println(e);
		}

		JScrollPane scrollPane = new JScrollPane();

		// Lis‰t‰‰n sarakkeet kirjaa varten
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Kirjan nimi");
		model.addColumn("Tekij‰");
		model.addColumn("Julkaisuvuosi");

		JTable table = new JTable(model);

//		model.addRow(new Object[] { "1", "Column 2", "Column 3" });
//		model.addRow(new Object[] { "1", "Column 2", "Column 3" });
//		model.addRow(new Object[] { "1", "Column 2", "Column 3" });
		
		// K‰yd‰‰n silmukassa
		for (int i=0; i < data.size(); i++ ) {
			model.addRow(data.get(i));
		}

		JFrame ikkuna = new JFrame();
		ikkuna.setTitle("Taulukkodemo");

		ikkuna.add(scrollPane);
		scrollPane.setViewportView(table);

		ikkuna.pack();
		ikkuna.setVisible(true);

	}

}
