/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.Persistence;

import br.edu.ifnmg.miniMundo.DomainModel.ErroValidacaoException;
import br.edu.ifnmg.miniMundo.DomainModel.Fornecedor;
import br.edu.ifnmg.miniMundo.DomainModel.Produto;
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
public class ProdutoRepositorio extends BancoDados{
    
    public ProdutoRepositorio(){
        super();
    }
    
    public boolean Salvar(Produto obj){
        try {  
            if(obj.getId() == 0){
                PreparedStatement sql = this.getConexao()
                        .prepareStatement("insert into Produto(descricao, fornecedor_fk,unidCompra, unidVenda, "
                                + "precoCompra, precoVenda, status, unidComprada)"
                                + " values(?,?,?,?,?,?,?,?)",
                                Statement.RETURN_GENERATED_KEYS);
                sql.setString(1, obj.getDescricao());
                sql.setInt(2, obj.getFornecedor().getId());
                sql.setString(3, obj.getUnidCompra());
                sql.setString(4, obj.getUnidVenda());
                sql.setFloat(5, obj.getPrecoCompra());
                sql.setFloat(6, obj.getPrecoVenda());
                sql.setString(7, obj.getStatus().name());
                sql.setInt(8, obj.getUnidComprada());
                
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
                        .prepareStatement("update Produto set descricao = ?, fornecedor_fk = ?, unidCompra = ?,"
                                + "unidVenda = ?, precoCompra = ?, precoVenda = ?, status = ?,"
                                + " unidComprada = ? where id = ?");
                sql.setString(1, obj.getDescricao());
                sql.setInt(2, obj.getFornecedor().getId());
                sql.setString(3, obj.getUnidCompra());
                sql.setString(4, obj.getUnidVenda());
                sql.setFloat(5, obj.getPrecoCompra());
                sql.setFloat(6, obj.getPrecoVenda());
                sql.setString(7, obj.getStatus().name());
                sql.setInt(8, obj.getUnidComprada());
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

    public Produto Abrir(int id) throws ErroValidacaoException{
        try {     
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("select * from Produto where id = ?");   
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            resultado.next();
            Produto produto = new Produto();   
            try{
               produto.setId( resultado.getInt("id"));
               produto.setDescricao( resultado.getString("descricao"));
               
               FornecedorRepositorio fornecedor_repo = new FornecedorRepositorio();
               Fornecedor fornecedor = fornecedor_repo.Abrir(resultado.getInt("fornecedor_id"));
               produto.setFornecedor(fornecedor);
               
               produto.setUnidCompra( resultado.getString("unidCompra"));
               produto.setUnidVenda(resultado.getString("unidVenda"));
               produto.setPrecoCompra(resultado.getFloat("precoCompra"));
               produto.setPrecoVenda(resultado.getFloat("precoVenda"));
               produto.setStatus(Status.valueOf(resultado.getString("status")));
               produto.setUnidComprada(resultado.getInt("unidComprada"));
               
            }catch(SQLException ex) {
               produto = null;
            }
            return produto;         
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public boolean Desativar(Produto obj){
        try {
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("update Produto set status = 'Inativo' where id = ?");          
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

    public List<Produto> Buscar(Produto filtro){

        try {
            String where = "";
            if(filtro.getDescricao() != null && !filtro.getDescricao().isEmpty())
                where += "descrição like '%"+filtro.getDescricao() + "'%";
            if(filtro.getFornecedor() != null){
                if(where.length() > 0)
                    where += " and ";
                where += "fornecedor_id = " + filtro.getFornecedor().getId();
            }
            if(filtro.getUnidCompra() != null && !filtro.getUnidCompra().isEmpty()){
                if(where.length() > 0)
                    where += " and ";
                where += "unidCompra = '"+filtro.getUnidCompra() + "'";
            }
            if(filtro.getUnidVenda() != null && !filtro.getUnidVenda().isEmpty()){
                if(where.length() > 0)
                    where += " and ";
                where += "unidVenda = '"+filtro.getUnidCompra() + "'";   
            }
            if(filtro.getPrecoCompra() > 0){
                if(where.length() > 0)
                    where += " and ";
                where += "precoCompra = '"+filtro.getPrecoCompra() + "'";
            }
            if(filtro.getPrecoVenda() > 0){
                if(where.length() > 0)
                    where += " and ";
                where += "precoVenda = '"+filtro.getPrecoVenda() + "'";   
            }
            if(filtro.getStatus() != null ){
                if(where.length() > 0)
                    where += " and ";
                where += "status = '"+filtro.getStatus().name() +"'";
            }
            if(filtro.getUnidComprada() > 0){
                if(where.length() > 0)
                    where += " and ";
                where += "unidComprada = '"+filtro.getUnidCompra() + "'";   
            }
                             
            String consulta = "select * from Produto";
            if(where.length() >0 )
               consulta += " where " + where;
            PreparedStatement sql = this.getConexao()
                    .prepareStatement(consulta);
            ResultSet resultado = sql.executeQuery();
             
            List<Produto> produtos = new ArrayList<>();
            FornecedorRepositorio fornecedor_repo = new FornecedorRepositorio();
            
            try{
                while(resultado.next()) {
                    Produto produto = new Produto();
                    produto.setId( resultado.getInt("id"));
                    produto.setDescricao( resultado.getString("descricao"));
                    produto.setFornecedor(fornecedor_repo.Abrir(resultado.getInt("fornecedor_fk")));
                    produto.setUnidCompra( resultado.getString("unidCompra"));
                    produto.setUnidVenda( resultado.getString("unidVenda"));
                    produto.setPrecoCompra( resultado.getFloat("precoCompra"));
                    produto.setPrecoVenda( resultado.getFloat("precoVenda"));
                    produto.setUnidComprada( resultado.getInt("unidComprada"));
                    produtos.add(produto);
            }
            return produtos;
            } catch(ErroValidacaoException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
