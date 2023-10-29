package br.com.pihoteisepousadas.Projeto.domain.entity;

public enum TipoAcomodacao {
    H("Hotel"),
    P("Pousada");

    private final String nome;

    TipoAcomodacao(String nome) {
        this.nome = nome;
    }
}
