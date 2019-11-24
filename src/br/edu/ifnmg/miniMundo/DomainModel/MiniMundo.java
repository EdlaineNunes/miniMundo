/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.DomainModel;

import static br.edu.ifnmg.miniMundo.DomainModel.Estado.Ativo;
import static br.edu.ifnmg.miniMundo.DomainModel.Estado.Inativo;
import static br.edu.ifnmg.miniMundo.DomainModel.Sexo.F;
import static br.edu.ifnmg.miniMundo.DomainModel.Sexo.M;
import br.edu.ifnmg.miniMundo.Persistence.ClienteRepositorio;
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
        
        Funcionario funcionario = new Funcionario();
        
        try{
            funcionario.setNome("Pedro");
            funcionario.setCpf("11111111111");
            funcionario.setSexo(M);
            funcionario.setUser("Pedro123");
            funcionario.setSenha("pedro123");
            funcionario.setStatus(Ativo);
            
            FuncionarioRepositorio func_repo = new FuncionarioRepositorio();
            func_repo.Salvar(funcionario);
        
        }catch(ErroValidacaoException ex){
            System.out.print(ex.getMessage());
        }
    }
        
}
