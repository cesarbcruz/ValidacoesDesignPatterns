/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar.validacoes.util;

import com.cesar.validacoes.model.Base;
import com.cesar.validacoes.model.Cliente;
import com.cesar.validacoes.model.Fornecedor;
import com.cesar.validacoes.model.Retorno;
import com.cesar.validacoes.regras.Erro;
import com.cesar.validacoes.regras.Regra;
import com.cesar.validacoes.util.Constantes;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author cesar
 */
public class Validar {

    Base objetoBase;
    private Set<Erro> erros;
    Retorno retorno;

    public Validar(Base objetoBase) {
        this.objetoBase = objetoBase;
        erros = new HashSet<>();
        retorno = new Retorno();
    }

    public Validar executar(Regra regra) {
        executarRegra(regra);
        return this;
    }

    public Validar and(Regra regra) {
        executarRegra(regra);
        return this;
    }

    public Validar or(Regra regra) {
        if (erros.isEmpty()) {
            executarRegra(regra);
        }
        return this;
    }

    public Retorno getErros() {
        if (!erros.isEmpty()) {
            retorno.setMensagem(erros.toString().replace("[", "").replace("]", "").replace(",", ";"));
            retorno.setCodigo(Constantes.COD_ERRO);
        }
        return retorno;
    }

    private void executarRegra(Regra regra) {
        if (objetoBase instanceof Fornecedor) {
            erros.addAll(regra.validar((Fornecedor) objetoBase));
        } else if (objetoBase instanceof Cliente) {
            erros.addAll(regra.validar((Cliente) objetoBase));
        } else {
            erros.addAll(regra.validar(objetoBase));
        }
    }

}
