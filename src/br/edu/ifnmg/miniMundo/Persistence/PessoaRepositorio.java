/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.miniMundo.Persistence;

import br.edu.ifnmg.miniMundo.DomainModel.ErroValidacaoException;
import br.edu.ifnmg.miniMundo.DomainModel.Pessoa;
import br.edu.ifnmg.miniMundo.DomainModel.Sexo;
import br.edu.ifnmg.miniMundo.DomainModel.Status;
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

public class PessoaRepositorio extends BancoDados {
    public PessoaRepositorio(){
        super();
    }

    public boolean Salvar(Pessoa obj){
        try {  
            if(obj.getId() == 0){
                PreparedStatement sql = this.getConexao()
                        .prepareStatement("insert into Pessoa(nome, cpf,sexo) values(?,?,?)",
                                Statement.RETURN_GENERATED_KEYS);

                sql.setString(1, obj.getNome());
                sql.setString(2, obj.getCpf().replace(".", "").replace("-", ""));
                sql.setString(3, obj.getSexo().name());
              
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
                        .prepareStatement("update Pessoa set nome = ?, cpf = ? where id = ?");
              
                sql.setString(1, obj.getNome());
                sql.setString(2, obj.getCpf().replace(".", "").replace("-", ""));
                sql.setString(3, obj.getSexo().name());
                sql.setInt(4, obj.getId());

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

    public Pessoa Abrir(int id) throws ErroValidacaoException{
        try {     
             PreparedStatement sql = this.getConexao()
                     .prepareStatement("select * from Pessoa where id = ?");   

             sql.setInt(1, id);
             ResultSet resultado = sql.executeQuery();
             resultado.next();
             Pessoa pessoa = new Pessoa();   
             try{
                pessoa.setId( resultado.getInt("id"));
                pessoa.setNome( resultado.getString("nome"));
                pessoa.setCpf( resultado.getString("cpf"));
                pessoa.setSexo( Sexo.valueOf(resultado.getString("sexo")));
             }catch(SQLException ex) {
                pessoa = null;
             }
             return pessoa;         
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
/*
    public boolean Desativar(Pessoa obj){
        try {
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("update Pessoa set status = 'Inativo' where id = ?");          
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
*/
    public List<Pessoa> Buscar(Pessoa filtro) throws ErroValidacaoException{
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
                     
            String consulta = "select * from Pessoa";

            if(where.length() >0 )
                consulta += " where " + where;
            
             PreparedStatement sql = this.getConexao()
                     .prepareStatement(consulta);

             ResultSet resultado = sql.executeQuery();
             List<Pessoa> pessoas = new ArrayList<>();
             while(resultado.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId( resultado.getInt("id"));
                pessoa.setNome( resultado.getString("nome"));
                pessoa.setCpf( resultado.getString("cpf"));
                pessoa.setSexo( Sexo.valueOf(resultado.getString("sexo")));
  
                pessoas.add(pessoa);
             }
             return pessoas;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}