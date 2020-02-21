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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edlâine
 */
public class VendaProduto {
    private int id;
    private BigDecimal preco_final;
    private List<ListaItens> itens;
    private Cliente cliente;
    private Funcionario func;
    private Date data;

    public VendaProduto() {
        this.id = 0;
        this.preco_final = new BigDecimal("0.0");
        this.itens = new ArrayList<ListaItens>();
        this.cliente = new Cliente();
        this.func = new Funcionario();
        this.data = new Date();
    }

    public VendaProduto(int id, BigDecimal preco_final, 
            List<ListaItens> itens, Cliente cliente, 
            Funcionario func, Date data) {
        this.id = id;
        this.preco_final = preco_final;
        this.itens = itens;
        this.cliente = cliente;
        this.func = func;
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
        if(!this.itens.isEmpty())
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFunc() {
        return func;
    }

    public void setFunc(Funcionario func) {
        this.func = func;
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
        hash = 13 * hash + this.id;
        hash = 13 * hash + Objects.hashCode(this.preco_final);
        hash = 13 * hash + Objects.hashCode(this.itens);
        hash = 13 * hash + Objects.hashCode(this.cliente);
        hash = 13 * hash + Objects.hashCode(this.func);
        hash = 13 * hash + Objects.hashCode(this.data);
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
        final VendaProduto other = (VendaProduto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.preco_final, other.preco_final)) {
            return false;
        }
        if (!Objects.equals(this.itens, other.itens)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.func, other.func)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "VendaProduto{" + "id=" + id + ", preco_final=" + 
                preco_final + ", itens=" + itens + ", cliente=" + 
                cliente + ", func=" + func + ", data=" + data + '}';
    }
        
}
