/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar.validacoes.model;

import com.cesar.validacoes.util.Constantes;

/**
 *
 * @author cesar
 */
public class Retorno {

    private String codigo;
    private String mensagem;

    public Retorno() {
        this.codigo = Constantes.COD_SUCESSO;
        this.mensagem = "";
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
