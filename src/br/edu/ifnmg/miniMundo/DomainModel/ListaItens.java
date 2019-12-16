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
public class ListaItens {
    private Produto produto;
    private int qnt;
    private BigDecimal total;

    public ListaItens() {
        this.produto = new Produto();
        this.qnt = 0;
        this.total = new BigDecimal("0.0");
    }

    public ListaItens(Produto produto, int qnt, BigDecimal total) {
        this.produto = produto;
        this.qnt = qnt;
        this.total = total;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.produto);
        hash = 53 * hash + this.qnt;
        hash = 53 * hash + Objects.hashCode(this.total);
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
        if (this.qnt != other.qnt) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ListaItens{" + "produto=" + produto + ", "
                + "qnt=" + qnt + ", total=" + total + '}';
    }
    
    
    
    
}
