/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author User
 */
public class CustomerAdd 
{
    private static final String DATABASE_URL = "jdbc:derby://localhost:1527/FlightSchedulerDBLINGYUXUljx5011";
    private static final String USERNAME = "java";
    private static final String PASSWORD = "java";   
    private Connection connect;
    private PreparedStatement CustomerAdder;
  ;
    
    public CustomerAdd(String cusname){
        try{
            
            connect = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            
            CustomerAdder = connect.prepareStatement("INSERT INTO CUSTOMERS" + "(NAME)" + "VALUES(?)");
            
            CustomerAdder.setString(1,cusname);
            
            CustomerAdder.executeUpdate();
            
           
        }
        catch(SQLException sqlException){
             sqlException.printStackTrace();
        }
    } 
}
