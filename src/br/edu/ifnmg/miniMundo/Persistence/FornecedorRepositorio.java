/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.Persistence;

import br.edu.ifnmg.miniMundo.DomainModel.ErroValidacaoException;
import br.edu.ifnmg.miniMundo.DomainModel.Fornecedor;
import br.edu.ifnmg.miniMundo.DomainModel.Status;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edlâine
 */
public class FornecedorRepositorio extends BancoDados{
    public FornecedorRepositorio(){
        super();
    }
    
    public boolean Salvar(Fornecedor obj){
        try {  
            if(obj.getId() == 0){
                PreparedStatement sql = this.getConexao()
                        .prepareStatement("insert into Fornecedor(razaoSocial, cnpj, endCompleto,status)"
                                + " values(?,?,?,?)",
                                Statement.RETURN_GENERATED_KEYS);
                sql.setString(1, obj.getRazaoSocial());
                sql.setString(2, obj.getCnpj().replace(".", "").replace("/","").replace("-", ""));
                sql.setString(3, obj.getEndCompleto());
                sql.setString(4, obj.getStatus().name());
                
                
                if(sql.executeUpdate() > 0){ 
                    ResultSet chave = sql.getGeneratedKeys();
                    chave.next();
                    obj.setId(chave.getInt(1));
                    atualizarTelefones(obj);
                    atualizarEmail(obj);
                    return true;
                }
                else
                    return false;
            } else {
                PreparedStatement sql = this.getConexao()
                        .prepareStatement("update Fornecedor set razaoSocial = ?, "
                                + "cnpj = ?, endCompleto = ?, status = ? where id = ?");
               sql.setString(1, obj.getRazaoSocial());
                sql.setString(2, obj.getCnpj().replace(".", "").replace("/","").replace("-", ""));
                sql.setString(3, obj.getEndCompleto());
                sql.setString(4, obj.getStatus().name());
                sql.setInt(5, obj.getId());
                
                if(sql.executeUpdate() > 0){ 
                    atualizarTelefones(obj);
                    atualizarEmail(obj);
                    return true;
                }
                else
                    return false;
            }                   
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }      
        return false;     
    }
    
    public void atualizarTelefones(Fornecedor fornecedor) throws SQLException{
        try {
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("delete from telefoneFornecedor where fornecedor_fk = ?");
       
            sql.setInt(1, fornecedor.getId());     
            String values = "";

            for(String telefone : fornecedor.getTelefones()){
                if(values.length() > 0) 
                    values += ", ";             
                values += "("+fornecedor.getId()+",'"+telefone+"')";
            }
            
            Statement sql2 = this.getConexao().createStatement();
            sql2.executeUpdate("insert into telefoneFornecedor(fornecedor_fk, telefone) VALUES " + values);
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizarEmail(Fornecedor fornecedor) throws SQLException{
        try {
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("delete from emailFornecedor where fornecedor_fk = ?");
       
            sql.setInt(1, fornecedor.getId());     
            String values = "";

            for(String email : fornecedor.getEmail()){
                if(values.length() > 0) 
                    values += ", ";             
                values += "("+fornecedor.getId()+",'"+email+"')";
            }
            
            Statement sql2 = this.getConexao().createStatement();
            sql2.executeUpdate("insert into emailFornecedor(fornecedor_fk, email) VALUES " + values);
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Fornecedor Abrir(int id) throws ErroValidacaoException{
        try {     
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("select * from Fornecedor where id = ?");   
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            resultado.next();
            Fornecedor fornecedor = new Fornecedor();   
            try{
               fornecedor.setId( resultado.getInt("id"));
               fornecedor.setRazaoSocial( resultado.getString("razaoSocial"));
               fornecedor.setCnpj( resultado.getString("cnpj"));
               fornecedor.setEndCompleto(resultado.getString("endCompleto"));
               fornecedor.setStatus(Status.valueOf(resultado.getString("status")));
               abrirTelefones(fornecedor);
               abrirEmails(fornecedor);
               
            }catch(SQLException ex) {
               fornecedor = null;
            }
            return fornecedor;         
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public List<Fornecedor> AbrirLista(Fornecedor obj) throws ErroValidacaoException{
        try {     
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("select * from Fornecedor where id = ?");   
            sql.setInt(1, obj.getId());
            ResultSet resultado = sql.executeQuery();
            List<Fornecedor> fornecedores = new ArrayList<>();
            
            while(resultado.next()){
                Fornecedor fornecedor = new Fornecedor();   
                try{
                   fornecedor.setId( resultado.getInt("id"));
                   fornecedor.setRazaoSocial( resultado.getString("razaoSocial"));
                   fornecedor.setCnpj( resultado.getString("cnpj"));
                   fornecedor.setEndCompleto(resultado.getString("endCompleto"));
                   fornecedor.setStatus(Status.valueOf(resultado.getString("status")));
                   abrirTelefones(fornecedor);
                   abrirEmails(fornecedor);

                }catch(SQLException ex) {
                   fornecedor = null;
                }
                fornecedores.add(fornecedor);
            }
            return fornecedores;         
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public void abrirTelefones(Fornecedor obj){
        try {
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("select telefone from telefoneFornecedor where fornecedor_fk = ?");
            sql.setInt(1, obj.getId());       
            ResultSet resultado = sql.executeQuery();         
            while(resultado.next()){
                obj.addTelefone(resultado.getString("telefone"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void abrirEmails(Fornecedor obj){
        try {
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("select * from emailFornecedor where fornecedor_fk = ?");
            sql.setInt(1, obj.getId());       
            ResultSet resultado = sql.executeQuery();         
            while(resultado.next()){
                obj.addEmail(resultado.getString("email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean Desativar(int id){
        try {
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("update Fornecedor set status = 'Inativo'"
                            + " where id = ?");
            
            sql.setInt(1, id);          
            if(sql.executeUpdate() > 0)
                return true;
            return false;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean Ativar(int id){
        try {
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("update Fornecedor set status = 'Ativo' "
                            + "where id = ?");
            
            sql.setInt(1, id);          
            if(sql.executeUpdate() > 0)
                return true;
            return false;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public List<Fornecedor> Buscar(Fornecedor filtro){
        try {
            String where = "";
            if (filtro != null){
                if(filtro.getId() != 0)
                    where += "id = '"+filtro.getId() + "'";
                if(filtro.getRazaoSocial() != null && !filtro.getRazaoSocial().isEmpty()){
                    if(where.length() > 0)
                            where += " and ";
                    where += "razaoSocial like '%"+filtro.getRazaoSocial() + "%'";
                }
                //39.113.709/0001-39
                if(filtro.getCnpj() != null && !filtro.getCnpj().isEmpty()&& 
                            !"00.000.000/0000-00".equals(filtro.getCnpj())){
                    if(where.length() > 0)
                        where += " and ";
                    where += "cnpj = '"+filtro.getCnpj().replace(".", "").replace("/","").replace("-", "") + "'";
                }          
                if(filtro.getStatus() != null ){
                    if(where.length() > 0)
                        where += " and ";
                    where += "status = '"+filtro.getStatus().name() +"'";
                }
                if(filtro.getEndCompleto() != null && !filtro.getEndCompleto().isEmpty()){
                    if(where.length() > 0)
                        where += " and ";
                    where += "endCompleto like '%"+filtro.getEndCompleto() + "%'";
                }
            }           
            
            String consulta = "select * from Fornecedor ";
            if(where.length() >0 )
                consulta += " where " + where;
            
            consulta += " order by razaoSocial ";
            
            PreparedStatement sql = this.getConexao()
                    .prepareStatement(consulta);
            ResultSet resultado = sql.executeQuery();
            List<Fornecedor> fornecedores = new ArrayList<>();
            while(resultado.next()) {
               Fornecedor fornecedor = new Fornecedor();
               fornecedor.setId( resultado.getInt("id"));
               fornecedor.setStatus(Status.valueOf(resultado.getString("status"))); 
               fornecedor.setRazaoSocial( resultado.getString("razaoSocial"));
               fornecedor.setCnpj( resultado.getString("cnpj"));
               fornecedor.setEndCompleto( resultado.getString("endCompleto"));              
               fornecedores.add(fornecedor);
            }
            return fornecedores;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ErroValidacaoException ex) {
            Logger.getLogger(FornecedorRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Fornecedor> Listar(Fornecedor filtro){
        try {         
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("select * from Fornecedor order by razaoSocial");
            ResultSet resultado = sql.executeQuery();
            List<Fornecedor> fornecedores = new ArrayList<>();
            while(resultado.next()) {
               Fornecedor fornecedor = new Fornecedor();
               fornecedor.setId( resultado.getInt("id"));
               fornecedor.setStatus(Status.valueOf(resultado.getString("status"))); 
               fornecedor.setRazaoSocial( resultado.getString("razaoSocial"));
               fornecedor.setCnpj( resultado.getString("cnpj"));
               fornecedor.setEndCompleto( resultado.getString("endCompleto"));              
               fornecedores.add(fornecedor);
            }
            return fornecedores;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ErroValidacaoException ex) {
            Logger.getLogger(FornecedorRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return null;
    }    
    
    public int ChecarStatus(int id_fornec){

        try {     
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("select status from Fornecedor where id = ?");   
            sql.setInt(1, id_fornec);
            ResultSet resultado = sql.executeQuery();
            resultado.next();
            Fornecedor fornec = new Fornecedor();   
            //ativo 1, inativo 0
            if(fornec.getStatus().toString() == "Ativo")
                return 1;
            return 0;         
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
}
