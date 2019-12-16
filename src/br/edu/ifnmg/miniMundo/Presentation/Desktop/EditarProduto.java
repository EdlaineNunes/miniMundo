/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.Presentation.Desktop;

import br.edu.ifnmg.miniMundo.DomainModel.ErroValidacaoException;
import br.edu.ifnmg.miniMundo.DomainModel.Fornecedor;
import br.edu.ifnmg.miniMundo.DomainModel.Produto;
import br.edu.ifnmg.miniMundo.DomainModel.Status;
import br.edu.ifnmg.miniMundo.DomainModel.UnidadesCompra;
import br.edu.ifnmg.miniMundo.DomainModel.UnidadesVenda;
import br.edu.ifnmg.miniMundo.Persistence.FornecedorRepositorio;
import br.edu.ifnmg.miniMundo.Persistence.ProdutoRepositorio;
import static br.edu.ifnmg.miniMundo.Presentation.Desktop.MenuGerenciamento.Desktop;
import java.math.BigDecimal;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Edlâine
 */
public class EditarProduto extends javax.swing.JInternalFrame {

    /**
     * Creates new form EditarProduto
     */
    Produto produto;
    ProdutoRepositorio repo_produto;
    
    Fornecedor fornec;
    FornecedorRepositorio repo_fornec;
    
    public EditarProduto() {
        produto = new Produto();
        repo_produto = new ProdutoRepositorio();
   
        fornec = new Fornecedor();
        repo_fornec = new FornecedorRepositorio();
       
        initComponents();
        listaFornecedor();
    }

    public void listaFornecedor(){
        List<Fornecedor> fornecedores;
        fornecedores = repo_fornec.Buscar(null);
        ComboBoxModel<Fornecedor> model_fornec =
            new DefaultComboBoxModel<>(new Vector (fornecedores) );
        cbxlistFornec.setModel(model_fornec); 
    }
    public void setProduto(Fornecedor fornec){
        this.produto = produto;
        this.txtDescricao.setText(produto.getDescricao());
        this.txtPrecoCompra.setText(produto.getPrecoCompra().toString());
        this.txtPrecoVenda.setText(produto.getPrecoVenda().toString());
        this.txtUnidComprada.setText(String.valueOf( produto.getUnidComprada() ));
        this.cbxUnidCompra.setSelectedItem(produto.getUnidCompra().name());
        this.cbxUnidVenda.setSelectedItem(produto.getUnidVenda().name());
        this.cbxlistFornec.setSelectedItem(produto.getFornecedor());
        this.cbxStatus.setSelectedItem(produto.getStatus().name());      
     }
    
     public Produto getProduto() throws ErroValidacaoException{
        this.produto.setDescricao(txtDescricao.getText());
        this.produto.setPrecoCompra(new BigDecimal (txtPrecoCompra.getText()));
        this.produto.setPrecoVenda(new BigDecimal (txtPrecoVenda.getText()));
        this.produto.setUnidComprada(Integer.parseInt( txtUnidComprada.getText() ));
        this.produto.setUnidCompra(UnidadesCompra.valueOf(cbxUnidCompra.getSelectedItem().toString()));
        this.produto.setUnidVenda(UnidadesVenda.valueOf(cbxUnidVenda.getSelectedItem().toString()));
        this.produto.setFornecedor((Fornecedor)cbxlistFornec.getSelectedItem());
        this.produto.setStatus(Status.valueOf(cbxStatus.getSelectedItem().toString()));

        return this.produto;
     
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
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        lblInfo = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        lblFornecedor = new javax.swing.JLabel();
        lblUnidCompra = new javax.swing.JLabel();
        lblUnidVenda = new javax.swing.JLabel();
        lblPrecoCompra = new javax.swing.JLabel();
        lblPrecoVenda = new javax.swing.JLabel();
        lblUnidComprada = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        cbxUnidCompra = new javax.swing.JComboBox<>();
        cbxUnidVenda = new javax.swing.JComboBox<>();
        cbxStatus = new javax.swing.JComboBox<>();
        cbxlistFornec = new javax.swing.JComboBox<>();
        txtDescricao = new javax.swing.JTextField();
        txtUnidComprada = new javax.swing.JTextField();
        txtPrecoCompra = new javax.swing.JTextField();
        txtPrecoVenda = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Mini Mundo Supermecados - Editar Produto");

        lblId.setText("Insisra o Id do Produto:");

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        lblInfo.setText("Faça as alterações necessárias:");

        lblDescricao.setText("Descrição:");

        lblFornecedor.setText("Fornecedor:");

        lblUnidCompra.setText("Unid. de Compra:");

        lblUnidVenda.setText("Unid. de Venda:");

        lblPrecoCompra.setText("Preço de Compra: R$");

        lblPrecoVenda.setText("Preço de Venda: R$");

        lblUnidComprada.setText("Unidades em Estoque:");

        lblStatus.setText("Status:");

        cbxUnidCompra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unidade", "Caixa", "Fardo", "Outro" }));

        cbxUnidVenda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unidade", "Caixa ", "Fardo ", "Outro" }));

        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(163, 163, 163)
                                .addComponent(lblInfo)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDescricao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDescricao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblStatus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblFornecedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxlistFornec, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblUnidComprada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUnidComprada, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblUnidCompra)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxUnidCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblUnidVenda)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbxUnidVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblPrecoVenda)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPrecoVenda))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblPrecoCompra)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPrecoCompra)))))))
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnNovo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescricao)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatus)
                    .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFornecedor)
                    .addComponent(cbxlistFornec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUnidComprada)
                    .addComponent(txtUnidComprada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUnidCompra)
                    .addComponent(cbxUnidCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecoCompra)
                    .addComponent(txtPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUnidVenda)
                    .addComponent(cbxUnidVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecoVenda)
                    .addComponent(txtPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Especificação", jPanel1);

        jTabbedPane1.addTab("Editar Produto", jTabbedPane2);

        btnSalvar.setText("SALVAR ALTERAÇÕES");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addGap(67, 67, 67)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        produto =  new Produto();
        if(txtId.getText().length() > 0){
            produto.setId(Integer.parseInt( txtId.getText() ));
            try {
                produto = repo_produto.Abrir(produto.getId());
                if(produto != null){
                    // preenchimento automático
                    this.txtDescricao.setText(produto.getDescricao());
                    this.txtPrecoCompra.setText(produto.getPrecoCompra().toString());
                    this.txtPrecoVenda.setText(produto.getPrecoVenda().toString());
                    this.txtUnidComprada.setText(String.valueOf( produto.getUnidComprada() ));
                    this.cbxUnidCompra.setSelectedItem(produto.getUnidCompra().name());
                    this.cbxUnidVenda.setSelectedItem(produto.getUnidVenda().name());
                    this.cbxlistFornec.setSelectedItem(produto.getFornecedor());
                    this.cbxStatus.setSelectedItem(fornec.getStatus().name());

                } else
                JOptionPane.showMessageDialog(null, "Produto Inexistente!");
            } catch (ErroValidacaoException ex) {
                Logger.getLogger(EditarProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        CadastrarProduto tela = new CadastrarProduto();

        Desktop.add(tela);
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        try{
            this.produto = getProduto();
        }
        catch(ErroValidacaoException ex){
            JOptionPane.showMessageDialog(null, "Erro de validação: " + ex.getMessage());
            return;
        }
        //mostra msg de confirmação
        if (JOptionPane.showConfirmDialog(null, "Deseja realmente alterar o registro?",
            "Confirmar", JOptionPane.YES_NO_OPTION) == 0){
            try {
                //clicou sim
                if (this.repo_produto.Salvar(produto)){
                    JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Falha ao salvar os dados! Consulte o administrador do banco de dados");
                    dispose();
                }   } catch (ErroValidacaoException ex) {
                Logger.getLogger(EditarProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //clicou em não
        else{
            JOptionPane.showMessageDialog(null, "Cancelado com sucesso!");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "Deseja realmente CANCELAR?",
            "Confirmar", JOptionPane.YES_NO_OPTION) == 0){
        dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JComboBox<String> cbxUnidCompra;
    private javax.swing.JComboBox<String> cbxUnidVenda;
    private javax.swing.JComboBox<Fornecedor> cbxlistFornec;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblFornecedor;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblPrecoCompra;
    private javax.swing.JLabel lblPrecoVenda;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblUnidCompra;
    private javax.swing.JLabel lblUnidComprada;
    private javax.swing.JLabel lblUnidVenda;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtPrecoCompra;
    private javax.swing.JTextField txtPrecoVenda;
    private javax.swing.JTextField txtUnidComprada;
    // End of variables declaration//GEN-END:variables
}