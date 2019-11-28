/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.miniMundo.Persistence;

import br.edu.ifnmg.miniMundo.DomainModel.ErroValidacaoException;
import br.edu.ifnmg.miniMundo.DomainModel.Pessoa;
import br.edu.ifnmg.miniMundo.DomainModel.Sexo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Statement.RETURN_GENERATED_KEYS;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                    
                    atualizarTelefones(obj);
                    
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

                if(sql.executeUpdate() > 0){ 
                    atualizarTelefones(obj);
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
  
    public void atualizarTelefones(Pessoa pessoa) throws SQLException{
        try {
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("delete from telefonePessoa where pessoa_fk = ?");
       
            sql.setInt(1, pessoa.getId());     
            String values = "";

            for(String telefone : pessoa.getTelefones()){
                if(values.length() > 0) 
                    values += ", ";             
                values += "("+pessoa.getId()+",'"+telefone+"')";
            }
            
            Statement sql2 = this.getConexao().createStatement();
            sql2.executeUpdate("insert into telefonePessoa(pessoa_fk, telefone) VALUES " + values);
            
        } catch (SQLException ex) {
            Logger.getLogger(PessoaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                abrirTelefones(pessoa);
             }catch(SQLException ex) {
                pessoa = null;
             }
             return pessoa;         
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public void abrirTelefones(Pessoa obj){
        try {
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("select telefone from telefonePessoa where pessoa_fk = ?");
            sql.setInt(1, obj.getId());       
            ResultSet resultado = sql.executeQuery();         
            while(resultado.next()){
                obj.addTelefone(resultado.getString("telefone"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            if(filtro.getCpf() != null && !filtro.getCpf().isEmpty()&& 
                        !"000.000.000-00".equals(filtro.getCpf())){
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
               try{
                    pessoa.setId( resultado.getInt("id"));
                    pessoa.setNome( resultado.getString("nome"));
                    pessoa.setCpf( resultado.getString("cpf"));
                    pessoa.setSexo( Sexo.valueOf(resultado.getString("sexo")));
               }catch(Exception ex){
                    pessoa = null;
                }
               pessoas.add(pessoa);
            }
            return pessoas;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}