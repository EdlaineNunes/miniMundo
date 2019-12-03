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
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edlâine
 */
public class BuscarProduto extends javax.swing.JInternalFrame {

    /**
     * Creates new form BuscarProduto
     */
    private Produto produto;
    private ProdutoRepositorio repo_produto;
    
    
    private FornecedorRepositorio repo_fornec;
    
    public BuscarProduto() {
        produto = new Produto();
        repo_produto = new ProdutoRepositorio();
        repo_fornec = new FornecedorRepositorio();
  
        initComponents();
        
        List<Fornecedor> fornecedores;
        fornecedores = repo_fornec.Buscar(null);
        ComboBoxModel<Fornecedor> model_fornec =
            new DefaultComboBoxModel<>(new Vector (fornecedores) );
        cbxlistFornec.setModel(model_fornec);   
    }

    
    public BuscarProduto(Produto produto, 
            ProdutoRepositorio repo_produto) {
        this.produto = produto;
        this.repo_produto = repo_produto;
        
        initComponents();
        
        List<Fornecedor> fornecedores;
        fornecedores = repo_fornec.Buscar(null);
        ComboBoxModel<Fornecedor> model_fornec = 
            new DefaultComboBoxModel<>(new Vector (fornecedores));
        cbxlistFornec.setModel(model_fornec);
       
    }
 
        /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tblGerenciarProduto = new javax.swing.JTabbedPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        lblDescricao = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        cbxStatus = new javax.swing.JComboBox<>();
        ScrollPane = new javax.swing.JScrollPane();
        tabResultado = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        lblFornecedor = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbxUnidCompra = new javax.swing.JComboBox<>();
        lblUnidVenda = new javax.swing.JLabel();
        cbxUnidVenda = new javax.swing.JComboBox<>();
        cbxlistFornec = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        lblDescTodos = new javax.swing.JLabel();
        txtDescTodos = new javax.swing.JTextField();
        lblStatusTodos = new javax.swing.JLabel();
        btnBuscarTodos = new javax.swing.JButton();
        cbxStatusTodos = new javax.swing.JComboBox<>();
        btnNovoTodos = new javax.swing.JButton();
        ScrollPane1 = new javax.swing.JScrollPane();
        tabResultadoTodos = new javax.swing.JTable();

        setClosable(true);
        setTitle("Mini Mundo Supermecados - Buscar Produto");

        lblDescricao.setText("Descrição:");

        lblStatus.setText("Status:");

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));

        tabResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descrição", "Fornecedor", "Unid Compra", "Unid Venda", "Preço Venda", "Preço Compra", "Unid Comprada", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabResultadoMouseClicked(evt);
            }
        });
        ScrollPane.setViewportView(tabResultado);

        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        lblFornecedor.setText("Fornecedor:");

        jLabel1.setText("Unid. Compra:");

        cbxUnidCompra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unidade", "Caixa", "Fardo", "Outro" }));

        lblUnidVenda.setText("Unid. Venda:");

        cbxUnidVenda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unidade", "Caixa ", "Fardo ", "Outro" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPane)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lblFornecedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxlistFornec, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lblDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxUnidCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUnidVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxUnidVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovo)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescricao)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatus)
                    .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxlistFornec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFornecedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscar)
                        .addComponent(btnNovo))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxUnidCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblUnidVenda)
                        .addComponent(cbxUnidVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Buscar Produto", jPanel3);

        lblDescTodos.setText("Descrição:");

        lblStatusTodos.setText("Status:");

        btnBuscarTodos.setText("BUSCAR");
        btnBuscarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTodosActionPerformed(evt);
            }
        });

        cbxStatusTodos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));

        btnNovoTodos.setText("NOVO");
        btnNovoTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoTodosActionPerformed(evt);
            }
        });

        tabResultadoTodos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descrição", "Fornecedor", "Unid Compra", "Unid Venda", "Preço Venda", "Preço Compra", "Unid Comprada", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabResultadoTodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabResultadoTodosMouseClicked(evt);
            }
        });
        ScrollPane1.setViewportView(tabResultadoTodos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblDescTodos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDescTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblStatusTodos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxStatusTodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarTodos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNovoTodos)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescTodos)
                    .addComponent(txtDescTodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatusTodos)
                    .addComponent(cbxStatusTodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarTodos)
                    .addComponent(btnNovoTodos))
                .addGap(18, 18, 18)
                .addComponent(ScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Exibir Todos ", jPanel1);

        tblGerenciarProduto.addTab("Buscar", jTabbedPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tblGerenciarProduto, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(tblGerenciarProduto)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        produto = new Produto();
        
        try {
            if(txtDescricao.getText().length() > 0)
                produto.setDescricao(txtDescricao.getText() );
            produto.setFornecedor((Fornecedor) cbxlistFornec.getSelectedItem());
            produto.setUnidCompra(UnidadesCompra.valueOf( cbxUnidCompra.getSelectedItem().toString() ));
            produto.setUnidVenda(UnidadesVenda.valueOf( cbxUnidVenda.getSelectedItem().toString() ));          
            produto.setStatus(Status.valueOf(cbxStatus.getSelectedItem().toString()));
        }catch(ErroValidacaoException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        List<Produto> list_produto = null;
        list_produto = repo_produto.Buscar(produto);
        preencherTabela(list_produto);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tabResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabResultadoMouseClicked
        // TODO add your handling code here:
        int linha = this.tabResultado.getSelectedRow();
        //pega a string e interpreta como inteiro
        int id = Integer.parseInt(this.tabResultado.getValueAt(linha,0).toString());
        //abro o aluno daquele id
        Produto produto = null;
        try {
            produto = repo_produto.Abrir(id);
        } catch (ErroValidacaoException ex) {
            Logger.getLogger(BuscarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }

        BuscarProduto tela = new BuscarProduto ();

        this.getParent().add(tela);
        tela.show();
    }//GEN-LAST:event_tabResultadoMouseClicked

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        CadastrarProduto novatela = new CadastrarProduto();
        this.getParent().add(novatela);
        dispose();
        novatela.show();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnNovoTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoTodosActionPerformed
        // TODO add your handling code here:
        CadastrarProduto novatela = new CadastrarProduto();
        this.getParent().add(novatela);
        dispose();
        novatela.show();
        
    }//GEN-LAST:event_btnNovoTodosActionPerformed

    private void tabResultadoTodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabResultadoTodosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabResultadoTodosMouseClicked

    private void btnBuscarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTodosActionPerformed
        // TODO add your handling code here:
        produto = new Produto();
        
        try {
            if(txtDescTodos.getText().length() > 0)
                produto.setDescricao(txtDescTodos.getText() );       
            produto.setStatus(Status.valueOf(cbxStatusTodos.getSelectedItem().toString()));
        }catch(ErroValidacaoException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        List<Produto> list_produto = null;
        list_produto = repo_produto.BuscarTodos(produto);
        preencherTabelaTodos(list_produto);
        
    }//GEN-LAST:event_btnBuscarTodosActionPerformed

    private void preencherTabela(List<Produto> lista) {
    //cria uma tabela vazia
        DefaultTableModel modelo = new DefaultTableModel();
        //adiciona coluna por coluna        
        modelo.addColumn("ID");
        modelo.addColumn("Descricao");
        modelo.addColumn("Fornecedor");
        modelo.addColumn("Unid Compra");
        modelo.addColumn("Unid Venda");
        modelo.addColumn("Preco Venda");
        modelo.addColumn("Preco Compra");
        modelo.addColumn("Unid Comprada");
        modelo.addColumn("Status");
        
        //para cada aluno da lista 
        for (Produto produto: lista){
            //cria um vetor de linha
            Vector linha = new Vector();
            //adiciona linha por linha
            linha.add(produto.getId());
            linha.add(produto.getDescricao());
            linha.add(produto.getFornecedor().getRazaoSocial());
            linha.add(produto.getUnidCompra());
            linha.add(produto.getUnidVenda());
            linha.add(produto.getPrecoVenda());
            linha.add(produto.getPrecoCompra());
            linha.add(produto.getUnidComprada());
            linha.add(produto.getStatus());
            
            //adiciona cada linha na tabela
            modelo.addRow(linha);
        }        
        //adiciona o modelo que é a minha tabela na tabela da interface
        tabResultado.setModel(modelo); 
    
    }
    
    private void preencherTabelaTodos(List<Produto> lista) {
    //cria uma tabela vazia
        DefaultTableModel modelo = new DefaultTableModel();
        //adiciona coluna por coluna        
        modelo.addColumn("ID");
        modelo.addColumn("Descricao");
        modelo.addColumn("Fornecedor");
        modelo.addColumn("Unid Compra");
        modelo.addColumn("Unid Venda");
        modelo.addColumn("Preco Venda");
        modelo.addColumn("Preco Compra");
        modelo.addColumn("Unid Comprada");
        modelo.addColumn("Status");
        
        //para cada aluno da lista 
        for (Produto produto: lista){
            //cria um vetor de linha
            Vector linha = new Vector();
            //adiciona linha por linha
            linha.add(produto.getId());
            linha.add(produto.getDescricao());
            linha.add(produto.getFornecedor().getRazaoSocial());
            linha.add(produto.getUnidCompra());
            linha.add(produto.getUnidVenda());
            linha.add(produto.getPrecoVenda());
            linha.add(produto.getPrecoCompra());
            linha.add(produto.getUnidComprada());
            linha.add(produto.getStatus());
            
            //adiciona cada linha na tabela
            modelo.addRow(linha);
        }        
        //adiciona o modelo que é a minha tabela na tabela da interface
        tabResultadoTodos.setModel(modelo); 
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JScrollPane ScrollPane1;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarTodos;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnNovoTodos;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JComboBox<String> cbxStatusTodos;
    private javax.swing.JComboBox<String> cbxUnidCompra;
    private javax.swing.JComboBox<String> cbxUnidVenda;
    private javax.swing.JComboBox<Fornecedor> cbxlistFornec;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblDescTodos;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblFornecedor;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStatusTodos;
    private javax.swing.JLabel lblUnidVenda;
    private javax.swing.JTable tabResultado;
    private javax.swing.JTable tabResultadoTodos;
    private javax.swing.JTabbedPane tblGerenciarProduto;
    private javax.swing.JTextField txtDescTodos;
    private javax.swing.JTextField txtDescricao;
    // End of variables declaration//GEN-END:variables

}
