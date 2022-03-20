package com.padwan.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MentorDTO {
    @JsonIgnore
    private Long id;
    private String nome;
    private Integer midichlorians;

    public MentorDTO (){

    }

    public MentorDTO(Long id, String nome, Integer midichlorians) {
        this.id = id;
        this.nome = nome;
        this.midichlorians = midichlorians;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getMidichlorians() {
        return midichlorians;
    }

    public void setMidichlorians(Integer midichlorians) {
        this.midichlorians = midichlorians;
    }
}
