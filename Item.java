/**
 * Class used to create and hold values for items that can be purchased.
 *
 * @author Michaeal Brennan     I.D: 22759599
 * @version 1.0                 26/09/23
 */

import java.util.ArrayList;

public class Item
{
//itemCount is used to keep track of the number of different items and automatically increment the item id.
private static int itemCount = 0;
private int id;

private String name;
private float price;
private String description;
// Array list so that an item can be called from its item id as the position in the array list is the same as the items id.
private static ArrayList<Item> itemIDlist = new ArrayList<>();

//constructor
public Item(String name, float price, String description){
this.id = itemCount;
itemCount++;
this.name = name;
this.price = price;
this.description = description;
} 


//this creates the test items and adds them to their ArrayList so that they are easier to find using their ID
public static void testItemSetup(){

Item uF10 = new Item("10uF", 0.17F, "Electrolytic capacitor");
itemIDlist.add(uF10);

Item ohm100 = new Item("100Ohm", 0.001F,"25 watt, nicrome");
itemIDlist.add(ohm100);

Item volt6 = new Item("6 Volt", 7F, "0.5 Amp, 2.3Ah, LiPo");
itemIDlist.add(volt6);

Item henry20uH = new Item("20uH", 0.5F, "Toroidal");
itemIDlist.add(henry20uH);

}


//setters
public void setName(String name){
    this.name = name;
}
public void setPrice(float price){
    this.price = price;
}
public void setDescription(String description){
    this.description = description;
}

//getters
public String getName(){
    return name;
}

public float getPrice(){
    return price;
}

public String getDescription(){
    return description;
}

// method to return an item when called by is id.
public static Item getItemFromID(int id){
return itemIDlist.get(id);
}

//method to get the count of how many items have been created, used in for loops mostly
public static int getItemCount(){
    return itemCount;
}      



}