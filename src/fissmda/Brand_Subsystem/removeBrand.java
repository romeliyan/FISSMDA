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
public class removeBrand extends javax.swing.JFrame {

    //declare variables
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    
    /**
     * Creates new form removeBrand
     */
    public removeBrand() {
        initComponents();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        try {
            //create objects
            connection = DBConnection.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(removeBrand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(removeBrand.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        loadBrandTable();
        
        fillBrandComboBox();
    }
    
    //method to fill the brand combo box
    public void fillBrandComboBox(){
        
        
        try {
            String getBrand = "SELECT * FROM brand";
            ps = connection.prepareStatement(getBrand);
            ResultSet rs = ps.executeQuery(getBrand);
            
            //remove all available items 
            selectBrandComboBox12345.removeAllItems();
            selectBrandComboBox12345.addItem("Select brand");
            
            while(rs.next()){
                
                selectBrandComboBox12345.addItem(rs.getInt("bID") + " - " + rs.getString("name") );
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(addBrand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //method to load the brandTable with content
    public void loadBrandTable(){
 
        
        try {
            String query = "SELECT bID as 'Brand ID',manufacture.name as 'Manufacture', brand.name as 'Brand Name', weight as 'Weight(g)' FROM brand LEFT OUTER JOIN manufacture ON brand.manufacture_maID = manufacture.maID";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            brandTableRemove.setModel(DbUtils.resultSetToTableModel(rs));
            
            //change row height
            brandTableRemove.setRowHeight(30);
            
            //change column width of column two
            TableColumnModel columnModel = brandTableRemove.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(100);
            columnModel.getColumn(1).setPreferredWidth(500);
            columnModel.getColumn(2).setPreferredWidth(1000);
            columnModel.getColumn(3).setPreferredWidth(300);
            
        } catch (SQLException ex) {
            Logger.getLogger(removeBrand.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    public void loadAllBrandsSearchTable(String category, String value){
 

        try {
            
            String query = null;
            
            if(category.equals("Brand ID")){
                query = "SELECT bID as 'Brand ID',manufacture.name as 'Manufacture', brand.name as 'Brand Name', weight as 'Weight(g)' FROM brand LEFT OUTER JOIN manufacture ON brand.manufacture_maID = manufacture.maID WHERE brand.bID LIKE '%"+value+"%' ORDER BY brand.name, brand.weight";
            }
            else if(category.equals("Brand Name")){
                query = "SELECT bID as 'Brand ID',manufacture.name as 'Manufacture', brand.name as 'Brand Name', weight as 'Weight(g)' FROM brand LEFT OUTER JOIN manufacture ON brand.manufacture_maID = manufacture.maID WHERE brand.name LIKE '%"+value+"%' ORDER BY brand.name, brand.weight";
            }
            else if(category.equals("Weight")){
                query = "SELECT bID as 'Brand ID',manufacture.name as 'Manufacture', brand.name as 'Brand Name', weight as 'Weight(g)' FROM brand LEFT OUTER JOIN manufacture ON brand.manufacture_maID = manufacture.maID WHERE brand.weight LIKE '%"+value+"%' ORDER BY brand.name, brand.weight";
            }
            else if(category.equals("Manufacture")){
                query = "SELECT bID as 'Brand ID',manufacture.name as 'Manufacture', brand.name as 'Brand Name', weight as 'Weight(g)' FROM brand LEFT OUTER JOIN manufacture ON brand.manufacture_maID = manufacture.maID WHERE manufacture.name LIKE '%"+value+"%' ORDER BY brand.name, brand.weight";
            }
            
           ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            brandTableRemove.setModel(DbUtils.resultSetToTableModel(rs));
            
            //change row height
            brandTableRemove.setRowHeight(30);
            
            //change column width of column two
            TableColumnModel columnModel = brandTableRemove.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(100);
            columnModel.getColumn(1).setPreferredWidth(500);
            columnModel.getColumn(2).setPreferredWidth(1000);
            columnModel.getColumn(3).setPreferredWidth(300);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(viewAllBrands.class.getName()).log(Level.SEVERE, null, ex);
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
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        categoryComboBox = new javax.swing.JComboBox<>();
        searchTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        brandTableRemove = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        selectBrandComboBox12345 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1276, 815));
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(137, 229, 47));
        jPanel3.setPreferredSize(new java.awt.Dimension(1276, 815));

        jPanel2.setBackground(new java.awt.Color(137, 229, 47));
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 58));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fissmda/ButtonImages/greenBack.png"))); // NOI18N
        jButton3.setToolTipText("");
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
                .addGap(28, 28, 28)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(153, 153, 91));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setText("Brand Name");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("Remove Brand");
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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fissmda/ButtonImages/REMOVE_BRANDS.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Category");

        categoryComboBox.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Brand ID", "Brand Name", "Weight", "Manufacture", " " }));

        searchTextField2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        brandTableRemove.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        brandTableRemove.setModel(new javax.swing.table.DefaultTableModel(
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
        brandTableRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                brandTableRemoveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                brandTableRemoveMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                brandTableRemoveMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(brandTableRemove);

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton6.setText("Search");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        selectBrandComboBox12345.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchTextField2)
                                .addGap(32, 32, 32)
                                .addComponent(jButton6))
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(159, 159, 159)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(selectBrandComboBox12345, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(439, 439, 439)
                    .addComponent(jButton5)
                    .addContainerGap(440, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(selectBrandComboBox12345, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6)
                    .addComponent(searchTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(128, 128, 128))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(424, 424, 424)
                    .addComponent(jButton5)
                    .addContainerGap(425, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 984, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1340, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        BrandUI bi = new BrandUI();

        bi.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        bi.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //get the values in text fields
        
        String getBrandText = selectBrandComboBox12345.getSelectedItem().toString();
        String selectedBrand = null;
        
        if(getBrandText.equals("Select brand")){
            selectedBrand = "Select brand";
            
           
        }
        else{
            String[] split = getBrandText.split(" - ");
            selectedBrand = split[1];
        }
        
        

        //validate inputs
        if(selectedBrand.equals("Select brand")){
            JOptionPane.showMessageDialog(null,"Please select a brand to remove");
        }
        else{

            int proceed = JOptionPane.showConfirmDialog(null, "Do you wish to proceed?");
            
            if(proceed == 0){
                //get manufacture id
                int brandID = getBrandID(selectedBrand);

                //sql query
                String query = "DELETE from brand WHERE bID = ?";
                try {
                    ps = connection.prepareStatement(query);
                    ps.setInt(1, brandID);


                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Deletion successful");

                    loadBrandTable();

                    fillBrandComboBox();

                } catch (SQLException ex) {
                    Logger.getLogger(addBrand.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        BrandUI bi = new BrandUI();
        
        bi.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        bi.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void brandTableRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_brandTableRemoveMouseClicked
        int selectedRow = brandTableRemove.getSelectedRow();
        
        String brandID =  brandTableRemove.getValueAt(selectedRow, 0).toString();
        String brandName = (String) brandTableRemove.getValueAt(selectedRow, 2).toString();
        
        String fullBrandName = brandID + " - " + brandName;
       
        selectBrandComboBox12345.setSelectedItem(fullBrandName);
        System.out.println("Brand ID : " + brandID);
        System.out.println("Brand Name: " + brandName);
    }//GEN-LAST:event_brandTableRemoveMouseClicked

    private void brandTableRemoveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_brandTableRemoveMouseEntered
        
    }//GEN-LAST:event_brandTableRemoveMouseEntered

    private void brandTableRemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_brandTableRemoveMousePressed
        int selectedRow = brandTableRemove.getSelectedRow();
        
        String brandID =  brandTableRemove.getValueAt(selectedRow, 0).toString();
        String brandName = (String) brandTableRemove.getValueAt(selectedRow, 2).toString();
        
        String fullBrandName = brandID + " - " + brandName;
       
        selectBrandComboBox12345.setSelectedItem(fullBrandName);
        System.out.println("Brand ID : " + brandID);
        System.out.println("Brand Name: " + brandName);
    }//GEN-LAST:event_brandTableRemoveMousePressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String value = searchTextField2.getText().toString();
        String selectedCategory = categoryComboBox.getSelectedItem().toString();

        System.out.println("Category: " + selectedCategory);
        System.out.println("Value: " + value);

        if(value.equals("")){
            loadBrandTable();
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
            java.util.logging.Logger.getLogger(removeBrand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(removeBrand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(removeBrand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(removeBrand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new removeBrand().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable brandTableRemove;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchTextField2;
    private javax.swing.JComboBox<String> selectBrandComboBox12345;
    // End of variables declaration//GEN-END:variables
}
