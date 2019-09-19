
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;

/**
 * @author User
 */

public class WAITLIST 
{
private static final String DATABASE_URL = "jdbc:derby://localhost:1527/FlightSchedulerDBLINGYUXUljx5011";
    private static final String USERNAME = "java";
    private static final String PASSWORD = "java";
        
    private Connection connection;
    private PreparedStatement getWaitlistCustomer;
    
    private Date d;
    ResultSet result;
    private ArrayList<String> waitlistedCustomersList = new ArrayList<String>();
    
    public WAITLIST(Date d){
        try{
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            getWaitlistCustomer = connection.prepareStatement("select CUSTOMER from WAITLIST where DATE = ?");
            this.d = d;
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
    
    public ArrayList<String> getWaitlistCustomer()
    {
        this.waitlistedCustomersList.clear();
        
        try{
            getWaitlistCustomer.setDate(1, d);
            result = getWaitlistCustomer.executeQuery();
            
            while (result.next()){
                this.waitlistedCustomersList.add(result.getString("CUSTOMER"));
            }
        }
        
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return this.waitlistedCustomersList;
    }    
    
}
