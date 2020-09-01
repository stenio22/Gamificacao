package com.stenio.gamificacao.model;

import java.io.Serializable;

public class Resultado implements Serializable {

    private String nome;
    private String total;
    private Long id;


    public Resultado() {
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

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
