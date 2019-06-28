/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fissmda.Brand_Subsystem;

import fissmda.Brand_Subsystem.DBConnection;
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
public class updateBrand extends javax.swing.JFrame {

    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    /**
     * Creates new form updateBrand
     */
    public updateBrand() {
        initComponents();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        try {
            //get database connection
            connection = DBConnection.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(updateBrand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(updateBrand.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        fillBrandComboBox();
        loadAllBrandsTable();
    }
    
    //method to load the brandTable with content
    public void loadAllBrandsTable(){
 
        
        try {
            String query = "SELECT bID as 'Brand ID', brand.name as 'Brand Name', weight as 'Weight(g)', price as 'Price' FROM brand";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            allBrandsTable.setModel(DbUtils.resultSetToTableModel(rs));
            
            //change row height
            allBrandsTable.setRowHeight(30);
            
            //change column width of column two
            TableColumnModel columnModel = allBrandsTable.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(10);
            columnModel.getColumn(1).setPreferredWidth(70);
            columnModel.getColumn(2).setPreferredWidth(5);
            columnModel.getColumn(3).setPreferredWidth(70);
            
        } catch (SQLException ex) {
            Logger.getLogger(viewAllBrands.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadAllBrandsSearchTable(String category, String value){
 

        try {
            
            String query = null;
            
            if(category.equals("Brand ID")){
                query = "SELECT bID as 'Brand ID', brand.name as 'Brand Name', weight as 'Weight(g)', price as 'Price' FROM brand WHERE brand.bID LIKE '%"+value+"%' ORDER BY brand.name, brand.weight";
            }
            else if(category.equals("Brand Name")){
                query = "SELECT bID as 'Brand ID', brand.name as 'Brand Name', weight as 'Weight(g)', price as 'Price' FROM brand WHERE brand.name LIKE '%"+value+"%' ORDER BY brand.name, brand.weight";
            }
            else if(category.equals("Weight")){
                query = "SELECT bID as 'Brand ID', brand.name as 'Brand Name', weight as 'Weight(g)', price as 'Price' FROM brand WHERE brand.weight LIKE '%"+value+"%' ORDER BY brand.name, brand.weight";
            }
            else if(category.equals("Price")){
                query = "SELECT bID as 'Brand ID', brand.name as 'Brand Name', weight as 'Weight(g)', price as 'Price' FROM brand WHERE brand.price LIKE '%"+value+"%' ORDER BY brand.name, brand.weight";
            }
            
            
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            allBrandsTable.setModel(DbUtils.resultSetToTableModel(rs));
            
            //change row height
            allBrandsTable.setRowHeight(30);
            
            //change column width of column two
            TableColumnModel columnModel = allBrandsTable.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(10);
            columnModel.getColumn(1).setPreferredWidth(70);
            columnModel.getColumn(2).setPreferredWidth(5);
            columnModel.getColumn(3).setPreferredWidth(70);
            
        } catch (SQLException ex) {
            Logger.getLogger(viewAllBrands.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //method to check a string can be converted to a float
    public static boolean isFloat(String s){
        
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
    
    //method to fill the brand combo box
    public void fillBrandComboBox(){
        
        
        try {
            String getBrand = "SELECT * FROM brand";
            ps = connection.prepareStatement(getBrand);
            ResultSet rs = ps.executeQuery(getBrand);
            
            //remove all available items 
            selectBrandComboBox.removeAllItems();
            selectBrandComboBox.addItem("Select brand");
            
            while(rs.next()){
                
                selectBrandComboBox.addItem(rs.getInt("bID") + " - " + rs.getString("name") );
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
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        selectBrandComboBox = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        newPriceTextBox = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        allBrandsTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        categoryComboBox = new javax.swing.JComboBox<>();
        searchTextField2 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1276, 815));

        jPanel3.setBackground(new java.awt.Color(137, 229, 47));
        jPanel3.setPreferredSize(new java.awt.Dimension(1276, 815));

        jPanel2.setBackground(new java.awt.Color(137, 229, 47));
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 58));

        jLabel2.setFont(new java.awt.Font("DejaVu Sans Light", 1, 42)); // NOI18N

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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(99, 99, 99)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(153, 153, 91));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("New price");

        selectBrandComboBox.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        selectBrandComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select brand" }));
        selectBrandComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectBrandComboBoxActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("Update Brand");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel3.setText("Brand Name");

        newPriceTextBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        newPriceTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPriceTextBoxActionPerformed(evt);
            }
        });

        allBrandsTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        allBrandsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        allBrandsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allBrandsTableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                allBrandsTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(allBrandsTable);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fissmda/ButtonImages/UPDATE_BRAND.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Category");

        categoryComboBox.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Brand ID", "Brand Name", "Weight", "Price", " " }));

        searchTextField2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton6.setText("Search");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(selectBrandComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(newPriceTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jButton1))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 855, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel4)))
                .addContainerGap(271, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectBrandComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(newPriceTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 237, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 212, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectBrandComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectBrandComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectBrandComboBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        int proceed = JOptionPane.showConfirmDialog(null, "Do you wish to proceed?");
        
        if(proceed == 0){
            //get the values in text fields
        
            String getBrandText = selectBrandComboBox.getSelectedItem().toString();
            String newPrice = newPriceTextBox.getText();

            String selectedBrand = null;

            if(getBrandText.equals("Select brand")){
                selectedBrand = "Select brand";
            }
            else{
                String[] split = getBrandText.split(" - ");
                selectedBrand = split[1];
            }


            if(selectedBrand.equals("Select brand")){
                    JOptionPane.showMessageDialog(null,"Please select a brand to update");
            }
            else if(!isFloat(newPrice)){

                JOptionPane.showMessageDialog(null,"New price field expects a floating point number");
                newPriceTextBox.setText(null);
            }
            else{
                //get manufacture id
                int brandID = getBrandID(selectedBrand);
                float updatedPrice = Float.parseFloat(newPrice);

                try {
                    String query = "UPDATE brand SET price = ? WHERE bID = ?";
                    ps = connection.prepareStatement(query);
                    ps.setFloat(1, updatedPrice);
                    ps.setInt(2, brandID);

                    ps.executeUpdate();
                    newPriceTextBox.setText(null);

                    fillBrandComboBox();
                    loadAllBrandsTable();



                } catch (SQLException ex) {
                    Logger.getLogger(updateBrand.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void newPriceTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPriceTextBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPriceTextBoxActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       BrandUI bi = new BrandUI();
        
        bi.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        bi.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void allBrandsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allBrandsTableMouseClicked
        try {
            int selectedRow = allBrandsTable.getSelectedRow();
            
            String brandID =  allBrandsTable.getValueAt(selectedRow, 0).toString();
            String brandName = (String) allBrandsTable.getValueAt(selectedRow, 1).toString();
            
            String fullBrandName = brandID + " - " + brandName;
            selectBrandComboBox.setSelectedItem(fullBrandName);
            
            String sql = "SELECT * FROM brand WHERE bID = ?";
            PreparedStatement ps10 = connection.prepareStatement(sql);
            
            
            
            ps10.setString(1,brandID);
            
            ResultSet rs2 = ps10.executeQuery();
            float price = 0;

            
            if(rs2.next()){
                
                price = rs2.getFloat("price");
            }
            
            
            newPriceTextBox.setText(String.valueOf(price));
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(updateBrand.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_allBrandsTableMouseClicked

    private void allBrandsTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allBrandsTableMousePressed
        try {
            int selectedRow = allBrandsTable.getSelectedRow();
            
            String brandID =  allBrandsTable.getValueAt(selectedRow, 0).toString();
            String brandName = (String) allBrandsTable.getValueAt(selectedRow, 1).toString();
            
            String fullBrandName = brandID + " - " + brandName;
            selectBrandComboBox.setSelectedItem(fullBrandName);
            
            String sql = "SELECT * FROM brand WHERE bID = ?";
            PreparedStatement ps10 = connection.prepareStatement(sql);
            
            
            
            ps10.setString(1,brandID);
            
            ResultSet rs2 = ps10.executeQuery();
            float price = 0;

            
            if(rs2.next()){
                
                price = rs2.getFloat("price");
            }
            
            
            newPriceTextBox.setText(String.valueOf(price));
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(updateBrand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_allBrandsTableMousePressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String value = searchTextField2.getText().toString();
        String selectedCategory = categoryComboBox.getSelectedItem().toString();

        System.out.println("Category: " + selectedCategory);
        System.out.println("Value: " + value);

        if(value.equals("")){
            loadAllBrandsTable();
        }
        else{
            loadAllBrandsSearchTable(selectedCategory, value);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(updateBrand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateBrand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateBrand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateBrand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateBrand().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable allBrandsTable;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField newPriceTextBox;
    private javax.swing.JTextField searchTextField2;
    private javax.swing.JComboBox<String> selectBrandComboBox;
    // End of variables declaration//GEN-END:variables
}
