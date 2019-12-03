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
public class Estoque extends Produto{  
    
    private Date data;

    public Estoque() {
        super();
        this.data = new Date();
    }

    public Estoque(Date data, int id, String descricao, Fornecedor fornecedor,
            UnidadesCompra unidCompra, UnidadesVenda unidVenda, 
            BigDecimal precoCompra, BigDecimal precoVenda, int unidComprada)
            throws ErroValidacaoException {
        setId(id);
        setDescricao(descricao);
        setFornecedor(fornecedor);
        setUnidCompra(unidCompra);
        setUnidVenda(unidVenda);
        setPrecoCompra(precoCompra);
        setPrecoVenda(precoVenda);
        setUnidComprada(unidComprada); 
        this.data = new Date();
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
        hash = 67 * hash + Objects.hashCode(this.data);
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
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estoque{" + "data=" + data + '}';
    }
        
}
