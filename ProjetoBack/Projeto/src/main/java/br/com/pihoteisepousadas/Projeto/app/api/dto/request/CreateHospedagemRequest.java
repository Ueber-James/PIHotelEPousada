package br.com.pihoteisepousadas.Projeto.app.api.dto.request;

import br.com.pihoteisepousadas.Projeto.domain.entity.Hoteis;
import br.com.pihoteisepousadas.Projeto.domain.entity.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class CreateHospedagemRequest {
    @NotBlank
    private Usuario usuario;
    private Hoteis hoteis;
    @NotNull
    private LocalDate dataHospedagem;
    @NotBlank
    private Boolean cancelada;
    @NotNull
    private String valor;
}
