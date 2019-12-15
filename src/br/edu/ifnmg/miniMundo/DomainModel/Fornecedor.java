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
public class Fornecedor {
    private int id;
    private String cnpj;
    private String razaoSocial;
    private String endCompleto;
    private List<String> email;
    private Status status;
    private List<String> telefones;

    //formato CNPJ 39.113.709/0001-39
    private Pattern regex_cnpj = Pattern.compile("\\d{2}\\.?\\d{3}\\.?\\d{3}\\/?\\d{4}\\-?\\d{2}");
         
    public Fornecedor() {
        this.id = 0;
        this.cnpj = "00000000000000";
        this.razaoSocial = "";
        this.endCompleto = "";
        this.email = new ArrayList<>();
        this.status = Status.Ativo;
        this.telefones = new ArrayList<>();
    }

    public Fornecedor(int id, String cnpj, String razaoSocial, String endCompleto, 
            List<String> email, Status status,List<String> telefones) {
        this.id = id;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.endCompleto = endCompleto;
        this.email = new ArrayList<>();
        this.status = status;
        this.telefones = new ArrayList<>();
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
    
    public String getCnpj() {
        //formato CNPJ 39.113.709/0001-39
        return cnpj.substring(0,2) + "." + 
                cnpj.substring(2,5) + "." +
                cnpj.substring(5,8) + "/" + 
                cnpj.substring(8,12) + "-" +
                cnpj.substring(12,14);
    }

    public void setCnpj(String cnpj) throws ErroValidacaoException {
         //formatação do CNPJ 39.113.709/0001-39
        Matcher cnpjFormatado = regex_cnpj.matcher(cnpj);
        if(cnpjFormatado.matches())
            this.cnpj = cnpj.replace(".", "").replace("/","").replace("-","");
        else 
            throw new ErroValidacaoException("CNPJ Inválido!!");
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) throws ErroValidacaoException {
        if(razaoSocial.length() < 5)
            throw new ErroValidacaoException("A razão social ser maior que cinco caracteres.Tente novamente");
        this.razaoSocial = razaoSocial;
    }

    public String getEndCompleto() {
        return endCompleto;
    }

    public void setEndCompleto(String endCompleto) throws ErroValidacaoException {
        if(endCompleto.length() <= 10)
            throw new ErroValidacaoException("Endereço deve conter mais de 10 caracteres");
        this.endCompleto = endCompleto;
    }

    public void addEmail(String email){
        if(email != null && email.length() <50) //verificar @ 
            this.email.add(email);
    }
    public void removeEmail(String email){
        if(this.email.contains(email))// o cantais faz um for e compara com tds os dados da lista
            this.email.remove(email);
    }    
    
    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.cnpj);
        hash = 71 * hash + Objects.hashCode(this.razaoSocial);
        hash = 71 * hash + Objects.hashCode(this.endCompleto);
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
        final Fornecedor other = (Fornecedor) obj;
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        if (!Objects.equals(this.razaoSocial, other.razaoSocial)) {
            return false;
        }
        if (!Objects.equals(this.endCompleto, other.endCompleto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.razaoSocial;
    }

}
