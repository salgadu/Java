/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.janelas;

import banco.codigos.Conta;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author salgadoPC
 */
public class Depositar extends javax.swing.JFrame {

    /**
     * Creates new form Depositar
     */
    public Depositar() {
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

        TituloLB = new javax.swing.JLabel();
        ValorLB = new javax.swing.JLabel();
        TituloLB_B = new javax.swing.JLabel();
        DepositoTX = new javax.swing.JTextField();
        ConfirmarBT = new javax.swing.JButton();
        CancelarBT = new javax.swing.JButton();
        ContaLB = new javax.swing.JLabel();
        ContaTX = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TituloLB.setText("Depositar");

        ValorLB.setText("Valor R$");

        TituloLB_B.setText("Entre com o Valor do Deposito");

        DepositoTX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepositoTXActionPerformed(evt);
            }
        });

        ConfirmarBT.setText("Confirmar");
        ConfirmarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarBTActionPerformed(evt);
            }
        });

        CancelarBT.setText("Cancelar Opera????o");
        CancelarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarBTActionPerformed(evt);
            }
        });

        ContaLB.setText("Conta do Favorecido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(TituloLB)
                .addGap(0, 198, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(TituloLB_B))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CancelarBT)
                                .addGap(90, 90, 90)
                                .addComponent(ConfirmarBT))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ValorLB)
                                    .addComponent(ContaLB))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ContaTX, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DepositoTX, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(TituloLB)
                .addGap(18, 18, 18)
                .addComponent(TituloLB_B)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ContaLB)
                    .addComponent(ContaTX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ValorLB)
                    .addComponent(DepositoTX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConfirmarBT)
                    .addComponent(CancelarBT))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DepositoTXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepositoTXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DepositoTXActionPerformed

    private void CancelarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarBTActionPerformed
        JOptionPane.showMessageDialog(null, "Opera????o Cancelada");
        dispose();
        Operacoes run = new Operacoes();
        run.setVisible(true);
    }//GEN-LAST:event_CancelarBTActionPerformed

    private void ConfirmarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarBTActionPerformed
        int conta = Integer.parseInt(ContaTX.getText());
        double deposito = Double.parseDouble(DepositoTX.getText());

        Conta teste = new Conta();
        try {
            String mensagem = teste.depositar(conta, deposito, true).get(0);
            JOptionPane.showMessageDialog(null, mensagem);
            dispose();
            Operacoes run = new Operacoes();
            run.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Depositar.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_ConfirmarBTActionPerformed

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
            java.util.logging.Logger.getLogger(Depositar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Depositar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Depositar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Depositar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Depositar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelarBT;
    private javax.swing.JButton ConfirmarBT;
    private javax.swing.JLabel ContaLB;
    private javax.swing.JTextField ContaTX;
    private javax.swing.JTextField DepositoTX;
    private javax.swing.JLabel TituloLB;
    private javax.swing.JLabel TituloLB_B;
    private javax.swing.JLabel ValorLB;
    // End of variables declaration//GEN-END:variables
}
