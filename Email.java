/**
 * This calls is to format and write emails to customers reguarding their order
 * this can be confirmation of orders or infromation on cancelations.
 *
 * Michael Brennan  I.D: 22759599
 * @version 15th Oct 23
 */

import java.util.ArrayList;

public class Email
{
//below are objects and variables needed to send the required information
//through the emails.
private String emailAddress;
private Customer customer;
private ArrayList<Integer> orderList;
private int orderNumber;
    
//constructor
public Email (String emailAddress, Customer customer){
    this.emailAddress = emailAddress;
    this.customer = customer;
}

//this email method is used if the Order was a success and sends the necisary information
    public void emailOrderSuccess(int orderNumber, ArrayList<Integer> orderList,Address billingAddress){
        this.orderNumber = orderNumber;
        this.orderList = orderList;
        float totalPrice = 0;
    
    System.out.println("\t\t~~~ Email start ~~~\t\t");
    System.out.println("To :\t "+ customer.getCustomerName() + " @ " + emailAddress);
    System.out.println("From :\t manyparts.com\n\n");
    System.out.println("Your order has been confirmed, the details are below.");
    System.out.println("your order number is: "+orderNumber);
    System.out.println("\nName \t Price \t Count \t Subotal");
    
    for(int i = 0; i < orderList.size();i++){

        
        if(orderList.get(i) > 0){
            // using temp to hold item poiter for the Item.
            Item temp = Item.getItemFromID(i);
            //adding values to the total
            totalPrice = totalPrice + orderList.get(i)*temp.getPrice();
            //printing the name,price,ammount and subtotal for each item.
            System.out.println(temp.getName() +"\t"+ temp.getPrice() +"\t"+ orderList.get(i) +"\t"+(orderList.get(i)*(temp.getPrice())));
}
}
    System.out.println("\nThe total price is €" + totalPrice+"\n");
    System.out.println("The delievery address is as follows:\n"+customer.getCustomerAddress().getAddressString());
    System.out.println("\nThe billing address is as follows:\n"+billingAddress.getAddressString());
    System.out.println("\nMany thanks from the Many Parts team.");
    System.out.println("\t\t~~~ Email end ~~~\t\t");
}
    
// this method is used if the order has been canceled.
public void emailRegret(String message){
        
    System.out.println("\t\t~~~ Email start ~~~\t\t");
    System.out.println("To \t:\t "+ customer.getCustomerName() + " @ " + emailAddress);
    System.out.println("From \t:\t manyparts.com\n\n");
    System.out.println("We regret to inform you that your order has been canceled for the reason :\n" + message);
    System.out.println("Your cart has been ulocked if you wish to update your information and try again.\n");
    System.out.println("Many thanks from the Many Parts team.");
    System.out.println("\t\t~~~ Email end ~~~\t\t");
}

}
