package br.com.cotiinformatica.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public static Connection getConnection() throws Exception {
		
		String url = "jdbc:mysql://localhost:3306/bddesafio?useTimezone=true&serverTimezone=UTC&useSSL=false";
		String user = "root";
		String password = "coti";
		String driver = "com.mysql.jdbc.Driver";
		
		Class.forName(driver);
		return DriverManager.getConnection(url, user, password);
		
	}

}
