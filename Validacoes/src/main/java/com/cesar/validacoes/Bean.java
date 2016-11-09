/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar.validacoes;

import com.cesar.validacoes.model.Cliente;
import com.cesar.validacoes.model.Retorno;
import com.cesar.validacoes.regras.RegraCamposObrigatorios;
import com.cesar.validacoes.regras.RegraFormatacaoCampo;
import com.cesar.validacoes.util.Validar;

/**
 *
 * @author cesar
 */
public class Bean {

    public Retorno processarCliente(Cliente c) {

        return new Validar(c).executar(new RegraCamposObrigatorios()).or(new RegraFormatacaoCampo()).getErros();

    }

    public static void main(String[] args) {
        Bean b = new Bean();
        Cliente c = new Cliente();
        c.setId(1);
        c.setDataHoraInclusao("09/11/2016 00:17:00");
        c.setCpf("12345678901");
        //c.setNome("cesar");
        Retorno r = b.processarCliente(c);
        System.out.println(r.getCodigo());
        System.out.println(r.getMensagem());
    }
}
