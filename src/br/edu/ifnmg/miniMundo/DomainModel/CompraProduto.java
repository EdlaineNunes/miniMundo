/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.DomainModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Edlâine
 */
public class CompraProduto {
    private int id;
    private BigDecimal preco_final;
    private List<ListaItens> itens;
    private Funcionario func;
    private Fornecedor fornec;
    private Date data;

    public CompraProduto() {
        this.id = 0;
        this.preco_final = new BigDecimal("0.0");
        this.itens = new ArrayList<ListaItens>();
        this.func = new Funcionario();
        this.fornec = new Fornecedor();
        this.data = new Date();
    }

    public CompraProduto(int id, BigDecimal preco_final, 
            List<ListaItens> itens, Funcionario func, 
            Fornecedor fornec, Date data) {
        this.id = id;
        this.preco_final = preco_final;
        this.itens = itens;
        this.func = func;
        this.fornec = fornec;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPreco_final() {
        return preco_final;
    }

    public void setPreco_final(BigDecimal preco_final) {
        this.preco_final = preco_final;
    }

    public void addItem(ListaItens item) throws ErroValidacaoException{
        if(this.itens != null)
            this.itens.add(item);
    }
    
    public void removeItem(ListaItens item) throws ErroValidacaoException{
        if(this.itens.contains(item))
            this.itens.remove(item);
        else
            throw new ErroValidacaoException("Item inválido!");
    }
    
    public List<ListaItens> getItens() {
        return itens;
    }

    public void setItens(List<ListaItens> itens) {
        this.itens = itens;
    }

    public Funcionario getFunc() {
        return func;
    }

    public void setFunc(Funcionario func) {
        this.func = func;
    }

    public Fornecedor getFornec() {
        return fornec;
    }

    public void setFornec(Fornecedor fornec) {
        this.fornec = fornec;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.id;
        hash = 23 * hash + Objects.hashCode(this.preco_final);
        hash = 23 * hash + Objects.hashCode(this.itens);
        hash = 23 * hash + Objects.hashCode(this.func);
        hash = 23 * hash + Objects.hashCode(this.fornec);
        hash = 23 * hash + Objects.hashCode(this.data);
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
        final CompraProduto other = (CompraProduto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.preco_final, other.preco_final)) {
            return false;
        }
        if (!Objects.equals(this.itens, other.itens)) {
            return false;
        }
        if (!Objects.equals(this.func, other.func)) {
            return false;
        }
        if (!Objects.equals(this.fornec, other.fornec)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CompraProduto{" + "id=" + id + ", preco_final="
                + preco_final + ", itens=" + itens + ", func=" +
                func + ", fornec=" + fornec + ", data=" + data + '}';
    }
    
}
