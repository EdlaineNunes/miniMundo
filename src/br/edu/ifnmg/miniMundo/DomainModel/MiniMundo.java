/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.DomainModel;

import static br.edu.ifnmg.miniMundo.DomainModel.Status.Ativo;
import static br.edu.ifnmg.miniMundo.DomainModel.Status.Inativo;
import static br.edu.ifnmg.miniMundo.DomainModel.Sexo.F;
import static br.edu.ifnmg.miniMundo.DomainModel.Sexo.M;
import br.edu.ifnmg.miniMundo.Persistence.ClienteRepositorio;
import br.edu.ifnmg.miniMundo.Persistence.FornecedorRepositorio;
import br.edu.ifnmg.miniMundo.Persistence.FuncionarioRepositorio;

/**
 *
 * @author Edlâine
 */
public class MiniMundo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Cliente cliente = new Cliente();
        
        try{
            cliente.setNome("Ana");
            cliente.setCpf("00000000000");
            cliente.setSexo(F);
            cliente.setRua("Rua 3");
            cliente.setBairro("Santos");
            cliente.setnCasa("34A");
            cliente.setCidade("Januária");
            cliente.setStatus(Ativo);
            
            ClienteRepositorio cliente_repo = new ClienteRepositorio();
            cliente_repo.Salvar(cliente);           
            
        }catch(ErroValidacaoException ex){
            System.out.print(ex.getMessage());
        }
        */
        /*
        Funcionario funcionario = new Funcionario();
        
        try{
            funcionario.setNome("Joao");
            funcionario.setCpf("11111114111");
            funcionario.setSexo(M);
            funcionario.setUser("joao53");
            funcionario.setSenha("joaozinho3");
            //funcionario.setStatus(Ativo);
            
            FuncionarioRepositorio func_repo = new FuncionarioRepositorio();
            func_repo.Salvar(funcionario);
        
        }catch(ErroValidacaoException ex){
            System.out.print(ex.getMessage());
        }
*/
        Fornecedor fornecedor = new Fornecedor();
        
        try{
            fornecedor.setRazaoSocial("BSI desenv sistemas");
            fornecedor.setCnpj("39.113.709/0001-39");
            fornecedor.setEndCompleto("Rua A,n 38-B, Nova Brasilina, Januaria");
            //fornecedor.setStatus(Ativo);
                   
            FornecedorRepositorio fornecedor_repo = new FornecedorRepositorio();
            fornecedor_repo.Salvar(fornecedor);
        
        }catch(ErroValidacaoException ex){
            System.out.print(ex.getMessage());
        }
        
    }
        
}
