/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.janelas;

import banco.codigos.Conta;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author salgadoPC
 */
public class TesteA extends javax.swing.JFrame {

    int aux = 0;
    double valor = 0;

    /**
     * Creates new form TesteA
     */
    public TesteA(ArrayList<String> transferencia, int numero, double valor) {
        initComponents();
        FavorecidoLB.setText("Destinatário : " + transferencia.get(0));
        ContaLB.setText("Número da conta : " + transferencia.get(1));
        this.aux = Integer.parseInt(transferencia.get(1));
        this.valor = valor;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ConfirmarBT = new javax.swing.JButton();
        DadosBT = new javax.swing.JButton();
        FavorecidoLB = new javax.swing.JLabel();
        ContaLB = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ConfirmarBT.setText("Confirmar");
        ConfirmarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarBTActionPerformed(evt);
            }
        });

        DadosBT.setText("Corrigir Dados");
        DadosBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DadosBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ContaLB, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FavorecidoLB, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DadosBT)
                        .addGap(31, 31, 31)
                        .addComponent(ConfirmarBT)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(FavorecidoLB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ContaLB, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DadosBT)
                    .addComponent(ConfirmarBT))
                .addGap(51, 51, 51))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ConfirmarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarBTActionPerformed
        Conta conta = new Conta();
        try {
            String mensagem = conta.transferir(aux, valor, true).get(0);
            JOptionPane.showMessageDialog(null, mensagem);
        } catch (IOException ex) {
            Logger.getLogger(TesteA.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
        Operacoes run = new Operacoes();
        run.setVisible(true);
    }//GEN-LAST:event_ConfirmarBTActionPerformed

    private void DadosBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DadosBTActionPerformed
        dispose();
        Transferir run = new Transferir();
        run.setVisible(true);
    }//GEN-LAST:event_DadosBTActionPerformed

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
            java.util.logging.Logger.getLogger(TesteA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TesteA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TesteA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TesteA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new TesteA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConfirmarBT;
    private javax.swing.JLabel ContaLB;
    private javax.swing.JButton DadosBT;
    private javax.swing.JLabel FavorecidoLB;
    // End of variables declaration//GEN-END:variables
}
