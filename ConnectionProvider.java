package dao;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;


public class ConnectionProvider {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/User","unknown","12345");
			return cn;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

}
