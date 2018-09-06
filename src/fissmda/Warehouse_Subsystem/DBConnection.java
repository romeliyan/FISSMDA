/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fissmda.Warehouse_Subsystem;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author melan
 */
public class DBConnection {
    
    //Configure Database Core 
    private static String dbUrl="jdbc:mysql://localhost:3306/fissmda";
    private static String dbUsername="root";
    private static String dbPassword="";
    private static String dbDriverName="com.mysql.jdbc.Driver";
    private static Connection connection =null;
    
    public static Connection getConnection(){
        
        
        try{
            //Define Driver to Project
            Class.forName(dbDriverName);
            
            //assign values to get connection object
            connection = (Connection) DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
             
        }catch(Exception e){
            //Error Prompt Message
            e.printStackTrace();
        }
    
        return connection;
    }
}
