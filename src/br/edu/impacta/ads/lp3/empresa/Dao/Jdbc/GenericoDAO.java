/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.impacta.ads.lp3.empresa.Dao.Jdbc;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author claudio
 *///É importante de criar uma "Interface" porque ela permita que todas as classes
/// que implementem a "Interface" tenham a mesma assinatura de método e também ela
///pode estender(extends) de uma outra "Interface"
public interface GenericoDAO<E> extends Serializable {

    public void inserir(E e);

    public void remover(E e);

    public void alterar(E e);

    public List<E> listar();

}
