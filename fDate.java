
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 * @author User
 */
public class fDate {
     private static final String DATABASE_URL = "jdbc:derby://localhost:1527/FlightSchedulerDBLINGYUXUljx5011";
    private static final String USERNAME = "java";
    private static final String PASSWORD = "java";
        
    
    private PreparedStatement F;
    private Connection connection;
    
    String f[] = new String[30];
    
    ResultSet result;
            
    public fDate(){
        try{
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            
            F = connection.prepareStatement("select DAY from DATE");
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
    
   public String[] getflightDate(){
       
       try{
           result = F.executeQuery();
           
           DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
           
           for (int i=0; result.next(); i++){
               
               String s = formatter.format(result.getDate(1));
               f[i] = s;
           }
       }
       catch(SQLException sqlException){
           
            sqlException.printStackTrace();
        }
       return f;
   }
    
}
