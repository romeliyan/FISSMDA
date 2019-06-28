/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */
package fissmda.Manufacturer_Subsystem;

import fissmda.Manufacturer_Subsystem.DBConnection;

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
 * @author supunbuddhike
 */
public class UpdateManufacturer extends javax.swing.JFrame {

    Connection connection = null;
    PreparedStatement ps = null;
    PreparedStatement ps1 = null;
    ResultSet rs = null;
    /**
     * Creates new form UpdateManufacturer
     */
    public UpdateManufacturer() {
        initComponents();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        try {
            //create objects
            connection = DBConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateManufacturer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       loadRouteTable();
        
        fillRouteComboBox();
    }
    
     public void fillRouteComboBox(){
        
        
        try {
            String getmanufact = "SELECT * FROM manufacture";
            ps = connection.prepareStatement(getmanufact);
            ResultSet rs = ps.executeQuery(getmanufact);
            
            //remove all available items 
            selectManufactComboBox.removeAllItems();
            selectManufactComboBox.addItem("Select Manufacture Name");
            
            while(rs.next()){
                
                selectManufactComboBox.addItem(rs.getString("name") );
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AddManufacturer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
   
    public int getRoutID(String name){
        
       
        int ManufactID = 0;
        
        String maID = "SELECT maID FROM manufacture WHERE name = ?";
        try {
            ps = connection.prepareStatement(maID);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                ManufactID = (int) rs.getInt("maID");
            }
            
            return ManufactID;
        } catch (SQLException ex) {
            Logger.getLogger(AddManufacturer.class.getName()).log(Level.SEVERE, null, ex);
            return ManufactID;
        }
    }
    
     public void loadRouteTable(){
 
        
        try {
            String query = "SELECT manufacture.maID as 'Manufacture ID', name as 'Manufacture Name', address as 'Manufacture Address', email as 'Manufacture Email', manufacture_phone.phone as 'Phone' FROM manufacture left outer join manufacture_phone ON manufacture.maID=manufacture_phone.maID ORDER BY manufacture.maID";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            update.setModel(DbUtils.resultSetToTableModel(rs));
            
            //change row height
            update.setRowHeight(30);
            
            //change column width of column two
           /* TableColumnModel columnModel = update.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(200);
            columnModel.getColumn(1).setPreferredWidth(1000);
            columnModel.getColumn(2).setPreferredWidth(1000);*/
            
        } catch (SQLException ex) {
            Logger.getLogger(RemoveManufacturer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
     public boolean isEmail(String email){
        
        int dotCounter = 0;
        int atCounter = 0;
        for(int i=0; i < email.length(); i++){
            
            if(email.charAt(i) == '@'){
                atCounter++;
            }
            
            if(email.charAt(i) == '.'){
                dotCounter++;
            }
            
            
        }
        
        if(dotCounter > 0 && atCounter == 1){
            return true;
        }
        else{
            return false;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        UpdateManufacturerName = new javax.swing.JLabel();
        UpdateBusinessRegistrationNumber = new javax.swing.JLabel();
        UpdateRegNum = new javax.swing.JTextField();
        UpdateBusinessRegistrationAddress = new javax.swing.JLabel();
        UpdateRegAdd = new javax.swing.JTextField();
        UpdateTel = new javax.swing.JTextField();
        UpdateCANCEL = new javax.swing.JButton();
        UpdateUPDATE = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        BusinessRegistrationAddress1 = new javax.swing.JLabel();
        selectManufactComboBox = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        update = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setPreferredSize(new java.awt.Dimension(1276, 815));

        jPanel1.setBackground(new java.awt.Color(153, 153, 91));

        UpdateManufacturerName.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        UpdateManufacturerName.setText("Select Manufacturer Name");

        UpdateBusinessRegistrationNumber.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        UpdateBusinessRegistrationNumber.setText("Business Registration E-mail");

        UpdateRegNum.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        UpdateRegNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateRegNumActionPerformed(evt);
            }
        });

        UpdateBusinessRegistrationAddress.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        UpdateBusinessRegistrationAddress.setText("Business Registration Address");

        UpdateRegAdd.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N

        UpdateTel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        UpdateTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateTelActionPerformed(evt);
            }
        });

        UpdateCANCEL.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        UpdateCANCEL.setText("CANCEL");
        UpdateCANCEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateCANCELActionPerformed(evt);
            }
        });

        UpdateUPDATE.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        UpdateUPDATE.setText("UPDATE");
        UpdateUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateUPDATEActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(137, 229, 47));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fissmda/ButtonImages/greenBack.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fissmda/ButtonImages/greenHome.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fissmda/ButtonImages/CompanyLogoSmall(new).png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(134, 134, 134)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BusinessRegistrationAddress1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        BusinessRegistrationAddress1.setText("Telephone Number");

        selectManufactComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        selectManufactComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Manufacture Name" }));

        update.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(update);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fissmda/ButtonImages/UpdateManufacturer.png"))); // NOI18N

        jButton3.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jButton3.setText("DEMO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UpdateManufacturerName)
                            .addComponent(UpdateBusinessRegistrationAddress)
                            .addComponent(UpdateBusinessRegistrationNumber)
                            .addComponent(BusinessRegistrationAddress1))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UpdateRegNum, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UpdateTel, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UpdateRegAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectManufactComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(jButton3)
                        .addGap(62, 62, 62)
                        .addComponent(UpdateUPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(UpdateCANCEL, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(863, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(UpdateManufacturerName)
                        .addGap(31, 31, 31)
                        .addComponent(UpdateBusinessRegistrationAddress)
                        .addGap(19, 19, 19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(selectManufactComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(UpdateRegAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(UpdateBusinessRegistrationNumber)
                    .addComponent(UpdateRegNum, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BusinessRegistrationAddress1)
                    .addComponent(UpdateTel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateUPDATE)
                    .addComponent(jButton3)
                    .addComponent(UpdateCANCEL))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateTelActionPerformed

    private void UpdateUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateUPDATEActionPerformed
       String updateNum = UpdateRegNum.getText().toString();
       String updateAdd = UpdateRegAdd.getText().toString();
       String updateTele = UpdateTel.getText().toString();
       String getManufactText = selectManufactComboBox.getSelectedItem().toString();
       
       
       if(getManufactText.equals("Select Manufacture Name")){
            JOptionPane.showMessageDialog(null,"Please select a Manufacture Name to update");
        }
      
           else if(updateAdd.isEmpty()){
           JOptionPane.showMessageDialog(null,"Please enter a Manufacture Registation Address  to update");
           UpdateRegAdd.setText(null);
       }
            else if(!isEmail(updateNum)){
           JOptionPane.showMessageDialog(null,"Please enter a valid E-mail address  to update");
           UpdateRegNum.setText(null);
       }
       else if(updateTele.length()!=10){
           
           JOptionPane.showMessageDialog(null,"Please enter valid Telephone Number");
           UpdateTel.setText(null);
       }
       
       else{
        int ManufactID = getRoutID(getManufactText);
        String query = "UPDATE manufacture SET address = ? , email = ? Where maID = ?";
        String query1 = "UPDATE manufacture_phone SET phone = ? Where maID =?";
            try {
                
                ps = connection.prepareStatement(query);
                ps1 = connection.prepareStatement(query1);
                ps.setString(1, updateAdd);
                ps.setString(2, updateNum );
                ps.setInt(3, ManufactID);
                
                ps1.setString(1, updateTele);
                ps1.setInt(2, ManufactID);
                
                

                ps.executeUpdate();
                ps1.executeUpdate();
                UpdateRegNum.setText(null);
                UpdateRegAdd.setText(null);
                UpdateTel.setText(null);
                JOptionPane.showMessageDialog(null, "Update successful");

               
                
               loadRouteTable();
        
             
        
                fillRouteComboBox();

            } catch (SQLException ex) {
                Logger.getLogger(AddManufacturer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_UpdateUPDATEActionPerformed

    private void UpdateCANCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateCANCELActionPerformed
         ManufacturerUI mu = new ManufacturerUI();
        mu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_UpdateCANCELActionPerformed

    private void UpdateRegNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateRegNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateRegNumActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ManufacturerUI mu = new ManufacturerUI();
        mu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ManufacturerUI mu = new ManufacturerUI();
        mu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    //update demo button
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       UpdateRegNum.setText("a");
       UpdateRegAdd.setText("b");
       UpdateTel.setText("c");
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
            java.util.logging.Logger.getLogger(UpdateManufacturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateManufacturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateManufacturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateManufacturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateManufacturer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BusinessRegistrationAddress1;
    private javax.swing.JLabel UpdateBusinessRegistrationAddress;
    private javax.swing.JLabel UpdateBusinessRegistrationNumber;
    private javax.swing.JButton UpdateCANCEL;
    private javax.swing.JLabel UpdateManufacturerName;
    private javax.swing.JTextField UpdateRegAdd;
    private javax.swing.JTextField UpdateRegNum;
    private javax.swing.JTextField UpdateTel;
    private javax.swing.JButton UpdateUPDATE;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> selectManufactComboBox;
    private javax.swing.JTable update;
    // End of variables declaration//GEN-END:variables
}
