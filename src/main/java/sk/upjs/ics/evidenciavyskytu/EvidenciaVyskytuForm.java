/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.evidenciavyskytu;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import sun.reflect.annotation.AnnotationParser;

/**
 *
 * @author student
 */
public class EvidenciaVyskytuForm extends javax.swing.JFrame {
    
//    private VyskytDao vyskytDao = new SuborovyVyskytDao();
    private VyskytListModel vyskytListModel;
    private AkciaVyskytuComboBoxModel akciaVyskytuComboBoxModel;

    /**
     * Creates new form EvidenciaVyskytuForm
     */
    public EvidenciaVyskytuForm() {
        vyskytListModel = new VyskytListModel();
        akciaVyskytuComboBoxModel = new AkciaVyskytuComboBoxModel();
        initComponents();
//        zobrazVyskyty();
    }
    
//    private void zobrazVyskyty() {
//         List<Vyskyt> vyskyty = vyskytDao.dajVyskyty();
//        
//        String[] poleVyskytov = new String[vyskyty.size()];
//        for (int i=0; i<vyskyty.size(); i++) {
//            poleVyskytov[i] = vyskyty.get(i).toString();
//        }
//                
////        vyskytyList.setListData(poleVyskytov);
//        vyskytyList.setModel(vyskytListModel);
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        vyskytyList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        menoTextField = new javax.swing.JTextField();
        pridatButton = new javax.swing.JButton();
        akcieVyskytuComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        vyskytyList.setModel(vyskytListModel);
        jScrollPane1.setViewportView(vyskytyList);

        jLabel1.setText("Akcia:");

        jLabel2.setText("Meno:");

        pridatButton.setText("Pridať");
        pridatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridatButtonActionPerformed(evt);
            }
        });

        akcieVyskytuComboBox.setModel(akciaVyskytuComboBoxModel);
        akcieVyskytuComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                akcieVyskytuComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(menoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pridatButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(akcieVyskytuComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(akcieVyskytuComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(menoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pridatButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pridatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridatButtonActionPerformed
        
        Vyskyt vyskyt = new Vyskyt();
//        String akcia = nazovAkcieTextField.getText();
        String akcia = (String) akcieVyskytuComboBox.getSelectedItem();
        String meno = menoTextField.getText();
        String[] split = meno.split(" ");
        meno = split[0];
        String priezvisko = "";
        for (int i = 1; i < split.length; i++) {
            priezvisko = priezvisko + " " + split[i];
        }
                
        vyskyt.setMeno(meno);
        vyskyt.setPriezvisko(priezvisko.trim());
        vyskyt.setAkcia(akcia);
        vyskyt.setKedy(LocalDateTime.now());
        
        vyskytListModel.pridajVyskyt(vyskyt);
//        vyskytDao.vlozVyskyt(vyskyt);
//        zobrazVyskyty();
    }//GEN-LAST:event_pridatButtonActionPerformed

    private void akcieVyskytuComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_akcieVyskytuComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_akcieVyskytuComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(EvidenciaVyskytuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EvidenciaVyskytuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EvidenciaVyskytuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EvidenciaVyskytuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EvidenciaVyskytuForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> akcieVyskytuComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField menoTextField;
    private javax.swing.JButton pridatButton;
    private javax.swing.JList<Vyskyt> vyskytyList;
    // End of variables declaration//GEN-END:variables
}
