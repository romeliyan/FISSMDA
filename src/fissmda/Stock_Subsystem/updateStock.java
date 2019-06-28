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
import java.sql.Date;
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
public class updateStock extends javax.swing.JFrame {

    //declare variables
    Connection connection = null;
    
    ResultSet rs = null;
    
    
    /**
     * Creates new form removeBrand
     */
    public updateStock() {
        initComponents();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        try {
            //create objects
            connection = DBConnection.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(updateStock.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(updateStock.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public boolean isFloat(String s){
        
        try{
            Float.parseFloat(s);
        }
        catch(NumberFormatException e){
            return false;
        }
        catch(NullPointerException e){
            return false;
        }
        
        return true;
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
            Logger.getLogger(updateStock.class.getName()).log(Level.SEVERE, null, ex);
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
        warehouseName = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        selectStockIDComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        stockTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        manufactureName = new javax.swing.JLabel();
        brandName = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        quantityTextField = new javax.swing.JTextField();
        arrivedDate = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        expireDate = new com.toedter.calendar.JDateChooser();
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
                .addContainerGap(111, Short.MAX_VALUE))
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

        warehouseName.setBackground(new java.awt.Color(153, 153, 91));
        warehouseName.setPreferredSize(new java.awt.Dimension(350, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Stock ID");

        selectStockIDComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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
        jButton1.setText("Update Stock");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fissmda/ButtonImages/updateSTOCK.png"))); // NOI18N

        manufactureName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        brandName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Quantity");

        quantityTextField.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        quantityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityTextFieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("Arrived Date");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("Expire Date");

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

        javax.swing.GroupLayout warehouseNameLayout = new javax.swing.GroupLayout(warehouseName);
        warehouseName.setLayout(warehouseNameLayout);
        warehouseNameLayout.setHorizontalGroup(
            warehouseNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(warehouseNameLayout.createSequentialGroup()
                .addGroup(warehouseNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(warehouseNameLayout.createSequentialGroup()
                        .addGap(559, 559, 559)
                        .addComponent(manufactureName, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(456, 456, 456)
                        .addComponent(jLabel6))
                    .addGroup(warehouseNameLayout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jLabel3))
                    .addGroup(warehouseNameLayout.createSequentialGroup()
                        .addGap(821, 821, 821)
                        .addComponent(brandName, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(warehouseNameLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(warehouseNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 883, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(warehouseNameLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(warehouseNameLayout.createSequentialGroup()
                                .addGroup(warehouseNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(warehouseNameLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(26, 26, 26)
                                        .addComponent(arrivedDate, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, warehouseNameLayout.createSequentialGroup()
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)))
                                .addGroup(warehouseNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(warehouseNameLayout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel9)
                                        .addGap(27, 27, 27)
                                        .addComponent(expireDate, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(warehouseNameLayout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addComponent(jButton1))))
                            .addGroup(warehouseNameLayout.createSequentialGroup()
                                .addGroup(warehouseNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel1))
                                .addGap(69, 69, 69)
                                .addGroup(warehouseNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(selectStockIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(522, Short.MAX_VALUE))
        );
        warehouseNameLayout.setVerticalGroup(
            warehouseNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(warehouseNameLayout.createSequentialGroup()
                .addGroup(warehouseNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(warehouseNameLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(brandName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(223, 223, 223))
                    .addGroup(warehouseNameLayout.createSequentialGroup()
                        .addGroup(warehouseNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, warehouseNameLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel3)
                                .addGap(35, 35, 35)
                                .addGroup(warehouseNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(selectStockIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                .addComponent(jLabel6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, warehouseNameLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(manufactureName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(warehouseNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(warehouseNameLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(warehouseNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(25, 25, 25)
                                .addGroup(warehouseNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(arrivedDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(warehouseNameLayout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(expireDate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54)
                        .addGroup(warehouseNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(warehouseNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(328, 328, 328))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(warehouseName, javax.swing.GroupLayout.PREFERRED_SIZE, 1791, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1108, Short.MAX_VALUE)
            .addComponent(warehouseName, javax.swing.GroupLayout.DEFAULT_SIZE, 1108, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 149, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(454, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectStockIDComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectStockIDComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectStockIDComboBoxActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        StockUI UI= new StockUI();

        UI.setVisible(true);
        
        this.dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
        //get the values in text fields
        
        String stockIDString = selectStockIDComboBox.getSelectedItem().toString();
        
        //validate inputs
        if(stockIDString.equals("Select stock ID")){
            JOptionPane.showMessageDialog(null,"Please select a stock ID to remove");
        }
        else if(!isFloat(quantityTextField.getText())){
            JOptionPane.showMessageDialog(null, "Please input a valid quantity");
        }
        else{
            
            int proceed = JOptionPane.showConfirmDialog(null, "Do you wish to proceed?");
        
            if(proceed == 0){
                float quantity = Float.parseFloat(quantityTextField.getText().toString());
            
                //get the dates
                Date arrivalDate = new Date(arrivedDate.getDate().getTime());
                Date eexpireDate = new Date(expireDate.getDate().getTime());
                int stockIDInt = Integer.parseInt(stockIDString);


                String query = "UPDATE stock SET quantity=?, arrivalDate=?, expDate=?  WHERE sID = ?";
                try {

                    int stockID = Integer.parseInt(stockIDString);
                    PreparedStatement ps = connection.prepareStatement(query);
                    ps.setFloat(1, quantity);
                    ps.setDate(2, arrivalDate);
                    ps.setDate(3, eexpireDate);
                    ps.setInt(4, stockIDInt);


                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Updation successful");

                    updateStock us = new updateStock();
                    us.setVisible(true);
                    this.dispose();

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
       
        try {
            int selectedRow = stockTable.getSelectedRow();
            
            Date aarrivedDate = null;
            Date eexpireDate = null;
            
            float quantity = 0;
            
            String stockID =  stockTable.getValueAt(selectedRow, 0).toString();
            selectStockIDComboBox.setSelectedItem(stockID);
            String query = "SELECT * FROM stock WHERE sID = ?";
            int stockIDInt = Integer.parseInt(stockID);
            PreparedStatement  ps110 = connection.prepareStatement(query);
            ps110.setInt(1, stockIDInt);
            
            ResultSet rs110 = ps110.executeQuery();
            
            if(rs110.next()){
                
                aarrivedDate = rs110.getDate("arrivalDate");
                eexpireDate = rs110.getDate("expDate");
                
                
                quantity = rs110.getFloat("quantity");
                        
            }
            
            arrivedDate.setDate(aarrivedDate);
            expireDate.setDate(eexpireDate);
            
            quantityTextField.setText(String.valueOf(quantity));
            
        } catch (SQLException ex) {
            Logger.getLogger(updateStock.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
        
    }//GEN-LAST:event_stockTableMouseClicked

    private void quantityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityTextFieldActionPerformed

    private void stockTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockTableMousePressed
        try {
            int selectedRow = stockTable.getSelectedRow();
            
            Date aarrivedDate = null;
            Date eexpireDate = null;
            
            float quantity = 0;
            
            String stockID =  stockTable.getValueAt(selectedRow, 0).toString();
            selectStockIDComboBox.setSelectedItem(stockID);
            String query = "SELECT * FROM stock WHERE sID = ?";
            int stockIDInt = Integer.parseInt(stockID);
            PreparedStatement  ps110 = connection.prepareStatement(query);
            ps110.setInt(1, stockIDInt);
            
            ResultSet rs110 = ps110.executeQuery();
            
            if(rs110.next()){
                
                aarrivedDate = rs110.getDate("arrivalDate");
                eexpireDate = rs110.getDate("expDate");
                
                
                quantity = rs110.getFloat("quantity");
                        
            }
            
            arrivedDate.setDate(aarrivedDate);
            expireDate.setDate(eexpireDate);
            
            quantityTextField.setText(String.valueOf(quantity));
            
        } catch (SQLException ex) {
            Logger.getLogger(updateStock.class.getName()).log(Level.SEVERE, null, ex);
        }
          
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
            java.util.logging.Logger.getLogger(updateStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateStock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser arrivedDate;
    private javax.swing.JLabel brandName;
    private javax.swing.JComboBox<String> categoryComboBox;
    private com.toedter.calendar.JDateChooser expireDate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel manufactureName;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JComboBox<String> selectStockIDComboBox;
    private javax.swing.JTable stockTable;
    private javax.swing.JPanel warehouseName;
    // End of variables declaration//GEN-END:variables
}
