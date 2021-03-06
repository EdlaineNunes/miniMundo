/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.Presentation.Desktop;

import br.edu.ifnmg.miniMundo.DomainModel.ErroValidacaoException;
import br.edu.ifnmg.miniMundo.DomainModel.Funcionario;
import br.edu.ifnmg.miniMundo.DomainModel.Pessoa;
import br.edu.ifnmg.miniMundo.DomainModel.Sexo;
import br.edu.ifnmg.miniMundo.DomainModel.Status;
import br.edu.ifnmg.miniMundo.Persistence.FuncionarioRepositorio;
import br.edu.ifnmg.miniMundo.Persistence.PessoaRepositorio;
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
public class BuscarFuncionario extends javax.swing.JInternalFrame {

    /**
     * Creates new form BuscarFuncionario
     */
    private Funcionario filtro;
    private FuncionarioRepositorio repo_func;
    private Pessoa pessoa;
    private PessoaRepositorio repo_pessoa;
    
    public BuscarFuncionario() {
        filtro = new Funcionario();
        repo_func = new FuncionarioRepositorio();
        pessoa = new Pessoa();
        repo_pessoa = new PessoaRepositorio();
        initComponents();
        
    }

    public BuscarFuncionario(Funcionario filtro, FuncionarioRepositorio repo_func,
            Pessoa pessoa,PessoaRepositorio repo_pessoa) {
        this.filtro = filtro;
        this.repo_func = repo_func;
        this.pessoa = pessoa;
        this.repo_pessoa = repo_pessoa;
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

        tblGerenciarFunc = new javax.swing.JTabbedPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        lblNomeBusca = new javax.swing.JLabel();
        lblSexoBusca = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        cbxSexoFunc = new javax.swing.JComboBox<>();
        lblCPFBusca = new javax.swing.JLabel();
        txtCPF = new javax.swing.JTextField();
        pessoaScrollPane = new javax.swing.JScrollPane();
        tabResultado = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtId_pessoaBusca = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblNome_funcBusca = new javax.swing.JLabel();
        txtId_funcBusca = new javax.swing.JTextField();
        lblUser = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        cbxStatusBuscaFunc = new javax.swing.JComboBox<>();
        btnBuscarFunc = new javax.swing.JButton();
        btnNovoCliente = new javax.swing.JButton();
        funcScrollPane = new javax.swing.JScrollPane();
        tabResultadoFunc = new javax.swing.JTable();
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

        setClosable(true);
        setTitle("Mini Mundo Supermecados - Buscar Funcionário");

        lblNomeBusca.setText("Nome:");

        lblSexoBusca.setText("Sexo:");

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        cbxSexoFunc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));

        lblCPFBusca.setText("CPF:");

        tabResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "Sexo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
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

        jLabel5.setText("ID:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pessoaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblCPFBusca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtId_pessoaBusca))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblNomeBusca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblSexoBusca)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxSexoFunc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeBusca)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSexoBusca)
                    .addComponent(cbxSexoFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCPFBusca)
                    .addComponent(jLabel5)
                    .addComponent(txtId_pessoaBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(pessoaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Buscar Pessoas", jPanel3);

        lblNome_funcBusca.setText("ID Funcionario:");

        lblUser.setText("User");

        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        lblStatus.setText("Status:");

        cbxStatusBuscaFunc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));

        btnBuscarFunc.setText("BUSCAR");
        btnBuscarFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFuncActionPerformed(evt);
            }
        });

        btnNovoCliente.setText("NOVO");
        btnNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoClienteActionPerformed(evt);
            }
        });

        tabResultadoFunc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Status", "User", "Senha"
            }
        ));
        funcScrollPane.setViewportView(tabResultadoFunc);

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

        jLabel1.setText("Para Ativar/Desativar insira o ID Funcionário!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(funcScrollPane)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblStatus)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxStatusBuscaFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(69, 69, 69))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblNome_funcBusca)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtId_funcBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblUser)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnAtivar)
                                        .addGap(40, 40, 40)
                                        .addComponent(btnDesativar)))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnBuscarFunc, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                    .addComponent(btnNovoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome_funcBusca)
                    .addComponent(txtId_funcBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarFunc)
                    .addComponent(lblUser)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoCliente)
                    .addComponent(lblStatus)
                    .addComponent(cbxStatusBuscaFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtivar)
                    .addComponent(btnDesativar))
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(funcScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Buscar Funcionarios", jPanel1);

        lblId_telefoneBusca.setText("ID:");

        lblTelefoneBuscar.setText("Telefone:");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
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
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Telefones Funcionarios", jPanel2);

        tblGerenciarFunc.addTab("Buscar", jTabbedPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(tblGerenciarFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(tblGerenciarFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        pessoa = new Pessoa();
        try {
            if(!txtId_pessoaBusca.getText().isEmpty())
                pessoa.setId(Integer.parseInt(txtId_pessoaBusca.getText()));
            if(txtNome.getText().length() > 0)
                pessoa.setNome( txtNome.getText() );
            if(!txtCPF.getText().isEmpty())
                pessoa.setCpf(txtCPF.getText());
            pessoa.setSexo(Sexo.valueOf(cbxSexoFunc.getSelectedItem().toString()));
        }catch(ErroValidacaoException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        List<Pessoa> pessoas = null;
        try {
            pessoas = repo_pessoa.Buscar(pessoa);
        } catch (ErroValidacaoException ex) {
            Logger.getLogger(BuscarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        preencherTabela(pessoas);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tabResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabResultadoMouseClicked
        // TODO add your handling code here:
        int linha = this.tabResultado.getSelectedRow();
        //pega a string e interpreta como inteiro
        int id = Integer.parseInt(this.tabResultado.getValueAt(linha,0).toString());
        //abro o aluno daquele id
        Funcionario func = null;
        try {
            func = (Funcionario) repo_func.Abrir(id);
        } catch (ErroValidacaoException ex) {
            Logger.getLogger(BuscarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }

        CadastrarFuncionario tela = new CadastrarFuncionario (func, repo_func);

        this.getParent().add(tela);
        tela.show();
    }//GEN-LAST:event_tabResultadoMouseClicked

    private void btnBuscarTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTelefoneActionPerformed
        // TODO add your handling code here:
        pessoa = new Pessoa();
        if(txtId_telefoneBuscar.getText().length() > 0)
            pessoa.setId(Integer.parseInt(txtId_telefoneBuscar.getText()));
         if(txtTelefoneBuscar.getText().length() > 0)
            pessoa.setTelefones( Arrays.asList(txtTelefoneBuscar.getText()) );

        List<Pessoa> filtro = null;
        try {
            filtro = repo_pessoa.AbrirPessoa(pessoa);
        } catch (ErroValidacaoException ex) {
            Logger.getLogger(BuscarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        preencherTabelaTelefones(filtro);
        
    }//GEN-LAST:event_btnBuscarTelefoneActionPerformed

    private void btnAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtivarActionPerformed
        // TODO add your handling code here:
        filtro = new Funcionario();
        if(Integer.parseInt(txtId_funcBusca.getText()) > 0 && txtUser.getText().isEmpty()){
            filtro.setId(Integer.parseInt(txtId_funcBusca.getText()));
            repo_func.Ativar(filtro.getId());
            JOptionPane.showMessageDialog(null, "Ativado com Sucesso!");
        }
    }//GEN-LAST:event_btnAtivarActionPerformed

    private void btnNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoClienteActionPerformed
        // TODO add your handling code here:
        CadastrarFuncionario novatela =
        new CadastrarFuncionario(new Funcionario(),this.repo_func);
        this.getParent().add(novatela);
        dispose();
        novatela.show();
    }//GEN-LAST:event_btnNovoClienteActionPerformed

    private void btnBuscarFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFuncActionPerformed
        // TODO add your handling code here:
        filtro = new Funcionario();
        try {
            if(txtId_funcBusca.getText().length() > 0)
            filtro.setId(Integer.parseInt(txtId_funcBusca.getText()));
            filtro.setStatus(Status.valueOf(cbxStatusBuscaFunc.getSelectedItem().toString()));

            if(txtUser.getText().length() > 0)
            filtro.setUser( txtUser.getText() );
        }catch(ErroValidacaoException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        List<Funcionario> funcionarios = null;
        try {
            funcionarios = repo_func.Buscar(filtro);
        } catch (ErroValidacaoException ex) {
            Logger.getLogger(BuscarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        preencherTabelaFuncionario(funcionarios);
    }//GEN-LAST:event_btnBuscarFuncActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void btnDesativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesativarActionPerformed
        // TODO add your handling code here:
        filtro = new Funcionario();
        if(Integer.parseInt(txtId_funcBusca.getText()) > 0 && txtUser.getText().isEmpty()){
            filtro.setId(Integer.parseInt(txtId_funcBusca.getText()));
            repo_func.Desativar(filtro.getId());
            JOptionPane.showMessageDialog(null, "Desativado com Sucesso!");
        }
    }//GEN-LAST:event_btnDesativarActionPerformed

    private void preencherTabelaTelefones(List<Pessoa> lista) {
        //cria uma tabela vazia
        DefaultTableModel modelo = new DefaultTableModel();
        //adiciona coluna por coluna
        modelo.addColumn("ID");
        modelo.addColumn("Telefone");
        
        
        //para cada aluno da lista 
        for (Pessoa pessoa: lista){
            //cria um vetor de linha
            Vector linha = new Vector();
            //adiciona linha por linha
            linha.add(pessoa.getId());
            linha.add(pessoa.getTelefones());
            
            //adiciona cada linha na tabela
            modelo.addRow(linha);
        }        
        //adiciona o modelo que é a minha tabela na tabela da interface
        tabResultadoTelefone.setModel(modelo);  
    }
    
    public void preencherTabela(List<Pessoa> lista){
        //cria uma tabela vazia
        DefaultTableModel modelo = new DefaultTableModel();
        //adiciona coluna por coluna
        modelo.addColumn("ID");
        modelo.addColumn("Nome");
        modelo.addColumn("Cpf");
        modelo.addColumn("Sexo");
        
        
        //para cada aluno da lista 
        for (Pessoa pessoa: lista){
            //cria um vetor de linha
            Vector linha = new Vector();
            //adiciona linha por linha
            linha.add(pessoa.getId());
            linha.add(pessoa.getNome());
            linha.add(pessoa.getCpf());
            linha.add(pessoa.getSexo().name());
            
            //adiciona cada linha na tabela
            modelo.addRow(linha);
        }        
        //adiciona o modelo que é a minha tabela na tabela da interface
        tabResultado.setModel(modelo);  
    
    }
    private void preencherTabelaFuncionario(List<Funcionario> lista) {
      //cria uma tabela vazia
        DefaultTableModel modelo = new DefaultTableModel();
        //adiciona coluna por coluna
        modelo.addColumn("ID");
        modelo.addColumn("Status");
        modelo.addColumn("User");
        modelo.addColumn("Senha");
        
        //para cada aluno da lista 
        for (Funcionario func: lista){
            //cria um vetor de linha
            Vector linha = new Vector();
            //adiciona linha por linha
            linha.add(func.getId());
            linha.add(func.getStatus());
            linha.add(func.getUser());
            linha.add(func.getSenha());
            
            //adiciona cada linha na tabela
            modelo.addRow(linha);
        }
        tabResultadoFunc.setModel(modelo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtivar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarFunc;
    private javax.swing.JButton btnBuscarTelefone;
    private javax.swing.JButton btnDesativar;
    private javax.swing.JButton btnNovoCliente;
    private javax.swing.JComboBox<String> cbxSexoFunc;
    private javax.swing.JComboBox<String> cbxStatusBuscaFunc;
    private javax.swing.JScrollPane funcScrollPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblCPFBusca;
    private javax.swing.JLabel lblId_telefoneBusca;
    private javax.swing.JLabel lblNomeBusca;
    private javax.swing.JLabel lblNome_funcBusca;
    private javax.swing.JLabel lblSexoBusca;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTelefoneBuscar;
    private javax.swing.JLabel lblUser;
    private javax.swing.JScrollPane pessoaScrollPane;
    private javax.swing.JTable tabResultado;
    private javax.swing.JTable tabResultadoFunc;
    private javax.swing.JTable tabResultadoTelefone;
    private javax.swing.JTabbedPane tblGerenciarFunc;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtId_funcBusca;
    private javax.swing.JTextField txtId_pessoaBusca;
    private javax.swing.JTextField txtId_telefoneBuscar;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefoneBuscar;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

    
}
