package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	Connection dbconnection;
	public Connection getconnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbconnection=DriverManager.getConnection("jdbc:mysql://localhost/sporsalonu?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return dbconnection;
	}

}
