package br.com.pihoteisepousadas.Projeto.app.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class CreateUsuarioRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotNull
    private String email;
    @NotBlank
    private String senha;

}
