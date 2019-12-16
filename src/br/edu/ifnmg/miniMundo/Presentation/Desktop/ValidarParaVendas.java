/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.Presentation.Desktop;

import br.edu.ifnmg.miniMundo.DomainModel.ErroValidacaoException;
import br.edu.ifnmg.miniMundo.DomainModel.Fornecedor;
import br.edu.ifnmg.miniMundo.DomainModel.Funcionario;
import br.edu.ifnmg.miniMundo.Persistence.FornecedorRepositorio;
import br.edu.ifnmg.miniMundo.Persistence.FuncionarioRepositorio;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Edlâine
 */
public class ValidarParaVendas extends javax.swing.JInternalFrame {

    /**
     * Creates new form ValidarParaVendas
     */
    Funcionario funcionario;
    FornecedorRepositorio repo_fornec;
    FuncionarioRepositorio repo_func;
    Fornecedor fornec;
    
    public ValidarParaVendas() {
        fornec = new Fornecedor();
        funcionario = new Funcionario();
        repo_fornec = new FornecedorRepositorio();
        repo_func = new FuncionarioRepositorio();
        
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

        lblFuncionario = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        btnContinuar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Mini Mundo Supermecados -Validação de Funcionários");

        lblFuncionario.setText("User Funcionário:");

        btnContinuar.setText("CONTINUAR");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");

        jLabel1.setText("Para prosseguir, preencha os dados a seguir:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btnContinuar)
                        .addGap(60, 60, 60)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lblFuncionario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuncionario)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnContinuar)
                    .addComponent(btnCancelar))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        // TODO add your handling code here:
        VenderProduto tela = new VenderProduto();
        funcionario = new Funcionario();

        if(!this.txtUser.getText().isEmpty())
        try {
            funcionario.setUser(txtUser.getText());
            funcionario = repo_func.ValidarUser(funcionario);
            if(funcionario != null){
                MenuGerenciamento.Desktop.add(tela);
                tela.setVisible(true);
                //tela.setVisible(true);
                this.setVisible(false);
            }
            else
                JOptionPane.showMessageDialog(null, "Usuário Inválido!");
        } catch (ErroValidacaoException ex) {
            Logger.getLogger(ValidarParaVendas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnContinuarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblFuncionario;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}