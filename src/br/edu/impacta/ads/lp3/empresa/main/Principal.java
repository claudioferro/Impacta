/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.impacta.ads.lp3.empresa.main;

import br.edu.impacta.ads.lp3.empresa.Dao.Jdbc.CargoDAO;
import br.edu.impacta.ads.lp3.empresa.model.Cargo;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author claudio
 */
public class Principal {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        List<Cargo> cargos = new CargoDAO().listar();

        for (Cargo cargo : cargos) {
            System.out.println(cargo.getCodico() + "" + cargo.getNome());
        }
    }

}
