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
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edlâine
 */
public class ProdutoRepositorio extends BancoDados{
    
    public ProdutoRepositorio(){
        super();
        
    }
    
    public boolean Salvar(Produto obj) throws ErroValidacaoException{
        try {  
            if(obj.getId() == 0){
                PreparedStatement sql = this.getConexao()
                        .prepareStatement("insert into Produto(descricao, fornecedor_fk, unidCompra, unidVenda, "
                                + "precoVenda, precoCompra, unidComprada,status)"
                                + " values(?,?,?,?,?,?,?,?)",
                                Statement.RETURN_GENERATED_KEYS);
                sql.setString(1, obj.getDescricao());
                sql.setInt(2, obj.getFornecedor().getId());
                sql.setString(3, obj.getUnidCompra().name());
                sql.setString(4, obj.getUnidVenda().name());
                sql.setFloat(5, obj.getPrecoVenda().floatValue());
                sql.setFloat(6, obj.getPrecoCompra().floatValue());
                sql.setInt(7, obj.getUnidComprada());
                sql.setString(8, obj.getStatus().name());
                
                if(sql.executeUpdate() > 0){ 
                    ResultSet chave = sql.getGeneratedKeys();
                    chave.next();
                    obj.setId(chave.getInt(1));
                    EstoqueRepositorio repo_estoque = new EstoqueRepositorio();
                    repo_estoque.SalvarEstoque(obj.getId(),0);
                    return true;
                }
                else
                    return false;
            } else {
                PreparedStatement sql = this.getConexao()
                        .prepareStatement("update Produto set descricao = ?, fornecedor_fk = ?, unidCompra = ?,"
                                + "unidVenda = ?, precoVenda = ?, precoCompra = ?,unidComprada = ?, "
                                + " status = ? where id = ?");
                sql.setString(1, obj.getDescricao());
                sql.setInt(2, obj.getFornecedor().getId());
                sql.setString(3, obj.getUnidCompra().name());
                sql.setString(4, obj.getUnidVenda().name());
                sql.setFloat(5, obj.getPrecoVenda().floatValue());
                sql.setFloat(6, obj.getPrecoCompra().floatValue());
                sql.setInt(7, obj.getUnidComprada());
                sql.setString(8, obj.getStatus().name());
                sql.setInt(9, obj.getId());
                
                if(sql.executeUpdate() > 0){
                    EstoqueRepositorio repo_estoque = new EstoqueRepositorio();
                    repo_estoque.SalvarEstoque(obj.getId(),1);
                    return true;
                }else
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
               Fornecedor fornecedor = fornecedor_repo.Abrir(resultado.getInt("fornecedor_fk"));
               produto.setFornecedor(fornecedor);
               
               produto.setUnidCompra(UnidadesCompra.valueOf(resultado.getString("unidCompra")));
               produto.setUnidVenda(UnidadesVenda.valueOf(resultado.getString("unidVenda")));
               produto.setPrecoVenda(resultado.getBigDecimal("precoVenda"));
               produto.setPrecoCompra(resultado.getBigDecimal("precoCompra"));
               produto.setUnidComprada(resultado.getInt("unidComprada"));
               produto.setStatus(Status.valueOf(resultado.getString("status")));
               
            }catch(SQLException ex) {
               produto = null;
            }
            return produto;         
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public Produto AbrirProduto(Produto filtro) throws ErroValidacaoException, SQLException{
        PreparedStatement sql = this.getConexao()
                .prepareStatement("select * from Produto where id = ?");
        sql.setInt(1, filtro.getId());
        
        ResultSet resultado = sql.executeQuery();
             
        Produto produto = new Produto();
        FornecedorRepositorio fornecedor_repo = new FornecedorRepositorio();
       
        if(resultado.next()){
                    
            produto.setId( resultado.getInt("id"));
            produto.setDescricao( resultado.getString("descricao"));
            produto.setFornecedor(fornecedor_repo.Abrir(resultado.getInt("fornecedor_fk")));
            produto.setUnidCompra(UnidadesCompra.valueOf( resultado.getString("unidCompra") ));
            produto.setUnidVenda(UnidadesVenda.valueOf( resultado.getString("unidVenda") ));
            produto.setPrecoVenda( resultado.getBigDecimal("precoVenda"));
            produto.setPrecoCompra( resultado.getBigDecimal("precoCompra"));
            produto.setUnidComprada( resultado.getInt("unidComprada"));
            produto.setStatus(Status.valueOf(resultado.getString("status")));
            
            return produto;
        }
        else
            produto = null;
        return produto;
    }

    public boolean Desativar(int id){
        try {
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("update Produto set status = 'Inativo' where id = ?");
            
            sql.setInt(1, id);          
            if(sql.executeUpdate() > 0)
                return true;
            return false;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean Ativar(int id){
        try {
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("update Produto set status = 'Ativo' where id = ?");
            
            sql.setInt(1, id);          
            if(sql.executeUpdate() > 0)
                return true;
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
                    where += "descricao like '%"+filtro.getDescricao() + "'%";
                if(filtro.getFornecedor() != null){
                    if(where.length() > 0)
                        where += " and ";
                    where += "fornecedor_fk = " + filtro.getFornecedor().getId();
                }
                if(filtro.getUnidCompra() != null){
                    if(where.length() > 0)
                        where += " and ";
                    where += "unidCompra = '"+filtro.getUnidCompra().name() + "'";
                }
                if(filtro.getUnidVenda() != null){
                    if(where.length() > 0)
                        where += " and ";
                    where += "unidVenda = '"+filtro.getUnidCompra().name() + "'";   
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
    
    public List<Produto> BuscarTodos(Produto filtro){

        try {
            String where = "";
            if(filtro != null){
                if(filtro.getStatus() != null ){
                    where += "status = '"+filtro.getStatus().name() +"'";
                }
            }
                             
            String consulta = "select * from Produto";
            if(where.length() > 0 )
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
    
    public boolean BuscarDesc(Produto filtro) throws SQLException{

        try {
            String where = "";
            if(filtro != null){
                if(filtro.getDescricao() != null && !filtro.getDescricao().isEmpty())
                    where += "descricao like '%"+filtro.getDescricao() + "'%";
                
            }   
                
            String consulta = "select * from Produto";
            if(where.length() > 0 )
               consulta += " where " + where;
            
            PreparedStatement sql = this.getConexao()
                    .prepareStatement(consulta);
            ResultSet resultado = sql.executeQuery();
            Produto produto = new Produto();
            FornecedorRepositorio fornecedor_repo = new FornecedorRepositorio();
            resultado.next();
                    
            try {
                produto.setId( resultado.getInt("id"));
                produto.setDescricao( resultado.getString("descricao"));
                produto.setFornecedor(fornecedor_repo.Abrir(resultado.getInt("fornecedor_fk")));
                produto.setUnidCompra(UnidadesCompra.valueOf( resultado.getString("unidCompra") ));
                produto.setUnidVenda(UnidadesVenda.valueOf( resultado.getString("unidVenda") ));
                produto.setPrecoVenda( resultado.getBigDecimal("precoVenda"));
                produto.setPrecoCompra( resultado.getBigDecimal("precoCompra"));
                produto.setUnidComprada( resultado.getInt("unidComprada"));
                produto.setStatus(Status.valueOf(resultado.getString("status")));
            
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
            } catch(ErroValidacaoException ex) {
                System.out.println(ex.getMessage());
            }
        return false;
    }
    
    public Produto PreencheProduto(Produto filtro) throws SQLException{

        try {
            String where = "";
            if(filtro != null){
                if(filtro.getId() > 0)
                    where += "id = '"+filtro.getId()+"'";
                if(filtro.getDescricao() != null && !filtro.getDescricao().isEmpty()){
                    if(where.length() > 0)
                        where += " and ";
                    where += "descricao like '%"+filtro.getDescricao() + "'%";
                }
            }   
                
            String consulta = "select * from Produto";
            if(where.length() > 0 )
               consulta += " where " + where;
            
            PreparedStatement sql = this.getConexao()
                    .prepareStatement(consulta);
            ResultSet resultado = sql.executeQuery();
            Produto produto = new Produto();
            FornecedorRepositorio fornecedor_repo = new FornecedorRepositorio();
            resultado.next();
                    
            try {
                produto.setId( resultado.getInt("id"));
                produto.setDescricao( resultado.getString("descricao"));
                produto.setFornecedor(fornecedor_repo.Abrir(resultado.getInt("fornecedor_fk")));
                produto.setUnidCompra(UnidadesCompra.valueOf( resultado.getString("unidCompra") ));
                produto.setUnidVenda(UnidadesVenda.valueOf( resultado.getString("unidVenda") ));
                produto.setPrecoVenda( resultado.getBigDecimal("precoVenda"));
                produto.setPrecoCompra( resultado.getBigDecimal("precoCompra"));
                produto.setUnidComprada( resultado.getInt("unidComprada"));
                produto.setStatus(Status.valueOf(resultado.getString("status")));
            
                return produto;
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
            } catch(ErroValidacaoException ex) {
                System.out.println(ex.getMessage());
            }
        return null;
    }
    
    public int ChecarStatus(int id_produto){

        try {     
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("select status from Produto where id = ?");   
            sql.setInt(1, id_produto);
            ResultSet resultado = sql.executeQuery();
            resultado.next();
            Produto produto = new Produto();   
            //ativo 1, inativo 0
            if(produto.getStatus().toString() == "Ativo")
                return 1;
            return 0;         
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
}
