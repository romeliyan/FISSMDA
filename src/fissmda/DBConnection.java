/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fissmda;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pasindu
 */
public class DBConnection {
    
    public Connection getConnection() throws ClassNotFoundException, SQLException
    {
        try
	{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/fissmda", "root", "");
            return connection;
	}
	catch(ClassNotFoundException e)
	{
            e.printStackTrace();
            return null;
	}
	catch(SQLException e)
        {
            e.printStackTrace();
            return null;
	}
    }
}
