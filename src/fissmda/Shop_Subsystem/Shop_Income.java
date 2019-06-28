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
public class Shop_Income {
    private float deliveredAmount, returnedAmount, additionalAmount, totalAmount;
    private int sID;
    private String date;
    
    public Shop_Income(int sID, float totalAmount, String date ){
        this.sID = sID;
        this.totalAmount = totalAmount;
        this.date = date;
    }
    
    public int getSID(){
        return sID;
    }
        
    public float getDeliveredAmount() {
        return deliveredAmount;
    }
    
    public float getReturnedAmount() {
        return returnedAmount;
    }
    
    public float getAdditionalAmount() {
        return additionalAmount;
    }
    
    public float getTotalAmount() {
        return totalAmount;
    }
    
    public String getDate() {
        return date;
    }
    
    

}


