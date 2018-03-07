/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotechgomeztorugnosemestreianno2018.gui;

import bibliotechgomeztorugnosemestreianno2018.Asset;
import bibliotechgomeztorugnosemestreianno2018.Audiovisual;
import bibliotechgomeztorugnosemestreianno2018.Book;
import bibliotechgomeztorugnosemestreianno2018.Library;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jtoru1
 */
public class doReturn extends javax.swing.JFrame {

    /**
     * Creates new form doReturn
     */
    public doReturn() {
        initComponents();
        Date date1 = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("MM-dd-yyyy");
        String n = format1.format(date1);
        jTextField1.setText(n);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Actual Date");

        jButton1.setText("Do Return");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(88, 88, 88)
                        .addComponent(jButton2))
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //do Return part
        logIn allObject = null;
        try {
            allObject = new logIn();
        } catch (IOException ex) {
            Logger.getLogger(doLent.class.getName()).log(Level.SEVERE, null, ex);
        }
        Library lb = allObject.biblioTech;
        ArrayList<Asset> myList = new ArrayList();
        try {
            myList = lb.getAssetList();
        } catch (IOException ex) {
            Logger.getLogger(doLent.class.getName()).log(Level.SEVERE, null, ex);
        }
        lending n = null;
        try {
            n = new lending();
        } catch (IOException ex) {
            Logger.getLogger(doLent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //compare values
        int selection = n.idn;
        String type1 = n.type;
        
        for(Asset temp: myList){
            if(temp instanceof Book && temp.getID() == selection && "lent".equals(temp.getState())){
                Book myBook = (Book) temp;
                String date1= temp.getReturnDate();
                if(date1.compareTo(jTextField1.getText())<=0){
                    JOptionPane.showMessageDialog(null,"Penalty");
                
                }
                myBook.setFK_student("-1");
                myBook.setState("free");
                myBook.setLentDate("*");
                myBook.setReturnDate("*");
                lb.updateAsset(myBook);
            }
            if(temp instanceof Audiovisual && temp.getID() == selection &&"lent".equals(temp.getState()) ){
                
                Audiovisual myAv = (Audiovisual) temp;
                String date1= temp.getReturnDate();
                if(date1.compareTo(jTextField1.getText())<=0){
                    JOptionPane.showMessageDialog(null,"Penalty");
                
                }
                myAv.setFK_student("-1");
                myAv.setState("free");
                myAv.setLentDate("*");
                myAv.setReturnDate("*");
                lb.updateAsset(myAv);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
