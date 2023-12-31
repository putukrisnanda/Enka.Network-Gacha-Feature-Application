package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import MainClass_GenshinGacha.Models_Character;

public class EnkaNetwork_DatabaseManager {

	private final String USERNAME = "root";
	private final String PASSWORD = "";
	private final String DATABASE = "enkanetwork";
	private final String HOST = "localhost:3306";
	private final String URL = String.format
			("jdbc:mysql://%s/%s", HOST, DATABASE);

	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public static EnkaNetwork_DatabaseManager connect;
	
	public static EnkaNetwork_DatabaseManager getInstance () {
		
		if (connect == null) {
			connect = new EnkaNetwork_DatabaseManager();
		}
		
		return connect;
	}
	public ResultSet execQuery (String query) {
		try {
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	public void execUpdate (String query) {
		
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}
	private EnkaNetwork_DatabaseManager() {	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			st = con.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}

