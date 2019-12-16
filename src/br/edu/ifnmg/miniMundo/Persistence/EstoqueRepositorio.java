/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.Persistence;

import br.edu.ifnmg.miniMundo.DomainModel.ErroValidacaoException;
import br.edu.ifnmg.miniMundo.DomainModel.Estoque;
import br.edu.ifnmg.miniMundo.DomainModel.Fornecedor;
import br.edu.ifnmg.miniMundo.DomainModel.Produto;
import br.edu.ifnmg.miniMundo.DomainModel.Status;
import br.edu.ifnmg.miniMundo.DomainModel.UnidadesCompra;
import br.edu.ifnmg.miniMundo.DomainModel.UnidadesVenda;
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
public class EstoqueRepositorio extends ProdutoRepositorio {
    
    public EstoqueRepositorio(){
        super();
    }
    
    public boolean AumentarEstoque(int id_produto) throws ErroValidacaoException{
        Produto obj = super.Abrir(id_produto);
        try {              
            PreparedStatement sql = this.getConexao()
                .prepareStatement("select * from Estoque where produto_fk = ?");
                
                sql.setInt(1, id_produto);
                
                ResultSet result = sql.executeQuery();
                result.next();
                int compra = result.getInt("qnt");
                Statement sql1 = this.getConexao().createStatement();
                String consulta= "";
                consulta = "update estoque set qnt = "+ (obj.getUnidComprada()+compra) +
                        " where produto_fk = "+ (obj.getId());
                if(sql1.executeUpdate(consulta)> 0)
                    return true;
                return false;
              
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }      
        return false;     
    }
    
    public boolean SubtrairEstoque(int id_produto) throws ErroValidacaoException{
        Produto obj = super.Abrir(id_produto);
        try {              
            PreparedStatement sql = this.getConexao()
                .prepareStatement("select * from Estoque where produto_fk = ?");
                
                sql.setInt(1, id_produto);
                
                ResultSet result = sql.executeQuery();
                result.next();
                int venda = result.getInt("qnt");
                if( venda <= obj.getUnidComprada()){
                    Statement sql1 = this.getConexao().createStatement();
                    String consulta= "";
                    consulta = "update estoque set qnt = "+ (obj.getUnidComprada() - venda) +
                            " where produto_fk = "+ (obj.getId());
                    if(sql1.executeUpdate(consulta)> 0)
                        return true;
                    return false;
                }
                else 
                    return false;              
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }      
        return false;     
    }
    
    public boolean SalvarEstoque(int id_produto, int op) throws ErroValidacaoException{
        Produto obj = super.Abrir(id_produto);
        Estoque estoque = new Estoque();
        try {     
            if(op == 0){
                PreparedStatement sql = this.getConexao()
                        .prepareStatement("insert into estoque"
                                + "(produto_fk, qnt, data) value (?,?,?)");

                sql.setInt(1, obj.getId()); 
                sql.setInt(2, obj.getUnidComprada() );
                sql.setDate(3, new java.sql.Date(estoque.getData().getTime()));
                if(sql.executeUpdate() > 0)
                    return true;
                return false; 
            }
            else{
                PreparedStatement sql = this.getConexao()
                        .prepareStatement("update estoque set qnt = ? "
                                + "where produto_fk = ?"); 
                sql.setInt(1, obj.getUnidComprada() );
                sql.setInt(2, obj.getId());
                if(sql.executeUpdate() > 0)
                    return true;
                return false; 
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }      
        return false; 
    }
       
}
