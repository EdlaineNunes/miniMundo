/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.Persistence;

import br.edu.ifnmg.miniMundo.DomainModel.ErroValidacaoException;
import br.edu.ifnmg.miniMundo.DomainModel.Status;
import br.edu.ifnmg.miniMundo.DomainModel.Funcionario;
import br.edu.ifnmg.miniMundo.DomainModel.Pessoa;
import br.edu.ifnmg.miniMundo.DomainModel.Sexo;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edlâine
 */
public class FuncionarioRepositorio extends PessoaRepositorio{
    public FuncionarioRepositorio(){
        super();
    }
    
    public boolean Salvar(Funcionario obj){
        super.Salvar((Pessoa) obj);
        try {  
            if(obj.getId() != 0){
                PreparedStatement sql = this.getConexao()
                        .prepareStatement("insert into Funcionario(pessoa_fk, user, senha,status)"
                                + " values(?,?,?,?)");
                               // Statement.RETURN_GENERATED_KEYS);
                sql.setInt(1, obj.getId());
                sql.setString(2, obj.getUser());
                sql.setString(3, obj.getSenha());
                sql.setString(4, obj.getStatus().name());
                
                sql.executeUpdate();
                return true;
            } else {
                PreparedStatement sql = this.getConexao()
                        .prepareStatement("update Funcionario set user = ?, "
                                + "senha = ?, status = ? where pessoa_fk = ?");
                
                sql.setString(1, obj.getUser());
                sql.setString(2, obj.getSenha());
                sql.setString(3, obj.getStatus().name());
                sql.setInt(4, obj.getId());
                
                sql.executeUpdate();
                return true;
            }                   
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }      
        return false;     
    }

    public Funcionario Abrir(Funcionario obj) throws ErroValidacaoException{
        try {     
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("select * from Funcionario where pessoa_fk = ?");   
            sql.setInt(1, obj.getId());
            ResultSet resultado = sql.executeQuery();
            resultado.next();
            Funcionario funcionario = new Funcionario();   
            try{
               funcionario.setId( resultado.getInt("pessoa_fk"));
               funcionario.setNome( resultado.getString("nome"));
               funcionario.setCpf( resultado.getString("cpf"));
               funcionario.setSexo( Sexo.valueOf(resultado.getString("sexo")));
               funcionario.setUser(resultado.getString("user"));
               funcionario.setSenha(resultado.getString("senha"));
               funcionario.setStatus(Status.valueOf(resultado.getString("status")));
               
            }catch(SQLException ex) {
               funcionario = null;
            }
            return funcionario;         
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public boolean Desativar(Funcionario obj){
        try {
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("update Funcionario set status = 'Inativo' where pessoa_fk = ?");          
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

    public List<Funcionario> Buscar(Funcionario filtro) throws ErroValidacaoException{
        try {
            String where = "";
            if(filtro.getId() !=  0)
                where += "pessoa_fk = '"+filtro.getId() + "'";
            if(filtro.getNome() != null && !filtro.getNome().isEmpty())
                where += "nome like '%"+filtro.getNome() + "%'";            
            if(filtro.getUser() != null && !filtro.getUser().isEmpty()){
                if(where.length() > 0)
                    where += " and ";
                where += "bairro like '%"+filtro.getUser() + "%'";
            }                 
            if(filtro.getStatus() != null ){
                if(where.length() > 0)
                    where += " and ";
                where += "status = '"+filtro.getStatus().name() +"'";
            }
            
            String consulta = "select * from Funcionario";
            if(where.length() >0 )
                consulta += " where " + where;
            PreparedStatement sql = this.getConexao()
                    .prepareStatement(consulta);
            ResultSet resultado = sql.executeQuery();
            List<Funcionario> funcionarios = new ArrayList<>();
            while(resultado.next()) {
               Funcionario funcionario = new Funcionario();
               funcionario.setId( resultado.getInt("pessoa_fk"));
               funcionario.setUser(resultado.getString("user"));
               funcionario.setSenha(resultado.getString("senha"));
               funcionario.setStatus(Status.valueOf(resultado.getString("status")));               
               funcionarios.add(funcionario);
            }
            return funcionarios;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
