/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fissmda.Warehouse_Subsystem.ExpenditureMS;

import fissmda.Warehouse_Subsystem.DBConnection;
import fissmda.Warehouse_Subsystem.DashBoardPackage.WarehouseDashboard;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author melan
 */
public class ExpenseReportUI extends javax.swing.JFrame {

    /**
     * Creates new form ExpenseReportUI
     */
    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    
    
    private int currentWID = WarehouseDashboard.passWID;
    
    public ExpenseReportUI() {
        initComponents();
        
        
        connection = DBConnection.getConnection();
        
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        reportText.setText("\t\t\t\t\tMARADANA BISCUIT DISTRIBUTION (PVT) LTD\n" +
"\n" +
"\t\t\t\tTELEPHONE : 011-2313415\t\tEMAIL maradanadistributor@mail.com\n" +
"\n" +
"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n" +
"\n" +
"\t\t\t\t\t   WAREHOUSE EXPENSES REPORT\n" +
"\n" +
"\t\t\t\tReport Generate TimeStamp : "+timeStamp+"\n\n");
        
        try{
            warehouseInformation();
        expenseListGen();
        paidBillsList();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    
    public void warehouseInformation(){
    
        

        String sqlEX = "select * from warehouse where wID = '"+currentWID+"'";
        
        try{
        PreparedStatement ps1;
        ps1 = connection.prepareStatement(sqlEX);
        rs = ps1.executeQuery();
        
        String pattern = "dd-MM-yyyy";
            String dateInString =new SimpleDateFormat(pattern).format(new Date());
        
        while(rs.next()){
                String warehouseName = rs.getString(2);
                String warehouseTelephone = rs.getString(8);
                String warehousFax = rs.getString(9);
                
                headlabel.setText("Expense Report of " +warehouseName);
                reportText.append("\t\t\t\tWarehouse\t:"+warehouseName+""
                        + "\t\tWarehouse Telephone Number\t"+warehouseTelephone+""
                                + "\n\t\t\t\t\t Expense Report for "+dateInString+" Period"
                                + "\n\n************************************************************************************************************************************************************************************************************************************************************************************\n");               
                
            }
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void expenseListGen(){
    
   
   
        String sqlExc = "Select * from expenditure where warehouse_wID = '"+currentWID+"' and paid = 1";
        try {

            reportText.append("\t\t\t\t\t\tPending Utility Bill Expenses ");
            ps = connection.prepareStatement(sqlExc);
            rs = ps.executeQuery();
          float totalAmountToPaid = 0;
            
            while(rs.next()){
            
                String category = rs.getString(4);
                String arrivalD = rs.getString(6);
                String endDate = rs.getString(7);
                String amount = rs.getString(2);
                float amountT = rs.getFloat(2);
                totalAmountToPaid+=amountT;
                
                reportText.append("\n************************************************************************************************************************************************************************************************************************************************************************************\n");
                reportText.append("\t\tBill Type\t\t:"+category+"\n");
                reportText.append("\t\tBill Start Date\t\t:"+arrivalD+"\n");
                reportText.append("\t\tBill End Date\t\t:"+endDate+"\n");
                reportText.append("\t\tBill Amount\t\t:"+amount+"\n");
                reportText.append("\n************************************************************************************************************************************************************************************************************************************************************************************\n");

            }
            
            reportText.append("\t\tTotal Amount payable \t\t:"+totalAmountToPaid+"\n");
            
       
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    
    }
    
    public void paidBillsList(){
    
      currentWID = WarehouseDashboard.passWID;
        
   
        String sqlExc = "Select * from expenditure where warehouse_wID = '"+currentWID+"' and paid = 0";
        try {
             reportText.append("\n\n\n");
            reportText.append("\t\t\t\t\t\tPaid Utility Bill Expenses ");
            ps = connection.prepareStatement(sqlExc);
            rs = ps.executeQuery();
          float totalAmountToPay = 0;
            
            while(rs.next()){
            
                String category = rs.getString(4);
                String arrivalD = rs.getString(6);
                String endDate = rs.getString(7);
                String amount = rs.getString(2);
                String transa=rs.getString(5);
                String transactionDate = rs.getString(10);
                float amountT = rs.getFloat(2);
                totalAmountToPay+=amountT;
                
                reportText.append("\n************************************************************************************************************************************************************************************************************************************************************************************\n");
                reportText.append("\t\tBill Type\t\t:"+category+"\n");
                reportText.append("\t\tBill Start Date\t\t:"+arrivalD+"\n");
                reportText.append("\t\tBill End Date\t\t:"+endDate+"\n");
                reportText.append("\t\tBill Amount\t\t:"+amount+"\n");
                reportText.append("\t\tTransaction Key\t\t:"+transa+"\n");
                reportText.append("\t\tTransaction Date\t\t:"+transactionDate+"\n");
                reportText.append("\n************************************************************************************************************************************************************************************************************************************************************************************\n");

            }
            
            reportText.append("\t\tTotal Amount Paid by Company \t\t:"+totalAmountToPay+"\n");
            
       
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        headlabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reportText = new javax.swing.JTextArea();

        jScrollPane2.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel2.setBackground(new java.awt.Color(153, 153, 91));

        jButton1.setText("Print Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fissmda/Warehouse_Subsystem/resources/backB.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        headlabel.setFont(new java.awt.Font("DejaVu Sans Light", 1, 24)); // NOI18N
        headlabel.setForeground(new java.awt.Color(51, 51, 51));
        headlabel.setText("Expenditure Report ");

        reportText.setColumns(20);
        reportText.setRows(5);
        jScrollPane1.setViewportView(reportText);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(28, 28, 28)
                        .addComponent(headlabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 557, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(headlabel)))))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        new WarehouseDashboard().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel6MouseClicked

 
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            reportText.print();
        } catch (PrinterException ex) {
            Logger.getLogger(ExpenseReportUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ExpenseReportUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExpenseReportUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExpenseReportUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExpenseReportUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExpenseReportUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel headlabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextArea reportText;
    // End of variables declaration//GEN-END:variables
}
