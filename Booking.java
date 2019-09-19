import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author User
 */
public class Booking 
{
     private static final String DATABASE_URL = "jdbc:derby://localhost:1527/FlightSchedulerDBLINGYUXUljx5011";
    private static final String USERNAME = "java";
    private static final String PASSWORD = "java";
        
    private Connection connection;
    private PreparedStatement addBooking;
    private PreparedStatement addWaitlist;
    private PreparedStatement countFlightSeats;
    private Book B;
    ResultSet resultSet;
   
    public Booking(Book B){
        this.B = B;
        try{
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            addBooking = connection.prepareStatement("insert into BOOKING" + "(FLIGHTNUMBER, CUSTOMER, DATE)" + "VALUES(?,?,?)");
            addWaitlist = connection.prepareStatement("insert into WAITLIST" + "(FLIGHTNUMBER, CUSTOMER,DATE)" + "VALUES(?,?,?)");
            countFlightSeats = connection.prepareStatement("select SEAT from FLIGHT where FLIGHTNUMBER = ?");
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
    
   
    
    public void addtoWaitlist(){
        try{
             addWaitlist.setString(1, B.getflightNumber());
             addWaitlist.setString(2, B.getcustomerName());
             addWaitlist.setDate(3, B.getdate());
             addWaitlist.executeUpdate();
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
    
     public void addtoBooking(){
        try{
            addBooking.setString(1, B.getflightNumber());
            addBooking.setString(2, B.getcustomerName());
            addBooking.setDate(3, B.getdate());
            addBooking.executeUpdate();
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
     
    public int getFlightSeats(String flightnumber){
        int seatsleft  = 0;
        try{
            countFlightSeats.setString(1, flightnumber);
            resultSet = countFlightSeats.executeQuery();
            resultSet.next();
            seatsleft = resultSet.getInt(1);
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return seatsleft;
    }
    
    public boolean check(){
        int seatsBooked = new BookingQuer(B.getflightNumber(), B.getdate()).getBookCustomers().size();
        int seats = getFlightSeats(B.getflightNumber());
        return seats>seatsBooked;
    }
}
    

