package br.com.pihoteisepousadas.Projeto.app.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class CreateHospedagemRequest {
    @NotBlank
    private LocalDate dataConsulta;
    @NotBlank
    private Boolean cancelada;
}
