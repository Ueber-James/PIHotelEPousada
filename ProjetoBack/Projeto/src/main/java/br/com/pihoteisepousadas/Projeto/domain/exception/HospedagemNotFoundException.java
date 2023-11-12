package br.com.pihoteisepousadas.Projeto.domain.exception;

import java.util.UUID;

public class HospedagemNotFoundException extends RuntimeException {
    public HospedagemNotFoundException(UUID id) {
        super("hospedagem com id: %s não encontrado! Reveja o que foi solicitado.".formatted(id));
    }
}
