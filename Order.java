/**
 * This class is used to take in the cart, transfer the carts contents to its own array, 
 * request a check from the payment Object and tell the email class/object what to email 
 * i.e confirmation of order or notification of cancelation of order
 *
 * @author Michael Brennan
 * @version 11 Oct 23
 */

import java.util.ArrayList;
import java.util.Random;


public class Order
{
// most variables here just used to hold pointers to various required input Objects.
private Cart cart;
private Customer customer;
private Payment payment;
private ArrayList orderList = new ArrayList();
private ArrayList cartList;
private Email email;
private int orderNumber;

public Order(Email email, Cart cart, Payment payment){
    //using a random nubmer for the order number just so it can bee seen to be changing,
    //( if i counted up every time it would just be 0.
    Random rNum = new Random();
    orderNumber = rNum.nextInt(); 
    
    this.cart = cart;
    this.customer = cart.getCustomer();
    this.payment = payment;
    this.email = email;
    
    //checking that the cart has been confirmed before an order is placed.
    if(!cart.getCartState()){  
        System.out.println("Please confirm cart before ordering.");
    }   else{
            if(!payment.isValid()){// checking the payment requirements
                //unlocking the cart and sending email that the order process has failed
                cart.cartUnlock();
                email.emailRegret("Payment not accepted, cart has been kept, please update card information with a valid one.");
            }   else{
    
                    cartList = cart.getCartArray();

                    //transfering the cart list to order list
                    for(int i = 0;i < Item.getItemCount();i ++){
                        orderList.add(cartList.get(i));  
                    }

                    //sending success email
                    email.emailOrderSuccess(orderNumber, orderList, payment.getBillingAddress());

                    //resetting the cartList array to hold no values 0's
                    for(int i = 0;i < Item.getItemCount();i ++){
                        cartList.set(i, 0);  
                    }
    }}

}

//simple getter to get the order number
public int getOrderNumber(){
    return orderNumber;
}
 
    
}
