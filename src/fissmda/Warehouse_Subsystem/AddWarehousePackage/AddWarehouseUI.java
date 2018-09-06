/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fissmda.Warehouse_Subsystem.AddWarehousePackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import fissmda.Warehouse_Subsystem.Warehouse;
import fissmda.Warehouse_Subsystem.DBConnection;
import fissmda.Warehouse_Subsystem.WMSUI;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author melan
 */
public class AddWarehouseUI extends javax.swing.JFrame {

    //initialize variables to Establish DB Connection
    Connection connection = null;
    PreparedStatement ps = null;

    /**
     * Creates new form AddWarehouseUI
     */
    public AddWarehouseUI() {
        initComponents();

        //Generate in Center at the Runtime 
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        //Establish Connection 
        try {
            connection = DBConnection.getConnection();

        } catch (Exception e) {
            System.out.println("Unable to Establish Connection with database");
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

        PannelLeft = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PannelRight = new javax.swing.JPanel();
        warehouseName = new javax.swing.JTextField();
        WarehouseContactInformationLabel = new javax.swing.JLabel();
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
        BasicInformationLabel1 = new javax.swing.JLabel();
        FaxNumberLabel = new javax.swing.JLabel();
        faxNumber = new javax.swing.JTextField();
        TelephoneNumberLabel = new javax.swing.JLabel();
        telephoneNumber = new javax.swing.JTextField();
        WarehouseContactInformationLabel1 = new javax.swing.JLabel();
        FaxNumberLabel2 = new javax.swing.JLabel();
        capacityValue = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        calculateWarehouseCapacityBtn = new javax.swing.JButton();
        proviceCombo = new javax.swing.JComboBox<>();
        cancleBtn = new javax.swing.JButton();
        addWarehouseBtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Maradana Distributors WMS ");
        setMaximumSize(new java.awt.Dimension(1276, 815));
        setMinimumSize(new java.awt.Dimension(1276, 815));
        setPreferredSize(new java.awt.Dimension(1276, 815));
        setResizable(false);

        jLabel3.setIcon(new javax.swing.ImageIcon("/home/melan/Desktop/icons8-back-arrow-32.png")); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("DejaVu Sans Light", 1, 20)); // NOI18N
        jLabel2.setText("Add Warehouse");

        javax.swing.GroupLayout PannelLeftLayout = new javax.swing.GroupLayout(PannelLeft);
        PannelLeft.setLayout(PannelLeftLayout);
        PannelLeftLayout.setHorizontalGroup(
            PannelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PannelLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PannelLeftLayout.setVerticalGroup(
            PannelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PannelLeftLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(PannelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PannelRight.setBackground(new java.awt.Color(51, 102, 0));

        WarehouseContactInformationLabel.setFont(new java.awt.Font("DejaVu Sans Light", 1, 18)); // NOI18N
        WarehouseContactInformationLabel.setText("Warehouse Contact Information");

        warehouseNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        warehouseNameLabel.setText("Warehouse Name");

        AddressLine01Label.setForeground(new java.awt.Color(255, 255, 255));
        AddressLine01Label.setText("Address Line 01");

        AddressLine02Label.setForeground(new java.awt.Color(255, 255, 255));
        AddressLine02Label.setText("Address Line 02");

        AddressLine03Label.setForeground(new java.awt.Color(255, 255, 255));
        AddressLine03Label.setText("Address Line 03");

        warehouseNameLabel4.setForeground(new java.awt.Color(255, 255, 255));
        warehouseNameLabel4.setText("Postal Code / ZIP");

        warehouseNameLabel5.setForeground(new java.awt.Color(255, 255, 255));
        warehouseNameLabel5.setText("Province / State");

        BasicInformationLabel1.setFont(new java.awt.Font("DejaVu Sans Light", 1, 18)); // NOI18N
        BasicInformationLabel1.setText("Basic Information");

        FaxNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        FaxNumberLabel.setText("Fax Number");

        TelephoneNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        TelephoneNumberLabel.setText("Telephone Number");

        WarehouseContactInformationLabel1.setFont(new java.awt.Font("DejaVu Sans Light", 1, 18)); // NOI18N
        WarehouseContactInformationLabel1.setText("Warehouse Capacity Information");

        FaxNumberLabel2.setForeground(new java.awt.Color(255, 255, 255));
        FaxNumberLabel2.setText("Capacity ");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        jLabel1.setText("(Approximate Value / CubicFeet)");

        calculateWarehouseCapacityBtn.setText("Calculate Capacity");
        calculateWarehouseCapacityBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateWarehouseCapacityBtnActionPerformed(evt);
            }
        });

        proviceCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Northern", "North Western", "Western \t", "North Central\t", "Central \t", "Sabaragamuwa \t", "Eastern \t", "Uva \t", "Southern" }));

        cancleBtn.setBackground(new java.awt.Color(255, 51, 102));
        cancleBtn.setText("CANCLE");
        cancleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancleBtnActionPerformed(evt);
            }
        });

        addWarehouseBtn1.setBackground(new java.awt.Color(102, 255, 102));
        addWarehouseBtn1.setText("ADD WAREHOUSE");
        addWarehouseBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWarehouseBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PannelRightLayout = new javax.swing.GroupLayout(PannelRight);
        PannelRight.setLayout(PannelRightLayout);
        PannelRightLayout.setHorizontalGroup(
            PannelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PannelRightLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(PannelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PannelRightLayout.createSequentialGroup()
                        .addComponent(AddressLine01Label)
                        .addGap(75, 75, 75)
                        .addComponent(addressLine01, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PannelRightLayout.createSequentialGroup()
                        .addComponent(warehouseNameLabel)
                        .addGap(64, 64, 64)
                        .addComponent(warehouseName, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PannelRightLayout.createSequentialGroup()
                        .addComponent(AddressLine02Label)
                        .addGap(75, 75, 75)
                        .addComponent(addressLine02, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PannelRightLayout.createSequentialGroup()
                        .addComponent(AddressLine03Label)
                        .addGap(75, 75, 75)
                        .addComponent(addressLine03, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PannelRightLayout.createSequentialGroup()
                        .addGroup(PannelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(warehouseNameLabel4)
                            .addComponent(warehouseNameLabel5))
                        .addGap(69, 69, 69)
                        .addGroup(PannelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(postalZipCode)
                            .addComponent(proviceCombo, 0, 244, Short.MAX_VALUE))))
                .addGroup(PannelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PannelRightLayout.createSequentialGroup()
                        .addGroup(PannelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PannelRightLayout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(cancleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addWarehouseBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PannelRightLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(PannelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(WarehouseContactInformationLabel1)
                                    .addComponent(WarehouseContactInformationLabel))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PannelRightLayout.createSequentialGroup()
                        .addGroup(PannelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PannelRightLayout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addGroup(PannelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(FaxNumberLabel2)
                                    .addComponent(jLabel1))
                                .addGap(59, 59, 59)
                                .addGroup(PannelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(calculateWarehouseCapacityBtn)
                                    .addComponent(capacityValue, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PannelRightLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(PannelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TelephoneNumberLabel)
                                    .addComponent(FaxNumberLabel))
                                .addGap(75, 75, 75)
                                .addGroup(PannelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(faxNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(telephoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 317, Short.MAX_VALUE))))
            .addGroup(PannelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PannelRightLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(BasicInformationLabel1)
                    .addContainerGap(1129, Short.MAX_VALUE)))
        );
        PannelRightLayout.setVerticalGroup(
            PannelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PannelRightLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(PannelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PannelRightLayout.createSequentialGroup()
                        .addComponent(WarehouseContactInformationLabel)
                        .addGap(18, 18, 18)
                        .addGroup(PannelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(faxNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FaxNumberLabel))
                        .addGap(18, 18, 18)
                        .addGroup(PannelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telephoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TelephoneNumberLabel))
                        .addGap(37, 37, 37)
                        .addComponent(WarehouseContactInformationLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(PannelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(capacityValue, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FaxNumberLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PannelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PannelRightLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(58, 58, 58)
                                .addComponent(warehouseNameLabel5))
                            .addComponent(calculateWarehouseCapacityBtn)))
                    .addGroup(PannelRightLayout.createSequentialGroup()
                        .addGroup(PannelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(warehouseName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(warehouseNameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(PannelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressLine01, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddressLine01Label))
                        .addGap(18, 18, 18)
                        .addGroup(PannelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressLine02, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddressLine02Label))
                        .addGap(18, 18, 18)
                        .addGroup(PannelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressLine03, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddressLine03Label))
                        .addGap(18, 18, 18)
                        .addGroup(PannelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(postalZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(warehouseNameLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(proviceCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(PannelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addWarehouseBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88))
            .addGroup(PannelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PannelRightLayout.createSequentialGroup()
                    .addGap(97, 97, 97)
                    .addComponent(BasicInformationLabel1)
                    .addContainerGap(518, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PannelLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PannelRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PannelLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PannelRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        new WMSUI().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void addWarehouseBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWarehouseBtn1ActionPerformed
        // TODO add your handling code here:

        String warehouseNameText = warehouseName.getText();
        String warehouseAddL1 = addressLine01.getText();
        String warehouseAddL2 = addressLine02.getText();
        String warehouseAddL3 = addressLine03.getText();
        String warehousePostal = postalZipCode.getText();
        String warehouseProvince = proviceCombo.getSelectedItem().toString();
        String warehouseTelephoneNumber = telephoneNumber.getText();
        String warehouseFaxNumber = faxNumber.getText();
        String warehouseCapacity = capacityValue.getText();

        String sqlExc = "INSERT INTO warehouse (warehouse_name,warehouse_addressline1,warehouse_addressline2,warehouse_addressline3,warehouse_zip,warehouse_province,"
                + "warehouse_telephoneNumber,warehouse_faxNo,warehouse_capacity) values('" + warehouseNameText + "','" + warehouseAddL1 + "','" + warehouseAddL2 + "','" + warehouseAddL3 + "','" + warehousePostal + "','" + warehouseProvince + "','" + warehouseTelephoneNumber + "','" + warehouseFaxNumber + "','" + warehouseCapacity + "')";

        Warehouse warehouseObj = new Warehouse(warehouseNameText, warehouseAddL1, warehouseAddL2, warehouseAddL3,
                warehousePostal, warehouseProvince, warehouseTelephoneNumber, warehouseFaxNumber, warehouseCapacity);

        if (warehouseObj.validatewarehouseNameExistInDB() == false) {
            JOptionPane.showMessageDialog(null, "The Entered Warehouse Name is existing in Database");
        } else {
            if (warehouseObj.checkInputTextFiledNull() == false) {
                JOptionPane.showMessageDialog(null, "Values cannot be null");
            } else {

                if (warehouseObj.validateContactNumbers()) { // execute if valid
                    if (warehouseObj.validatePostalCode()) {
                        if (warehouseObj.validateCapacity()) {
                            int choice = JOptionPane.showConfirmDialog(this, "Do You want to Add to Database");
                            if (choice == 0) {
                                try {
                                    ps = connection.prepareStatement(sqlExc);
                                    ps.execute();
                                    JOptionPane.showMessageDialog(this, "Successfully Added to Database");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                          
                        } else {
                            JOptionPane.showMessageDialog(this, "Attempt Fail");
                        }
                    }

                }

            }
        }
    }//GEN-LAST:event_addWarehouseBtn1ActionPerformed
    }

    private void calculateWarehouseCapacityBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateWarehouseCapacityBtnActionPerformed
        // TODO add your handling code here:
        new CalculateWHCapacityUI().setVisible(true);
    }//GEN-LAST:event_calculateWarehouseCapacityBtnActionPerformed

    private void cancleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleBtnActionPerformed
        // TODO add your handling code here:

        //Asking user to close panel
        int choice = JOptionPane.showConfirmDialog(null, "Do You want to Cancel ?");
        if (choice == 0) {
            //cancel button clicked
            this.setVisible(false);
            new WMSUI().setVisible(true);
        } else {

        }
    }//GEN-LAST:event_cancleBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AddWarehouseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddWarehouseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddWarehouseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddWarehouseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddWarehouseUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddressLine01Label;
    private javax.swing.JLabel AddressLine02Label;
    private javax.swing.JLabel AddressLine03Label;
    private javax.swing.JLabel BasicInformationLabel1;
    private javax.swing.JLabel FaxNumberLabel;
    private javax.swing.JLabel FaxNumberLabel2;
    private javax.swing.JPanel PannelLeft;
    private javax.swing.JPanel PannelRight;
    private javax.swing.JLabel TelephoneNumberLabel;
    private javax.swing.JLabel WarehouseContactInformationLabel;
    private javax.swing.JLabel WarehouseContactInformationLabel1;
    private javax.swing.JButton addWarehouseBtn1;
    private javax.swing.JTextField addressLine01;
    private javax.swing.JTextField addressLine02;
    private javax.swing.JTextField addressLine03;
    private javax.swing.JButton calculateWarehouseCapacityBtn;
    private javax.swing.JButton cancleBtn;
    private javax.swing.JTextField capacityValue;
    private javax.swing.JTextField faxNumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField postalZipCode;
    private javax.swing.JComboBox<String> proviceCombo;
    private javax.swing.JTextField telephoneNumber;
    private javax.swing.JTextField warehouseName;
    private javax.swing.JLabel warehouseNameLabel;
    private javax.swing.JLabel warehouseNameLabel4;
    private javax.swing.JLabel warehouseNameLabel5;
    // End of variables declaration//GEN-END:variables
}
