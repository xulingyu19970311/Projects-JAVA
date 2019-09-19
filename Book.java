import java.sql.Date;

public class Book {
    private String customername;
    private String flightnumber;
    private Date date;
   
    public Book(String cname, String fnumber, Date day){
        
        setcustomerName(cname);
        setflightNumber(fnumber);
        setdate(day);
    }
    
    public void setcustomerName(String custn) { this.customername = custn;}
    public void setflightNumber(String flightn) { this.flightnumber = flightn;}
    public void setdate(Date d) { this.date = d; }
    
    public String getcustomerName(){ return this.customername;}
    public String getflightNumber() {return this.flightnumber;}
    
    public Date getdate() {return this.date;}
    
}
