/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.Presentation.Desktop;

import br.edu.ifnmg.miniMundo.DomainModel.AquisicaoProduto;
import br.edu.ifnmg.miniMundo.DomainModel.ListaItens;
import br.edu.ifnmg.miniMundo.Persistence.AquisicaoRepositorio;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListModel;

/**
 *
 * @author Edlâine
 */
public class CompraProdutos extends javax.swing.JInternalFrame {

    /**
     * Creates new form CompraProdutos
     */
    
    AquisicaoProduto aquisicao;
    ListaItens lista;
    AquisicaoRepositorio repo_aquisicao;
        
    public CompraProdutos() {
        aquisicao = new AquisicaoProduto();
        lista = new ListaItens();
        repo_aquisicao = new AquisicaoRepositorio();
        initComponents();
    }
    
    public CompraProdutos(AquisicaoProduto aquisicao, ListaItens lista, 
            AquisicaoRepositorio repo_aquisicao){
        this.aquisicao = aquisicao;
        this.lista = lista;
        this.repo_aquisicao = repo_aquisicao;
        initComponents();    
    }
    
    public void setCompraProduto(AquisicaoProduto aquisicao){
        this.aquisicao = aquisicao;
           
        atualizarItens();
    }
    
    public AquisicaoProduto getCompraProduto(){
        this.aquisicao.setId();
    
        
        return this.aquisicao;   
    }
    
    private void atualizarItens(){
        String[] item = new String[aquisicao.getItens().size()];
        item = aquisicao.getItens().toArray(item);
        ListModel<String> itens = new DefaultComboBoxModel<>(item) ;
        lista_itens.setModel(itens);
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tblGerenciarFuncionario = new javax.swing.JTabbedPane();
        tblDadosPessoais = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblDescricao = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        cbxStatus = new javax.swing.JComboBox<>();
        lblInformações = new javax.swing.JLabel();
        lblFornecedor = new javax.swing.JLabel();
        cbxFornecedor = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        lblPrecoCompra = new javax.swing.JLabel();
        txtprecoCompra = new javax.swing.JTextField();
        lblUnidVenda = new javax.swing.JLabel();
        lblprecoVenda = new javax.swing.JLabel();
        txtprecoVenda = new javax.swing.JTextField();
        lblUnidComprada = new javax.swing.JLabel();
        txtUnidComprada = new javax.swing.JTextField();
        cbxUnidCompra = new javax.swing.JComboBox<>();
        cbxUnidVenda = new javax.swing.JComboBox<>();
        btnAdicionarItem = new javax.swing.JButton();
        btnRemoverItem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lista_itens = new javax.swing.JList<>();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        lblDescricao.setText("Descrição:");

        lblStatus.setText("Status:");

        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));

        lblInformações.setText("Preencha os campos a seguir:");

        lblFornecedor.setText("Fornecedor:");

        jLabel1.setText("Unid. Compra:");

        lblPrecoCompra.setText("Preço Compra:");

        lblUnidVenda.setText("Unid. Venda:");

        lblprecoVenda.setText("Preço Venda:");

        lblUnidComprada.setText("Qtd. Comprada:");

        cbxUnidCompra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unidade", "Caixa", "Fardo ", "Outro" }));

        cbxUnidVenda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unidade", "Caixa ", "Fardo ", "Outro" }));

        btnAdicionarItem.setText("Adicionar Item");
        btnAdicionarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarItemActionPerformed(evt);
            }
        });

        btnRemoverItem.setText("Remover Item");

        jScrollPane2.setViewportView(lista_itens);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxUnidCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblPrecoCompra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtprecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblUnidComprada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUnidComprada))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblFornecedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDescricao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDescricao)))
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(284, 284, 284)
                                .addComponent(btnAdicionarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRemoverItem, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(79, 79, 79)
                                        .addComponent(cbxUnidVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblprecoVenda))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblUnidVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtprecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblStatus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(231, 231, 231)
                                .addComponent(lblInformações))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInformações)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescricao)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFornecedor)
                    .addComponent(cbxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblPrecoCompra)
                    .addComponent(txtprecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxUnidCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUnidComprada)
                    .addComponent(txtUnidComprada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblprecoVenda)
                    .addComponent(txtprecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxUnidVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUnidVenda)
                    .addComponent(lblStatus)
                    .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarItem)
                    .addComponent(btnRemoverItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addContainerGap())
        );

        tblDadosPessoais.addTab("Compra de Produto", jPanel1);

        tblGerenciarFuncionario.addTab("Cadastrar", tblDadosPessoais);

        btnSalvar.setText("SALVAR");
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
                .addGap(22, 22, 22)
                .addComponent(tblGerenciarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addGap(29, 29, 29)
                .addComponent(btnCancelar)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tblGerenciarFuncionario)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        if (JOptionPane.showConfirmDialog(null, "Deseja realmente salvar o registro?",
            "Confirmar", JOptionPane.YES_NO_OPTION) == 0){
        //clicou sim
        if (this.repo_produto.Salvar(produto)){
            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Falha ao salvar os dados! Consulte o administrador do banco de dados");
            dispose();
        }
        }
        //clicou em não
        else{
            JOptionPane.showMessageDialog(null, "Cancelado com sucesso!");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        //mostra msg de confirmação
        if (JOptionPane.showConfirmDialog(null, "Deseja realmente CANCELAR?",
            "Confirmar", JOptionPane.YES_NO_OPTION) == 0){
        dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAdicionarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarItemActionPerformed
        // TODO add your handling code here:
        this.aquisicao.addProduto(txtDescricao.getText());
        txtDescricao.setText("");
        
    }//GEN-LAST:event_btnAdicionarItemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarItem;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRemoverItem;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Fornecedor> cbxFornecedor;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JComboBox<String> cbxUnidCompra;
    private javax.swing.JComboBox<String> cbxUnidVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblFornecedor;
    private javax.swing.JLabel lblInformações;
    private javax.swing.JLabel lblPrecoCompra;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblUnidComprada;
    private javax.swing.JLabel lblUnidVenda;
    private javax.swing.JLabel lblprecoVenda;
    private javax.swing.JList<String> lista_itens;
    private javax.swing.JTabbedPane tblDadosPessoais;
    private javax.swing.JTabbedPane tblGerenciarFuncionario;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtUnidComprada;
    private javax.swing.JTextField txtprecoCompra;
    private javax.swing.JTextField txtprecoVenda;
    // End of variables declaration//GEN-END:variables
}
