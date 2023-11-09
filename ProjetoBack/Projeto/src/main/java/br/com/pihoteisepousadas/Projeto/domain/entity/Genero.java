package br.com.pihoteisepousadas.Projeto.domain.entity;

import lombok.Getter;

@Getter
public enum Genero {
    M("Masculino"),
    F("Feminino");

    private final String nome;

    Genero(String nome) {
        this.nome = nome;
    }
}
