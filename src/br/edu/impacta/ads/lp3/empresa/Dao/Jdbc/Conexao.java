/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.impacta.ads.lp3.empresa.Dao.Jdbc;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author claudio
 */
/**
 * implementação Singleton para conexão com a base de dados
 */
public class Conexao implements Serializable {

    private static Conexao conexao;

    private Conexao() {
    }        
        
    

    public static Conexao getInstance() {
        if (conexao == null) {
            conexao = new Conexao();
        }

        return conexao;
    }

    public Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");//Criando a conexão com o banco de Dados
            connection = DriverManager.getConnection("jdbc:derby://127.0.0.1:1527/Empresa", "fit", "fit");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
}