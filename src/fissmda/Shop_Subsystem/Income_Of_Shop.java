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
public class Income_Of_Shop {
    private float deliveredAmount, returnedAmount, additionalAmount, totalAmount;
    private String date;
    private int sID;
    
    public Income_Of_Shop(int sID, String date, float deliveredAmount, float returnedAmount, float additionalAmount, float totalAmount ){
        this.sID = sID;
        this.date = date;
        this.deliveredAmount = deliveredAmount;
        this.returnedAmount = returnedAmount;
        this.additionalAmount = additionalAmount;
        this.totalAmount = totalAmount;
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
