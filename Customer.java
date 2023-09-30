
/**
 * basic Class to hold basic customer information.
 *
 * @author Michael Brennan  I.D: 22759599
 * @verion 1.0              26/09/23
 */
public class Customer
{
private static int customerCount = 0;
private final int customerID;
private String customerName;

public Customer(String customerName){
    customerID=customerCount;
    customerCount++;
    this.customerName = customerName;
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
