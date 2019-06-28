/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fissmda.Shop_Subsystem;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pasindu
 */
public class DBConnection {
    
	public static final String dburl = "jdbc:mysql://localhost:3306/fissmda";
	public static final String dbUserName = "root";
	public static final String dbPassword = "";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(dburl, dbUserName, dbPassword);
		
	}
	
	public static void main(Object args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
                    //TODO Auto-generated catch block

		}
	}
}

