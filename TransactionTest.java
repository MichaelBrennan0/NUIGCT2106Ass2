/**
 * Test class
 *
 * Michael Brennan  I.D: 22759599
 * @version 15th Oct 23
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TransactionTest
{
    
public static void main(String[] args) { 
    //setting up the items to be used.
    Item.testItemSetup();
    //allowing for this classes tests(methods) to be called, i could have altrnativly added  the this
    //keyword to the start of those methods to be able to call them like : TransactionTest.test1();
    TransactionTest tester = new TransactionTest();
    
    tester.test1();
    tester.test2();
}

public void test1(){ 
    System.out.println("=============================== Test 1 Start ===============================");
    //setting up the customer
    Customer userA = new Customer("Barret","Ireland","Azxy22","Dublin","Dublin","Quack heights","64 Zoo Lane");

    //setting up the expirery date for the card.
    LocalDateTime expDateA = LocalDateTime.of(2025, 6, 28,0,0,0);//goes by yyyy-mm-dd-hh-mm-ss ignoring day to second
    //add ing the card info.
    Payment paymentA = new Payment("00000000001212", "Visa", expDateA ,"Barret");
    //i seperated the card info and billing address to simplify this part.
    paymentA.setBillingAddress("Ireland","R6969","notDublin","littleBig Town","Quack heights","onty one rock S.t.");

    // setting up the information
    Email emailA = new Email("barett11@trxmail.com", userA);

    //adding a cart.
    Cart cartA = new Cart(userA);
    //adding items to the cart.
    cartA.addItem(0,1);
    cartA.addItem(2,1);
    cartA.addItem(3,1);
    //confirming the cart.
    cartA.cartConfirm();
    
    //calling for an order
    Order orderA = new Order(emailA, cartA, paymentA);
    System.out.println("=============================== Test 1 End ===============================\n\n");
}

public void test2(){
    System.out.println("=============================== Test 2 Start ===============================");
    //mostly same as in test1.
    Customer user2 = new Customer("Jimbob","Ireland","F6969","notDublin","littleBig Town","Quack heights","onty one rock S.t.");

    LocalDateTime expDate2 = LocalDateTime.of(2022, 4, 28,0,0,0);
    Payment payment2 = new Payment("09127553828562467", "Visa", expDate2, "Jimothy");
    payment2.setBillingAddress("Ireland","R6969","notDublin","littleBig Town","Quack heights","onty one rock S.t.");

    Email email2 = new Email("jim@bob.ie", user2);
    Cart cart2 = new Cart(user2);
    cart2.addItem(2,1);
    cart2.addItem(3,1);
    cart2.addItem(2,1);
    //printing the cart for scenario 2.
    cart2.printCart();
    //removing item
    cart2.removeItem(3,1);
    //printing cart again to confirm that the item has been removed.
    cart2.printCart();

    cart2.cartConfirm();

    Order order2 = new Order(email2, cart2, payment2);

System.out.println("=============================== Test 2 End ===============================\n\n");
}




}
