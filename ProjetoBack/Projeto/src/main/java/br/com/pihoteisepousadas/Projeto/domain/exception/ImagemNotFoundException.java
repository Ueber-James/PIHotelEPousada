package br.com.pihoteisepousadas.Projeto.domain.exception;

import java.util.UUID;

public class ImagemNotFoundException extends RuntimeException{
    public ImagemNotFoundException (UUID id){
        super("Imagem com id: %s não encontrado! Reveja o que foi solicitado.".formatted(id));
    }
}

