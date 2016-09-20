package javaPatternFabrique1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BDDConfigApp implements IConfigApp {
	
	private String BDDName;
	private String BDDAdress;
	
	private Connection connection;
	
	public BDDConfigApp(String bDDName, String bDDAdress) {
		BDDName = bDDName;
		BDDAdress = bDDAdress;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(BDDAdress + BDDName,"root","");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void BDDClose(){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public String getConfigValue(String name) {
		return null;
	}

	@Override
	public void setConfigValue(String name, String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}
	

}
