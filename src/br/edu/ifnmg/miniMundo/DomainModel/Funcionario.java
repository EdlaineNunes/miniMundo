/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.DomainModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Edlâine
 */
public class Funcionario extends Pessoa{
    private String senha;
    private String user;
    private Status status;
    
    private Pattern regex_cpf = Pattern.compile("\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}"); //formatar cpf

    public Funcionario() {
        super();
        this.senha = "";
        this.user = "";
        this.status = Status.Ativo;
    }

    public Funcionario(int id, String nome, String cpf, Sexo sexo, String senha, String user,Status status) throws ErroValidacaoException {
        setId(id);
        setNome(nome);
        setCpf(cpf);
        //setTelefone(telefones);
        setSexo(sexo);
        this.senha = senha;
        this.user = user;
        this.status = status;
      
    } 
 
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws ErroValidacaoException {
        if(senha.length() < 3 && senha.length() > 15)
            throw new ErroValidacaoException("A senha deve possuir no minimo 4 caracteres e máximo de 15.");
        this.senha = senha;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) throws ErroValidacaoException {
        if(user.length() < 3 && user.length() >10)
            throw new ErroValidacaoException("O Usuário deve ter no mínimo 4 caracteres e máximo de 10.");
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.senha);
        hash = 29 * hash + Objects.hashCode(this.user);
        hash = 29 * hash + Objects.hashCode(this.status);
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
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "senha=" + senha + ", user=" + user + ", status=" + status + '}';
    }
    
}
