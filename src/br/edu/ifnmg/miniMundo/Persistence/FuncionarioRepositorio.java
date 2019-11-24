/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.Persistence;

import br.edu.ifnmg.miniMundo.DomainModel.ErroValidacaoException;
import br.edu.ifnmg.miniMundo.DomainModel.Estado;
import br.edu.ifnmg.miniMundo.DomainModel.Funcionario;
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
public class FuncionarioRepositorio extends BancoDados{
    public FuncionarioRepositorio(){
        super();
    }
    
    public boolean Salvar(Funcionario obj){
        try {  
            if(obj.getId() == 0){
                PreparedStatement sql = this.getConexao()
                        .prepareStatement("insert into Funcionario(nome, cpf, sexo, user, senha,status)"
                                + " values(?,?,?,?,?,?)",
                                Statement.RETURN_GENERATED_KEYS);
                sql.setString(1, obj.getNome());
                sql.setString(2, obj.getCpf().replace(".", "").replace("-", ""));
                sql.setString(3, obj.getSexo().name());
                sql.setString(4, obj.getUser());
                sql.setString(5, obj.getSenha());
                sql.setString(6, obj.getStatus().name());
                               
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
                        .prepareStatement("update Funcionario set nome = ?, cpf = ?, "
                                + "sexo = ?, user = ?, senha = ?, status = ? where id = ?");
                sql.setString(1, obj.getNome());
                sql.setString(2, obj.getCpf().replace(".", "").replace("-", ""));
                sql.setString(3, obj.getSexo().name());
                sql.setString(4, obj.getUser());
                sql.setString(5, obj.getSenha());
                sql.setString(6, obj.getStatus().name());
                sql.setInt(7, obj.getId());
                
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

    public Funcionario Abrir(int id) throws ErroValidacaoException{
        try {     
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("select * from Funcionario where id = ?");   
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            resultado.next();
            Funcionario funcionario = new Funcionario();   
            try{
               funcionario.setId( resultado.getInt("id"));
               funcionario.setNome( resultado.getString("nome"));
               funcionario.setCpf( resultado.getString("cpf"));
               funcionario.setSexo( Sexo.valueOf(resultado.getString("sexo")));
               funcionario.setUser(resultado.getString("user"));
               funcionario.setSenha(resultado.getString("senha"));
               funcionario.setStatus(Estado.valueOf(resultado.getString("status")));
               
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
                    .prepareStatement("update Funcionario set status = 'Inativo' where id = ?");          
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
            String consulta = "select * from Funcionario";
            if(where.length() >0 )
                consulta += " where " + where;
            PreparedStatement sql = this.getConexao()
                    .prepareStatement(consulta);
            ResultSet resultado = sql.executeQuery();
            List<Funcionario> funcionarios = new ArrayList<>();
            while(resultado.next()) {
               Funcionario funcionario = new Funcionario();
               funcionario.setId( resultado.getInt("id"));
               funcionario.setNome( resultado.getString("nome"));
               funcionario.setCpf( resultado.getString("cpf"));
               funcionario.setSexo( Sexo.valueOf(resultado.getString("sexo")));
               funcionario.setUser(resultado.getString("user"));
               funcionario.setSenha(resultado.getString("senha"));
               funcionario.setStatus(Estado.valueOf(resultado.getString("status")));               
               funcionarios.add(funcionario);
            }
            return funcionarios;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
