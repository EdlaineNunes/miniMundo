/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.DomainModel;

import static br.edu.ifnmg.miniMundo.DomainModel.Sexo.F;
import static br.edu.ifnmg.miniMundo.DomainModel.Sexo.M;
import br.edu.ifnmg.miniMundo.Persistence.PessoaRepositorio;

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
        Pessoa pessoa = new Pessoa();
        
        try{
            pessoa.setNome("Mariana");
            pessoa.setCpf("00000000000");
            pessoa.setSexo(F); 
            
            PessoaRepositorio pessoa_repo = new PessoaRepositorio();
            pessoa_repo.Salvar(pessoa);
            
        }catch(ErroValidacaoException ex){
            System.out.print(ex.getMessage());
        }
    }
    
}
