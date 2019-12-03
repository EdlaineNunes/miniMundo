/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.DomainModel;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Edlâine
 */
public class Produto {
    private int id;
    private String descricao;
    Fornecedor fornecedor; //classe já existente
    private UnidadesCompra unidCompra;
    private UnidadesVenda unidVenda;
    private BigDecimal precoCompra;
    private BigDecimal precoVenda;
    private int unidComprada;
    private Status status;

     // no banco de dados ao inves de float utilizar numeric (8,2)
    //no java utilizar BigDecimal
    
    public Produto() {
        this.id = 0;
        this.descricao = "";
        this.fornecedor = new Fornecedor();
        this.unidCompra = UnidadesCompra.Caixa;
        this.unidVenda = UnidadesVenda.Unidade;
        this.precoCompra =  new BigDecimal("0,0");
        this.precoVenda = new BigDecimal("0,0");
        this.unidComprada = 0;
        this.status = Status.Ativo;
    }

    public Produto(int id, String descricao, Fornecedor forncedor, UnidadesCompra unidCompra, 
            UnidadesVenda unidVenda, BigDecimal precoCompra, BigDecimal precoVenda, int unidEstoque) {
        this.id = id;
        this.descricao = descricao;
        this.fornecedor = new Fornecedor();
        this.unidCompra = unidCompra;
        this.unidVenda = unidVenda;
        this.precoCompra = new BigDecimal("precoCompra");
        this.precoVenda = new BigDecimal("precoVenda");
        this.unidComprada = unidEstoque;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
       try{
            if(id > 0)
                this.id = id;
        }
        catch(Exception ex){
            System.out.println("Aconteceu um erro: " + ex.getMessage());
        } 
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) throws ErroValidacaoException {
        if(descricao.length() < 5)
            throw new ErroValidacaoException("A descrição deve conter mais de 4 caracteres!");
        this.descricao = descricao;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public UnidadesCompra getUnidCompra() {
        return unidCompra;
    }

    public void setUnidCompra(UnidadesCompra unidCompra) {
        this.unidCompra = unidCompra;
    }

    public UnidadesVenda getUnidVenda() {
        return unidVenda;
    }

    public void setUnidVenda(UnidadesVenda unidVenda) {
        this.unidVenda = unidVenda;
    }

    public BigDecimal getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(BigDecimal precoCompra) throws ErroValidacaoException {
        if(precoCompra.intValue() <= 0)
            throw new ErroValidacaoException("Preço de compra INVÁLIDO!");
        this.precoCompra = precoCompra;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) throws ErroValidacaoException {
        if(precoVenda.intValue() <= 0)
          throw new ErroValidacaoException("Preço de venda INVÁLIDO!");  
        this.precoVenda = precoVenda;
       
    }

    public int getUnidComprada() {
        return unidComprada;
    }

    public void setUnidComprada(int unidComprada) {
        if(unidComprada > 0 )
            this.unidComprada += unidComprada;
        this.unidComprada = unidComprada;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.descricao);
        hash = 79 * hash + Objects.hashCode(this.fornecedor);
        hash = 79 * hash + Objects.hashCode(this.unidCompra);
        hash = 79 * hash + Objects.hashCode(this.unidVenda);
        hash = 79 * hash + Objects.hashCode(this.status);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.fornecedor, other.fornecedor)) {
            return false;
        }
        if (this.unidCompra != other.unidCompra) {
            return false;
        }
        if (this.unidVenda != other.unidVenda) {
            return false;
        }
        if (!Objects.equals(this.precoCompra, other.precoCompra)) {
            return false;
        }
        if (!Objects.equals(this.precoVenda, other.precoVenda)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", descricao=" + descricao + ", fornecedor="
                + fornecedor + ", unidCompra=" + unidCompra + ", unidVenda=" + 
                unidVenda + ", precoCompra=" + precoCompra + ", precoVenda=" + 
                precoVenda + ", unidComprada=" + unidComprada + ", status=" + status + '}';
    }
    
}