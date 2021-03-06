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
public class Estoque {  
    
    private Produto produto;
    private Date data;
    private int unid;

    public Estoque() {
        this.produto = new Produto();
        this.data = new Date();
        this.unid = 0;
    }
    
    public Estoque(Produto produto, Date data, int unid) {
        this.produto = produto;
        this.data = data;
        this.unid = unid;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getUnid() {
        return unid;
    }

    public void setUnid(int unid) {
        this.unid = unid;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.produto);
        hash = 53 * hash + Objects.hashCode(this.data);
        hash = 53 * hash + this.unid;
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
        final Estoque other = (Estoque) obj;
        if (this.unid != other.unid) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estoque{" + "produto=" + produto + ", data=" + data + ", unid=" + unid + '}';
    }
       
}
