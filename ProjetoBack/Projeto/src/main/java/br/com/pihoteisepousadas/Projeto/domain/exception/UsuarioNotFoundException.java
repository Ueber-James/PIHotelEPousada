package br.com.pihoteisepousadas.Projeto.domain.exception;

import java.util.UUID;

public class UsuarioNotFoundException extends RuntimeException{
    public UsuarioNotFoundException(UUID id) {
        super("usuario com id: %s não encontrado! Reveja o que foi solicitado.".formatted(id));
    }
}
