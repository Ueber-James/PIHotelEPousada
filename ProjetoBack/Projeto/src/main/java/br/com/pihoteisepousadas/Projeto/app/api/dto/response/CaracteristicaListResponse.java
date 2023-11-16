package br.com.pihoteisepousadas.Projeto.app.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CaracteristicaListResponse {
    private UUID id;
    private String nome;
    private String icone;
}
