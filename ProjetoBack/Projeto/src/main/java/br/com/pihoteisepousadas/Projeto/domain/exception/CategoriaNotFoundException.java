package br.com.pihoteisepousadas.Projeto.domain.exception;

import java.util.UUID;

public class CategoriaNotFoundException extends RuntimeException{
    public CategoriaNotFoundException(UUID id){
        super("Categoria com id: %s não encontrado! Reveja o que foi solicitado.".formatted(id));
    }
}
