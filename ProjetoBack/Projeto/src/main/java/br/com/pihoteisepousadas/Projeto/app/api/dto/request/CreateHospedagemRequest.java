package br.com.pihoteisepousadas.Projeto.app.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class CreateHospedagemRequest {
    @NotNull
    private LocalDate dataConsulta;
    @NotBlank
    private Boolean cancelada;
}
