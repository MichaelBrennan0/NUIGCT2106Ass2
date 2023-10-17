/**
 * Simple Address class to hold various fields(strings) to hold ones address, has setter and getter
 *
 * @author Michael Brennan  I.D: 22759599
 * @version 26/09/23
 */
public class Address
{
private String line1;
private String line2;
private String city;
private String county;
private String country;
private String eircode;

//two constructors so that an object can be named first and afterwards be set and also be made and set
// i ran into some null pointer errors.
public Address(){
line1 = "line1";
line2 = "line2";
city = "city";
county = "county";
country = "country";
eircode = "eircode";
}

public Address(String country, String eircode, String county, String city, String line2, String line1){
this.line1 = line1;
this.line2 = line2;
this.city = city;
this.county = county;
this.country = country;
this.eircode = eircode;
}

//setter
public void setAddress(String country, String eircode, String county, String city, String line2, String line1){
this.line1 = line1;
this.line2 = line2;
this.city = city;
this.county = county;
this.country = country;
this.eircode = eircode;
}

//getter
public String getAddressString(){
return eircode +"\n" + line1 +"\n" + line2 +"\n" + city +"\n" +county +"\n" +country;
}

}
