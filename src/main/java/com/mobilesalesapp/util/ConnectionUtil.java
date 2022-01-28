package com.mobilesalesapp.util;

import java.sql.*;

public class ConnectionUtil {
	  ConnectionUtil() {
		    throw new IllegalStateException("Utility class");
		  }
	public static Connection connect() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String userName="system";
			String password= "oracle";
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",userName ,password);
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		return con;

	}

}
