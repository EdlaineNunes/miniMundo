/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.Persistence;

import br.edu.ifnmg.miniMundo.DomainModel.Cliente;
import br.edu.ifnmg.miniMundo.DomainModel.ErroValidacaoException;
import br.edu.ifnmg.miniMundo.DomainModel.Cliente;
import br.edu.ifnmg.miniMundo.DomainModel.Pessoa;
import br.edu.ifnmg.miniMundo.DomainModel.Status;
import br.edu.ifnmg.miniMundo.DomainModel.Sexo;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
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
public class ClienteRepositorio extends PessoaRepositorio {
    
    public ClienteRepositorio() {
        super();
    }
    
    public boolean Salvar(Cliente obj){
        super.Salvar((Pessoa) obj);
        try {  
          
            if(obj.getId() != 0){
                PreparedStatement sql = this.getConexao()
                        .prepareStatement("insert into Cliente(pessoa_fk, rua, nCasa, bairro, cidade, status)"
                                + " values(?,?,?,?,?,?) ");

                sql.setInt(1, obj.getId());
                sql.setString(2, obj.getRua());
                sql.setString(3, obj.getnCasa());
                sql.setString(4, obj.getBairro());
                sql.setString(5, obj.getCidade());
                sql.setString(6, obj.getStatus().name());
                
                
                if(sql.executeUpdate() > 0){
                    atualizarEmail(obj);
                    return true;
                }                
            } 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }      
        return false;     
    }
    
    public boolean Editar(Cliente obj){
        super.Salvar((Pessoa) obj);
        try {  
          
            if(obj.getId() != 0){
                PreparedStatement sql = this.getConexao()
                        .prepareStatement("update Cliente set rua = ?, nCasa =?,"
                                + " bairro =?, cidade = ?, status = ? where pessoa_fk = ?");
                sql.setString(1, obj.getRua());
                sql.setString(2, obj.getnCasa());
                sql.setString(3, obj.getBairro());
                sql.setString(4, obj.getCidade());
                sql.setString(5, obj.getStatus().name());
                sql.setInt(6, obj.getId());
                
                
                if(sql.executeUpdate() > 0){ 
                    atualizarEmail(obj);
                    return true;
                }
                
                return true;
            }   
            else
                return false;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }      
        return false;     
    }    
    
    public void atualizarEmail(Cliente cliente) throws SQLException{
        try {
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("delete from emailCliente where cliente_pessoa_fk = ?");
       
            sql.setInt(1, cliente.getId());     
            String values = "";

            for(String email : cliente.getEmails()){
                if(values.length() > 0) 
                    values += ", ";             
                values += "("+cliente.getId()+",'"+email+"')";
            }
            
            Statement sql2 = this.getConexao().createStatement();
            sql2.executeUpdate("insert into emailCliente(cliente_pessoa_fk, email) VALUES " + values);
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Cliente> Abrir(Cliente obj) throws ErroValidacaoException{
        super.AbrirPessoa(obj);
        try {    
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("select * from Cliente where pessoa_fk = ?");  

            sql.setInt(1, obj.getId());
            ResultSet resultado = sql.executeQuery();
            List<Cliente> clientes = new ArrayList<>();
             
            while(resultado.next()) {
                Cliente cliente = new Cliente();
                try{
                   cliente.setId(resultado.getInt("pessoa_fk"));
                   cliente.setRua(resultado.getString("rua"));
                   cliente.setnCasa(resultado.getString("nCasa"));
                   cliente.setBairro(resultado.getString("bairro"));
                   cliente.setCidade(resultado.getString("cidade"));
                   cliente.setStatus(Status.valueOf(resultado.getString("status")));
                   abrirEmails(cliente);
                   
                }catch(SQLException ex) {
                   cliente = null;
                }
                clientes.add(cliente);
            }
            return clientes; 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
   public void abrirEmails(Cliente obj){
       try {
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("select * from emailCliente where cliente_pessoa_fk = ? ");
            sql.setInt(1, obj.getId());
            ResultSet resultado = sql.executeQuery();
            while(resultado.next()){
                obj.addEmail(resultado.getString("email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Cliente AbrirId(int id) throws ErroValidacaoException{
        
        try {    
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("select * from Cliente where pessoa_fk = ?");  

            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            resultado.next();
            Cliente cliente = new Cliente();
            try{
                cliente.setRua(resultado.getString("rua"));
                cliente.setnCasa(resultado.getString("nCasa"));
                cliente.setBairro(resultado.getString("bairro"));
                cliente.setCidade(resultado.getString("cidade"));
                cliente.setStatus(Status.valueOf(resultado.getString("status")));
                
            }catch(SQLException ex) {
                cliente = null;
            }   
            return cliente; 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public boolean Desativar(int id){
        try {
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("update Cliente set status = 'Inativo'"
                            + " where pessoa_fk = ?");
            
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
                    .prepareStatement("update Cliente set status = 'Ativo' where pessoa_fk = ?");
            
            sql.setInt(1, id);          
            if(sql.executeUpdate() > 0)
                return true;
            return false;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public List<Cliente> Buscar(Cliente filtro) throws ErroValidacaoException{
        super.Buscar(filtro);
        try {
            String where = "";
            if(filtro != null){
                if(filtro.getId() !=  0)
                    where += "pessoa_fk = '"+filtro.getId() + "'";
                if(filtro.getRua() != null && !filtro.getRua().isEmpty()){
                    if(where.length() > 0)
                            where += " and ";
                    where += "rua like '%"+filtro.getRua() + "%'";            
                }
                if(filtro.getnCasa() != null && !filtro.getnCasa().isEmpty()){
                        if(where.length() > 0)
                            where += " and ";
                        where += "nCasa = '"+filtro.getnCasa() + "'";
                    }
                if(filtro.getBairro() != null && !filtro.getBairro().isEmpty() ){
                    if(where.length() > 0)
                        where += " and ";
                    where += "bairro = '"+filtro.getBairro() +"'";
                }   
                if(filtro.getCidade() != null && !filtro.getCidade().isEmpty() ){
                    if(where.length() > 0)
                        where += " and ";
                    where += "cidade = '"+filtro.getCidade() +"'";
                } 
                if(filtro.getStatus() != null ){
                    if(where.length() > 0)
                        where += " and ";
                    where += "status = '"+filtro.getStatus().name() +"'";
                }
            }
                      
            String consulta = "select * from Cliente";
            if(where.length() > 0 )
                consulta += " where " + where;
            PreparedStatement sql = this.getConexao()
                    .prepareStatement(consulta);
            ResultSet resultado = sql.executeQuery();
            
            List<Cliente> clientes = new ArrayList<>();
            while(resultado.next()) {
               Cliente cliente = new Cliente();
               try{                            
                    cliente.setId(Integer.parseInt(resultado.getString("pessoa_fk")));
                    cliente.setRua( resultado.getString("rua"));
                    cliente.setnCasa( resultado.getString("nCasa"));
                    cliente.setBairro( resultado.getString("bairro"));
                    cliente.setCidade(resultado.getString("cidade"));  
                    cliente.setStatus(Status.valueOf(resultado.getString("status")));
               }catch(Exception ex){
                    cliente = null;
                }
               
               clientes.add(cliente);
            }
            return clientes;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public Cliente Validar(Cliente filtro) throws ErroValidacaoException{
        super.Buscar(filtro);
        try{
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("select * from cliente where pessoa_fk = ?");
            ResultSet resultado = sql.executeQuery();
            Cliente cliente = new Cliente();
            if(resultado.next() == false) {
               cliente = null;
               return cliente;
            }else{                         
                try {
                    cliente.setId(Integer.parseInt(resultado.getString("pessoa_fk")));
                    cliente.setRua( resultado.getString("rua"));
                    cliente.setnCasa( resultado.getString("nCasa"));
                    cliente.setBairro( resultado.getString("bairro"));
                    cliente.setCidade(resultado.getString("cidade"));  
                    cliente.setStatus(Status.valueOf(resultado.getString("status")));
                    return cliente;
                } catch (ErroValidacaoException ex) {
                    Logger.getLogger(ClienteRepositorio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
       return null;    
    }
    
    public Cliente ValidarId(Cliente obj) throws ErroValidacaoException {      
        Cliente cliente = new Cliente();
        try{
            PreparedStatement sql = this.getConexao()
                        .prepareStatement("select * from cliente where "
                                + "pessoa_fk = ? ");          
                sql.setInt(1, obj.getId());
                
                ResultSet resultado = sql.executeQuery();

                if(resultado.next()){
                    cliente.setId(Integer.parseInt(resultado.getString("pessoa_fk")));
                    cliente.setRua( resultado.getString("rua"));
                    cliente.setnCasa( resultado.getString("nCasa"));
                    cliente.setBairro( resultado.getString("bairro"));
                    cliente.setCidade(resultado.getString("cidade"));  
                    cliente.setStatus(Status.valueOf(resultado.getString("status")));
                    abrirEmails(obj);
                    return cliente;       
                }else{
                    cliente = null;
                    return cliente;
                }

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return cliente;
    }
    
}
