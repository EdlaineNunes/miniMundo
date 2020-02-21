/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.Persistence;

import br.edu.ifnmg.miniMundo.DomainModel.ListaItens;
import br.edu.ifnmg.miniMundo.DomainModel.VendaProduto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Edlâine
 */
public class VendaRepositorio extends BancoDados {
    public VendaRepositorio(){
        super();
    }
    
    public boolean Salvar(VendaProduto obj) throws SQLException{
        try{
            if(obj.getId() == 0){
                PreparedStatement sql = this.getConexao()
                        .prepareStatement("insert into Compras(funcionario_fk, cliente_fk,"
                                + "data,valor_total) values(?,?,?,?)",
                                Statement.RETURN_GENERATED_KEYS);
                sql.setInt(1, obj.getFunc().getId());
                sql.setInt(2, obj.getCliente().getId());
                sql.setDate(3, new java.sql.Date(obj.getData().getTime()));
                sql.setBigDecimal(4, obj.getPreco_final());
                
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
                                + "set funcionario_fk = ? set cliente_fk = ? where id =?");
                sql.setBigDecimal(1, obj.getPreco_final());
                sql.setDate(2, new java.sql.Date( obj.getData().getTime()));
                sql.setInt(3, obj.getFunc().getId());
                sql.setInt(4, obj.getCliente().getId());
                
                if(sql.executeUpdate() > 0)
                   return true;
                return false;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;    
    }
    
    public void ListagemItens(VendaProduto obj){

        try{
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("delete from itensVendidos where venda_fk = ?  ");
            sql.setInt(1, obj.getId());
            EstoqueRepositorio repo_estoque = new EstoqueRepositorio();
            String values = "";
            for(ListaItens item : obj.getItens()){
                if(values.length() > 0) 
                   values += ", ";
                values += "("+obj.getId()+","+item.getProduto().getId()+
                        ","+item.getQnt()+","+item.getTotal()+")";
                repo_estoque.SubtrairEstoque(item.getProduto().getId());
            }
            
            // id func cli data valor
            Statement sql_lista = this.getConexao().createStatement();
            sql_lista.executeUpdate("insert into itensVendidos(venda_fk, produto_fk,"
                    + "qnt, valor_compra) VALUES " + values);       
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
