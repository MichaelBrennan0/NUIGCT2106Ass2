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
private ArrayList<Integer> cartList = new ArrayList<>();
private LocalDateTime creationDate;

//constructor  
public Cart(){
creationDate = LocalDateTime.now();
  for (int i = 0; i < Item.getItemCount();i++){
    cartList.add(0);    
    }  
}

public void addItem(int itemID,int amount){
if(lockState == false){
int a = cartList.get(itemID) + amount;
cartList.set(itemID, a);
}else {System.out.println("Cart has been locked, No items have been added.");} 
}

public void cartLock(){lockState = true;}
public void cartUnlock(){lockState = false;}


public void printCart(){
System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
System.out.print("Cart created at:"+ creationDate);
System.out.println("Name \t Price \t Count \t Total");
float totalPrice = 0;

    for(int i = 0; i < Item.getItemCount();i++){
        if(cartList.get(i) > 0){
            Item temp = Item.getItemFromID(i);
            totalPrice = totalPrice + i*temp.getPrice();
            System.out.println(temp.getName() +"\t"+ temp.getPrice() +"\t"+ i +"\t"+i*(temp.getPrice()));
}
}
System.out.println("\t\t\t\t Total Price = "+ totalPrice);
System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
}


}