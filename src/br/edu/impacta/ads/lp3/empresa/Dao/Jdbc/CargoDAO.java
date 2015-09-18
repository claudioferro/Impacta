/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.impacta.ads.lp3.empresa.Dao.Jdbc;

import br.edu.impacta.ads.lp3.empresa.model.Cargo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author claudio
 */
public class CargoDAO implements GenericoDAO<Cargo> {

    @Override //Anotaçao que indica que esse método foi reescrito "HERANÇA"
    public void inserir(Cargo cargo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override //Anotaçao que indica que esse método foi reescrito "HERANÇA"
    public void remover(Cargo cargo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override //Anotaçao que indica que esse método foi reescrito "HERANÇA"
    public void alterar(Cargo cargo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override //Anotaçao que indica que esse método foi reescrito "HERANÇA"
    public List<Cargo> listar() {
        //Criando uma "LISTA" e passando método Cargo e colocando no ArrayList
        List<Cargo> cargos = new ArrayList<Cargo>();
        //Circundando com try catch
        try {

           // Conexao c = new Conexao();
            
            Connection connection = Conexao.getInstance().getConnection();
          
            java.sql.Statement statement = connection.createStatement();// Criando o caminho com o Banco
            ResultSet result = statement.executeQuery("SELECT * FROM EMPRESA.CARGO");// Exececutando a tabela e obtendo o resultado("ResultSet")do Banco de Dados 
             //Interando o resultado "While" ("ResultSet")
            while (result.next()) { 
                Cargo cargo = new Cargo();//Adicionando um novo Cargo
                cargo.setCodico(result.getInt("id_CARGO"));//Saida do Banco de Dados pedindo ID de Cargos
                cargo.setNome(result.getString("NOME"));//Saida do Banco de Dados pedindo Nome
                cargos.add(cargo);// Inclusão de um novo Cargo

            
            }
            connection.close();//Fechando a conexão
            //Circundando com o cach
        } catch (SQLException ex) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Retorno de cargos
        return cargos;
    }

}
