package br.com.projetofilmes.cnn;

import java.sql.*;

public class ConnectionFactory {
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/filmesdb?useTimezone=true&serverTimezone=UTC&useSSL=false";
			Connection cnn = DriverManager.getConnection(url, "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		return null;
		
	}

}
