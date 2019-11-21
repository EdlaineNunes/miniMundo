/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.DomainModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Edlâine
 */
public class VendaProduto {
    private List<Produto> produtos;
    private Funcionario funcionario;
    private Cliente cliente;
    private Estoque estoque;
    private int qntDesejada;
    private float precoFinalCompra;
    private Date data;

    public VendaProduto() {
        this.produtos = new ArrayList<Produto>();
        this.funcionario = new Funcionario();
        this.cliente = new Cliente();
        this.estoque = new Estoque();
        this.qntDesejada = 0;
        this.precoFinalCompra = 0;
        this.data = new Date();
    }

    
    
    public VendaProduto(Produto produto, Funcionario funcionario, Cliente cliente, Estoque estoque, int qntDesejada, float precoFinalCompra, Date data) {
        this.produtos = new ArrayList<Produto>();
        this.funcionario = new Funcionario();
        this.cliente = new Cliente();
        this.estoque = new Estoque();
        this.qntDesejada = qntDesejada;
        this.precoFinalCompra = precoFinalCompra;
        this.data = new Date();
    }

    public void addProduto(Produto produto){
        if(produto != null) // o método length retorna o tamanho da string
            this.produtos.add(produto);
    }
    public void removeProduto(Produto produto){
        if(this.produtos.contains(produto))// o cantais faz um for e compara com tds os dados da lista
            this.produtos.remove(produto);
    }
    
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public int getQntDesejada() {
        return qntDesejada;
    }

    public void setQntDesejada(int qntDesejada) {
        this.qntDesejada = qntDesejada;
    }

    public float getPrecoFinalCompra() {
        return precoFinalCompra;
    }

    public void setPrecoFinalCompra(float precoFinalCompra) {
        this.precoFinalCompra = precoFinalCompra;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.produtos);
        hash = 17 * hash + Objects.hashCode(this.funcionario);
        hash = 17 * hash + Objects.hashCode(this.cliente);
        hash = 17 * hash + this.qntDesejada;
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
        if (this.qntDesejada != other.qntDesejada) {
            return false;
        }
        if (!Objects.equals(this.produtos, other.produtos)) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "VendaProduto{" + "produtos=" + produtos + ", funcionario=" + funcionario + ", cliente=" + cliente + ", estoque=" + estoque + ", qntDesejada=" + qntDesejada + ", precoFinalCompra=" + precoFinalCompra + ", data=" + data + '}';
    }
    
}
