/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.Presentation.Desktop;

import br.edu.ifnmg.miniMundo.DomainModel.ErroValidacaoException;
import br.edu.ifnmg.miniMundo.DomainModel.Fornecedor;
import br.edu.ifnmg.miniMundo.DomainModel.Status;
import br.edu.ifnmg.miniMundo.Persistence.FornecedorRepositorio;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edlâine
 */
public class BuscarFornecedor extends javax.swing.JInternalFrame {

    /**
     * Creates new form BuscarFornecedor
     */
    private Fornecedor fornecedor;
    private FornecedorRepositorio repo_fornecedor;
    
    
    public BuscarFornecedor() {
        fornecedor = new Fornecedor();
        repo_fornecedor = new FornecedorRepositorio();
        initComponents();   
    }

    public BuscarFornecedor(Fornecedor fornecedor, 
        FornecedorRepositorio repo_fornecedor) {
        this.fornecedor = fornecedor;
        this.repo_fornecedor = repo_fornecedor;
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

        tblGerenciarCliente = new javax.swing.JTabbedPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        lblRazaoSocial = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        txtRazaoSocial = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        cbxStatus = new javax.swing.JComboBox<>();
        lblCnpj = new javax.swing.JLabel();
        txtCNPJ = new javax.swing.JTextField();
        pessoaScrollPane = new javax.swing.JScrollPane();
        tabResultado = new javax.swing.JTable();
        lblId = new javax.swing.JLabel();
        txtIdBusca = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnAtivar = new javax.swing.JButton();
        btnDesativar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblId_telefoneBusca = new javax.swing.JLabel();
        txtId_telefoneBuscar = new javax.swing.JTextField();
        lblTelefoneBuscar = new javax.swing.JLabel();
        txtTelefoneBuscar = new javax.swing.JTextField();
        btnBuscarTelefone = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabResultadoTelefone = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lblId_emailBuscar = new javax.swing.JLabel();
        txtId_emailBuscar = new javax.swing.JTextField();
        lblEmailBuscar = new javax.swing.JLabel();
        txtEmailBuscar = new javax.swing.JTextField();
        btnBuscarEmail = new javax.swing.JButton();
        jscroll = new javax.swing.JScrollPane();
        tabResultadoEmail = new javax.swing.JTable();

        setClosable(true);
        setTitle("Mini Mundo Supermecados - Buscar Fornecedores");

        lblRazaoSocial.setText("Razão Social:");

        lblStatus.setText("Status:");

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));

        lblCnpj.setText("CNPJ:");

        tabResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Status", "Razão Social", "CNPJ", "End Completo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
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
        pessoaScrollPane.setViewportView(tabResultado);

        lblId.setText("ID:");

        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAtivar.setText("ATIVAR");
        btnAtivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtivarActionPerformed(evt);
            }
        });

        btnDesativar.setText("DESATIVAR");
        btnDesativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesativarActionPerformed(evt);
            }
        });

        jLabel1.setText("Para Ativar/Desativar insira o ID do Fornecedor!");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pessoaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lblRazaoSocial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRazaoSocial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblCnpj)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblId))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtIdBusca))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(btnNovo))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btnDesativar)
                                .addGap(26, 26, 26)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRazaoSocial)
                    .addComponent(txtRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatus)
                    .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCnpj)
                    .addComponent(lblId)
                    .addComponent(txtIdBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtivar)
                    .addComponent(btnDesativar)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pessoaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Buscar Fornecedor", jPanel3);

        lblId_telefoneBusca.setText("ID:");

        lblTelefoneBuscar.setText("Telefone:");

        txtTelefoneBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneBuscarActionPerformed(evt);
            }
        });

        btnBuscarTelefone.setText("BUSCAR");
        btnBuscarTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTelefoneActionPerformed(evt);
            }
        });

        tabResultadoTelefone.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabResultadoTelefone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabResultadoTelefoneMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabResultadoTelefone);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblId_telefoneBusca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtId_telefoneBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTelefoneBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTelefoneBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnBuscarTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId_telefoneBusca)
                    .addComponent(txtId_telefoneBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefoneBuscar)
                    .addComponent(txtTelefoneBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarTelefone))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Telefones Fornecedor", jPanel2);

        lblId_emailBuscar.setText("ID:");

        lblEmailBuscar.setText("Email:");

        btnBuscarEmail.setText("BUSCAR");
        btnBuscarEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEmailActionPerformed(evt);
            }
        });

        jscroll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jscrollMouseClicked(evt);
            }
        });

        tabResultadoEmail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabResultadoEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabResultadoEmailMouseClicked(evt);
            }
        });
        jscroll.setViewportView(tabResultadoEmail);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jscroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblId_emailBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtId_emailBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblEmailBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmailBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscarEmail)))
                .addGap(37, 37, 37))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId_emailBuscar)
                    .addComponent(txtId_emailBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmailBuscar)
                    .addComponent(txtEmailBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarEmail))
                .addGap(34, 34, 34)
                .addComponent(jscroll, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Email Fornecedor", jPanel4);

        tblGerenciarCliente.addTab("Buscar", jTabbedPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(tblGerenciarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(tblGerenciarCliente)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        fornecedor = new Fornecedor();
        try {
            if(txtRazaoSocial.getText().length() > 0)
                fornecedor.setRazaoSocial(txtRazaoSocial.getText() );
            fornecedor.setStatus(Status.valueOf(cbxStatus.getSelectedItem().toString()));
            if(!txtCNPJ.getText().isEmpty())
                fornecedor.setCnpj(txtCNPJ.getText());
            if(!txtIdBusca.getText().isEmpty())
                fornecedor.setId(Integer.parseInt(txtIdBusca.getText()));
        }catch(ErroValidacaoException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        List<Fornecedor> list_fornec = null;
        list_fornec = repo_fornecedor.Buscar(fornecedor);
        preencherTabela(list_fornec);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tabResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabResultadoMouseClicked
        // TODO add your handling code here:
        int linha = this.tabResultado.getSelectedRow();
        //pega a string e interpreta como inteiro
        int id = Integer.parseInt(this.tabResultado.getValueAt(linha,0).toString());
        //abro o aluno daquele id
        Fornecedor fornecedor = null;
        try {
            fornecedor = (Fornecedor) repo_fornecedor.Abrir(id);
        } catch (ErroValidacaoException ex) {
            Logger.getLogger(BuscarFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }

        BuscarFornecedor tela = new BuscarFornecedor (fornecedor, repo_fornecedor);

        this.getParent().add(tela);
        tela.show();
    }//GEN-LAST:event_tabResultadoMouseClicked

    private void btnBuscarTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTelefoneActionPerformed
        // TODO add your handling code here:
        fornecedor = new Fornecedor();
        if(txtId_telefoneBuscar.getText().length() > 0)
            fornecedor.setId(Integer.parseInt(txtId_telefoneBuscar.getText()));
        if(txtTelefoneBuscar.getText().length() > 0)
            fornecedor.setTelefones( Arrays.asList(txtTelefoneBuscar.getText()) );

        List<Fornecedor> filtro = null;
        try {
            filtro = repo_fornecedor.AbrirLista(fornecedor);
        } catch (ErroValidacaoException ex) {
            Logger.getLogger(BuscarFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        preencherTabelaTelefones(filtro);

    }//GEN-LAST:event_btnBuscarTelefoneActionPerformed
   
    private void tabResultadoTelefoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabResultadoTelefoneMouseClicked
        // TODO add your handling code here:
        int linha = this.tabResultado.getSelectedRow();
        //pega a string e interpreta como inteiro
        int id = Integer.parseInt(this.tabResultado.getValueAt(linha,0).toString());
        //abro o aluno daquele id
        Fornecedor fornecedor = null;
        try {
            fornecedor = (Fornecedor) repo_fornecedor.Abrir(id);
        } catch (ErroValidacaoException ex) {
            Logger.getLogger(BuscarFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }

        BuscarFornecedor tela = new BuscarFornecedor (fornecedor, repo_fornecedor);

        this.getParent().add(tela);
        tela.show();
    }//GEN-LAST:event_tabResultadoTelefoneMouseClicked

    private void btnBuscarEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmailActionPerformed
        // TODO add your handling code here:
        fornecedor = new Fornecedor();
        if(txtId_emailBuscar.getText().length() > 0)
            fornecedor.setId(Integer.parseInt(txtId_emailBuscar.getText()));
        if(txtEmailBuscar.getText().length() > 0)
            fornecedor.setEmail( Arrays.asList(txtEmailBuscar.getText()) );

        List <Fornecedor> email = null;
        try {
            email = repo_fornecedor.AbrirLista(fornecedor);
        } catch (ErroValidacaoException ex) {
            Logger.getLogger(BuscarFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        preencherTabelaEmails(email);

    }//GEN-LAST:event_btnBuscarEmailActionPerformed

    private void tabResultadoEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabResultadoEmailMouseClicked
        // TODO add your handling code here:
        int linha = this.tabResultado.getSelectedRow();
        //pega a string e interpreta como inteiro
        int id = Integer.parseInt(this.tabResultado.getValueAt(linha,0).toString());
        //abro o aluno daquele id
        Fornecedor fornecedor = null;
        try {
            fornecedor = (Fornecedor) repo_fornecedor.Abrir(id);
        } catch (ErroValidacaoException ex) {
            Logger.getLogger(BuscarFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }

        BuscarFornecedor tela = new BuscarFornecedor (fornecedor, repo_fornecedor);

        this.getParent().add(tela);
        tela.show();
    }//GEN-LAST:event_tabResultadoEmailMouseClicked

    private void preencherTabela(List<Fornecedor> lista) {
        //cria uma tabela vazia
        DefaultTableModel modelo = new DefaultTableModel();
        //adiciona coluna por coluna
        modelo.addColumn("ID");
        modelo.addColumn("Status");
        modelo.addColumn("Razão Social");
        modelo.addColumn("CNPJ");
        modelo.addColumn("End Completo");
        
        
        //para cada aluno da lista 
        for (Fornecedor fornecedor: lista){
            //cria um vetor de linha
            Vector linha = new Vector();
            //adiciona linha por linha
            linha.add(fornecedor.getId());
            linha.add(fornecedor.getStatus());
            linha.add(fornecedor.getRazaoSocial());
            linha.add(fornecedor.getCnpj());
            linha.add(fornecedor.getEndCompleto());
            
            //adiciona cada linha na tabela
            modelo.addRow(linha);
        }        
        //adiciona o modelo que é a minha tabela na tabela da interface
        tabResultado.setModel(modelo);  
    }

    private void preencherTabelaTelefones(List<Fornecedor> lista) {
        DefaultTableModel modelo = new DefaultTableModel();
        //adiciona coluna por coluna
        modelo.addColumn("ID");
        modelo.addColumn("Telefone");
          
        //para cada aluno da lista 
        for (Fornecedor fornecedor: lista){
            //cria um vetor de linha
            Vector linha = new Vector();
            //adiciona linha por linha
            linha.add(fornecedor.getId());
            linha.add(fornecedor.getTelefones());
                        
            //adiciona cada linha na tabela
            modelo.addRow(linha);
        }        
        //adiciona o modelo que é a minha tabela na tabela da interface
        tabResultadoTelefone.setModel(modelo);  
    }

    private void preencherTabelaEmails(List<Fornecedor> lista) {
        DefaultTableModel modelo = new DefaultTableModel();
        //adiciona coluna por coluna
        modelo.addColumn("ID");
        modelo.addColumn("Email");
          
        //para cada aluno da lista 
        for (Fornecedor fornecedor: lista){
            //cria um vetor de linha
            Vector linha = new Vector();
            //adiciona linha por linha
            linha.add(fornecedor.getId());
            linha.add(fornecedor.getEmail());
                        
            //adiciona cada linha na tabela
            modelo.addRow(linha);
        }        
        //adiciona o modelo que é a minha tabela na tabela da interface
        tabResultadoEmail.setModel(modelo);  
    }
    
    private void jscrollMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jscrollMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jscrollMouseClicked

    private void txtTelefoneBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneBuscarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        CadastrarFornecedor novatela = 
                new CadastrarFornecedor(new Fornecedor(),this.repo_fornecedor);
        this.getParent().add(novatela);
        dispose();
        novatela.show();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtivarActionPerformed
        // TODO add your handling code here:
        fornecedor = new Fornecedor();
        if(Integer.parseInt(txtIdBusca.getText()) > 0 ){
            fornecedor.setId(Integer.parseInt(txtIdBusca.getText()));
            repo_fornecedor.Ativar(fornecedor.getId());
            JOptionPane.showMessageDialog(null, "Ativado com Sucesso!");
        }  
        
    }//GEN-LAST:event_btnAtivarActionPerformed

    private void btnDesativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesativarActionPerformed
        // TODO add your handling code here:
        fornecedor = new Fornecedor();
        if(Integer.parseInt(txtIdBusca.getText()) > 0 ){
            fornecedor.setId(Integer.parseInt(txtIdBusca.getText()));
            repo_fornecedor.Desativar(fornecedor.getId());
            JOptionPane.showMessageDialog(null,"Desativado com Sucesso!");
        } 
    }//GEN-LAST:event_btnDesativarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtivar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarEmail;
    private javax.swing.JButton btnBuscarTelefone;
    private javax.swing.JButton btnDesativar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JScrollPane jscroll;
    private javax.swing.JLabel lblCnpj;
    private javax.swing.JLabel lblEmailBuscar;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblId_emailBuscar;
    private javax.swing.JLabel lblId_telefoneBusca;
    private javax.swing.JLabel lblRazaoSocial;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTelefoneBuscar;
    private javax.swing.JScrollPane pessoaScrollPane;
    private javax.swing.JTable tabResultado;
    private javax.swing.JTable tabResultadoEmail;
    private javax.swing.JTable tabResultadoTelefone;
    private javax.swing.JTabbedPane tblGerenciarCliente;
    private javax.swing.JTextField txtCNPJ;
    private javax.swing.JTextField txtEmailBuscar;
    private javax.swing.JTextField txtIdBusca;
    private javax.swing.JTextField txtId_emailBuscar;
    private javax.swing.JTextField txtId_telefoneBuscar;
    private javax.swing.JTextField txtRazaoSocial;
    private javax.swing.JTextField txtTelefoneBuscar;
    // End of variables declaration//GEN-END:variables

}
