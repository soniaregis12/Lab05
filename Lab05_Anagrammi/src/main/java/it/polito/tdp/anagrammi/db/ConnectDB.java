package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
;

class ConnectDB {
	
	public static Connection getConnection() throws SQLException {
		
		String jdbcURL = "jdbc:mysql://localhost/dizionario?user=root&password=MuccaVolante98";

		return DriverManager.getConnection(jdbcURL);
	}

}
