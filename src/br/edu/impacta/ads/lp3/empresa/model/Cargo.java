/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.impacta.ads.lp3.empresa.model;

import java.io.Serializable;

/**
 *
 * @author claudio
 */
public class Cargo implements Serializable {

    private Integer codico;
    private String nome;

    public Cargo() {
    }

    public Cargo(Integer codico, String nome) {
        this.codico = codico;
        this.nome = nome;
    }

    public Integer getCodico() {
        return codico;
    }

    public void setCodico(Integer codico) {
        this.codico = codico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
