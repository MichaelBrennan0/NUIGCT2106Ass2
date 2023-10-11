/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version 1.0     4th Oct
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Payment
{
private int cardNumber;
private int csv;
private String cardName;
private Address billingAddress;
private LocalDateTime expDate;
private LocalDateTime currentDate;
private DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-yyyy");


public Payment(int cardNumber ,int csv,LocalDateTime expDate, String cardName){
this.cardNumber = cardNumber;
this.csv = csv;
this.expDate = expDate;
this.cardName = cardName;


}   
    
public boolean checkDate(){
    currentDate = LocalDateTime.now();
    if(expDate.compareTo(currentDate)<0){
    return false;
    }
    return true;
}

public void setBillingAddress(String country, String eircode, String county, String city,String line2,String line1){
billingAddress.setAddress(country, eircode, county, city, line2, line1);
}  

}
