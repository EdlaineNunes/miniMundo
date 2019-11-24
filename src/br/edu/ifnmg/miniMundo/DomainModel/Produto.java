/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.DomainModel;

import java.util.Objects;

/**
 *
 * @author Edlâine
 */
public class Produto {
    private int id;
    private String descricao;
    private Fornecedor fornecedor; //classe já existente
    private String unidCompra;
    private String unidVenda;
    private float precoCompra;
    private float precoVenda;
    private int unidComprada;
    private Status status;

    public Produto() {
        this.id = 0;
        this.descricao = "";
        this.fornecedor = new Fornecedor();
        this.unidCompra = "";
        this.unidVenda = "";
        this.precoCompra = 0;
        this.precoVenda = 0;
        this.unidComprada = 0;
        this.status = Status.Ativo;
    }

    public Produto(int id, String descricao, Fornecedor forncedor, String unidCompra, String unidVenda, float precoCompra, float precoVenda, int unidEstoque) {
        this.id = id;
        this.descricao = descricao;
        this.fornecedor = new Fornecedor();
        this.unidCompra = unidCompra;
        this.unidVenda = unidVenda;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
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

    public String getUnidCompra() {
        return unidCompra;
    }

    public void setUnidCompra(String unidCompra) throws ErroValidacaoException {
        if (unidCompra.length() < 5)
            throw new ErroValidacaoException("Unidade de compra inválida!");
        this.unidCompra = unidCompra;
    }

    public String getUnidVenda() {
        return unidVenda;
    }

    public void setUnidVenda(String unidVenda) throws ErroValidacaoException {
        if (unidCompra.length() < 5)
            throw new ErroValidacaoException("Unidade de venda inválida!");
        this.unidVenda = unidVenda;
    }

    public float getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(float precoCompra) throws ErroValidacaoException {
        if(precoCompra <= 0)
            throw new ErroValidacaoException("Preço de compra INVÁLIDO!");
        this.precoCompra = precoCompra;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) throws ErroValidacaoException {
        if(precoVenda <= 0)
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
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.descricao);
        hash = 41 * hash + Objects.hashCode(this.fornecedor);
        hash = 41 * hash + Objects.hashCode(this.unidVenda);
        hash = 41 * hash + Float.floatToIntBits(this.precoVenda);
        hash = 41 * hash + this.unidComprada;
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
        if (Float.floatToIntBits(this.precoVenda) != Float.floatToIntBits(other.precoVenda)) {
            return false;
        }
        if (this.unidComprada != other.unidComprada) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.unidVenda, other.unidVenda)) {
            return false;
        }
        if (!Objects.equals(this.fornecedor, other.fornecedor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", descricao=" + descricao + ", fornecedor=" + fornecedor + ", unidCompra=" + unidCompra + ", unidVenda=" + unidVenda + ", precoCompra=" + precoCompra + ", precoVenda=" + precoVenda + ", unidEstoque=" + unidComprada + '}';
    }
   
}
