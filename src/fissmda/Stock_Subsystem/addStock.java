/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fissmda.Stock_Subsystem;

import fissmda.Brand_Subsystem.*;
import fissmda.DBConnection;
import fissmda.InventoryUI;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pasindu
 */
public class addStock extends javax.swing.JFrame {

    Connection connection = null;
    PreparedStatement ps2 = null;
    PreparedStatement ps = null;
    /**
     * Creates new form addBrand
     */
    public addStock() {
        initComponents();
        
        //Make the JFrame run in the center of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        
        
        //get database connectin
        connection = (Connection) DBConnection.connect();
        
        //fill the select manufacture combo box
        fillManufactureBox();
        manufacureListener();
        fillWarehouseBox();
        
        
    }
    
    //method to check whether a specific brand has already been added
    public boolean isAddedStock(String manufacture, String brand, String warehouse, Float quantity, Date aDate, Date eDate){

         try {
            
            //get manufacture id
            int manufactureID = getManufactureID(manufacture);
            
            
            //get brand id
            int brandID = getBrandID(brand);
            
            //get warehouse id
            int warehouseID = getWarehouseID(warehouse);
            
            
            //check whether a particular stock exist
            String stockExist = "SELECT * FROM stock WHERE quantity=? AND arrivalDate=? AND expDate =? AND bID=? AND warehouse_wid=? AND manufacture_maID=?";
            
            ps2 = connection.prepareStatement(stockExist);
            
            ps2.setFloat(1,quantity);
            ps2.setDate(2, aDate);
            ps2.setDate(3, eDate);
            ps2.setInt(4, brandID);
            ps2.setInt(5, warehouseID);
            ps2.setInt(6, manufactureID);
            
            ResultSet rs = ps2.executeQuery();
            
            if(rs.next()){
                return true;
            }
            else {
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(addBrand.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
    }
    
    //method to get manufacture id when manufacture name is given
    public int getManufactureID(String manufactureName){
        
        //get the manufacture id for the selected manufacture name
        int manufactureID = 0;
        
        String mID = "SELECT maID FROM manufacture WHERE name = ?";
        try {
            ps = connection.prepareStatement(mID);
            ps.setString(1, manufactureName);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                manufactureID = (int) rs.getInt("maID");
            }
            
            return manufactureID;
        } catch (SQLException ex) {
            Logger.getLogger(addStock.class.getName()).log(Level.SEVERE, null, ex);
            return manufactureID;
        }
    }
    
    public void manufacureListener(){
        manufactureComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                
                //get the values in text fields
            String manufacture = manufactureComboBox.getSelectedItem().toString();

            if(!manufacture.equals("Select manufacure")){

                int manID = getManufactureID(manufacture);
                fillBrandComboBox(manID);
            }
            }
        });
    }
    //method to fill the manufacture combo box
    public void fillManufactureBox(){
        
        
        try {
            String getManufactures = "SELECT * FROM manufacture";
            ps = connection.prepareStatement(getManufactures);
            ResultSet rs = ps.executeQuery(getManufactures);
            
            while(rs.next()){
                
                manufactureComboBox.addItem(rs.getString("name"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(addStock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //method to check a string can be converted to a float
    public static boolean isInt(String s){
        
        try{
            Integer.parseInt(s);
        }
        catch(NumberFormatException e){
            return false;
        }
        catch(NullPointerException e){
            return false;
        }
        
        return true;
    }
    
    //method to get manufacture id when manufacture name is given
    public int getBrandID(String brandName){
        
        //get the manufacture id for the selected manufacture name
        int brandID = 0;
        
        String mID = "SELECT bID FROM brand WHERE name = ?";
        try {
            ps = connection.prepareStatement(mID);
            ps.setString(1, brandName);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                brandID = (int) rs.getInt("bID");
            }
            
            return brandID;
        } catch (SQLException ex) {
            Logger.getLogger(addBrand.class.getName()).log(Level.SEVERE, null, ex);
            return brandID;
        }
    }
    
   
    public int getWarehouseID(String warehouse){
        
        //get the manufacture id for the selected manufacture name
        int warehouseID = 0;
        
        String wID = "SELECT wID FROM warehouse WHERE warehouse_name = ?";
        try {
            ps = connection.prepareStatement(wID);
            ps.setString(1, warehouse);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                warehouseID = (int) rs.getInt("wID");
            }
            
            return warehouseID;
        } catch (SQLException ex) {
            Logger.getLogger(addBrand.class.getName()).log(Level.SEVERE, null, ex);
            return warehouseID;
        }
    }
    
    //method to fill the brand combo box
    public void fillBrandComboBox(int manufactureID){
        
        
        try {
            String brand = "SELECT * FROM brand WHERE manufacture_maID = ?";
            PreparedStatement pst1 = connection.prepareStatement(brand);
            pst1.setInt(1, manufactureID);
            ResultSet rst = pst1.executeQuery();
            
            
            //remove all available items 
            selectBrandComboBox.removeAllItems();
            selectBrandComboBox.addItem("Select brand");
            
            while(rst.next()){
                
                selectBrandComboBox.addItem(rst.getInt("bID") + " - " + rst.getString("name") + " - " + rst.getFloat("weight") + "g" );
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(addBrand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //method to fill the brand combo box
    public void fillWarehouseBox(){
        
        
        try {
            String getWarehouse = "SELECT * FROM warehouse";
            ps = connection.prepareStatement(getWarehouse);
            ResultSet rs = ps.executeQuery(getWarehouse);
            
            //remove all available items 
            warehouseComboBox.removeAllItems();
            warehouseComboBox.addItem("Select warehouse");
            
            while(rs.next()){
                
                warehouseComboBox.addItem(rs.getString("warehouse_name"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(addBrand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        quantityTextBox = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        manufactureComboBox = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        selectBrandComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        arrivedDate = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        expireDate = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        warehouseComboBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(137, 229, 47));
        setMinimumSize(new java.awt.Dimension(1276, 815));
        setPreferredSize(new java.awt.Dimension(1276, 815));
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(137, 229, 47));
        jPanel3.setMaximumSize(new java.awt.Dimension(1276, 815));
        jPanel3.setPreferredSize(new java.awt.Dimension(1276, 815));

        jPanel2.setBackground(new java.awt.Color(137, 229, 47));
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 58));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fissmda/ButtonImages/greenBack.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fissmda/ButtonImages/greenHome.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(624, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(153, 153, 91));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setText("Quantity");

        quantityTextBox.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        quantityTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityTextBoxActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jButton1.setText("Add Stock");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel5.setText("Manufacture");

        manufactureComboBox.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        manufactureComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select manufacture" }));
        manufactureComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manufactureComboBoxActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel6.setText("Brand");

        selectBrandComboBox.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        selectBrandComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select brand" }));
        selectBrandComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectBrandComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel3.setText("Arrived Date");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel4.setText("Expire Date");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel7.setText("Warehouse");

        warehouseComboBox.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        warehouseComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select warehouse" }));
        warehouseComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warehouseComboBoxActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fissmda/ButtonImages/addStock.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(selectBrandComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(warehouseComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quantityTextBox)
                    .addComponent(arrivedDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(expireDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manufactureComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(116, 116, 116))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 434, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(292, 292, 292))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manufactureComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectBrandComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(warehouseComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityTextBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(arrivedDate, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(expireDate, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1322, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1689, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quantityTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityTextBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityTextBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
        //get the values in text fields
            String manufacture = manufactureComboBox.getSelectedItem().toString();

            String getBrandText = selectBrandComboBox.getSelectedItem().toString();
            System.out.println("Get brand text: " + getBrandText);
            String selectedBrand = null;

            if(getBrandText.equals("Select brand")){
                selectedBrand = "Select brand";
            }
            else{
                String[] split = getBrandText.split(" - ");
                selectedBrand = split[0];
            }

            String warehouse = warehouseComboBox.getSelectedItem().toString();
            String quantity = quantityTextBox.getText();

            if(manufacture.equals("Select manufacture")){

                JOptionPane.showMessageDialog(null, "Please select a manufacture");
            }
            else if(selectedBrand.equals("Select brand")){

                JOptionPane.showMessageDialog(null, "Please select a brand");
            }
            else if(warehouse.equals("Select warehouse")){

                JOptionPane.showMessageDialog(null, "Please select a warehouse");
            }
            else if(!isInt(quantity)){
                JOptionPane.showMessageDialog(null, "Quantity field expects an integer value");
                quantityTextBox.setText(null);
            }
            else if(arrivedDate.getDate() == null){
                JOptionPane.showMessageDialog(null, "Please select arrival date");
                arrivedDate.requestFocusInWindow();
            }
            else if(expireDate.getDate() == null){
                JOptionPane.showMessageDialog(null, "Please select expire date");
                expireDate.requestFocusInWindow();
            }
            else if(isAddedStock(manufacture, selectedBrand, warehouse, Float.parseFloat(quantity), new Date(arrivedDate.getDate().getTime()), new Date(expireDate.getDate().getTime()))){
                JOptionPane.showMessageDialog(null, "This particular stock already exists");
                addStock ad = new addStock();
                ad.setVisible(true);
                this.dispose();
            }
            else{
                
                int proceed = JOptionPane.showConfirmDialog(null, "Do you wish to proceed?");
        
                if(proceed == 0){
                    
                    try {
                        String query = "INSERT INTO stock(quantity, arrivalDate, expDate, bID, warehouse_wid, manufacture_maID) VALUES(?,?,?,?,?,?)";
                        PreparedStatement ps1 = connection.prepareStatement(query);
                        Date aDate = new Date(arrivedDate.getDate().getTime());
                        Date eDate = new Date(expireDate.getDate().getTime());
                        

                        float quantityFloat = Float.parseFloat(quantity);
                        int brandID = Integer.parseInt(selectedBrand);
                        int warehouseID = getWarehouseID(warehouse);
                        int manufactureID = getManufactureID(manufacture);
                        System.out.println("Selected brand: " + selectedBrand);
                        System.out.println("Brand ID: " + brandID);
                        ps1.setFloat(1, quantityFloat);
                        ps1.setDate(2, aDate);
                        ps1.setDate(3, eDate);
                        ps1.setInt(4, brandID);
                        ps1.setInt(5, warehouseID);
                        ps1.setInt(6, manufactureID);

                        ps1.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Insertion Successful");

                        StockUI ui = new StockUI();
                        ui.setVisible(true);
                        this.dispose();


                    } catch (SQLException ex) {
                        Logger.getLogger(addStock.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
        

                

            }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        StockUI ui = new StockUI();
        
        ui.setVisible(true);
        
        this.dispose();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void manufactureComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manufactureComboBoxActionPerformed
        
    }//GEN-LAST:event_manufactureComboBoxActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        addStock ad = new addStock();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void selectBrandComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectBrandComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectBrandComboBoxActionPerformed

    private void warehouseComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warehouseComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_warehouseComboBoxActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       InventoryUI iu = new InventoryUI();
       iu.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         StockUI ui = new StockUI();
        
        ui.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(addStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addStock().setVisible(true);
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser arrivedDate;
    private com.toedter.calendar.JDateChooser expireDate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox<String> manufactureComboBox;
    private javax.swing.JTextField quantityTextBox;
    private javax.swing.JComboBox<String> selectBrandComboBox;
    private javax.swing.JComboBox<String> warehouseComboBox;
    // End of variables declaration//GEN-END:variables
}
