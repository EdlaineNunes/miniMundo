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
public class AquisicaoProduto {
    private int id;
    private List<ListaItens> list_produtos;
    private Funcionario funcionario;
    private Fornecedor fornecedor; //um so fornecedor
    private BigDecimal precoFinal;
    private Date data;

    public AquisicaoProduto() {
        this.id = 0;
        this.list_produtos = new ArrayList<>();
        this.funcionario = new Funcionario();
        this.fornecedor = new Fornecedor();
        this.precoFinal = new BigDecimal ("0,0");
        this.data = new Date();
    }

    public AquisicaoProduto(int id, List<ListaItens> list_produtos, 
            Funcionario pessoaFunc, Fornecedor fornecedor, BigDecimal precoFinal) {
        this.id = id;
        this.list_produtos = new ArrayList<>();
        this.funcionario = new Funcionario();
        this.fornecedor = new Fornecedor();
        this.precoFinal = new BigDecimal("precoFinal"); 
        this.data = new Date();
    }
     
    
    public List<ListaItens> getList_produtos() {
        return list_produtos;
    }

    public void setList_produtos(List<ListaItens> list_produtos) {
        this.list_produtos = list_produtos;
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
    
   
    public void addItem(ListaItens item){
        if( item != null ) // o método length retorna o tamanho da string
            this.list_produtos.add(item);
        else
           try {
               throw new ErroValidacaoException(" Item Inválido!");
        } catch (ErroValidacaoException ex) {
            Logger.getLogger(AquisicaoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeItem(ListaItens item){
        if(this.list_produtos.contains(item))// o cantais faz um for e compara com tds os dados da lista
            this.list_produtos.remove(item);
    }

    public List<ListaItens> getItens() {
        return list_produtos;
    }

    public void setItens(List<ListaItens> produtos) {
        this.list_produtos = produtos;
    }
    
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Fornecedor getFornecedor() {
        return (Fornecedor) fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public BigDecimal getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(BigDecimal precoFinal) {
        this.precoFinal = precoFinal;
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
        hash = 31 * hash + this.id;
        hash = 31 * hash + Objects.hashCode(this.list_produtos);
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
        final AquisicaoProduto other = (AquisicaoProduto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.list_produtos, other.list_produtos)) {
            return false;
        }
        if (!Objects.equals(this.fornecedor, other.fornecedor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CompraProduto{" + "id=" + id + ", produtos=" + list_produtos + ", pessoaFunc=" + funcionario + ", fornecedor=" + fornecedor + ", precoFinal=" + precoFinal + '}';
    }

}
