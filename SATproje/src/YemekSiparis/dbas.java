package YemekSiparis;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class dbas {
	static Connection con;
	static Statement stat;
	
	public dbas() {
		
	}

public Connection baglanti() {
		try {
			 con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema?useSSL=false" , "root", "1234");
			 return con;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connection Failed "+e);
		}
      return con;
	}


}