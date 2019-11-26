/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.DomainModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Edlâine
 */
public class CompraProduto {
    private int id;
    private List<Produto> produtos;
    private Funcionario pessoaFunc;
    private Fornecedor fornecedor; //um so fornecedor
    private float precoFinal;

    public CompraProduto() {
        this.id = 0;
        this.produtos = new ArrayList<Produto>();
        this.pessoaFunc = new Funcionario();
        this.fornecedor = new Fornecedor();
        this.precoFinal = 0;
    }

    public CompraProduto(int id, Produto produto, Funcionario pessoaFunc, Fornecedor fornecedor, float precoFinal) {
        this.id = id;
        this.produtos = new ArrayList<Produto>();
        this.pessoaFunc = new Funcionario();
        this.fornecedor = new Fornecedor();
        this.precoFinal = precoFinal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
       try{
            if(id > 0)
                this.id = id;
        }catch(Exception ex){
            System.out.println("Erro!" + ex.getMessage());
        }
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
    
    public Funcionario getPessoaFunc() {
        return pessoaFunc;
    }

    public void setPessoaFunc(Funcionario pessoaFunc) {
        this.pessoaFunc = pessoaFunc;
    }

    public Fornecedor getFornecedor() {
        return (Fornecedor) fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public float getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(float precoFinal) {
        if(this.precoFinal > 0)
            this.precoFinal += precoFinal;
        this.precoFinal = precoFinal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.id;
        hash = 31 * hash + Objects.hashCode(this.produtos);
        hash = 31 * hash + Objects.hashCode(this.fornecedor);
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
        if (!Objects.equals(this.produtos, other.produtos)) {
            return false;
        }
        if (!Objects.equals(this.fornecedor, other.fornecedor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CompraProduto{" + "id=" + id + ", produtos=" + produtos + ", pessoaFunc=" + pessoaFunc + ", fornecedor=" + fornecedor + ", precoFinal=" + precoFinal + '}';
    }
    
}
