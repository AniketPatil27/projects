package com.dbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connected {
	static String url="jdbc:mysql://localhost:3306/harmandb";
	
	static Connection connect() throws SQLException {
	return DriverManager.getConnection(url,"root","root");
	}
	
}