package br.com.pihoteisepousadas.Projeto.domain.entity;

import lombok.Getter;

@Getter
public enum Qualificacao {
    UMA( "1 Estrela"),
    DUAS("2 Estrelas"),
    TRES("3 Estrelas"),
    QUATRO("4 Estrelas"),
    CINCO("5 Estrelas");
    private final String nome;

    Qualificacao(String nome) {
        this.nome = nome;
    }
}
