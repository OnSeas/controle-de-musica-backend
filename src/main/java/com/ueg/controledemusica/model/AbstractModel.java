package com.ueg.controledemusica.model;

import com.ueg.controledemusica.reflection.ValidacoesReflexao;

public abstract class AbstractModel {
    public void validarDuracao(){
        ValidacoesReflexao.validarDuracao(this);
    }
}
