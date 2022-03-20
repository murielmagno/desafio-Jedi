package com.padwan.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.padwan.test.model.Status;

public class JediDTO {

    @JsonIgnore
    private Long id;
    private String nome;
    private Status status;
    private Long mentor_id;
    private Integer midichlorians;

    public JediDTO (){}

    public JediDTO(Long id, String nome, Status status, Long mentor_id, Integer midichlorians) {
        this.id = id;
        this.nome = nome;
        this.status = status;
        this.mentor_id = mentor_id;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getMentor_id() {
        return mentor_id;
    }

    public void setMentor_id(Long mentor_id) {
        this.mentor_id = mentor_id;
    }

    public Integer getMidichlorians() {
        return midichlorians;
    }

    public void setMidichlorians(Integer midichlorians) {
        this.midichlorians = midichlorians;
    }
}
