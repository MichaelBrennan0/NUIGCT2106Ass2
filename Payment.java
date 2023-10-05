/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version 1.0     4th Oct
 */
public class Payment
{
private int cardNumber;
private int csv;
private String cardName;
private Address billingAddress;

public Payment(int cardNumber ,int csv, String cardName,String country, String eircode, String county, String city,String line2,String line1){
this.cardNumber = cardNumber;
this.csv = csv;
this.cardName = cardName;
billingAddress.setAddress(country, eircode, county, city, line2, line1);

}   
    
    
}
