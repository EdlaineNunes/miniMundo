/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.Presentation.Desktop;

import br.edu.ifnmg.miniMundo.DomainModel.ErroValidacaoException;
import br.edu.ifnmg.miniMundo.DomainModel.Funcionario;
import br.edu.ifnmg.miniMundo.Persistence.FuncionarioRepositorio;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Edlâine
 */
public class TelaLogin extends javax.swing.JFrame {

    /**
     * Creates new form TelaLogin
     */
    
    Funcionario funcionario = new Funcionario();
    FuncionarioRepositorio repo_func = new FuncionarioRepositorio();
    
    public TelaLogin() {
        funcionario = new Funcionario();
        repo_func = new FuncionarioRepositorio();
        initComponents();
    }
    
    public TelaLogin(Funcionario funcionario, FuncionarioRepositorio func_repo){
        this.funcionario = funcionario;
        this.repo_func = repo_func;
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
        java.awt.GridBagConstraints gridBagConstraints;

        lblMiniMundo2 = new javax.swing.JLabel();
        lblMiniMundo3 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JTextField();
        btnEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mini Mundo - LOGIN");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lblMiniMundo2.setFont(new java.awt.Font("Monotype Corsiva", 1, 24)); // NOI18N
        lblMiniMundo2.setText("Mini Mundo Supermecados");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 21;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 62, 0, 60);
        getContentPane().add(lblMiniMundo2, gridBagConstraints);

        lblMiniMundo3.setFont(new java.awt.Font("Monotype Corsiva", 1, 18)); // NOI18N
        lblMiniMundo3.setText("Login");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 164, 0, 0);
        getContentPane().add(lblMiniMundo3, gridBagConstraints);

        lblUser.setText("Usuário:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 165, 0, 0);
        getContentPane().add(lblUser, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 107;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 133, 0, 0);
        getContentPane().add(txtUser, gridBagConstraints);

        jLabel2.setText("Senha:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 172, 0, 0);
        getContentPane().add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 107;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 133, 0, 0);
        getContentPane().add(txtSenha, gridBagConstraints);

        btnEntrar.setText("ENTRAR");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 145, 28, 0);
        getContentPane().add(btnEntrar, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        // TODO add your handling code here:
        funcionario = new Funcionario();
        repo_func = new FuncionarioRepositorio();
        MenuGerenciamento menu = new MenuGerenciamento();
        
        if(!this.txtUser.getText().isEmpty() && this.txtSenha.getText().length() > 0){
            try {
                funcionario.setUser(txtUser.getText());
                funcionario.setSenha(String.valueOf(txtSenha.getText()));
                funcionario = repo_func.ValidarUsuario(funcionario);
                if(funcionario != null){
                    menu.setVisible(true);
                    this.setVisible(false);
                }
                else 
                  JOptionPane.showMessageDialog(null, "Usuário Inválido!");  
            } catch (ErroValidacaoException ex) {
                Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
            }               
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblMiniMundo2;
    private javax.swing.JLabel lblMiniMundo3;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}