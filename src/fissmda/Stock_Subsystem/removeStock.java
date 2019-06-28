/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fissmda.Stock_Subsystem;

import fissmda.Brand_Subsystem.*;
import fissmda.InventoryUI;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author pasindu
 */
public class removeStock extends javax.swing.JFrame {

    //declare variables
    Connection connection = null;
    
    ResultSet rs = null;
    
    
    /**
     * Creates new form removeBrand
     */
    public removeStock() {
        initComponents();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        try {
            //create objects
            connection = DBConnection.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(removeStock.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(removeStock.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        loadStockTable();
        
        fillStockIDComboBox();
    }
    
    //method to fill the brand combo box
    public void fillStockIDComboBox(){
        
        
        try {
            String getStock = "SELECT * FROM stock";
            PreparedStatement  ps = connection.prepareStatement(getStock);
            ResultSet rs = ps.executeQuery(getStock);
            
            //remove all available items 
            selectStockIDComboBox.removeAllItems();
            selectStockIDComboBox.addItem("Select stock ID");
            
            while(rs.next()){
                
                selectStockIDComboBox.addItem( String.valueOf(rs.getInt("sID")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(addBrand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //method to load the brandTable with content
    public void loadStockTable(){
 
        
        try {
            String query = "SELECT sID as 'Stock ID', quantity as 'Quantity', arrivalDate as 'Arrived Date', expDate as 'Expire Date', brand.name as 'Brand Name', warehouse.warehouse_name as 'Warehouse Name', manufacture.name as 'Manufacture Name' FROM stock LEFT OUTER JOIN brand on stock.bID = brand.bID LEFT OUTER JOIN manufacture ON stock.manufacture_maID=manufacture.maID LEFT OUTER JOIN warehouse ON stock.warehouse_wid = warehouse.wID ORDER BY manufacture.name, stock.arrivalDate, stock.expDate, stock.quantity";
            PreparedStatement ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            stockTable.setModel(DbUtils.resultSetToTableModel(rs));
            
            //change row height
            stockTable.setRowHeight(30);
            
            //change column width of column two
            TableColumnModel columnModel = stockTable.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(5);
            columnModel.getColumn(1).setPreferredWidth(10);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(removeStock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadStockSearchTable(String category, String value){

        try {
            String query = null;
            
            if(category.equals("Stock ID")){
                query = "SELECT sID as 'Stock ID', quantity as 'Quantity', arrivalDate as 'Arrived Date', expDate as 'Expire Date', brand.name as 'Brand Name', warehouse.warehouse_name as 'Warehouse Name', manufacture.name as 'Manufacture Name' FROM stock LEFT OUTER JOIN brand on stock.bID = brand.bID LEFT OUTER JOIN manufacture ON stock.manufacture_maID=manufacture.maID LEFT OUTER JOIN warehouse ON stock.warehouse_wid = warehouse.wID WHERE  stock.sID LIKE '%"+value+"%' ORDER BY manufacture.name, stock.arrivalDate, stock.expDate, stock.quantity";
            }
            else if(category.equals("Quantity")){
                query = "SELECT sID as 'Stock ID', quantity as 'Quantity', arrivalDate as 'Arrived Date', expDate as 'Expire Date', brand.name as 'Brand Name', warehouse.warehouse_name as 'Warehouse Name', manufacture.name as 'Manufacture Name' FROM stock LEFT OUTER JOIN brand on stock.bID = brand.bID LEFT OUTER JOIN manufacture ON stock.manufacture_maID=manufacture.maID LEFT OUTER JOIN warehouse ON stock.warehouse_wid = warehouse.wID WHERE  stock.quantity LIKE '%"+value+"%' ORDER BY manufacture.name, stock.arrivalDate, stock.expDate, stock.quantity";
            }
            else if(category.equals("Arrived Date")){
                query = "SELECT sID as 'Stock ID', quantity as 'Quantity', arrivalDate as 'Arrived Date', expDate as 'Expire Date', brand.name as 'Brand Name', warehouse.warehouse_name as 'Warehouse Name', manufacture.name as 'Manufacture Name' FROM stock LEFT OUTER JOIN brand on stock.bID = brand.bID LEFT OUTER JOIN manufacture ON stock.manufacture_maID=manufacture.maID LEFT OUTER JOIN warehouse ON stock.warehouse_wid = warehouse.wID WHERE  stock.arrivalDate LIKE '%"+value+"%' ORDER BY manufacture.name, stock.arrivalDate, stock.expDate, stock.quantity";
            }
            else if(category.equals("Expire Date")){
                query = "SELECT sID as 'Stock ID', quantity as 'Quantity', arrivalDate as 'Arrived Date', expDate as 'Expire Date', brand.name as 'Brand Name', warehouse.warehouse_name as 'Warehouse Name', manufacture.name as 'Manufacture Name' FROM stock LEFT OUTER JOIN brand on stock.bID = brand.bID LEFT OUTER JOIN manufacture ON stock.manufacture_maID=manufacture.maID LEFT OUTER JOIN warehouse ON stock.warehouse_wid = warehouse.wID WHERE  stock.expDate LIKE '%"+value+"%' ORDER BY manufacture.name, stock.arrivalDate, stock.expDate, stock.quantity";
            }
            else if(category.equals("Brand Name")){
                query = "SELECT sID as 'Stock ID', quantity as 'Quantity', arrivalDate as 'Arrived Date', expDate as 'Expire Date', brand.name as 'Brand Name', warehouse.warehouse_name as 'Warehouse Name', manufacture.name as 'Manufacture Name' FROM stock LEFT OUTER JOIN brand on stock.bID = brand.bID LEFT OUTER JOIN manufacture ON stock.manufacture_maID=manufacture.maID LEFT OUTER JOIN warehouse ON stock.warehouse_wid = warehouse.wID WHERE  brand.name LIKE '%"+value+"%' ORDER BY manufacture.name, stock.arrivalDate, stock.expDate, stock.quantity";
            }
            else if(category.equals("Warehouse Name")){
                query = "SELECT sID as 'Stock ID', quantity as 'Quantity', arrivalDate as 'Arrived Date', expDate as 'Expire Date', brand.name as 'Brand Name', warehouse.warehouse_name as 'Warehouse Name', manufacture.name as 'Manufacture Name' FROM stock LEFT OUTER JOIN brand on stock.bID = brand.bID LEFT OUTER JOIN manufacture ON stock.manufacture_maID=manufacture.maID LEFT OUTER JOIN warehouse ON stock.warehouse_wid = warehouse.wID WHERE  warehouse.warehouse_name LIKE '%"+value+"%' ORDER BY manufacture.name, stock.arrivalDate, stock.expDate, stock.quantity";
            }
            else if(category.equals("Manufacture Name")){
                query = "SELECT sID as 'Stock ID', quantity as 'Quantity', arrivalDate as 'Arrived Date', expDate as 'Expire Date', brand.name as 'Brand Name', warehouse.warehouse_name as 'Warehouse Name', manufacture.name as 'Manufacture Name' FROM stock LEFT OUTER JOIN brand on stock.bID = brand.bID LEFT OUTER JOIN manufacture ON stock.manufacture_maID=manufacture.maID LEFT OUTER JOIN warehouse ON stock.warehouse_wid = warehouse.wID WHERE  manufacture.name LIKE '%"+value+"%' ORDER BY manufacture.name, stock.arrivalDate, stock.expDate, stock.quantity";
            }
            PreparedStatement ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            stockTable.setModel(DbUtils.resultSetToTableModel(rs));
            
            //change row height
            stockTable.setRowHeight(30);
            
            //change column width of column two
            TableColumnModel columnModel = stockTable.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(5);
            columnModel.getColumn(1).setPreferredWidth(10);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(removeStock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //method to get manufacture id when manufacture name is given
    public int getBrandID(String brandName){
        
        //get the manufacture id for the selected manufacture name
        int brandID = 0;
        
        String mID = "SELECT bID FROM brand WHERE name = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(mID);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        selectStockIDComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        stockTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        categoryComboBox = new javax.swing.JComboBox<>();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(137, 229, 47));
        setPreferredSize(new java.awt.Dimension(1276, 815));
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(137, 229, 47));

        jPanel2.setBackground(new java.awt.Color(137, 229, 47));
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 58));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fissmda/ButtonImages/greenBack.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fissmda/ButtonImages/greenHome.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(153, 153, 91));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setText("Stock ID");

        selectStockIDComboBox.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        selectStockIDComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select stock ID" }));
        selectStockIDComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectStockIDComboBoxActionPerformed(evt);
            }
        });

        stockTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        stockTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        stockTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockTableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                stockTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(stockTable);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("Remove Stock");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fissmda/ButtonImages/REOMOVE_STOCK.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Category");

        categoryComboBox.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Stock ID", "Quantity", "Arrived Date", "Expire Date", "Brand Name", "Warehouse Name", "Manufacture Name", " " }));

        searchTextField.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N

        searchButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(selectStockIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addContainerGap(884, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectStockIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1752, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 987, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 987, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 158, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(575, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectStockIDComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectStockIDComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectStockIDComboBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
        //get the values in text fields
        
        String stockIDString = selectStockIDComboBox.getSelectedItem().toString();

        //validate inputs
        if(stockIDString.equals("Select stock ID")){
            JOptionPane.showMessageDialog(null,"Please select a stock ID to remove");
        }
        else{
            int proceed = JOptionPane.showConfirmDialog(null, "Do you wish to proceed?");
        
            if(proceed == 0){
                //sql query
                String query = "DELETE from stock WHERE sID = ?";
                try {

                    int stockID = Integer.parseInt(stockIDString);
                    PreparedStatement ps = connection.prepareStatement(query);
                    ps.setInt(1, stockID);


                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Deletion successful");

                    loadStockTable();

                    fillStockIDComboBox();

                } catch (SQLException ex) {
                    Logger.getLogger(addBrand.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            

        }
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        StockUI su = new StockUI();
        su.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void stockTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockTableMouseClicked
        int selectedRow = stockTable.getSelectedRow();
        
        String stockID =  stockTable.getValueAt(selectedRow, 0).toString();
        
        
        selectStockIDComboBox.setSelectedItem(stockID);
        
    }//GEN-LAST:event_stockTableMouseClicked

    private void stockTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockTableMousePressed
        int selectedRow = stockTable.getSelectedRow();
        
        String stockID =  stockTable.getValueAt(selectedRow, 0).toString();
        
        
        selectStockIDComboBox.setSelectedItem(stockID);
    }//GEN-LAST:event_stockTableMousePressed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        String value = searchTextField.getText().toString();
        String selectedCategory = categoryComboBox.getSelectedItem().toString();

        System.out.println("Category: " + selectedCategory);
        System.out.println("Value: " + value);

        if(value.equals("")){
            loadStockTable();
        }
        else{
            loadStockSearchTable(selectedCategory, value);
        }

    }//GEN-LAST:event_searchButtonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       InventoryUI iu = new InventoryUI();
       iu.setVisible(true);
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
            java.util.logging.Logger.getLogger(removeStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(removeStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(removeStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(removeStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new removeStock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JComboBox<String> selectStockIDComboBox;
    private javax.swing.JTable stockTable;
    // End of variables declaration//GEN-END:variables
}
