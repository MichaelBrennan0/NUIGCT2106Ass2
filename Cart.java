/**
 * Write a description of class Cart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class Cart
{
private boolean lockState = false; 
 
private ArrayList<Item> cartList = new ArrayList<Item>();

//constructor  
public Cart(){
;}


public void addItem(int itemID,int amount){
for(int i = 0;i>amount;i++){
cartList.add(Item.getItemFromID(itemID));
} 
  
}



}