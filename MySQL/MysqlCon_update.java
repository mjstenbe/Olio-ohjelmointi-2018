package MySQL;
import java.sql.*;

public class MysqlCon_update {

	public static void main(String args[]) {

		try {

			// Luodaan tietokantayhteys
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kirjat", "root", "");

			// Luodaan Statement-olio, joka keskustelee tietokannan kanssa
			Statement stmt = con.createStatement();

			// P‰ivitysoperaatio t‰ytyy tehd‰ executeUpdate -metodilla. 
			// K‰ytet‰‰n siisteyden vuoksi SQL lausetta joka on m‰‰ritelty muuttujaan
			
			String SQL_lause = "INSERT INTO KIRJAT VALUES ('Uusi Kirja','Uusi Tekij‰','2018')";
			int tuloksia = stmt.executeUpdate(SQL_lause);
			
			System.out.println("P‰ivitys vaikutti "+tuloksia+ " riviin.");
			
			// Luodaan tulosjoukko, johon sijoitetaan kyselyn tulos
			ResultSet rs = stmt.executeQuery("SELECT * FROM kirja");

			// Tulosjoukko k‰yd‰‰n silmukassa l‰pi
			while (rs.next())
				System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getInt(3));

			con.close();

			// Varaudutaan virheisiin
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}