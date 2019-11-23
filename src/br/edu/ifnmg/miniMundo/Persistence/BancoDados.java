/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.miniMundo.Persistence;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Edlâine
 */
public class BancoDados {
    private Connection conexao;
    
    public BancoDados(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/miniMundo",
                    "miniMundo","digitesuasenha1");
        }
        catch(ClassNotFoundException ex){
            System.out.println("Driver do banco de dados não foi encontrado!");
        } catch (SQLException ex) {
            System.out.println("Os dados da conexão com o banco de dados estão errados!");
            System.out.println(ex.getMessage());           
        }
    }

    public java.sql.Connection getConexao() {
        return conexao;
    }
}
