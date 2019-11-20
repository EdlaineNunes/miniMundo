/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.DomainModel;

/**
 *
 * @author Edlâine
 */
public class Produto {
    private int id;
    private String descricao;
    private Fornecedor forncedor; //classe já existente
    private String unidCompra;
    private String unidVenda;
    private float precoCompra;
    private float precoVenda;
    private int unidEstoque;

    public Produto() {
        this.id = 0;
        this.descricao = "";
        this.forncedor = new Fornecedor();
        this.unidCompra = "";
        this.unidVenda = "";
        this.precoCompra = 0;
        this.precoVenda = 0;
        this.unidEstoque = 0;
    }

    public Produto(int id, String descricao, Fornecedor forncedor, String unidCompra, String unidVenda, float precoCompra, float precoVenda, int unidEstoque) {
        this.id = id;
        this.descricao = descricao;
        this.forncedor = new Fornecedor();
        this.unidCompra = unidCompra;
        this.unidVenda = unidVenda;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.unidEstoque = unidEstoque;
    }

    public int getI5d() {
        return id;
    }

    public void setId(int id) {
       try{
            if(id > 0)
                this.id = id;
        }
        catch(Exception ex){
            System.out.println("Aconteceu um erro: " + ex.getMessage());
        } 
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) throws ErroValidacaoException {
        if(descricao.length() < 5)
            throw new ErroValidacaoException("A descrição deve conter mais de 4 caracteres!");
        this.descricao = descricao;
    }

    public Fornecedor getForncedor() {
        return forncedor;
    }

    public void setForncedor(Fornecedor forncedor) {
        this.forncedor = forncedor;
    }

    public String getUnidCompra() {
        return unidCompra;
    }

    public void setUnidCompra(String unidCompra) {
        this.unidCompra = unidCompra;
    }

    public String getUnidVenda() {
        return unidVenda;
    }

    public void setUnidVenda(String unidVenda) {
        this.unidVenda = unidVenda;
    }

    public float getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(float precoCompra) {
        this.precoCompra = precoCompra;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getUnidEstoque() {
        return unidEstoque;
    }

    public void setUnidEstoque(int unidEstoque) {
        this.unidEstoque = unidEstoque;
    }

    
    
}
