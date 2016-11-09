/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar.validacoes.regras;

import com.cesar.validacoes.model.Base;
import com.cesar.validacoes.model.Cliente;
import com.cesar.validacoes.model.Fornecedor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author cesar
 */
public class RegraFormatacaoCampo implements Regra {

    public static final SimpleDateFormat FORMATO_DATA_HORA = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    @Override
    public Set<Erro> validar(Base b) {
        Set<Erro> erros = new HashSet<>();
        if (b.getId() > 999999999) {
            erros.add(new Erro("campo id com valor inválido (maior que 999999999)"));
        }
        try {
            Date dataFormatada = FORMATO_DATA_HORA.parse(b.getDataHoraInclusao());
            if (!FORMATO_DATA_HORA.format(dataFormatada).equals(b.getDataHoraInclusao())) {
                erros.add(new Erro("campo data hora inclusão com valor inválido (formato esperado: " + FORMATO_DATA_HORA.toPattern() + ")"));
            }
        } catch (Exception e) {
            erros.add(new Erro("campo data hora inclusão com valor inválido (formato esperado: " + FORMATO_DATA_HORA.toPattern() + ")"));
        }
        return erros;
    }

    @Override
    public Set<Erro> validar(Fornecedor f) {
        Set<Erro> erros = validar((Base) f);
        if (f.getRazaoSocial().length() > 100) {
            erros.add(new Erro("campo razão social com valor inválido (maior que 100)"));
        }
        if (f.getCnpj().length() != 14 || !f.getCnpj().matches("^\\d+$")) {
            erros.add(new Erro("campo cnpj com valor inválido"));
        }
        return erros;
    }

    @Override
    public Set<Erro> validar(Cliente c) {
        Set<Erro> erros = validar((Base) c);
        if (c.getNome().length() > 50) {
            erros.add(new Erro("campo nome com valor inválido (maior que 50)"));
        }
        if (c.getCpf().length() != 11 || !c.getCpf().matches("^\\d+$")) {
            erros.add(new Erro("campo cpf com valor inválido"));
        }

        return erros;
    }

}
