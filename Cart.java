/**
 * Write a description of class Cart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Date;

public class Cart
{
private boolean lockState = false; 
 
private ArrayList<Item> cartList = new ArrayList<Item>();

//constructor  
public Cart(){
    Date creationDate = java.time.LocalDate.now();}


public void addItem(int itemID,int amount){
for(int i = 0;i>amount;i++){
cartList.add(Item.getItemFromID(itemID));
} 
  
}



}