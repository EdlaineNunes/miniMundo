/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.DomainModel;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Edlâine
 */
public class Funcionario extends Pessoa {
    private String senha;

    public Funcionario() {
        super();
        this.senha = "";
    }

    public Funcionario(int id, String nome, String cpf, List<String> telefones, Sexo sexo) {
        super(id, nome, cpf, telefones, sexo);
        this.senha = "";
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws ErroValidacaoException {
        if(senha.length() < 5)
            throw new ErroValidacaoException("A senha deve possuir no minimo 4 caracteres.");
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.senha);
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
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "senha=" + senha + '}';
    }
       
}
