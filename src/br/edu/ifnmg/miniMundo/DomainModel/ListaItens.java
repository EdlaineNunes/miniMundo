/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.DomainModel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Edlâine
 */
public class ListaItens {
    private Produto produto;
    private int quantidade;
    private BigDecimal valor;
    private Date data;

    public ListaItens(Produto produto, int quantidade, BigDecimal valor, Date data) {
        this.produto = new Produto();
        this.quantidade = quantidade;
        this.valor = new BigDecimal("0,0");
        this.data = new Date();
    }

    public ListaItens() {
        this.produto = new Produto();
        this.quantidade = 0;
        this.valor = new BigDecimal("0,0");
        this.data = new Date();
        
    }
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.produto);
        hash = 59 * hash + this.quantidade;
        hash = 59 * hash + Objects.hashCode(this.valor);
        hash = 59 * hash + Objects.hashCode(this.data);
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
        final ListaItens other = (ListaItens) obj;
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ListaItens{" + "produto=" + produto + ", quantidade=" + quantidade + ", valor=" + valor + ", data=" + data + '}';
    }
    
    
    
}
