package com.ueg.controledemusica.enums;

public enum TipoEstilo {
    POP(0),
    REB(1),
    MPB(2),
    ROCK(3),
    FOLK(4);

    private int code;

    TipoEstilo(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
