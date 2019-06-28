/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fissmda.Warehouse_Subsystem.DashBoardPackage;

import fissmda.Warehouse_Subsystem.DBConnection;
import fissmda.Warehouse_Subsystem.ExpenditureMS.ExpenseReportUI;
import fissmda.Warehouse_Subsystem.WMSUI;
import fissmda.Warehouse_Subsystem.ExpenditureMS.ViewExpense.ViewExpense;
import fissmda.Warehouse_Subsystem.ViewWarehousePackage.ViewWarehouse;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author melan
 */
public class WarehouseDashboard extends javax.swing.JFrame {

    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    public String selectedItemName = null;
    public String fetchedAddressL1;
    public String fetchedAddressL2;
    public String fetchedAddressL3;
    public String fetchedPostalCode;
    public String fetchedProviceCode;
    public static int passWID;
    

    /**
     * Creates new form WarehouseDashboard
     */
    public WarehouseDashboard() {
        initComponents();
        notificationLabel.setVisible(false);
        
         //Generate in Center at the Runtime 
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        // Establish Connection 
        try {
            connection = DBConnection.getConnection();
            fillCombo();
        warehouseSelector.setSelectedIndex(2);
        String getSelectedItem = warehouseSelector.getSelectedItem().toString();
        String sqlExec = "select * from warehouse where warehouse_name='" + getSelectedItem + "'";
      
        checkNotification();
        
           

        } catch (Exception e) {
            System.out.println("Unable to Establish Connection with database");
        }
        
        
        
        ///////////////Dynamically Load Pane/////////////////////////////////
        
        warehouseSelector.setSelectedIndex(1);
         String getSelectedItem = warehouseSelector.getSelectedItem().toString();
        String sqlExec = "select * from warehouse where warehouse_name='" + getSelectedItem + "'";
      
        
           try {
            ps = connection.prepareStatement(sqlExec);
            rs = ps.executeQuery();

            while (rs.next()) {
                passWID =rs.getInt(1);
                
                System.out.println(""+passWID);
               
                
                String dbReturnName = rs.getString(2);
                String dbReturnCapacity = rs.getString(10);
                String dbReturnTelephone = rs.getString(8);
                String fetchedFaxNumber = rs.getString(9);
                fetchedAddressL1 = rs.getString(3);
                fetchedAddressL2 = rs.getString(4);
                fetchedAddressL3 = rs.getString(5);
                fetchedPostalCode = rs.getString(6);
                fetchedProviceCode = rs.getString(7);
                
                
                warehouseNameView.setText(dbReturnName);
                warehouseCapacityView.setText(dbReturnCapacity + " sq.m");
                warehouseTelephoneView.setText(dbReturnTelephone);
                AddressLine01View.setText(fetchedAddressL1);
                AddressLine02View.setText(fetchedAddressL2);
                AddressLine03View.setText(fetchedAddressL3);
                faxNumberView.setText(fetchedFaxNumber);
                postalCodeView.setText(fetchedPostalCode);
                provinceZipView.setText(fetchedProviceCode);
                
                calculateWarehouseExpenses();
                
                       
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        
        
     //////////////////////////////////////////////////////////////   
        

    }

    public void setSelectedItemName(String value) {

        this.selectedItemName = value;
    }

  
    
    public void checkNotification(){
    
        PreparedStatement psN;
        ResultSet rsN;
        String sqlEx = "SELECT * FROM `expenditure` WHERE `deadLine` BETWEEN NOW() AND DATE_ADD(NOW(), INTERVAL 7 DAY) ";
        
           try {
            psN = connection.prepareStatement(sqlEx);
            rsN = psN.executeQuery();

              if(!rsN.next()){
                  System.out.println("No Notifications");
              }else{
                  notificationLabel.setVisible(true);
                  
                  //displayTray();
              }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    
    }

    public void fillCombo() {

        try {

            String sqlExec = "select * from warehouse";
            ps = connection.prepareStatement(sqlExec);
            rs = ps.executeQuery();

            while (rs.next()) {
                String getWarehouseName = rs.getString("warehouse_name");
                warehouseSelector.addItem(getWarehouseName);
            }

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

        kGradientPanel1 = new keeptoo.KGradientPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        warehouseDisplayCapacity = new javax.swing.JLabel();
        warehouseNameView = new javax.swing.JLabel();
        warehouseCapacityView = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        warehouseTelephoneView = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        faxNumberView = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        warehouseSelector = new javax.swing.JComboBox<>();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        BasicInformationLabel1 = new javax.swing.JLabel();
        AddressLine01Label = new javax.swing.JLabel();
        AddressLine02Label = new javax.swing.JLabel();
        AddressLine03Label = new javax.swing.JLabel();
        warehouseNameLabel4 = new javax.swing.JLabel();
        warehouseNameLabel5 = new javax.swing.JLabel();
        AddressLine01View = new javax.swing.JLabel();
        AddressLine02View = new javax.swing.JLabel();
        AddressLine03View = new javax.swing.JLabel();
        postalCodeView = new javax.swing.JLabel();
        provinceZipView = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        BasicInformationLabel2 = new javax.swing.JLabel();
        ViewWarehouseExpense = new javax.swing.JButton();
        expenseTitle = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        expenseTotal = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ViewWarehouseExpenseReport = new javax.swing.JButton();
        notificationLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1276, 815));

        kGradientPanel1.setkEndColor(new java.awt.Color(36, 36, 62));
        kGradientPanel1.setkGradientFocus(200);
        kGradientPanel1.setkStartColor(new java.awt.Color(15, 12, 41));

        kGradientPanel2.setkEndColor(new java.awt.Color(15, 52, 67));
        kGradientPanel2.setkGradientFocus(999);
        kGradientPanel2.setkStartColor(new java.awt.Color(52, 232, 158));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fissmda/Warehouse_Subsystem/resources/warehouse(2).png"))); // NOI18N

        warehouseDisplayCapacity.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N

        warehouseNameView.setBackground(new java.awt.Color(255, 255, 255));
        warehouseNameView.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        warehouseNameView.setForeground(new java.awt.Color(255, 255, 255));
        warehouseNameView.setText("jLabel1");

        warehouseCapacityView.setBackground(new java.awt.Color(255, 255, 255));
        warehouseCapacityView.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        warehouseCapacityView.setForeground(new java.awt.Color(255, 255, 255));
        warehouseCapacityView.setText("ware");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Capacity                    :");

        warehouseTelephoneView.setBackground(new java.awt.Color(255, 255, 255));
        warehouseTelephoneView.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        warehouseTelephoneView.setForeground(new java.awt.Color(255, 255, 255));
        warehouseTelephoneView.setText("jLabel3");

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Telephone Number   :");

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fax Number              :");

        faxNumberView.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        faxNumberView.setForeground(new java.awt.Color(255, 255, 255));
        faxNumberView.setText("jLabel6");

        jLabel6.setFont(new java.awt.Font("DejaVu Sans Light", 1, 24)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fissmda/Warehouse_Subsystem/resources/icons8-back-arrow-32.png"))); // NOI18N
        jLabel6.setText("Dashboard");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(jLabel2)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(warehouseNameView))
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                        .addGap(81, 81, 81)
                                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel3))
                                        .addGap(15, 15, 15))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)))
                                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(warehouseTelephoneView)
                                    .addComponent(warehouseCapacityView)
                                    .addComponent(faxNumberView)))))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(388, 388, 388)
                        .addComponent(warehouseDisplayCapacity))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warehouseDisplayCapacity)
                .addGap(44, 44, 44)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(warehouseNameView)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel5))
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(warehouseCapacityView)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(warehouseTelephoneView)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(faxNumberView))))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        warehouseSelector.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                warehouseSelectorPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        warehouseSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warehouseSelectorActionPerformed(evt);
            }
        });

        kGradientPanel3.setkEndColor(new java.awt.Color(15, 52, 67));
        kGradientPanel3.setkGradientFocus(999);
        kGradientPanel3.setkStartColor(new java.awt.Color(52, 232, 158));
        kGradientPanel3.setMaximumSize(new java.awt.Dimension(518, 361));
        kGradientPanel3.setMinimumSize(new java.awt.Dimension(518, 361));

        BasicInformationLabel1.setFont(new java.awt.Font("DejaVu Sans Light", 1, 18)); // NOI18N
        BasicInformationLabel1.setForeground(new java.awt.Color(51, 51, 51));
        BasicInformationLabel1.setText("Basic Information");

        AddressLine01Label.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        AddressLine01Label.setForeground(new java.awt.Color(102, 102, 102));
        AddressLine01Label.setText("Address Line 01");

        AddressLine02Label.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        AddressLine02Label.setForeground(new java.awt.Color(102, 102, 102));
        AddressLine02Label.setText("Address Line 02");

        AddressLine03Label.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        AddressLine03Label.setForeground(new java.awt.Color(102, 102, 102));
        AddressLine03Label.setText("Address Line 03");

        warehouseNameLabel4.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        warehouseNameLabel4.setForeground(new java.awt.Color(102, 102, 102));
        warehouseNameLabel4.setText("Postal Code / ZIP");

        warehouseNameLabel5.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        warehouseNameLabel5.setForeground(new java.awt.Color(102, 102, 102));
        warehouseNameLabel5.setText("Province / State");

        AddressLine01View.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        AddressLine01View.setForeground(new java.awt.Color(255, 255, 255));
        AddressLine01View.setText("Address Line 01");

        AddressLine02View.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        AddressLine02View.setForeground(new java.awt.Color(255, 255, 255));
        AddressLine02View.setText("Address Line 02");

        AddressLine03View.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        AddressLine03View.setForeground(new java.awt.Color(255, 255, 255));
        AddressLine03View.setText("Address Line 03");

        postalCodeView.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        postalCodeView.setForeground(new java.awt.Color(255, 255, 255));
        postalCodeView.setText("Postal Code / ZIP");

        provinceZipView.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        provinceZipView.setForeground(new java.awt.Color(255, 255, 255));
        provinceZipView.setText("Province / State");

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BasicInformationLabel1)
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddressLine01Label)
                            .addComponent(AddressLine02Label)
                            .addComponent(AddressLine03Label)
                            .addComponent(warehouseNameLabel4)
                            .addComponent(warehouseNameLabel5))
                        .addGap(39, 39, 39)
                        .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddressLine01View)
                            .addComponent(AddressLine02View)
                            .addComponent(AddressLine03View)
                            .addComponent(postalCodeView)
                            .addComponent(provinceZipView))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(BasicInformationLabel1)
                .addGap(63, 63, 63)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(AddressLine01Label)
                        .addGap(18, 18, 18)
                        .addComponent(AddressLine02Label)
                        .addGap(18, 18, 18)
                        .addComponent(AddressLine03Label)
                        .addGap(18, 18, 18)
                        .addComponent(warehouseNameLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(warehouseNameLabel5))
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(AddressLine01View)
                        .addGap(18, 18, 18)
                        .addComponent(AddressLine02View)
                        .addGap(18, 18, 18)
                        .addComponent(AddressLine03View)
                        .addGap(18, 18, 18)
                        .addComponent(postalCodeView)
                        .addGap(18, 18, 18)
                        .addComponent(provinceZipView)))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fissmda/Warehouse_Subsystem/resources/icons8-warehouse-30.png"))); // NOI18N
        jLabel4.setText("Current Warehouse |");

        kGradientPanel4.setkEndColor(new java.awt.Color(75, 19, 79));
        kGradientPanel4.setkGradientFocus(150);
        kGradientPanel4.setkStartColor(new java.awt.Color(201, 75, 75));

        BasicInformationLabel2.setBackground(new java.awt.Color(255, 255, 255));
        BasicInformationLabel2.setFont(new java.awt.Font("DejaVu Sans Light", 1, 24)); // NOI18N
        BasicInformationLabel2.setForeground(new java.awt.Color(255, 255, 255));
        BasicInformationLabel2.setText("Warehouse Expenses");

        ViewWarehouseExpense.setBackground(new java.awt.Color(44, 189, 137));
        ViewWarehouseExpense.setText("View Warehouse Expenses");
        ViewWarehouseExpense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewWarehouseExpenseActionPerformed(evt);
            }
        });

        expenseTitle.setBackground(new java.awt.Color(255, 255, 255));
        expenseTitle.setFont(new java.awt.Font("DejaVu Sans", 0, 20)); // NOI18N
        expenseTitle.setForeground(new java.awt.Color(255, 255, 255));
        expenseTitle.setText("Total Expense for ");

        jLabel8.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Rs .");

        expenseTotal.setBackground(new java.awt.Color(255, 255, 255));
        expenseTotal.setFont(new java.awt.Font("DejaVu Sans", 0, 34)); // NOI18N
        expenseTotal.setForeground(new java.awt.Color(255, 255, 255));
        expenseTotal.setText("243242.00");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fissmda/Warehouse_Subsystem/resources/expensive.png"))); // NOI18N

        ViewWarehouseExpenseReport.setBackground(new java.awt.Color(44, 189, 137));
        ViewWarehouseExpenseReport.setText("View Warehouse Expense Report");
        ViewWarehouseExpenseReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewWarehouseExpenseReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel4Layout = new javax.swing.GroupLayout(kGradientPanel4);
        kGradientPanel4.setLayout(kGradientPanel4Layout);
        kGradientPanel4Layout.setHorizontalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(expenseTotal))
                    .addComponent(expenseTitle)
                    .addComponent(BasicInformationLabel2)
                    .addGroup(kGradientPanel4Layout.createSequentialGroup()
                        .addComponent(ViewWarehouseExpense, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ViewWarehouseExpenseReport, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        kGradientPanel4Layout.setVerticalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel9))
                    .addGroup(kGradientPanel4Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(BasicInformationLabel2)))
                .addGap(37, 37, 37)
                .addComponent(expenseTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(expenseTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ViewWarehouseExpense, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ViewWarehouseExpenseReport, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        notificationLabel.setForeground(new java.awt.Color(255, 0, 51));
        notificationLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fissmda/Warehouse_Subsystem/resources/icons8-new-message-30.png"))); // NOI18N
        notificationLabel.setText("New Notification");
        notificationLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        notificationLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notificationLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(notificationLabel)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warehouseSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(kGradientPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(warehouseSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(notificationLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void warehouseSelectorPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_warehouseSelectorPopupMenuWillBecomeInvisible
        // TODO add your handling code here:

        String getSelectedItem = warehouseSelector.getSelectedItem().toString();
        String sqlExec = "select * from warehouse where warehouse_name='" + getSelectedItem + "'";
        try {
            ps = connection.prepareStatement(sqlExec);
            rs = ps.executeQuery();

            while (rs.next()) {
                passWID =rs.getInt(1);
                
                System.out.println(""+passWID);
               
                
                String dbReturnName = rs.getString(2);
                String dbReturnCapacity = rs.getString(10);
                String dbReturnTelephone = rs.getString(8);
                String fetchedFaxNumber = rs.getString(9);
                fetchedAddressL1 = rs.getString(3);
                fetchedAddressL2 = rs.getString(4);
                fetchedAddressL3 = rs.getString(5);
                fetchedPostalCode = rs.getString(6);
                fetchedProviceCode = rs.getString(7);
                
                
                warehouseNameView.setText(dbReturnName);
                warehouseCapacityView.setText(dbReturnCapacity + " sq.m");
                warehouseTelephoneView.setText(dbReturnTelephone);
                AddressLine01View.setText(fetchedAddressL1);
                AddressLine02View.setText(fetchedAddressL2);
                AddressLine03View.setText(fetchedAddressL3);
                faxNumberView.setText(fetchedFaxNumber);
                postalCodeView.setText(fetchedPostalCode);
                provinceZipView.setText(fetchedProviceCode);
                
                calculateWarehouseExpenses();
                       
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }//GEN-LAST:event_warehouseSelectorPopupMenuWillBecomeInvisible

    
    
    public void calculateWarehouseExpenses(){
        
        float amountGet = 0;
          
         try {
            PreparedStatement psCalc;
        String calcSql = "select * from expenditure where warehouse_wID = '"+passWID+"'";
               
            psCalc = connection.prepareStatement(calcSql);
            rs = psCalc.executeQuery();
            while(rs.next()){
                
                
               
                
                     amountGet+=rs.getFloat(2);
                
              
               
            }
            
            String pattern = "dd-MM-yyyy";
            String dateInString =new SimpleDateFormat(pattern).format(new Date());
            expenseTitle.setText("Total Expense till "+dateInString+" " );
            expenseTotal.setText(""+amountGet);
         

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
         new WMSUI().setVisible(true);
        this.setVisible(false);
       
    }//GEN-LAST:event_jLabel7MouseClicked

    private void warehouseSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warehouseSelectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_warehouseSelectorActionPerformed

    private void ViewWarehouseExpenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewWarehouseExpenseActionPerformed
        // TODO add your handling code here:

        new ViewExpense().setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_ViewWarehouseExpenseActionPerformed

    private void ViewWarehouseExpenseReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewWarehouseExpenseReportActionPerformed
        // TODO add your handling code here:
        new ExpenseReportUI().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ViewWarehouseExpenseReportActionPerformed

    public void displayTray() throws AWTException, MalformedURLException {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        //Alternative (if the icon is on the classpath):
        //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("System tray icon demo");
        tray.add(trayIcon);

        trayIcon.displayMessage("Warehouse System Notification Service", "Time to pay bills", MessageType.INFO);
    }
    
    private void notificationLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationLabelMouseClicked
        // TODO add your handling code here:
        new NotificationWindow().setVisible(true);
    }//GEN-LAST:event_notificationLabelMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked


        // TODO add your handling code here:
        
        
          new WMSUI().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel6MouseClicked

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
            java.util.logging.Logger.getLogger(WarehouseDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WarehouseDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WarehouseDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WarehouseDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WarehouseDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddressLine01Label;
    private javax.swing.JLabel AddressLine01View;
    private javax.swing.JLabel AddressLine02Label;
    private javax.swing.JLabel AddressLine02View;
    private javax.swing.JLabel AddressLine03Label;
    private javax.swing.JLabel AddressLine03View;
    private javax.swing.JLabel BasicInformationLabel1;
    private javax.swing.JLabel BasicInformationLabel2;
    private javax.swing.JButton ViewWarehouseExpense;
    private javax.swing.JButton ViewWarehouseExpenseReport;
    private javax.swing.JLabel expenseTitle;
    private javax.swing.JLabel expenseTotal;
    private javax.swing.JLabel faxNumberView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    private javax.swing.JLabel notificationLabel;
    private javax.swing.JLabel postalCodeView;
    private javax.swing.JLabel provinceZipView;
    private javax.swing.JLabel warehouseCapacityView;
    private javax.swing.JLabel warehouseDisplayCapacity;
    private javax.swing.JLabel warehouseNameLabel4;
    private javax.swing.JLabel warehouseNameLabel5;
    private javax.swing.JLabel warehouseNameView;
    private javax.swing.JComboBox<String> warehouseSelector;
    private javax.swing.JLabel warehouseTelephoneView;
    // End of variables declaration//GEN-END:variables
}
