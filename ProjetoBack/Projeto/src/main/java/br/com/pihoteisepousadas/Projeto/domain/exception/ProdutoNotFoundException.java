package br.com.pihoteisepousadas.Projeto.domain.exception;

import java.util.UUID;

public class ProdutoNotFoundException extends RuntimeException{
    public ProdutoNotFoundException (UUID id){
        super("Produto com id: %s não encontrado! Reveja o que foi solicitado.".formatted(id));
    }
}

