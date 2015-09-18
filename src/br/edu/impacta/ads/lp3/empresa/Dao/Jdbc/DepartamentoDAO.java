/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.impacta.ads.lp3.empresa.Dao.Jdbc;

import br.edu.impacta.ads.lp3.empresa.model.Cargo;
import br.edu.impacta.ads.lp3.empresa.model.Departamento;
import br.edu.impacta.ads.lp3.empresa.model.Funcionario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author claudio
 */
public class DepartamentoDAO implements GenericoDAO<Departamento> {

    @Override
    public void inserir(Departamento departamento) {
        List<Departamento> departamentos = new ArrayList();
        String sql = " INSERT INTO D.NOME_DEPARTAMENTO,\n "
                + "D.CODIGO_DEPARTAMENTO,\n "
                + "";
        try {
            Connection connection = Conexao.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            departamento.setCodigo(result.getInt("ID_DEPARTAMENTO"));
            departamento.setNome(result.getString("NOME"));
            while (result.next()) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void remover(Departamento departamento) {
        List<Departamento> departamentos = new ArrayList();
        String sql = " DELETE D.ID_DEPARTAMENTO, D.NOME ";
        try {
        Connection connection = Conexao.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
              
    }

    @Override
    public void alterar(Departamento departamento) {
        List<Departamento> departamentos = new ArrayList();
        String sql = " ALTER F.ID_CARGO,C.NOME_CARGO,ID_DEPARTAMENTO,\n"
                + "NOME_DEPARTAMENTO, ";
    }

    @Override
    public List<Departamento> listar() {
        List<Departamento> departamentos = new ArrayList();
        String sql = "SELECT F.ID_DEPARTAMENTO, F.NOME_DEPARTAMENTO,\n"
                + " C.ID_CARGO, C.NOME CARGO, D.ID_DEPARTAMENTO, D.NOME_DEPARTAMENTO\n"
                + " FROM EMPRESA.FUNCIONARIO F"
                + " INNER JOIN EMPRESA.CARGO C"
                + " ON F.ID_CARGO = C.ID_CARGO"
                + " INNER JOIN EMPRESA.DEPARTAMENTO D\n"
                + " ON F.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO";

        try {
            Connection connection = Conexao.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                Departamento departamento = new Departamento();
                departamento.setCodigo(result.getInt("ID_DEPARTAMENTO"));
                departamento.setNome(result.getString("NOME"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return departamentos;
    }
}
