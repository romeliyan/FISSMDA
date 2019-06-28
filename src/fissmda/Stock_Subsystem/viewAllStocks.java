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
public class viewAllStocks extends javax.swing.JFrame {

    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    
    /**
     * Creates new form viewAllBrands
     */
    public viewAllStocks() {
        initComponents();
        
        //Make the JFrame run in the center of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        try {
            //create objects
            connection = DBConnection.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(viewAllStocks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(viewAllStocks.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        loadStockTable();
    }
    
    
    public void loadStockTable(){
 
        
        try {
            String query = "SELECT sID as 'Stock ID', quantity as 'Quantity', arrivalDate as 'Arrived Date', expDate as 'Expire Date', brand.name as 'Brand Name', warehouse.warehouse_name as 'Warehouse Name', manufacture.name as 'Manufacture Name' FROM stock LEFT OUTER JOIN brand on stock.bID = brand.bID LEFT OUTER JOIN manufacture ON stock.manufacture_maID=manufacture.maID LEFT OUTER JOIN warehouse ON stock.warehouse_wid = warehouse.wID ORDER BY manufacture.name, stock.arrivalDate, stock.expDate, stock.quantity";
            PreparedStatement ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            allStocksTable.setModel(DbUtils.resultSetToTableModel(rs));
            
            //change row height
            allStocksTable.setRowHeight(30);
            
            //change column width of column two
            TableColumnModel columnModel = allStocksTable.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(5);
            columnModel.getColumn(1).setPreferredWidth(10);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(removeStock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  boolean isInt(String s){
        
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
            
            allStocksTable.setModel(DbUtils.resultSetToTableModel(rs));
            
            //change row height
            allStocksTable.setRowHeight(30);
            
            //change column width of column two
            TableColumnModel columnModel = allStocksTable.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(5);
            columnModel.getColumn(1).setPreferredWidth(10);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(removeStock.class.getName()).log(Level.SEVERE, null, ex);
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
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        allStocksTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        categoryComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(137, 229, 47));
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(137, 229, 47));
        jPanel3.setMaximumSize(new java.awt.Dimension(1276, 815));
        jPanel3.setPreferredSize(new java.awt.Dimension(1276, 815));

        jPanel2.setBackground(new java.awt.Color(137, 229, 47));
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 58));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fissmda/ButtonImages/greenBack.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fissmda/ButtonImages/greenHome.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(153, 153, 91));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 50));

        allStocksTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        allStocksTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(allStocksTable);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fissmda/ButtonImages/ALL_STOCK_DETAILS.png"))); // NOI18N

        searchTextField.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Category");

        searchButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        categoryComboBox.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Stock ID", "Quantity", "Arrived Date", "Expire Date", "Brand Name", "Warehouse Name", "Manufacture Name", " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(217, 217, 217)
                            .addComponent(jLabel2))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       StockUI si = new StockUI();
       si.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       InventoryUI iu = new InventoryUI();
       iu.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(viewAllStocks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewAllStocks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewAllStocks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewAllStocks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewAllStocks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable allStocksTable;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    // End of variables declaration//GEN-END:variables
}
