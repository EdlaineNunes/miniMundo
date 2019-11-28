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

public class Pessoa {
    private int id;
    private String nome;
    private String cpf;
    private List<String> telefones;
    private Sexo sexo; //enumeração
    
    private Pattern regex_cpf = Pattern.compile("\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}"); //formatar cpf
   
    public Pessoa() {
        this.id = 0;
        this.nome = "";
        this.cpf = "00000000000";
        this.telefones = new ArrayList<>();
        this.sexo = Sexo.M;
    }

    public Pessoa(int id, String nome, String cpf, List<String> telefones, Sexo sexo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefones = new ArrayList<>();
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws ErroValidacaoException {
        if(nome.length() < 3)
            throw new ErroValidacaoException("O nome deve ser maior que três caracteres.Tente novamente");
        this.nome = nome;
    }

    public String getCpf() {
        //formatação do cpf no formato 000.000.000-00
        return cpf.substring(0, 3)+"." +
               cpf.substring(3, 6)+"." +
               cpf.substring(6, 9)+"-" +
               cpf.substring(9, 11);
    }

    public void setCpf(String cpf) throws ErroValidacaoException {
        //formatação do cpf no formato 000.000.000-00
        Matcher m = regex_cpf.matcher(cpf);
        if(m.matches())
            this.cpf = cpf.replace(".", "").replace("-", "");
        else
            throw new ErroValidacaoException("CPF Inválido!");
    }

    public void addTelefone(String telefone){
        //038 9 9999 9999 
        if(telefone != null )//&& telefone.length() == 11) // o método length retorna o tamanho da string
        //if(!this.telefones.contains(telefone))    
            this.telefones.add(telefone);
    }

    public void removeTelefone(String telefone){
        if(this.telefones.contains(telefone))// o cantais faz um for e compara com tds os dados da lista
            this.telefones.remove(telefone);
    }    

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.cpf);
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
        final Pessoa other = (Pessoa) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", telefones=" + telefones + ", sexo=" + sexo + '}';
    }

}