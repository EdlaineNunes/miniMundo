/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.Persistence;

import br.edu.ifnmg.miniMundo.DomainModel.Estoque;
import br.edu.ifnmg.miniMundo.DomainModel.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
                        .prepareStatement("insert into Estoque(produto_fk, produto_fornecedor_fk,data) values(?, ?,?)",
                                Statement.RETURN_GENERATED_KEYS);
                
                sql.setInt(1, id_produto);
                sql.setInt(2, id_fornecedor);
               // sql.setInt(1, obj.getId());
              //  sql.setInt(2, obj.getFornecedor().getId());
                sql.setDate(3, new java.sql.Date(obj.getData().getTime()));
                
                if(sql.executeUpdate() > 0){ 
                    return true;
                }
                else
                    return false;
             /*else {
                PreparedStatement sql = this.getConexao()
                        .prepareStatement("update Estoque set descricao = ?, fornecedor_fk = ?, unidCompra = ?,"
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
                
                if(sql.executeUpdate() > 0) 
                    return true;
                else
                    return false;
            }
            */
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }      
        return false;     
    }
/*
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
    */  
}
