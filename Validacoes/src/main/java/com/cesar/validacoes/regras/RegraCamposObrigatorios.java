/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar.validacoes.regras;

import com.cesar.validacoes.model.Base;
import com.cesar.validacoes.model.Cliente;
import com.cesar.validacoes.model.Fornecedor;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author cesar
 */
public class RegraCamposObrigatorios implements Regra {

    @Override
    public Set<Erro> validar(Base b) {
        Set<Erro> erros = new HashSet<>();
        if (b.getId() == 0) {
            erros.add(new Erro("campo id não informado"));
        }
        if (b.getDataHoraInclusao() == null || b.getDataHoraInclusao().isEmpty()) {
            erros.add(new Erro("campo data hora inclusão não informado"));
        }
        return erros;
    }

    @Override
    public Set<Erro> validar(Fornecedor f) {
        Set<Erro> erros = validar((Base) f);
        if (f.getRazaoSocial() == null || f.getRazaoSocial().isEmpty()) {
            erros.add(new Erro("campo razão social não informado"));
        }
        if (f.getCnpj() == null || f.getCnpj().isEmpty()) {
            erros.add(new Erro("campo cnpj não informado"));
        }
        return erros;
    }

    @Override
    public Set<Erro> validar(Cliente c) {
        Set<Erro> erros = validar((Base) c);
        if (c.getNome() == null || c.getNome().isEmpty()) {
            erros.add(new Erro("campo nome não informado"));
        }
        if (c.getCpf() == null || c.getCpf().isEmpty()) {
            erros.add(new Erro("campo cpf não informado"));
        }
        return erros;
    }

}
