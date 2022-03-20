package com.padwan.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mentor")
public class Mentor extends Jedi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @JsonProperty("nome")
    @Column(nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column()
    private final Status status = Status.MESTRE_JEDI;

    @Column(nullable = false)
    private Integer midichlorians;

    @JsonIgnore
    @OneToMany(mappedBy = "mentor")
    private List<Jedi> discipulo = new ArrayList<>();

    public Mentor(){}

    public Mentor(Long id, String nome, Integer midichlorians, List<Jedi> discipulo) {
        this.id = id;
        this.nome = nome;
        this.midichlorians = midichlorians;
        this.discipulo = discipulo;
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

    public List<Jedi> getDiscipulo() {
        return discipulo;
    }

    public void setDiscipulo(List<Jedi> discipulo) {
        this.discipulo = discipulo;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public Integer getMidichlorians() {
        return midichlorians;
    }

    @Override
    public void setMidichlorians(Integer midichlorians) {
        this.midichlorians = midichlorians;
    }
}
