/**
 * cart is a class to be used as a place to store what and how may items can be bought before they are bought
 * has cart lock methods and a creation date, carts are also linked to a particular customer.
 *
 * Michael Brennan  I.D: 22759599
 * @version 28/09/23
 */
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Cart
{
private boolean lockState = false; 
private ArrayList<Integer> cartList = new ArrayList<>();
private LocalDateTime creationDate;
private Customer customer;

//constructor must provide customer linked to the cart
public Cart(Customer customer){
    //setting the creation date.
    creationDate = LocalDateTime.now();
    this.customer = customer;
    // This for loop makes sure that the array list has enough elements for each Item i.e there is a slot in this array
    // list to hold how many of each item has been added to the cart, done so that the array element position = the item id.
    for (int i = 0; i < Item.getItemCount();i++){
        cartList.add(0);    
    }  
}

public void addItem(int itemID,int amount){
    //checking if the cart has been locked.
    if(lockState == false){
        //adding amount value to the element at the same item id(array element).
        int a = cartList.get(itemID) + amount;
        cartList.set(itemID, a);
    }else {
            // telling the user that the cart has been locked
            System.out.println("Cart has been locked, No items have been added.");
        } 
}

public void removeItem(int itemID,int amount){
    if(lockState == false){
        //removing amount value to the element at the same item id(array element).
        int a = cartList.get(itemID) - amount;
        cartList.set(itemID, a);
    }else {
            System.out.println("Cart has been locked, No items have been added.");
        } 
}


public void cartConfirm(){lockState = true;}//locking the cart.
public void cartUnlock(){lockState = false;}//unlocking the cart.

public boolean getCartState(){return lockState;}


public void printCart(){
    //a method to print the carts contents and iformation of ammount(s) and pricing.
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("Cart created at:"+ creationDate +"\n");
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
            System.out.println(temp.getName() +"\t"+ "€"+temp.getPrice() +"\t"+ cartList.get(i) +"\t"+"€"+cartList.get(i)*(temp.getPrice()));
        }
    }
    System.out.println("\t\t\t\t Total Price = €"+ totalPrice);
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
}

// this getter returns the carts array.
public ArrayList  getCartArray(){
return cartList;
}

//returns the customer linked to this cart.
public Customer getCustomer(){
return customer;
}

}