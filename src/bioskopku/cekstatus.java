package bioskopku;

/**
 *
 * @author Michel
 */
import javax.swing.*;
import java.sql.SQLException;
public class cekstatus extends javax.swing.JFrame {
    /**
     * Creates new form pilihan
     */
    //deklarasi kelas
    public cekstatus() {
        initComponents();
        new dbconnector();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                         
    private void initComponents() {
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        kursinomor = new javax.swing.JLabel();
        jfilm = new javax.swing.JComboBox();
        jstudio = new javax.swing.JComboBox();
        jkodekursi = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Check Seats");
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("NAMA FILM");
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("STUDIO");
        kursinomor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        kursinomor.setText("KURSI NOMOR");
        jfilm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ALADIN", "MINIONS", "JOHN WICK 3" }));
        jstudio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "STUDIO 1", "STUDIO 2", "STUDIO 3" }));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("OK");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setText("BACK");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kursinomor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(140, 140, 140)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jstudio, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jkodekursi)
                            .addComponent(jfilm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(208, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jfilm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jstudio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kursinomor)
                    .addComponent(jkodekursi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(97, 97, 97))
        );
        pack();
    }// </editor-fold>                       
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
new pilihan(1).setVisible(true);
dispose();
    }                                       
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        int studio;
        String kodekursi, sql1, sql2;
        switch (jstudio.getSelectedItem().toString()) { //BELUM SELESAI
            case "Studio 1" -> {
        studio = 1;
            } 
            case "Studio 2" -> {
        studio = 2;
            } 
            case "Studio 3" -> {
        studio = 3;
            } 
            default -> throw new AssertionError();
        }
        kodekursi = jkodekursi.getText();
        sql1 = "INSERT INTO `inputan`(`studioId`, `kodekursi`) VALUES ('"+studio+"', '"+kodekursi+"') WHERE NOT EXISTS (SELECT 1 FROM `inputan` WHERE `studioId`='"+studio+"' AND `kodekursi`='"+kodekursi+"')";
       
        try {
            dbconnector.statement = dbconnector.connection.createStatement();
            dbconnector.statement.execute(sql1);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog (null, "The seat is booked or not valid");
        return;
        }
        JOptionPane.showMessageDialog (null, "Empty seat");
        sql2 = "delete from inputan where kodekursi='"+kodekursi+"'";
       
        try
        {
        dbconnector.statement = dbconnector.connection.createStatement();
        dbconnector.statement.execute (sql2);
        }
        catch (Exception e){
            System.out.println(e);
        }

    }                                    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify                    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox jfilm;
    private javax.swing.JTextField jkodekursi;
    private javax.swing.JComboBox jstudio;
    private javax.swing.JLabel kursinomor;
    // End of variables declaration       
}