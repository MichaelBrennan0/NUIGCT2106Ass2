/**
 * basic Class to hold basic customer information.
 *
 * @author Michael Brennan  I.D: 22759599
 * @verion 1.0              26/09/23
 */

import java.util.Random;

public class Customer
{

private static int customerCount = 0;
private final int customerID;
private String customerName;
private Address address1;

public Customer(String customerName, String country, String eircode, String county, String city,String line2,String line1){
    //if i wanted to make sure that the customerid was truely random i might make an array list of the current customer id's and check against that.
    Random rNum = new Random();
    customerID=rNum.nextInt();
    customerCount++;
    this.customerName = customerName;
    address1.setAddress(country, eircode, county, city, line2, line1);
    
}

//setters
public void setCustomerName(String name){
customerName = name; 
}


//getters
public String getCustomerName(){
return customerName;
}

public int getCustomerID(){
return customerID;
}

}
