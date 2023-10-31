package br.com.pihoteisepousadas.Projeto.domain.exception;

import java.util.UUID;

public class ClienteNotFoundException extends RuntimeException{
    public ClienteNotFoundException(UUID id) {
        super("cliente com id: %s não encontrado! Reveja o que foi solicitado.".formatted(id));
    }
}
