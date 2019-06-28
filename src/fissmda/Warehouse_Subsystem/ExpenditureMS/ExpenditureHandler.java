/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fissmda.Warehouse_Subsystem.ExpenditureMS;

import javax.swing.JOptionPane;

/**
 *
 * @author melan
 */
public class ExpenditureHandler {
    
    private String wID;
    private String warehouseName;
    private String billType;
    private String amount;

    public ExpenditureHandler(String warehouseName, String billType, String amount) {
        this.warehouseName = warehouseName;
        this.billType = billType;
        this.amount = amount;
    }
    
    
    
    
    public boolean isInputNotEmpty(){
        if(warehouseName.isEmpty()||billType.isEmpty()||amount.isEmpty()){
        
            
            return false;
        }else{
            return true;
        }
    }
    
    public boolean isAmountValid(){
        
        String validPhase = "^[0-9]{10}$";
        if(amount.matches(validPhase)){
            return true;
        }else{
               return false;
        }
    }
}
