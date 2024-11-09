/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Receipt extends javax.swing.JFrame {
    
    public Receipt(Customer cc, Payment pymnt,Selection select){
        initComponents();
        
        Name.setText(cc.getName());
        
        String a = select.getProductID();
        int b = select.getQuantity();
        double c = select.getTotalPrice();
        double d = pymnt.getTotalMoney();
        String e = pymnt.getPymntType();
        
        Dispense dp = new Dispense(a,b,c,d,e);
        
        String f = String.valueOf(dp.generateReceiptID(8));
        String g = String.valueOf(dp.getProductName());
        String h = String.valueOf(b);
        String i = String.valueOf(new DecimalFormat("0.00").format(dp.calcChange()));
        String j = dp.messageChange();
        
        //Database
        //database insert selection
        try{
        Connection VMConn;
        Statement VMState;
        ResultSet VMSet;
        
        String address = "jdbc:mysql://localhost:3306/vm";
        String user = "root";
        String pass = "";
        
        VMConn = DriverManager.getConnection(address, user, pass);
        VMState = VMConn.createStatement();
        
        
        VMState.executeUpdate("INSERT INTO selectionDetails (ID, Name, Guantity Price(RM)) VALUES ('"+f+"', '"+g+"', '"+h+"','"+c+"')");
        JOptionPane.showMessageDialog(null, "Payment Success!!!");
        
        } catch (Exception x){
            JOptionPane.showMessageDialog(null, "Failed");
            MainPage mp = new MainPage();
            mp.setVisible(true);
            dispose();
        }
        
        //Display
        //Receipt
        Receipt.setText(f);
        //Product Name
        txtProductName.setText(g);
        //Quantity
        txtSelectQty.setText(h);
        //Change
        txtChange.setText(i);
        //Message
        txtMessage.setText(dp.messageChange());
        
    }
    
    private Receipt(){
        initComponents();
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlReceipt = new javax.swing.JPanel();
        iconSucces = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        pnlItem = new javax.swing.JPanel();
        lblItem = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        getQuantity = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        txtSelectQty = new javax.swing.JTextField();
        pnlDispense = new javax.swing.JPanel();
        lblChange = new javax.swing.JLabel();
        lblQty = new javax.swing.JLabel();
        txtChange = new javax.swing.JTextField();
        txtMessage = new javax.swing.JTextField();
        lblMessage = new javax.swing.JLabel();
        Receipt = new javax.swing.JLabel();
        lblTitle1 = new javax.swing.JLabel();
        pnlTop = new javax.swing.JPanel();
        lblIcon = new javax.swing.JLabel();
        txtTitle = new javax.swing.JLabel();
        lblTiitle = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlReceipt.setBackground(new java.awt.Color(255, 255, 255));

        iconSucces.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Success.png"))); // NOI18N

        lblTitle.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblTitle.setText("Purchase Succesfully!");

        btnNext.setBackground(new java.awt.Color(238, 197, 109));
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        pnlItem.setBackground(new java.awt.Color(242, 242, 242));
        pnlItem.setBorder(null);

        lblItem.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lblItem.setText("Your Item");

        lblName.setText("Product Name : ");

        getQuantity.setText("Quantity             :");

        txtProductName.setEditable(false);

        txtSelectQty.setEditable(false);

        javax.swing.GroupLayout pnlItemLayout = new javax.swing.GroupLayout(pnlItem);
        pnlItem.setLayout(pnlItemLayout);
        pnlItemLayout.setHorizontalGroup(
            pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblItem)
                    .addGroup(pnlItemLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlItemLayout.createSequentialGroup()
                                .addComponent(lblName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtProductName))
                            .addGroup(pnlItemLayout.createSequentialGroup()
                                .addComponent(getQuantity)
                                .addGap(11, 11, 11)
                                .addComponent(txtSelectQty, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        pnlItemLayout.setVerticalGroup(
            pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlItemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(getQuantity)
                    .addComponent(txtSelectQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDispense.setBackground(new java.awt.Color(239, 239, 239));
        pnlDispense.setBorder(null);

        lblChange.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lblChange.setText("Your Change");

        lblQty.setText("Change : RM");

        txtChange.setEditable(false);

        txtMessage.setEditable(false);
        txtMessage.setForeground(new java.awt.Color(0, 102, 204));

        lblMessage.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lblMessage.setText("Message");

        javax.swing.GroupLayout pnlDispenseLayout = new javax.swing.GroupLayout(pnlDispense);
        pnlDispense.setLayout(pnlDispenseLayout);
        pnlDispenseLayout.setHorizontalGroup(
            pnlDispenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDispenseLayout.createSequentialGroup()
                .addGroup(pnlDispenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDispenseLayout.createSequentialGroup()
                        .addGroup(pnlDispenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDispenseLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblChange))
                            .addGroup(pnlDispenseLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(lblQty)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtChange, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 165, Short.MAX_VALUE))
                    .addGroup(pnlDispenseLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtMessage)))
                .addContainerGap())
            .addGroup(pnlDispenseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMessage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDispenseLayout.setVerticalGroup(
            pnlDispenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDispenseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblChange)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDispenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQty)
                    .addComponent(txtChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(lblMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        Receipt.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        Receipt.setForeground(new java.awt.Color(0, 153, 0));
        Receipt.setText("A0A0A0A0");

        lblTitle1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblTitle1.setText("Order #");

        pnlTop.setBackground(new java.awt.Color(238, 197, 109));
        pnlTop.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/smallLogo.png"))); // NOI18N

        txtTitle.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTitle.setText("Vending ");

        lblTiitle.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lblTiitle.setText("Machine");

        Name.setBackground(new java.awt.Color(255, 255, 255));
        Name.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        Name.setText("XXXXXXX");

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setText("Welcome,");

        javax.swing.GroupLayout pnlTopLayout = new javax.swing.GroupLayout(pnlTop);
        pnlTop.setLayout(pnlTopLayout);
        pnlTopLayout.setHorizontalGroup(
            pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTitle)
                    .addComponent(lblTiitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Name)
                .addGap(18, 18, 18))
        );
        pnlTopLayout.setVerticalGroup(
            pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopLayout.createSequentialGroup()
                .addGroup(pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTopLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblIcon))
                    .addGroup(pnlTopLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(txtTitle)
                        .addGap(0, 0, 0)
                        .addComponent(lblTiitle)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Name))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout pnlReceiptLayout = new javax.swing.GroupLayout(pnlReceipt);
        pnlReceipt.setLayout(pnlReceiptLayout);
        pnlReceiptLayout.setHorizontalGroup(
            pnlReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReceiptLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(pnlItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(pnlDispense, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26))
            .addGroup(pnlReceiptLayout.createSequentialGroup()
                .addGroup(pnlReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlReceiptLayout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(iconSucces))
                    .addGroup(pnlReceiptLayout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(btnNext))
                    .addGroup(pnlReceiptLayout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(lblTitle1)
                        .addGap(0, 0, 0)
                        .addComponent(Receipt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTitle)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pnlTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlReceiptLayout.setVerticalGroup(
            pnlReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReceiptLayout.createSequentialGroup()
                .addComponent(pnlTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(iconSucces)
                .addGap(12, 12, 12)
                .addGroup(pnlReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(Receipt)
                    .addComponent(lblTitle1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDispense, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlReceipt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlReceipt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        ThankYou ty =  new ThankYou();
        ty.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnNextActionPerformed

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
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Receipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Name;
    private javax.swing.JLabel Receipt;
    private javax.swing.JButton btnNext;
    private javax.swing.JLabel getQuantity;
    private javax.swing.JLabel iconSucces;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblChange;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblItem;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblQty;
    private javax.swing.JLabel lblTiitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JPanel pnlDispense;
    private javax.swing.JPanel pnlItem;
    private javax.swing.JPanel pnlReceipt;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JTextField txtChange;
    private javax.swing.JTextField txtMessage;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtSelectQty;
    private javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables

}
