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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author claudio
 */
public class FuncionarioDAO extends Object implements GenericoDAO<Funcionario> {

    @Override
    public void inserir(Funcionario e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Funcionario e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Funcionario e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Funcionario> listar() {
        List<Funcionario> funcionarios = new ArrayList();

        String sql = "SELECT F.ID_FUNCIONARIO, F.NOME, F.DT_CONTRATACAO,\n"
                + " C.ID_CARGO, C.NOME CARGO, D.ID_DEPARTAMENTO, D.NOME DEPARTAMENTO\n"
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
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(result.getInt("ID_FUNCIONARIO"));
                funcionario.setNome(result.getString("NOME"));
                funcionario.setContratacao(result.getDate("DT_CONTRATACAO"));
                
                Cargo cargo = new Cargo();
                cargo.setCodico(result.getInt("ID_CARGO"));
                cargo.setNome(result.getString("NOME"));
                funcionario.setCargo(cargo);
                
                Departamento departamento = new Departamento();
                departamento.setCodigo(result.getInt("ID_DEPARTAMENTO"));
                departamento.setNome(result.getString("NOME"));
                funcionario.setDepartamento(departamento);
            }        
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return funcionarios;
    }
}
