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
 * @author 28754
 */
public class FlightADD
{
    
    private static final String DATABASE_URL = "jdbc:derby://localhost:1527/FlightSchedulerDBLINGYUXUljx5011";
    private static final String USERNAME = "java";
    private static final String PASSWORD = "java";
        
    private Connection connect;
    private PreparedStatement FlightAdder;
    private PreparedStatement SeatAdder;
    
      public FlightADD(String flgihtname,int flightseat)
      {
        try{
    connect = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            
            FlightAdder = connect.prepareStatement("INSERT INTO FLIGHT" + "(FLIGHTNUMBER)" + "VALUES(?)");
            SeatAdder = connect.prepareStatement("INSERT INTO FLIGHT" + "(SEAT) where FLIGHTNUMBER = ?"+ "VALUES(?)");
            
          FlightAdder.setString(1,flgihtname);
          SeatAdder.setInt(2, flightseat);
            
           FlightAdder.executeUpdate();
           SeatAdder.executeUpdate();
           
        }
        catch(SQLException sqlException){
             sqlException.printStackTrace();
        }
    } 
    
    
    
    
    
}
