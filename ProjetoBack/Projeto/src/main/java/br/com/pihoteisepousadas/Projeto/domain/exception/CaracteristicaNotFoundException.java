package br.com.pihoteisepousadas.Projeto.domain.exception;

import java.util.UUID;

public class CaracteristicaNotFoundException extends RuntimeException{
    public CaracteristicaNotFoundException(UUID id){
        super("Caracteristica com id: %s não encontrado! Reveja o que foi solicitado.".formatted(id));
    }
}

