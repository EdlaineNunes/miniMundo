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
public class Cliente extends Pessoa{
    private String rua;
    private String bairro;
    private String nCasa;
    private String cidade;
    private List<String> email;
    
    public Cliente() {
        this.rua = "";
        this.bairro = "";
        this.nCasa = "";
        this.nCasa = "";
        this.cidade = "";
        this.email = new ArrayList<>();
    }

    public Cliente(int id, String nome, String cpf, List<String> telefones, Sexo sexo) {
        super(id, nome, cpf, telefones, sexo);
        this.rua = "";
        this.bairro = "";
        this.nCasa = "";
        this.nCasa = "";
        this.cidade = "";
        this.email = new ArrayList<>();
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) throws ErroValidacaoException {
        if(rua.length() == 0)
            throw new ErroValidacaoException("Insira o endereço.");
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) throws ErroValidacaoException {
        if(bairro.length() < 5)
            throw new ErroValidacaoException("O bairro deve conter mais de 4 caracteres!");
        this.bairro = bairro;
    }

    public String getnCasa() {
        return nCasa;
    }

    public void setnCasa(String nCasa) throws ErroValidacaoException {
        if(nCasa.length() < 1)
            throw new ErroValidacaoException("Insira o número da residência!");
        this.nCasa = nCasa;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) throws ErroValidacaoException {
        if(cidade.length() < 5)
            throw new ErroValidacaoException("O nome da cidade deve ser maior que 4 caracteres!");
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.rua);
        hash = 97 * hash + Objects.hashCode(this.nCasa);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (!Objects.equals(this.nCasa, other.nCasa)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "Cliente{" + "rua=" + rua + ", bairro=" + bairro + ", nCasa=" + nCasa + ", cidade=" + cidade + '}';
    }
    
}
