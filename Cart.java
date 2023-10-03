/**
 * Write a description of class Cart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Cart
{
private boolean lockState = false; 
private ArrayList<Item> cartList = new ArrayList<Item>();
private LocalDateTime creationDate;


//constructor  
public Cart(){
creationDate = LocalDateTime.now();
    
}

public void addItem(int itemID,int amount){
if(lockState == false){
for(int i = 0; i > amount; i++){
cartList.add(Item.getItemFromID(itemID));
}}else {System.out.println("Cart has been locked, No items have been added.");} 
}

public void cartLock(){lockState = true;}
public void cartUnlock(){lockState = false;}

public void printCart(){
for(Item i : cartList){


}
}
}