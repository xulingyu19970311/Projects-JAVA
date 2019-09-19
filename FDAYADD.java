
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;


/**
 *
 * @author 28754
 */
public class FDAYADD 
{
    private static final String DATABASE_URL = "jdbc:derby://localhost:1527/FlightSchedulerDBLINGYUXUljx5011";
    private static final String USERNAME = "java";
    private static final String PASSWORD = "java";
        
    private Connection connect;
    private PreparedStatement FlightdayAdder;
  

            
      public FDAYADD(String Flightdate)
      {
          
        try{
            
           String Fdate;
            
           DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
           
          connect = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            
          FlightdayAdder = connect.prepareStatement("INSERT INTO DATE" + "(DAY)" + "VALUES(?)");
          
          
           Fdate= formatter.format(Flightdate);
            
          FlightdayAdder.setString(1, Fdate);
         
            
          FlightdayAdder.executeUpdate();
          
           
        }
        catch(SQLException sqlException){
             sqlException.printStackTrace();
        }
    
      }
}
