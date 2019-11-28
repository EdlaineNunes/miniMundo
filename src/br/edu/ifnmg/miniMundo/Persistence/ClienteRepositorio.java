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
                
                sql.executeUpdate();
                return true;
                
            } else {
                PreparedStatement sql = this.getConexao()
                        .prepareStatement("update Cliente set rua = ?, nCasa =?,"
                                + " bairro =?, cidade = ?, status = ? where pessoa_fk = ?");
                sql.setString(1, obj.getRua());
                sql.setString(2, obj.getnCasa());
                sql.setString(3, obj.getBairro());
                sql.setString(4, obj.getCidade());
                sql.setString(5, obj.getStatus().name());
                sql.setInt(6, obj.getId());
                
                sql.executeUpdate();
                return true;
            }                   
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }      
        return false;     
    }

    public Cliente Abrir(Cliente obj) throws ErroValidacaoException{
        super.Abrir(obj.getId());
        try {    
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("select * from Cliente where pessoa_fk = ?");  
            //select * from Pessoa where id = ?
            sql.setInt(1, obj.getId());
            ResultSet resultado = sql.executeQuery();
            resultado.next();
            //Pessoa cliente = new Pessoa();  
            Cliente cliente = new Cliente();
            try{
               /*cliente.setId( resultado.getInt("id"));
               cliente.setNome( resultado.getString("nome"));
               cliente.setCpf( resultado.getString("cpf"));
               cliente.setSexo( Sexo.valueOf(resultado.getString("sexo")));
               */cliente.setRua(resultado.getString("rua"));
               cliente.setnCasa(resultado.getString("nCasa"));
               cliente.setBairro(resultado.getString("bairro"));
               cliente.setCidade(resultado.getString("cidade"));
               cliente.setStatus(Status.valueOf(resultado.getString("status")));
               
            }catch(SQLException ex) {
               cliente = null;
            }
            return (Cliente) cliente;         
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public boolean Desativar(Cliente obj){
        try {
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("update Cliente set status = 'Inativo' where id = ?");          
            sql.setInt(1, obj.getId());          
            if(sql.executeUpdate() > 0)
                return true;
            else
                return false;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public List<Cliente> Buscar(Cliente filtro) throws ErroValidacaoException{
        //super.Buscar(filtro);
        try {
            String where = "";
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

}
