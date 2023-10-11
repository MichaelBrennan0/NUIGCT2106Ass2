/**
 * Write a description of class Cart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cart
{
private boolean lockState = false; 
private ArrayList<Integer> cartList = new ArrayList<>();
private LocalDateTime creationDate;
private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");


//constructor  
public Cart(){
creationDate = LocalDateTime.now();

// This for loop makes sure that the array list has enough elements for each Item i.e there is a slot in this array
// list to hold how many of each item has been added to the cart, done so that the array element position = the item id.
  for (int i = 0; i < Item.getItemCount();i++){
    cartList.add(0);    
    }  
}

public void addItem(int itemID,int amount){
    //checking if the cart has been locked.
    if(lockState == false){
        //adding amout value to the element at the same item id.
        int a = cartList.get(itemID) + amount;
        cartList.set(itemID, a);
    }else {
            // telling the user that the cart has been locked
            System.out.println("Cart has been locked, No items have been added.");
        } 
}

public void cartLock(){lockState = true;}//locking the cart.
public void cartUnlock(){lockState = false;}//unlocking the cart.


public void printCart(){
    //a method to print the carts contents
System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
System.out.print("Cart created at:"+ creationDate);
System.out.println("Name \t Price \t Count \t Subotal");
float totalPrice = 0;
//this loop has been made so that items with 0 in the cart are ommited from the print statement
    for(int i = 0; i < Item.getItemCount();i++){
        if(cartList.get(i) > 0){
            // using temp to hold item poiter for the Item.
            Item temp = Item.getItemFromID(i);
            //adding values to the total
            totalPrice = totalPrice + cartList.get(i)*temp.getPrice();
            //printing the name,price,ammount and subtotal for each item.
            System.out.println(temp.getName() +"\t"+ temp.getPrice() +"\t"+ cartList.get(i) +"\t"+cartList.get(i)*(temp.getPrice()));
}
}
System.out.println("\t\t\t\t Total Price = "+ totalPrice);
System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
}


}