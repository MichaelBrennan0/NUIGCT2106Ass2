
/**
 * Write a description of class Address here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Address
{
private String line1;
private String line2;
private String city;
private String county;
private String country;
private String eircode;

public Address(String country, String eircode, String county, String city,String line2,String line1){
this.line1 = line1;
this.line2 = line2;
this.city = city;
this.county = county;
this.country = country;
this.eircode = eircode;
}

//setter
public void setAddress(String country, String eircode, String county, String city,String line2,String line1){
this.line1 = line1;
this.line2 = line2;
this.city = city;
this.county = county;
this.country = country;
this.eircode = eircode;
}

//getter
public String getAddressString(){
return country + county + city + line2 + line1 + "\t" + eircode;
}



}
