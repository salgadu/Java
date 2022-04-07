/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.janelas;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author salgadoPC
 */
public class Extrato extends javax.swing.JFrame {

    /**
     * Creates new form Extrato
     */
    public Extrato(ArrayList<String> extrato) {
        initComponents();
        DefaultListModel teste = new DefaultListModel();
        for (int i = 0; i < extrato.size(); i++) {
            teste.addElement(extrato.get(i));
        }
        ExtratoLST.setModel(teste);
       //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TituloLB = new javax.swing.JLabel();
        Voltar = new javax.swing.JButton();
        ExtratoSP = new javax.swing.JScrollPane();
        ExtratoLST = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TituloLB.setText("Extrato");

        Voltar.setText("Voltar");
        Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarActionPerformed(evt);
            }
        });

        ExtratoLST.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ExtratoSP.setViewportView(ExtratoLST);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(Voltar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(TituloLB))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(ExtratoSP, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TituloLB)
                .addGap(18, 18, 18)
                .addComponent(ExtratoSP, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(Voltar)
                .addGap(45, 45, 45))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
        JOptionPane.showMessageDialog(null, "Confirme para Sair");
        dispose();
        Operacoes aux = new Operacoes();
        aux.setVisible(true);
    }//GEN-LAST:event_VoltarActionPerformed

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
            java.util.logging.Logger.getLogger(Extrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Extrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Extrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Extrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //            new Extrato().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ExtratoLST;
    private javax.swing.JScrollPane ExtratoSP;
    private javax.swing.JLabel TituloLB;
    private javax.swing.JButton Voltar;
    // End of variables declaration//GEN-END:variables
}