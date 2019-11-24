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
public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private List<String> telefones;
    private Sexo sexo; //enumeração
    private String rua;
    private String bairro;
    private String nCasa;
    private String cidade;
    private List<String> emails;
    private Estado status;
    
    private Pattern regex_cpf = Pattern.compile("\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}"); //formatar cpf

    public Cliente() {
        this.id = 0;
        this.nome = "";
        this.cpf = "00000000000";
        this.telefones = new ArrayList<>();
        this.sexo = Sexo.M;
        this.rua = "";
        this.bairro = "";
        this.nCasa = "";
        this.nCasa = "";
        this.cidade = "";
        this.emails = new ArrayList<>();
        this.status = Estado.Ativo;
    }

    public Cliente(int id, String nome, String cpf, List<String> telefones, 
                Sexo sexo, String rua, String bairro, String nCasa,    
                    String cidade, List<String> emails,Estado status) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefones = new ArrayList<>();
        this.sexo = sexo;
        this.rua = rua;
        this.bairro = bairro;
        this.nCasa = nCasa;
        this.cidade = cidade;
        this.emails = new ArrayList<>();
        this.status = status;
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
        if(telefone != null && telefone.length() == 11) // o método length retorna o tamanho da string
            this.telefones.add(telefone);
    }
    public void removeTelefone(String telefone){
        if(this.telefones.contains(telefone))// o contais faz um for e compara com tds os dados da lista
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
        if(email != null && email.length() == 11) // o método length retorna o tamanho da string
            this.emails.add(email);
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

    public Estado getStatus() {
        return status;
    }

    public void setStatus(Estado status) {
        this.status = status;
    }  
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.cpf);
        hash = 97 * hash + Objects.hashCode(this.telefones);
        hash = 97 * hash + Objects.hashCode(this.sexo);
        hash = 97 * hash + Objects.hashCode(this.nCasa);
        hash = 97 * hash + Objects.hashCode(this.cidade);
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
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (this.sexo != other.sexo) {
            return false;
        }
        if (!Objects.equals(this.emails, other.emails)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", telefones=" + telefones + ", sexo=" + sexo + ", rua=" + rua + ", bairro=" + bairro + ", nCasa=" + nCasa + ", cidade=" + cidade + ", emails=" + emails + ", status=" + status + ", regex_cpf=" + regex_cpf + '}';
    }

     
}
