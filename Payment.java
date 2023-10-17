/**
 * Class to hold payment information and check said info when a payment is made.
 *
 * @author Michael Brennan  I.D: 22759599
 * @version 1.0     4th Oct
 */
import java.time.LocalDateTime;

public class Payment
{
private String cardNumber;
private String ppn;// this is the payment processing network that the card is from (card Provider).
private String cardHolder;
private Address billingAddress = new Address();
private LocalDateTime expDate;
private LocalDateTime currentDate;

// constructor
public Payment(String cardNumber, String ppn, LocalDateTime expDate, String cardHolder){   
    this.cardNumber = cardNumber;
    this.ppn = ppn;
    this.expDate = expDate;
    this.cardHolder = cardHolder;
}   

private boolean checkNumberLength(){
    //making sure that the card number is correct length, 
    //could have also checked if all the values where numbers but i did not
    if((cardNumber.length() > 12) && (cardNumber.length() < 20)){
        return true;
    }
    System.out.println("\n-System message- Payment canceled,  invalid card number\n");
    return false;
}


private boolean checkDate(){
    currentDate = LocalDateTime.now();
    if(expDate.compareTo(currentDate) < 0){
        //checking the expiry date vs the current date value will be less than 0 if ithe expiry date has passed.
        System.out.println("\n-System message- Payment canceled, card is out of date\n");
        return false;
    }
    return true;
}

// chaecking that the ppn is valid
private boolean checkPpn(){
    
    if((ppn.equals("Mastercard")) || (ppn.equals("Visa")) || (ppn.equals("visa")) || (ppn.equals("mastercard"))){
        return true;
    }else{
        System.out.println("\n-System message- Payment canceled invalid payment processing network name/card provider name.\n");
        return false;
}
}

public boolean isValid(){
    //making sure the the ppn date and number length are all vaild together.
    if(checkNumberLength() && checkPpn() && checkDate()){
        //ensuring that the billing address has been added
        if(billingAddress == null){
            return false;
        }
        return true;
        }
    return false;

}


//setters
public void setBillingAddress(String country, String eircode, String county, String city,String line2,String line1){
billingAddress.setAddress(country, eircode, county, city, line2, line1);
}  

//getter
public Address getBillingAddress(){
return billingAddress;
}

}
