import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author User
 */
public class FlightNumber 
{
private static final String DATABASE_URL = "jdbc:derby://localhost:1527/FlightSchedulerDBLINGYUXUljx5011";
 private static final String USERNAME = "java";
 private static final String PASSWORD = "java";
     
 private Connection connection;
 private PreparedStatement F;
 
 String fnumber[] = new String[20];
 ResultSet resultSet;
         
 public FlightNumber (){
     try{
         connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        F = connection.prepareStatement("select FLIGHTNUMBER from FLIGHT");
     }
     catch(SQLException sqlException){
         sqlException.printStackTrace();
     }
 }
 
public String[] getflightIDList(){
    try{
        resultSet = F.executeQuery();
        
        for (int i=0; resultSet.next(); i++){
            
            fnumber[i] = (String) resultSet.getString(1);
        }
    }
    catch(SQLException sqlException){
         sqlException.printStackTrace();
     }
    return fnumber;
}

}
