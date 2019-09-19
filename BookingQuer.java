
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
/**

 * @author User
 */
public class BookingQuer {
    
     private static final String DATABASE_URL = "jdbc:derby://localhost:1527/FlightSchedulerDBLINGYUXUljx5011";
    private static final String USERNAME = "java";
    private static final String PASSWORD = "java";
        
    private Connection connection;
    private PreparedStatement getBookCustomer;
    
    
    private Date day;
    private String flightn;
    
    private ArrayList<String> bookedCustomersList = new ArrayList<String>();
    ResultSet result;
    
    public BookingQuer(String flightn, Date day){
        try{
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            getBookCustomer = connection.prepareStatement("select CUSTOMER from BOOKING where FLIGHTNUMBER = ? and DATE = ?");
            
            this.flightn = flightn;
            
            this.day = day;
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
    
    
    public ArrayList<String> getBookCustomers(){
        this.bookedCustomersList.clear();
        try{
            
            getBookCustomer.setString(1, this.flightn);
            getBookCustomer.setDate(2, this.day);
            
            result = getBookCustomer.executeQuery();
            
            while (result.next()){
                this.bookedCustomersList.add(result.getString("Customer"));
            }
            
        }
        
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return this.bookedCustomersList;
    }
}
