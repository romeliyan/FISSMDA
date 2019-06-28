/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fissmda.Shop_Subsystem;

/**
 *
 * @author Binali Jayawindi
 */
public class Shop {
    private int sID;
    private String sName, oName, email, address, pNumber1, pNumber2;
    private float latitude, longitude;
    
    public Shop(int sID, String sName, String oName, String email, String address, String pNumber1, float latitude, float longitude){
        this.sID = sID;
        this.sName = sName;
        this.oName = oName;
        this.address = address;
        this.pNumber1 = pNumber1;
        //this.pNumber2 = pNumber2;
        this.email = email;
       // this.radioTxt = radioTxt;
        this.latitude = latitude;
        this.longitude = longitude;
        
    }

    public int getsID() {
        return sID;
    }

    public String getsName() {
        return sName;
    }

    public String getoName() {
        return oName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getpNumber1() {
        return pNumber1;
    }

    /*public String getpNumber2() {
        return pNumber2;
    }*/

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }
    
    
  
    

}
