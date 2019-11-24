/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.Persistence;

import br.edu.ifnmg.miniMundo.DomainModel.Cliente;
import br.edu.ifnmg.miniMundo.DomainModel.ErroValidacaoException;
import br.edu.ifnmg.miniMundo.DomainModel.Cliente;
import br.edu.ifnmg.miniMundo.DomainModel.Status;
import br.edu.ifnmg.miniMundo.DomainModel.Sexo;
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
public class ClienteRepositorio extends BancoDados {
    
    public ClienteRepositorio() {
        super();
    }
    
    public boolean Salvar(Cliente obj){
        try {  
            if(obj.getId() == 0){
                PreparedStatement sql = this.getConexao()
                        .prepareStatement("insert into Cliente(nome, cpf, sexo, rua, nCasa, bairro, cidade,status)"
                                + " values(?,?,?,?,?,?,?,?)",
                                Statement.RETURN_GENERATED_KEYS);
                sql.setString(1, obj.getNome());
                sql.setString(2, obj.getCpf().replace(".", "").replace("-", ""));
                sql.setString(3, obj.getSexo().name());
                sql.setString(4, obj.getRua());
                sql.setString(5, obj.getnCasa());
                sql.setString(6, obj.getBairro());
                sql.setString(7, obj.getCidade());
                sql.setString(8, obj.getStatus().name());
                
                if(sql.executeUpdate() > 0){ 
                    ResultSet chave = sql.getGeneratedKeys();
                    chave.next();
                    obj.setId(chave.getInt(1));
                    return true;
                }
                else
                    return false;
            } else {
                PreparedStatement sql = this.getConexao()
                        .prepareStatement("update Cliente set nome = ?, cpf = ?, sexo = ?,"
                                + "rua = ?, nCasa =?, bairro =?, cidade = ?, status = ? where id = ?");
                sql.setString(1, obj.getNome());
                sql.setString(2, obj.getCpf().replace(".", "").replace("-", ""));
                sql.setString(3, obj.getSexo().name());
                sql.setString(4, obj.getRua());
                sql.setString(5, obj.getnCasa());
                sql.setString(6, obj.getBairro());
                sql.setString(7, obj.getCidade());
                sql.setString(8, obj.getStatus().name());
                sql.setInt(9, obj.getId());
                
                if(sql.executeUpdate() > 0) 
                    return true;
                else
                    return false;
            }                   
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }      
        return false;     
    }

    public Cliente Abrir(int id) throws ErroValidacaoException{
        try {     
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("select * from Cliente where id = ?");   
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            resultado.next();
            Cliente cliente = new Cliente();   
            try{
               cliente.setId( resultado.getInt("id"));
               cliente.setNome( resultado.getString("nome"));
               cliente.setCpf( resultado.getString("cpf"));
               cliente.setSexo( Sexo.valueOf(resultado.getString("sexo")));
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
        try {
            String where = "";
            if(filtro.getNome() != null && !filtro.getNome().isEmpty())
                where += "nome like '%"+filtro.getNome() + "%'";            
            if(filtro.getCpf() != null && !filtro.getCpf().isEmpty()){
                if(where.length() > 0)
                    where += " and ";
                where += "cpf = '"+filtro.getCpf().replace(".", "").replace("-", "") + "'";
            }          
            if(filtro.getSexo() != null ){
                if(where.length() > 0)
                    where += " and ";
                where += "sexo = '"+filtro.getSexo().name() +"'";
            }
            if(filtro.getRua() != null && !filtro.getRua().isEmpty()){
                if(where.length() > 0)
                    where += " and ";
                where += "rua like '%"+filtro.getRua() + "%'";
            }
            if(filtro.getnCasa() != null && !filtro.getnCasa().isEmpty()){
                if(where.length() > 0)
                    where += " and ";
                where += "nCasa like '%"+filtro.getnCasa() + "%'";
            }          
            if(filtro.getBairro() != null && !filtro.getBairro().isEmpty()){
                if(where.length() > 0)
                    where += " and ";
                where += "bairro like '%"+filtro.getBairro() + "%'";
            }          
            if(filtro.getCidade() != null && !filtro.getCidade().isEmpty()){
                if(where.length() > 0)
                    where += " and ";
                where += "cidade like '%"+filtro.getCidade() + "%'";
            }          
            if(filtro.getStatus() != null ){
                if(where.length() > 0)
                    where += " and ";
                where += "status = '"+filtro.getStatus().name() +"'";
            }
            
            String consulta = "select * from Cliente";
            if(where.length() >0 )
                consulta += " where " + where;
            PreparedStatement sql = this.getConexao()
                    .prepareStatement(consulta);
            ResultSet resultado = sql.executeQuery();
            List<Cliente> clientes = new ArrayList<>();
            while(resultado.next()) {
               Cliente cliente = new Cliente();
               cliente.setId( resultado.getInt("id"));
               cliente.setNome( resultado.getString("nome"));
               cliente.setCpf( resultado.getString("cpf"));
               cliente.setSexo( Sexo.valueOf(resultado.getString("sexo")));
               cliente.setRua(resultado.getString("rua"));
               cliente.setnCasa(resultado.getString("nCasa"));
               cliente.setBairro(resultado.getString("bairro"));
               cliente.setCidade(resultado.getString("cidade"));
               cliente.setStatus(Status.valueOf(resultado.getString("status")));               
               clientes.add(cliente);
            }
            return clientes;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
