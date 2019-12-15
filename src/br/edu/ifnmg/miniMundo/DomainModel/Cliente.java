/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.DomainModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Edlâine
 */
public class Cliente extends Pessoa {
    private String rua;
    private String bairro;
    private String nCasa;
    private String cidade;
    private List<String> emails;
    private Status status;
    
    private Pattern regex_cpf = Pattern.compile("\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}"); //formatar cpf

    public Cliente() {
        super();
        this.rua = "";
        this.bairro = "";
        this.nCasa = "";
        this.nCasa = "";
        this.cidade = "";
        this.emails = new ArrayList<>();
        this.status = Status.Ativo;
    }

    public Cliente(int id, String nome, String cpf, List<String> telefones, 
                Sexo sexo, String rua, String bairro, String nCasa,    
                    String cidade, List<String> emails,Status status) throws ErroValidacaoException {
        setId(id);
        setNome(nome);
        setCpf(cpf);
        setTelefones(telefones);
        setSexo(sexo);
        this.rua = rua;
        this.bairro = bairro;
        this.nCasa = nCasa;
        this.cidade = cidade;
        this.emails = new ArrayList<>();
        this.status = status;
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

    public void addEmail(String email){
        if(email != null && email.length() <50) // o método length retorna o tamanho da string
            this.emails.add(email);
        else
            try {
               throw new ErroValidacaoException("Email Inválido!");
        } catch (ErroValidacaoException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeEmail(String email){
        if(this.emails.contains(email))// o contais faz um for e compara com tds os dados da lista
            this.emails.remove(email);
    }    
    
    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }  

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.rua);
        hash = 37 * hash + Objects.hashCode(this.bairro);
        hash = 37 * hash + Objects.hashCode(this.nCasa);
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
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "rua=" + rua + ", bairro=" + bairro + ", nCasa=" + nCasa + ", cidade=" + cidade + ", emails=" + emails + ", status=" + status + ", regex_cpf=" + regex_cpf + '}';
    }

    
      
}
