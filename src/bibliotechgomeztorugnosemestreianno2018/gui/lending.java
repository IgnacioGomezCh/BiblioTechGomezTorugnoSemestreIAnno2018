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
import bibliotechgomeztorugnosemestreianno2018.Student;
import com.sun.glass.events.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Jtoru1
 */
public class lending extends javax.swing.JFrame {
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model1 = new DefaultTableModel();
    DefaultTableModel model11 = new DefaultTableModel();
    DefaultTableModel model12 = new DefaultTableModel();
    DefaultTableModel model13 = new DefaultTableModel();
    private int selection;
    /**
     * Creates new form lending
     */
    Library myLib;
    public lending() throws IOException {
        
        
        initComponents();
        
        //Add columns to the model
        model.addColumn("ID");
        model.addColumn("Title");
        model.addColumn("Edition");
        model.addColumn("ISBN");
        this.jTable1.setModel( model);
        
        model12.addColumn("ID");
        model12.addColumn("Title");
        model12.addColumn("Edition");
        model12.addColumn("ISBN");
        
        model13.addColumn("ID");
        model13.addColumn("Title");
        model13.addColumn("Edition");
        model13.addColumn("ISBN");
        
        model1.addColumn("Code");
        model1.addColumn("Model");
        this.jTable2.setModel(model1);
        
        model11.addColumn("Code");
        model11.addColumn("Model");
        
        
        logIn allObject = new logIn();
        Library lb = allObject.biblioTech;
        ArrayList<Asset> array = lb.getAssetList();
        
        Iterator <Asset> it =array.iterator();
        while(it.hasNext()){
            Asset e = it.next();
            if(e instanceof Book){
                String [] add = new String[4];
                add[0]=String.valueOf(e.getID());
                add[1]=((Book) e).getTitle();
                add[2]= ((Book) e).getEdition();
                add[3]=((Book) e).getISBN();
            
                model.addRow(add);
            }
            if(e instanceof Audiovisual){
                String [] add1 = new String[2];
                add1[0]=String.valueOf(((Audiovisual) e).getCode());
                add1[1]=((Audiovisual) e).getModel();
                model1.addRow(add1);
            
            }
            
        }
        jTable1.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent e){
                int row = jTable1.rowAtPoint(e.getPoint());
                int column = jTable1.columnAtPoint(e.getPoint());
                if((row>-1)&&(column>-1)){
                    TableModel model123 = jTable1.getModel();
                    selection = Integer.valueOf(String.valueOf(model123.getValueAt(row, column)));
                    JOptionPane.showMessageDialog(null,model123.getValueAt(row, column));
                }
            }


        });
        
        /*
        ArrayList<Asset> myList = new ArrayList();
        myList = lb.getAssetList();
        for(Asset temp: myList){
            if(temp instanceof Book && temp.getID() == selection){
                Book myBook = (Book) temp;
                myBook.setState("lent");
                myBook.setLentDate("FECHA");
                myBook.setReturnDate("FECHA");
                lb.updateAsset(myBook);
            }
        }
        */
        test();
        
    }
    
    public void test() throws IOException{
        logIn allObject = new logIn();
        Library lb = allObject.biblioTech;
        ArrayList<Asset> myList = new ArrayList();
        myList = lb.getAssetList();
        for(Asset temp: myList){
            if(temp instanceof Book && temp.getID() == 1){
                Book myBook = (Book) temp;
                myBook.setFK_student("c12345");
                myBook.setState("lent");
                myBook.setLentDate("FECHA");
                myBook.setReturnDate("FECHA");
                lb.updateAsset(myBook);
            }
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ISBN");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Title");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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

        jButton4.setText("LogOut");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 265, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Book", jPanel1);

        jLabel3.setText("Code");

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable2);

        jButton5.setText("LogOut");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(23, 23, 23))
        );

        jTabbedPane1.addTab("AudioVisual", jPanel2);

        jList3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Return", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        // TODO add your handling code here:
        //Only puts Numbers in the Text Field
        char vchar = evt.getKeyChar();
        if(!(Character.isDigit(vchar))
            ||(vchar == KeyEvent.VK_BACKSPACE)
            || (vchar == KeyEvent.VK_DELETE)){
        evt.consume();
    }
        //Only 5 number code
        if(jTextField3.getText().length()>=5){
            evt.consume();
        }
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        logIn window1 = null;
        try {
            window1 = new logIn();
        } catch (IOException ex) {
            Logger.getLogger(lending.class.getName()).log(Level.SEVERE, null, ex);
        }
        window1.setTitle("logIn");
        window1.setLocationRelativeTo(null);
        window1.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        logIn window1 = null;
        try {
            window1 = new logIn();
        } catch (IOException ex) {
            Logger.getLogger(lending.class.getName()).log(Level.SEVERE, null, ex);
        }
        window1.setTitle("logIn");
        window1.setLocationRelativeTo(null);
        window1.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {                                         
            // TODO add your handling code here:
            model11.setRowCount(0);
            this.jTable2.setModel(model11);
            logIn allObject = null;
            try {
                allObject = new logIn();
            } catch (IOException ex) {
                Logger.getLogger(lending.class.getName()).log(Level.SEVERE, null, ex);
            }
            Library lb = allObject.biblioTech;
            ArrayList<Asset> array = lb.getAssetList();
            
            Iterator <Asset> it =array.iterator();
            while(it.hasNext()){
                Asset e = it.next();
                if(e instanceof Audiovisual){
                    if(String.valueOf(((Audiovisual) e).getCode()) == null ? jTextField3.getText() == null : String.valueOf(((Audiovisual) e).getCode()).equals(jTextField3.getText())){
                        String [] add1 = new String[2];
                        add1[0]=String.valueOf(((Audiovisual) e).getCode());
                        add1[1]=((Audiovisual) e).getModel();
                        model11.addRow(add1);
                    }
                    
                }
                
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(lending.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {                                         
            // TODO add your handling code here:
            model12.setRowCount(0);
            this.jTable1.setModel(model12);
            
            logIn allObject = null;
            try {
                allObject = new logIn();
            } catch (IOException ex) {
                Logger.getLogger(lending.class.getName()).log(Level.SEVERE, null, ex);
            }
            Library lb = allObject.biblioTech;
            ArrayList<Asset> array = lb.getAssetList();
            
            Iterator <Asset> it =array.iterator();
            while(it.hasNext()){
                Asset e = it.next();
                if(e instanceof Book){
                    if(((Book) e).getISBN() == null ? jTextField1.getText() == null : ((Book) e).getISBN().equals(jTextField1.getText())){
                        String [] add = new String[4];
                        add[0]=String.valueOf(e.getID());
                        add[1]=((Book) e).getTitle();
                        add[2]= ((Book) e).getEdition();
                        add[3]=((Book) e).getISBN();
                        
                        model12.addRow(add);
                    }
                }
                
            }
        } catch (IOException ex) {
            Logger.getLogger(lending.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
        //Only puts Numbers in the Text Field
        char vchar = evt.getKeyChar();
        if(!(Character.isAlphabetic(vchar))
            ||(vchar == KeyEvent.VK_BACKSPACE)
            || (vchar == KeyEvent.VK_DELETE)){
        evt.consume();
    }
        //Only 1  code
        if(jTextField2.getText().length()>=1){
            evt.consume();
        }
        
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {                                         
            // TODO add your handling code here:
            model13.setRowCount(0);
            this.jTable1.setModel(model13);
            logIn allObject = null;
            try {
                allObject = new logIn();
            } catch (IOException ex) {
                Logger.getLogger(lending.class.getName()).log(Level.SEVERE, null, ex);
            }
            Library lb = allObject.biblioTech;
            ArrayList<Asset> array = lb.getAssetList();
            
            Iterator <Asset> it =array.iterator();
            while(it.hasNext()){
                Asset e = it.next();
                if(e instanceof Book){
                    //Convert to uper or lower case
                    String char1 = (jTextField2.getText()).toUpperCase();
                    String char2 = (jTextField2.getText()).toLowerCase();
                    String firstChar= String.valueOf(((Book) e).getTitle().charAt(0));
                    if((char1 == null ? firstChar == null : char1.equals(firstChar)) || char2==firstChar){
                        String [] add = new String[4];
                        add[0]=String.valueOf(e.getID());
                        add[1]=((Book) e).getTitle();
                        add[2]= ((Book) e).getEdition();
                        add[3]=((Book) e).getISBN();
                        
                        model13.addRow(add);
                    }
                }
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(lending.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
