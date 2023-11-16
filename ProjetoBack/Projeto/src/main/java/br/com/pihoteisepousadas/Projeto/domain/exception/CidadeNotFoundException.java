package br.com.pihoteisepousadas.Projeto.domain.exception;

import java.util.UUID;

public class CidadeNotFoundException extends RuntimeException{
    public CidadeNotFoundException (UUID id){
        super("Cidade com id: %s não encontrado! Reveja o que foi solicitado.".formatted(id));
    }
}

