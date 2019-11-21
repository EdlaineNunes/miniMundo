/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.DomainModel;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Edlâine
 */
class Estoque extends CompraProduto{
    private Date data;
    private int id;

    public Estoque() {
        super();
        this.data = new Date();
        this.id = 0;
    }

    public Estoque(int id, Produto produto, Funcionario pessoaFunc, Fornecedor fornecedor, int qnt, float precoFinal) {
        super(id, produto, pessoaFunc, fornecedor, qnt, precoFinal);
        this.data = data;
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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

    @Override
    public int hashCode() {
        int hash = 7;
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
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estoque{" + "data=" + data + ", id=" + id + '}';
    }
    
}
