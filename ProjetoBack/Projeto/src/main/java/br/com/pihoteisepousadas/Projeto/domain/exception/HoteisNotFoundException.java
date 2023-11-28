package br.com.pihoteisepousadas.Projeto.domain.exception;

import java.util.UUID;

public class HoteisNotFoundException extends RuntimeException{
    public HoteisNotFoundException(UUID id) {
        super("hotel com id: %s não encontrado! Reveja o que foi solicitado.".formatted(id));
       }
}
