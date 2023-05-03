/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lan.zold.szinthumgui;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author diak
 */
public class MainFrame extends javax.swing.JFrame {
    ArrayList<Employee> employeeList;
    //számláló
    int actEmp = 0;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        this.employeeList = new ArrayList<>();
        initComponents();
        this.readContent();
        Employee emp = employeeList.get(0);
        this.loadEmployee(emp);
    }
    
    public void readContent(){
        try {
            tryReadContent();
        } catch (FileNotFoundException e) {
            System.err.println("Hiba! A file nem található");
        }
    }
    
    public void tryReadContent()throws FileNotFoundException{
        File file = new File("szinthum_dolgozok.csv");
        Scanner scanner = new Scanner(file,"utf-8");
        //ELSŐSOR mezőnév
        String firstLine = scanner.nextLine();
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            String[] lineArray = line.split(",");
            Employee emp = new Employee(
                Integer.parseInt(lineArray[0]),
                lineArray[1],
                lineArray[2],
                Double.parseDouble(lineArray[3]),
                LocalDate.parse(lineArray[4])
                );
            //hozzáadjuk a listához    
            this.employeeList.add(emp);
        }
    }
    
    private void loadEmployee(Employee emp){
        idField.setText(emp.id.toString());
        nameField.setText(emp.name);
        cityField.setText(emp.city);
        salaryField.setText(emp.salary.toString());
        birthdateField.setText(emp.birthdate.toString());
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
        jLabel1 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cityField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        salaryField = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        birthdateField = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        previousButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setText("id");
        jPanel1.add(jLabel1);

        idField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFieldActionPerformed(evt);
            }
        });
        jPanel1.add(idField);

        getContentPane().add(jPanel1);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jLabel2.setText("Név");
        jPanel2.add(jLabel2);
        jPanel2.add(nameField);

        getContentPane().add(jPanel2);

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jLabel3.setText("Település");
        jPanel3.add(jLabel3);
        jPanel3.add(cityField);

        getContentPane().add(jPanel3);

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jLabel4.setText("Fizetés");
        jPanel4.add(jLabel4);
        jPanel4.add(salaryField);

        getContentPane().add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        jLabel5.setText("Születés");
        jPanel5.add(jLabel5);
        jPanel5.add(birthdateField);

        getContentPane().add(jPanel5);

        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        previousButton.setText("<");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });
        jPanel6.add(previousButton);

        nextButton.setText(">");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        jPanel6.add(nextButton);

        aboutButton.setText("Névjegy");
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });
        jPanel6.add(aboutButton);

        saveButton.setText("Rögzit");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel6.add(saveButton);

        getContentPane().add(jPanel6);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFieldActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        startNext();
    }//GEN-LAST:event_nextButtonActionPerformed

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        startPrevious();
    }//GEN-LAST:event_previousButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        startSave();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        startAbout();
    }//GEN-LAST:event_aboutButtonActionPerformed

    
    private void startAbout(){
        JOptionPane.showMessageDialog(this, "Baráth Dávid");
    }
    private void startSave(){
        try{
            tryStartSave();
        }
        catch(SQLException e){
            System.err.println("Hiba! A beszúrás sikertelen");
            System.err.println(e.getMessage());
            
        }
    }
    private void tryStartSave() throws SQLException {
        Connection con = null;
        String url = "jdbc:mariadb://localhost:3306/szinthum";
        con= DriverManager.getConnection(url, "szinthum","titok");
        
        Employee emp = new Employee(
                nameField.getText(),
                cityField.getText(),
                Double.parseDouble(salaryField.getText()),
                LocalDate.parse(birthdateField.getText())
        );
        
            String sql = "insert into employees" +
                   "(name,city,salary,birthdate) values "+
                    "(?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,emp.name);
            pstmt.setString(2,emp.city);
            pstmt.setDouble(3,emp.salary);
            pstmt.setDate(4,java.sql.Date.valueOf(emp.birthdate));
            //futtatás
            pstmt.execute();
       
        System.out.println("beszúrás vége");
    }
    
    private void startNext(){
        if(this.actEmp < this.employeeList.size()-1){
             this.actEmp++;
            Employee emp = this.employeeList.get(this.actEmp);
            this.loadEmployee(emp);
        }
    }
    
    private void startPrevious(){
        if(this.actEmp > 0){
            this.actEmp--;
            Employee emp = this.employeeList.get(this.actEmp);
            this.loadEmployee(emp);
        }
    }
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutButton;
    private javax.swing.JTextField birthdateField;
    private javax.swing.JTextField cityField;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previousButton;
    private javax.swing.JTextField salaryField;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
