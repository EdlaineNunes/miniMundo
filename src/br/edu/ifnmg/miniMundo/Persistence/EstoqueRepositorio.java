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
    
    public boolean SalvarEstoque(int id_produto, int id_fornecedor){

        try {  
            Estoque obj = new Estoque();
            
                PreparedStatement sql = this.getConexao()
                        .prepareStatement("insert into Estoque(produto_fk, "
                                + "produto_fornecedor_fk,data) values(?, ?,?)",
                                Statement.RETURN_GENERATED_KEYS);
                
                sql.setInt(1, id_produto);
                sql.setInt(2, id_fornecedor);
                sql.setDate(3, new java.sql.Date(obj.getData().getTime()));
                
                if(sql.executeUpdate() > 0){
                    ResultSet chave = sql.getGeneratedKeys();
                    chave.next();
                    obj.setId(chave.getInt(1));
                    return true;
                }
                else
                    return false;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }      
        return false;     
    }
    
    public boolean Modificar(int id_produto, int id_fornecedor){
    try {  
            
        Estoque obj = new Estoque();
            PreparedStatement sql0 = this.getConexao()
                    .prepareStatement("delete from Estoque where produto_fk = ? ");
       
            sql0.setInt(1, id_produto);   
            
                PreparedStatement sql = this.getConexao()
                        .prepareStatement("insert into Estoque (produto_fk, "
                                + "produto_fornecedor_fk, data) VALUES (?,?,?)",
                                Statement.RETURN_GENERATED_KEYS);
               
                sql.setInt(1, id_produto);
                sql.setInt(2, id_fornecedor);
                sql.setDate(3, new java.sql.Date(obj.getData().getTime()));
                
                if(sql.executeUpdate() > 0){
                    ResultSet chave = sql.getGeneratedKeys();
                    chave.next();
                    obj.setId(chave.getInt(1));
                    return true;
                }
                else
                    return false;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }      
        return false; 
    }

    public Estoque Abrir(int id) throws ErroValidacaoException{
        try {     
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("select * from Estoque where produto_fk = ?");   
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            resultado.next();
            Estoque estoque = new Estoque();   
            try{
               estoque.setId( resultado.getInt("produto_fk"));
               
               FornecedorRepositorio fornecedor_repo = new FornecedorRepositorio();
               Fornecedor fornecedor = fornecedor_repo.Abrir(resultado.getInt("produto_fornecedor_fk"));
               estoque.setFornecedor(fornecedor);
               
               estoque.setData(resultado.getDate("data"));
              
               
            }catch(SQLException ex) {
               estoque = null;
            }
            return estoque;         
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public boolean Desativar(int produto_fk){
        try {
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("update Produto set status = 'Inativo' where id = ?");          
            sql.setInt(1, produto_fk);          
            if(sql.executeUpdate() > 0)
                return true;
            else
                return false;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean Ativar(int produto_fk){
        try {
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("update Produto set status = 'Ativo' where id = ?");          
            sql.setInt(1, produto_fk);          
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
            if(filtro != null){
                if(filtro.getDescricao() != null && !filtro.getDescricao().isEmpty())
                    where += "descrição like '%"+filtro.getDescricao() + "'%";
                if(filtro.getFornecedor() != null){
                    if(where.length() > 0)
                        where += " and ";
                    where += "fornecedor_fk = " + filtro.getFornecedor().getId();
                }
                if(filtro.getUnidCompra() != null){
                    if(where.length() > 0)
                        where += " and ";
                    where += "unidCompra = '"+filtro.getUnidCompra() + "'";
                }
                if(filtro.getUnidVenda() != null){
                    if(where.length() > 0)
                        where += " and ";
                    where += "unidVenda = '"+filtro.getUnidCompra() + "'";   
                }
                if(filtro.getStatus() != null ){
                    if(where.length() > 0)
                        where += " and ";
                    where += "status = '"+filtro.getStatus().name() +"'";
                }
            }
                             
            String consulta = "select * from Produto";
            if(where.length() > 0 )
               consulta += " where " + where;
            else
                consulta += "order by descricao";
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
                    produto.setUnidCompra(UnidadesCompra.valueOf( resultado.getString("unidCompra") ));
                    produto.setUnidVenda(UnidadesVenda.valueOf( resultado.getString("unidVenda") ));
                    produto.setPrecoVenda( resultado.getBigDecimal("precoVenda"));
                    produto.setPrecoCompra( resultado.getBigDecimal("precoCompra"));
                    produto.setUnidComprada( resultado.getInt("unidComprada"));
                    produto.setStatus(Status.valueOf(resultado.getString("status")));
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
