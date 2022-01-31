package com.mobilesalesapp.util;

import java.sql.*;

public class ConnectionUtil {
	  ConnectionUtil() {
		    throw new IllegalStateException("Utility class");
		  }
	public static Connection connect() {
		Connection con = null;
		try {
			EncryptionAndDecryption encrypt=new EncryptionAndDecryption();
			Class.forName("oracle.jdbc.OracleDriver");
			String userName="system";
			String password= encrypt.decryt();
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",userName ,password);
		} catch (Exception e) {
	
			e.getMessage();
		}
		return con;

	}

}
