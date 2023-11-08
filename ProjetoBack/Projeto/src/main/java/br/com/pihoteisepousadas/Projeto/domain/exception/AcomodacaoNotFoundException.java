package br.com.pihoteisepousadas.Projeto.domain.exception;

import java.util.UUID;

public class AcomodacaoNotFoundException extends RuntimeException{
    public AcomodacaoNotFoundException(UUID id) {
        super("acomodação com id: %s não encontrado! Reveja o que foi solicitado.".formatted(id));
       }
}
