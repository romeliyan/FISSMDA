/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fissmda.Warehouse_Subsystem.UpdateWarehousePackage;

import fissmda.Warehouse_Subsystem.DBConnection;
import fissmda.Warehouse_Subsystem.AddWarehousePackage.AddWarehouseUI;
import fissmda.Warehouse_Subsystem.WMSUI;
import fissmda.Warehouse_Subsystem.Warehouse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author melan
 */
public class UpdateWarehouseUI extends javax.swing.JFrame {

    /**
     * Creates new form UpdateWarehouseUI
     */
    //Initialize variable for establish database connection
    Connection connection;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public String warehouseID;

    public UpdateWarehouseUI() {
        initComponents();
        connection = DBConnection.getConnection();
        refreshTable();
    }

    public void refreshTable() {

        String sqlExec = "SELECT * FROM warehouse";
        try {

            ps = connection.prepareStatement(sqlExec);
            rs = ps.executeQuery();
            updateJTable.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
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

        BasePanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        updateJTable = new javax.swing.JTable();
        cancelBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        warehouseName = new javax.swing.JTextField();
        warehouseNameLabel = new javax.swing.JLabel();
        addressLine01 = new javax.swing.JTextField();
        AddressLine01Label = new javax.swing.JLabel();
        addressLine02 = new javax.swing.JTextField();
        AddressLine02Label = new javax.swing.JLabel();
        addressLine03 = new javax.swing.JTextField();
        AddressLine03Label = new javax.swing.JLabel();
        postalZipCode = new javax.swing.JTextField();
        warehouseNameLabel4 = new javax.swing.JLabel();
        warehouseNameLabel5 = new javax.swing.JLabel();
        FaxNumberLabel = new javax.swing.JLabel();
        faxNumber = new javax.swing.JTextField();
        TelephoneNumberLabel = new javax.swing.JLabel();
        telephoneNumber = new javax.swing.JTextField();
        capacityValue = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        proviceCombo = new javax.swing.JComboBox<>();
        capacityLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1276, 815));
        setMinimumSize(new java.awt.Dimension(1276, 815));
        setPreferredSize(new java.awt.Dimension(1276, 815));
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(51, 102, 0));

        updateJTable.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        updateJTable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        updateJTable.setModel(new javax.swing.table.DefaultTableModel(
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
        updateJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateJTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(updateJTable);

        cancelBtn.setBackground(new java.awt.Color(255, 102, 102));
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setText("CANCEL");

        updateBtn.setBackground(new java.awt.Color(153, 255, 0));
        updateBtn.setText("UPDATE");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1264, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(737, Short.MAX_VALUE)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 364, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
        );

        jLabel1.setFont(new java.awt.Font("DejaVu Sans Light", 1, 20)); // NOI18N
        jLabel1.setText("Update Warehouse");

        jLabel3.setIcon(new javax.swing.ImageIcon("/home/melan/Desktop/icons8-back-arrow-32.png")); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        warehouseNameLabel.setText("Warehouse Name");

        AddressLine01Label.setText("Address Line 01");

        AddressLine02Label.setText("Address Line 02");

        AddressLine03Label.setText("Address Line 03");

        warehouseNameLabel4.setText("Postal Code / ZIP");

        warehouseNameLabel5.setText("Province / State");

        FaxNumberLabel.setText("Fax Number");

        TelephoneNumberLabel.setText("Telephone Number");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        jLabel2.setText("(Approximate Value / CubicFeet)");

        proviceCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Northern", "North Western", "Western \t", "North Central\t", "Central \t", "Sabaragamuwa \t", "Eastern \t", "Uva \t", "Southern" }));

        capacityLabel1.setText("Capacity");

        javax.swing.GroupLayout BasePanelLayout = new javax.swing.GroupLayout(BasePanel);
        BasePanel.setLayout(BasePanelLayout);
        BasePanelLayout.setHorizontalGroup(
            BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BasePanelLayout.createSequentialGroup()
                .addGroup(BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BasePanelLayout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addGroup(BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(warehouseNameLabel)
                            .addComponent(AddressLine01Label)
                            .addComponent(AddressLine02Label)
                            .addComponent(AddressLine03Label)
                            .addComponent(warehouseNameLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addressLine01, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressLine02, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(warehouseName, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressLine03, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(postalZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(87, 87, 87)
                        .addGroup(BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(BasePanelLayout.createSequentialGroup()
                                    .addComponent(FaxNumberLabel)
                                    .addGap(65, 65, 65)
                                    .addComponent(faxNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(BasePanelLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(warehouseNameLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(proviceCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(BasePanelLayout.createSequentialGroup()
                                .addGroup(BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TelephoneNumberLabel)
                                    .addComponent(capacityLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(telephoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(capacityValue, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))))))
                    .addGroup(BasePanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addContainerGap(227, Short.MAX_VALUE))
            .addGroup(BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BasePanelLayout.setVerticalGroup(
            BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BasePanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(320, 320, 320)
                .addGroup(BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(BasePanelLayout.createSequentialGroup()
                        .addGroup(BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(warehouseNameLabel5)
                            .addComponent(proviceCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(faxNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FaxNumberLabel))
                        .addGap(18, 18, 18)
                        .addGroup(BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TelephoneNumberLabel)
                            .addComponent(telephoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(BasePanelLayout.createSequentialGroup()
                        .addGroup(BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(warehouseName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(warehouseNameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(AddressLine01Label)
                            .addComponent(addressLine01, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressLine02, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddressLine02Label))))
                .addGroup(BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BasePanelLayout.createSequentialGroup()
                        .addGroup(BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BasePanelLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(capacityLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BasePanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(capacityValue, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BasePanelLayout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressLine03, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddressLine03Label))
                        .addGap(18, 18, 18)
                        .addGroup(BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(postalZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(warehouseNameLabel4))
                        .addGap(196, 196, 196))))
            .addGroup(BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BasePanelLayout.createSequentialGroup()
                    .addGap(134, 134, 134)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BasePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BasePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        new WMSUI().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void updateJTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateJTableMouseClicked
        // TODO add your handling code here:

        int selectedRow = updateJTable.getSelectedRow();

        warehouseID = updateJTable.getValueAt(selectedRow, 0).toString();
        String warehouseNameText = updateJTable.getValueAt(selectedRow, 1).toString();
        String warehouseAddL1 = updateJTable.getValueAt(selectedRow, 2).toString();
        String warehouseAddL2 = updateJTable.getValueAt(selectedRow, 3).toString();
        String warehouseAddL3 = updateJTable.getValueAt(selectedRow, 4).toString();
        String warehousePostal = updateJTable.getValueAt(selectedRow, 5).toString();
        String warehouseProvince = updateJTable.getValueAt(selectedRow, 6).toString();
        String warehouseTelephoneNumber = updateJTable.getValueAt(selectedRow, 7).toString();
        String warehouseFaxNumber = updateJTable.getValueAt(selectedRow, 8).toString();
        String warehouseCapacity = updateJTable.getValueAt(selectedRow, 9).toString();

        warehouseName.setText(warehouseNameText);
        addressLine01.setText(warehouseAddL1);
        addressLine02.setText(warehouseAddL2);
        addressLine03.setText(warehouseAddL3);
        postalZipCode.setText(warehousePostal);
        telephoneNumber.setText(warehouseTelephoneNumber);
        proviceCombo.setSelectedItem(warehouseProvince);
        faxNumber.setText(warehouseFaxNumber);
        capacityValue.setText(warehouseCapacity);
    }//GEN-LAST:event_updateJTableMouseClicked

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed

        // TODO add your handling code here:
        int choiceValue = JOptionPane.showConfirmDialog(null, "Do You Want to Update Database ?");

        if (choiceValue == 0) {
            //when user accpets the changes
            String warehouseNameText = warehouseName.getText();
            String warehouseAddL1 = addressLine01.getText();
            String warehouseAddL2 = addressLine02.getText();
            String warehouseAddL3 = addressLine03.getText();
            String warehousePostal = postalZipCode.getText();
            String warehouseProvince = proviceCombo.getSelectedItem().toString();
            String warehouseTelephoneNumber = telephoneNumber.getText();
            String warehouseFaxNumber = faxNumber.getText();
            String warehouseCapacity = capacityValue.getText();

            //Check user entered wearhouse name existing on database
            Warehouse warehouseObj = new Warehouse(warehouseNameText, warehouseAddL1, warehouseAddL2, warehouseAddL3,
                    warehousePostal, warehouseProvince, warehouseTelephoneNumber, warehouseFaxNumber, warehouseCapacity);

            if (warehouseObj.validatewarehouseNameExistInDB() == false) {
                JOptionPane.showMessageDialog(null, "The Entered Warehouse Name is existing in Database");
            } else {
                if (warehouseObj.checkInputTextFiledNull() == false) {
                    JOptionPane.showMessageDialog(null, "Values cannot be null");
                } else {

                    if (warehouseObj.validateContactNumbers()) { // execute if valid 

                        try {

                            String sqlExc = "UPDATE  warehouse SET warehouse_name='" + warehouseNameText + "',warehouse_addressline1='" + warehouseAddL1 + "',warehouse_addressline2='" + warehouseAddL2 + "',warehouse_addressline3='" + warehouseAddL3 + "',warehouse_zip='" + warehousePostal + "',warehouse_province='" + warehouseProvince + "',"
                                    + "warehouse_telephoneNumber='" + warehouseTelephoneNumber + "',warehouse_faxNo='" + warehouseFaxNumber + "',warehouse_capacity='" + warehouseCapacity + "' Where wID = '" + warehouseID + "'";

                            ps = connection.prepareStatement(sqlExc);
                            ps.execute();
                            JOptionPane.showMessageDialog(this, "Successfully Added to Database");
                            refreshTable();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                }
            }

        
        } else {

        }
    }//GEN-LAST:event_updateBtnActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateWarehouseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateWarehouseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateWarehouseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateWarehouseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateWarehouseUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddressLine01Label;
    private javax.swing.JLabel AddressLine02Label;
    private javax.swing.JLabel AddressLine03Label;
    private javax.swing.JPanel BasePanel;
    private javax.swing.JLabel FaxNumberLabel;
    private javax.swing.JLabel TelephoneNumberLabel;
    private javax.swing.JTextField addressLine01;
    private javax.swing.JTextField addressLine02;
    private javax.swing.JTextField addressLine03;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel capacityLabel1;
    private javax.swing.JTextField capacityValue;
    private javax.swing.JTextField faxNumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField postalZipCode;
    private javax.swing.JComboBox<String> proviceCombo;
    private javax.swing.JTextField telephoneNumber;
    private javax.swing.JButton updateBtn;
    private javax.swing.JTable updateJTable;
    private javax.swing.JTextField warehouseName;
    private javax.swing.JLabel warehouseNameLabel;
    private javax.swing.JLabel warehouseNameLabel4;
    private javax.swing.JLabel warehouseNameLabel5;
    // End of variables declaration//GEN-END:variables
}
