package br.com.pihoteisepousadas.Projeto.app.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateCaracteristicaRequest {
    @NotBlank
    private String nome;
    @NotNull
    private String icone;
}
