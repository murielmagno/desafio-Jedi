package com.padwan.test.model;

public enum Status {

    PADAWAN("Padawan"),
    JEDI("Jedi"),
    MESTRE_JEDI("Mestre Jedi");

    private final String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

}
