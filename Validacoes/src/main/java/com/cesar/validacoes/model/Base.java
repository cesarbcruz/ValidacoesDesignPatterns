/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar.validacoes.model;

import java.util.Date;

/**
 *
 * @author cesar
 */
public class Base {
    private long id;
    private String dataHoraInclusao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDataHoraInclusao() {
        return dataHoraInclusao;
    }

    public void setDataHoraInclusao(String dataHoraInclusao) {
        this.dataHoraInclusao = dataHoraInclusao;
    }
    
    
}
