/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.Persistence;

import br.edu.ifnmg.miniMundo.DomainModel.CompraProduto;
import br.edu.ifnmg.miniMundo.DomainModel.ListaItens;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Edlâine
 */
public class ComprasRepositorio extends BancoDados {
    
    public ComprasRepositorio(){
        super();
    }
    
    public boolean Salvar(CompraProduto obj) throws SQLException{
        try{
            if(obj.getId() == 0){
                PreparedStatement sql = this.getConexao()
                        .prepareStatement("insert into Compras(funcionario_fk, fornecedor_fk,"
                                + "valor_total, data) values(?,?,?,?)",
                                Statement.RETURN_GENERATED_KEYS);
                sql.setInt(1, obj.getFunc().getId());
                sql.setInt(2, obj.getFornec().getId());
                sql.setBigDecimal(3, obj.getPreco_final());
                sql.setDate(4, new java.sql.Date(obj.getData().getTime()));
               
                
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
                        .prepareStatement("update Compras set valor_total = ?, set data = ? "
                                + "where funcionario_fk = ? and fornecedor_fk = ?");
                sql.setBigDecimal(1, obj.getPreco_final());
                sql.setDate(2, new java.sql.Date( obj.getData().getTime()));
                sql.setInt(3, obj.getFunc().getId());
                sql.setInt(4, obj.getFornec().getId());
                
                if(sql.executeUpdate() > 0)
                   return true;
                return false;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;    
    }
    
    public void ListagemItens(CompraProduto obj){

        try{
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("delete from itensComprados where compra_fk = ? ");
            sql.setInt(1, obj.getId());
            EstoqueRepositorio repo_estoque = new EstoqueRepositorio();
            String values = "";
            for(ListaItens item : obj.getItens()){
                if(values.length() > 0) 
                   values += ", ";
                values += "("+obj.getId()+","+item.getProduto().getId()+
                        ","+item.getQnt()+","+item.getTotal()+")";
                repo_estoque.AumentarEstoque(item.getProduto().getId());
            }
            Statement sql_lista = this.getConexao().createStatement();
            sql_lista.executeUpdate("insert into itensComprados(compra_fk, produto_fk,"
                    + "qnt, valor_compra) VALUES " + values);       
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }
    
    
}
