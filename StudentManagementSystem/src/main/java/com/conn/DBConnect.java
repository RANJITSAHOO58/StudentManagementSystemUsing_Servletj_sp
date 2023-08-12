package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	private static Connection conn=null;
	
	public static Connection getConn()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-TFHJEAE:1521:XE"," XE","orcl");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
}
