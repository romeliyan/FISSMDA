/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fissmda;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Romesh
 */
public class CompareMonthIncome extends javax.swing.JFrame {

    
     Connection con = null;
    PreparedStatement pst55 = null; 
    ResultSet rs66 = null;
    
    
    PreparedStatement pstm1 = null; 
    ResultSet rsm1 = null;
    
    PreparedStatement pstm2 = null; 
    ResultSet rsm2 = null;
    
    PreparedStatement pstm3 = null; 
    ResultSet rsm3 = null;
    
    PreparedStatement pstm4 = null; 
    ResultSet rsm4 = null;
    
    PreparedStatement pstm5 = null; 
    ResultSet rsm5 = null;
    
    PreparedStatement pstm6 = null; 
    ResultSet rsm6 = null;
    
    PreparedStatement pstm7 = null; 
    ResultSet rsm7 = null;
    
    PreparedStatement pstm8 = null; 
    ResultSet rsm8 = null;
    
    PreparedStatement pstm9 = null; 
    ResultSet rsm9 = null;
    
    PreparedStatement pstm10 = null; 
    ResultSet rsm10 = null;
    
    PreparedStatement pstm11 = null; 
    ResultSet rsm11 = null;
    
    PreparedStatement pstm12 = null; 
    ResultSet rsm12 = null;
    
    PreparedStatement pstm1a = null; 
    ResultSet rsm1a = null;
    
    PreparedStatement pstm2a = null; 
    ResultSet rsm2a = null;
    
    PreparedStatement pstm3a = null; 
    ResultSet rsm3a = null;
    
    PreparedStatement pstm4a = null; 
    ResultSet rsm4a = null;
    
    PreparedStatement pstm5a = null; 
    ResultSet rsm5a = null;
    
    PreparedStatement pstm6a = null; 
    ResultSet rsm6a = null;
    
    PreparedStatement pstm7a = null; 
    ResultSet rsm7a = null;
    
    PreparedStatement pstm8a = null; 
    ResultSet rsm8a = null;
    
    PreparedStatement pstm9a = null; 
    ResultSet rsm9a = null;
    
    PreparedStatement pstm10a = null; 
    ResultSet rsm10a = null;
    
    PreparedStatement pstm11a = null; 
    ResultSet rsm11a = null;
    
    PreparedStatement pstm12a = null; 
    ResultSet rsm12a = null;
    
    
    
    /**
     * Creates new form CompareMonthIncome
     */
    public CompareMonthIncome() {
        initComponents();
        
        con = DBConnection.connect();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlReport5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 91));
        jPanel1.setMaximumSize(new java.awt.Dimension(1276, 815));
        jPanel1.setMinimumSize(new java.awt.Dimension(1276, 815));
        jPanel1.setPreferredSize(new java.awt.Dimension(1276, 815));

        pnlReport5.setBackground(new java.awt.Color(187, 224, 103));
        pnlReport5.setLayout(new javax.swing.BoxLayout(pnlReport5, javax.swing.BoxLayout.LINE_AXIS));

        jButton1.setBackground(new java.awt.Color(240, 242, 114));
        jButton1.setText("Show");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fissmda/ButtonImages/homeB.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fissmda/ButtonImages/backB.png"))); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fissmda/ButtonImages/agencySummarypic.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Compare Monthly Income of the Agency by Year");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("MONTHLY  INCOME");

        jLabel10.setText("( Right click on the bar chart to see properties [ zoom in | zoom out | print | save as photo ] )");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(pnlReport5, javax.swing.GroupLayout.PREFERRED_SIZE, 1091, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(331, 331, 331)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(jLabel1)))))
                .addContainerGap(339, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(pnlReport5, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
         try{
                String sqln1 = "SELECT SUM(totalAmount) As jan FROM shop_income WHERE iDate >= '2017/01/01' and iDate <= '2017/01/31' ";
                 pstm1 = con.prepareStatement(sqln1);
                 rsm1 = pstm1.executeQuery(); 
               
        
                 if(rsm1.next()){
        
                         String total = rsm1.getString("jan");
                         System.out.println(total);
            
                         if(total == null){
            
                             jantot = 0;
                         }
                          else if(total != null){
                             Double tot = Double.parseDouble(total);
            
                             jantot = tot;
                         }
                     }
            
              }catch(SQLException e){}
             
             
             try{
                String sqln2 = "SELECT SUM(totalAmount) As feb FROM shop_income WHERE iDate >= '2017/02/01' and iDate <= '2017/02/31' ";
                 pstm2 = con.prepareStatement(sqln2);
                 rsm2 = pstm2.executeQuery(); 
              
        
                 if(rsm2.next()){
        
                         String total = rsm2.getString("feb");
                         System.out.println(total);
            
                         if(total == null){
            
                             febtot = 0;
                         }
                          else if(total != null){
                             Double tot = Double.parseDouble(total);
            
                             febtot = tot;
                         }
                     }
            
              }catch(SQLException e){}
             
             try{
                String sqln3 = "SELECT SUM(totalAmount) As mar FROM shop_income WHERE iDate >= '2017/03/01' and iDate <= '2017/03/31' ";
                 pstm3 = con.prepareStatement(sqln3);
                 rsm3 = pstm3.executeQuery(); 
               
        
                 if(rsm3.next()){
        
                         String total = rsm3.getString("mar");
                         System.out.println(total);
            
                         if(total == null){
            
                             martot = 0;
                         }
                          else if(total != null){
                             Double tot = Double.parseDouble(total);
            
                             martot = tot;
                         }
                     }
            
              }catch(SQLException e){}
             
             
             try{
                String sqln4 = "SELECT SUM(totalAmount) As apr FROM shop_income WHERE iDate >= '2017/04/01' and iDate <= '2017/04/31' ";
                 pstm4 = con.prepareStatement(sqln4);
                 rsm4 = pstm4.executeQuery(); 
               
        
                 if(rsm4.next()){
        
                         String total = rsm4.getString("apr");
                         System.out.println(total);
            
                         if(total == null){
            
                             aprtot = 0;
                         }
                          else if(total != null){
                             Double tot = Double.parseDouble(total);
            
                             aprtot = tot;
                         }
                     }
            
              }catch(SQLException e){}
             
             try{
                String sqln5 = "SELECT SUM(totalAmount) As may FROM shop_income WHERE iDate >= '2017/05/01' and iDate <= '2017/05/31' ";
                 pstm5 = con.prepareStatement(sqln5);
                 rsm5 = pstm5.executeQuery(); 
              
        
                 if(rsm5.next()){
        
                         String total = rsm5.getString("may");
                         System.out.println(total);
            
                         if(total == null){
            
                             maytot = 0;
                         }
                          else if(total != null){
                             Double tot = Double.parseDouble(total);
            
                             maytot = tot;
                         }
                     }
            
              }catch(SQLException e){}
             
             
             try{
                String sqln6 = "SELECT SUM(totalAmount) As jun FROM shop_income WHERE iDate >= '2017/06/01' and iDate <= '2017/06/31' ";
                 pstm6 = con.prepareStatement(sqln6);
                 rsm6 = pstm6.executeQuery(); 
             
        
                 if(rsm6.next()){
        
                         String total = rsm6.getString("jun");
                         System.out.println(total);
            
                         if(total == null){
            
                             juntot = 0;
                         }
                          else if(total != null){
                             Double tot = Double.parseDouble(total);
            
                             juntot = tot;
                         }
                     }
            
              }catch(SQLException e){}
             
             
             try{
                String sqln7 = "SELECT SUM(totalAmount) As jul FROM shop_income WHERE iDate >= '2017/07/01' and iDate <= '2017/07/31' ";
                 pstm7 = con.prepareStatement(sqln7);
                 rsm7 = pstm7.executeQuery(); 
              
        
                 if(rsm7.next()){
        
                         String total = rsm7.getString("jul");
                         System.out.println(total);
            
                         if(total == null){
            
                             juntot = 0;
                         }
                          else if(total != null){
                             Double tot = Double.parseDouble(total);
            
                             juntot = tot;
                         }
                     }
            
              }catch(SQLException e){}
             
             
             try{
                String sqln8 = "SELECT SUM(totalAmount) As aug FROM shop_income WHERE iDate >= '2017/08/01' and iDate <= '2017/08/31' ";
                 pstm8 = con.prepareStatement(sqln8);
                 rsm8 = pstm8.executeQuery(); 
             
        
                 if(rsm8.next()){
        
                         String total = rsm8.getString("aug");
                         System.out.println(total);
            
                         if(total == null){
            
                             augtot = 0;
                         }
                          else if(total != null){
                             Double tot = Double.parseDouble(total);
            
                             augtot = tot;
                         }
                     }
            
              }catch(SQLException e){}
             
             
             try{
                String sqln9 = "SELECT SUM(totalAmount) As sep FROM shop_income WHERE iDate >= '2017/09/01' and iDate <= '2017/09/31' ";
                 pstm9 = con.prepareStatement(sqln9);
                 rsm9 = pstm9.executeQuery(); 
              
        
                 if(rsm9.next()){
        
                         String total = rsm9.getString("sep");
                         System.out.println(total);
            
                         if(total == null){
            
                             septot = 0;
                         }
                          else if(total != null){
                             Double tot = Double.parseDouble(total);
            
                             septot = tot;
                         }
                     }
            
              }catch(SQLException e){}
             
             
             try{
                String sqln10 = "SELECT SUM(totalAmount) As oct FROM shop_income WHERE iDate >= '2017/10/01' and iDate <= '2017/10/31' ";
                 pstm10 = con.prepareStatement(sqln10);
                 rsm10 = pstm10.executeQuery(); 
            
        
                 if(rsm10.next()){
        
                         String total = rsm10.getString("oct");
                         System.out.println(total);
            
                         if(total == null){
            
                             octtot = 0;
                         }
                          else if(total != null){
                             Double tot = Double.parseDouble(total);
            
                             octtot = tot;
                         }
                     }
            
              }catch(SQLException e){}
             
             
             try{
                String sqln11 = "SELECT SUM(totalAmount) As nov FROM shop_income WHERE iDate >= '2017/11/01' and iDate <= '2017/11/31' ";
                 pstm11 = con.prepareStatement(sqln11);
                 rsm11 = pstm11.executeQuery(); 
              
        
                 if(rsm11.next()){
        
                         String total = rsm11.getString("nov");
                         System.out.println(total);
            
                         if(total == null){
            
                             novtot = 0;
                         }
                          else if(total != null){
                             Double tot = Double.parseDouble(total);
            
                             novtot = tot;
                         }
                     }
            
              }catch(SQLException e){}
             
             
             try{
                String sqln12 = "SELECT SUM(totalAmount) As dec FROM shop_income WHERE iDate >= '2017/12/01' and iDate <= '2017/12/31' ";
                 pstm12 = con.prepareStatement(sqln12);
                 rsm12 = pstm12.executeQuery(); 
              
        
                 if(rsm12.next()){
        
                         String total = rsm12.getString("dec");
                         System.out.println(total);
            
                         if(total == null){
            
                             dectot = 0;
                         }
                          else if(total != null){
                             Double tot = Double.parseDouble(total);
            
                             dectot = tot;
                         }
                     }
            
              }catch(SQLException e){}
             
      //***************************************************2018****************************************************************
      
       try{
                String sqln1a = "SELECT SUM(totalAmount) As jana FROM shop_income WHERE iDate >= '2018/01/01' and iDate <= '2018/01/31' ";
                 pstm1a = con.prepareStatement(sqln1a);
                 rsm1a = pstm1a.executeQuery(); 
               
        
                 if(rsm1a.next()){
        
                         String total = rsm1a.getString("jana");
                         System.out.println(total);
            
                         if(total == null){
            
                             jantota = 0;
                         }
                          else if(total != null){
                             Double tot = Double.parseDouble(total);
            
                             jantota = tot;
                         }
                     }
            
              }catch(SQLException e){}
             
             
             try{
                String sqln2a = "SELECT SUM(totalAmount) As feba FROM shop_income WHERE iDate >= '2018/02/01' and iDate <= '2018/02/31' ";
                 pstm2a = con.prepareStatement(sqln2a);
                 rsm2a = pstm2a.executeQuery(); 
              
        
                 if(rsm2a.next()){
        
                         String total = rsm2a.getString("feba");
                         System.out.println(total);
            
                         if(total == null){
            
                             febtota = 0;
                         }
                          else if(total != null){
                             Double tot = Double.parseDouble(total);
            
                             febtota = tot;
                         }
                     }
            
              }catch(SQLException e){}
             
             try{
                String sqln3a = "SELECT SUM(totalAmount) As mara FROM shop_income WHERE iDate >= '2018/03/01' and iDate <= '2018/03/31' ";
                 pstm3a = con.prepareStatement(sqln3a);
                 rsm3a = pstm3a.executeQuery(); 
               
        
                 if(rsm3a.next()){
        
                         String total = rsm3a.getString("mara");
                         System.out.println(total);
            
                         if(total == null){
            
                             martota = 0;
                         }
                          else if(total != null){
                             Double tot = Double.parseDouble(total);
            
                             martota = tot;
                         }
                     }
            
              }catch(SQLException e){}
             
             
             try{
                String sqln4a = "SELECT SUM(totalAmount) As apra FROM shop_income WHERE iDate >= '2018/04/01' and iDate <= '2018/04/31' ";
                 pstm4a = con.prepareStatement(sqln4a);
                 rsm4a = pstm4a.executeQuery(); 
              
        
                 if(rsm4a.next()){
        
                         String total = rsm4a.getString("apra");
                         System.out.println(total);
            
                         if(total == null){
            
                             aprtota = 0;
                         }
                          else if(total != null){
                             Double tot = Double.parseDouble(total);
            
                             aprtota = tot;
                         }
                     }
            
              }catch(SQLException e){}
             
             try{
                String sqln5a = "SELECT SUM(totalAmount) As maya FROM shop_income WHERE iDate >= '2018/05/01' and iDate <= '2018/05/31' ";
                 pstm5a = con.prepareStatement(sqln5a);
                 rsm5a = pstm5a.executeQuery(); 
             
        
                 if(rsm5a.next()){
        
                         String total = rsm5a.getString("maya");
                         System.out.println(total);
            
                         if(total == null){
            
                             maytota = 0;
                         }
                          else if(total != null){
                             Double tot = Double.parseDouble(total);
            
                             maytota = tot;
                         }
                     }
            
              }catch(SQLException e){}
             
             
             try{
                String sqln6a = "SELECT SUM(totalAmount) As juna FROM shop_income WHERE iDate >= '2018/06/01' and iDate <= '2018/06/31' ";
                 pstm6a = con.prepareStatement(sqln6a);
                 rsm6a = pstm6a.executeQuery(); 
             
        
                 if(rsm6a.next()){
        
                         String total = rsm6a.getString("juna");
                         System.out.println(total);
            
                         if(total == null){
            
                             juntota = 0;
                         }
                          else if(total != null){
                             Double tot = Double.parseDouble(total);
            
                             juntota = tot;
                         }
                     }
            
              }catch(SQLException e){}
             
             
             try{
                String sqln7a = "SELECT SUM(totalAmount) As jula FROM shop_income WHERE iDate >= '2018/07/01' and iDate <= '2018/07/31' ";
                 pstm7a = con.prepareStatement(sqln7a);
                 rsm7a = pstm7a.executeQuery(); 
            
        
                 if(rsm7a.next()){
        
                         String total = rsm7a.getString("jula");
                         System.out.println(total);
            
                         if(total == null){
            
                             juntota = 0;
                         }
                          else if(total != null){
                             Double tot = Double.parseDouble(total);
            
                             juntota = tot;
                         }
                     }
            
              }catch(SQLException e){}
             
             
             try{
                String sqln8a = "SELECT SUM(totalAmount) As auga FROM shop_income WHERE iDate >= '2018/08/01' and iDate <= '2018/08/31' ";
                 pstm8a = con.prepareStatement(sqln8a);
                 rsm8a= pstm8a.executeQuery(); 
              
        
                 if(rsm8a.next()){
        
                         String total = rsm8a.getString("auga");
                         System.out.println(total);
            
                         if(total == null){
            
                             augtota = 0;
                         }
                          else if(total != null){
                             Double tot = Double.parseDouble(total);
            
                             augtota = tot;
                         }
                     }
            
              }catch(SQLException e){}
             
             
             try{
                String sqln9a = "SELECT SUM(totalAmount) As sepa FROM shop_income WHERE iDate >= '2018/09/01' and iDate <= '2018/09/31' ";
                 pstm9a = con.prepareStatement(sqln9a);
                 rsm9a = pstm9a.executeQuery(); 
             
        
                 if(rsm9a.next()){
        
                         String total = rsm9a.getString("sepa");
                         System.out.println(total);
            
                         if(total == null){
            
                             septota = 0;
                         }
                          else if(total != null){
                             Double tot = Double.parseDouble(total);
            
                             septota = tot;
                         }
                     }
            
              }catch(SQLException e){}
             
             
             try{
                String sqln10a = "SELECT SUM(totalAmount) As octa FROM shop_income WHERE iDate >= '2018/10/01' and iDate <= '2018/10/31' ";
                 pstm10a = con.prepareStatement(sqln10a);
                 rsm10a = pstm10a.executeQuery(); 
            
        
                 if(rsm10a.next()){
        
                         String total = rsm10a.getString("octa");
                         System.out.println(total);
            
                         if(total == null){
            
                             octtota = 0;
                         }
                          else if(total != null){
                             Double tot = Double.parseDouble(total);
            
                             octtota = tot;
                         }
                     }
            
              }catch(SQLException e){}
             
             
             try{
                String sqln11a = "SELECT SUM(totalAmount) As nova FROM shop_income WHERE iDate >= '2018/11/01' and iDate <= '2018/11/31' ";
                 pstm11a = con.prepareStatement(sqln11a);
                 rsm11a = pstm11a.executeQuery(); 
            
        
                 if(rsm11a.next()){
        
                         String total = rsm11a.getString("nova");
                         System.out.println(total);
            
                         if(total == null){
            
                             novtota = 0;
                         }
                          else if(total != null){
                             Double tot = Double.parseDouble(total);
            
                             novtota = tot;
                         }
                     }
            
              }catch(SQLException e){}
             
             
             try{
                String sqln12a = "SELECT SUM(totalAmount) As deca FROM shop_income WHERE iDate >= '2018/12/01' and iDate <= '2018/12/31' ";
                 pstm12a = con.prepareStatement(sqln12a);
                 rsm12a = pstm12a.executeQuery(); 
            
        
                 if(rsm12a.next()){
        
                         String total = rsm12a.getString("deca");
                         System.out.println(total);
            
                         if(total == null){
            
                             dectota = 0;
                         }
                          else if(total != null){
                             Double tot = Double.parseDouble(total);
            
                             dectota = tot;
                         }
                     }
            
              }catch(SQLException e){}
             
            
            //***************************print*************************************************
            
             DefaultCategoryDataset dcd2 = new DefaultCategoryDataset();
     
        
        dcd2.setValue(jantot,"2017","January");
        dcd2.setValue(jantota,"2018","January");
        dcd2.setValue(febtot,"2017","February");
        dcd2.setValue(febtota,"2018","February");
        dcd2.setValue(martot,"2017","March");
        dcd2.setValue(martota,"2018","March");
        dcd2.setValue(aprtot,"2017","April");
        dcd2.setValue(aprtota,"2018","April");
        dcd2.setValue(maytot,"2017","May");
        dcd2.setValue(maytota,"2018","May");
        dcd2.setValue(juntot,"2017","June");
        dcd2.setValue(juntota,"2018","June");
        dcd2.setValue(jultot,"2017","July");
        dcd2.setValue(jultota,"2018","July");
        dcd2.setValue(augtot,"2017","August");
        dcd2.setValue(augtota,"2018","August");
        dcd2.setValue(septot,"2017","September");
        dcd2.setValue(septota,"2018","September");
        dcd2.setValue(octtot,"2017","October");
        dcd2.setValue(octtota,"2018","October");
        dcd2.setValue(novtot,"2017","November");
        dcd2.setValue(novtota,"2018","November");
        dcd2.setValue(dectot,"2017","December");
        dcd2.setValue(dectota,"2018","December");
        
         JFreeChart jchart = ChartFactory.createBarChart("Agency Income", "Income Month", "Value Rs.", dcd2, PlotOrientation.VERTICAL, true , true, false);
        
        CategoryPlot plot = jchart.getCategoryPlot();
      
        plot.setBackgroundPaint(new Color(187, 224, 103));
        plot.setRangeGridlinePaint(Color.black);
        
        ChartFrame chartFrm = new ChartFrame("Shop Income",jchart,true);
        chartFrm.setVisible(false);
        chartFrm.setSize(500, 400);
        
        ChartPanel chartPanel = new ChartPanel(jchart);
        
        pnlReport5.removeAll();
        pnlReport5.add(chartPanel);
        pnlReport5.updateUI();
        
        
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
         //navigate to back
        MonthlySummaryIncome r1 = new MonthlySummaryIncome();
        r1.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        r1.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
        this.dispose();
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
         //navigate to main
        MainUI bg = new MainUI();
        bg.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        bg.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
        this.dispose();
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(CompareMonthIncome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompareMonthIncome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompareMonthIncome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompareMonthIncome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompareMonthIncome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlReport5;
    // End of variables declaration//GEN-END:variables

    private double jantot;
    private double febtot;
    private double martot;
    private double aprtot;
    private double maytot;
    private double juntot;
    private double jultot;
    private double augtot;
    private double septot;
    private double octtot;
    private double novtot;
    private double dectot;
    
    private double jantota;
    private double febtota;
    private double martota;
    private double aprtota;
    private double maytota;
    private double juntota;
    private double jultota;
    private double augtota;
    private double septota;
    private double octtota;
    private double novtota;
    private double dectota;

    public static double jantotb;



}
