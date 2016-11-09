/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar.validacoes.regras;

import com.cesar.validacoes.model.Base;
import com.cesar.validacoes.model.Cliente;
import com.cesar.validacoes.model.Fornecedor;
import java.util.Set;

/**
 *
 * @author cesar
 */
public interface Regra {
    public Set<Erro> validar(Base b);
    public Set<Erro> validar(Fornecedor f);
    public Set<Erro> validar(Cliente c);
}
