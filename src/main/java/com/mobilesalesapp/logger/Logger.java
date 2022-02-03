package com.mobilesalesapp.logger;

import java.sql.SQLException;

public class Logger {
	private Logger() {

	}

	public static void printStackTrace(SQLException e) {
		e.printStackTrace();
	}

	public static void runTimeException(String message) {
		throw new RuntimeException(message);
	}
}
