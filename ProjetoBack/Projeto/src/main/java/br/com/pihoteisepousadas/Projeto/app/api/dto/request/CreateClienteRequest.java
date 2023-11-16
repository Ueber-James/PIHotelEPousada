package br.com.pihoteisepousadas.Projeto.app.api.dto.request;

import br.com.pihoteisepousadas.Projeto.domain.entity.Genero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class CreateClienteRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private LocalDate dataNascimento;
    @NotNull
    private CreateEnderecoRequest endereco;
    private LocalDate criadoEm;
    private LocalDate atualizadoEm;
    @NotBlank
    private Genero genero;
    @NotNull
    private CreateContatoRequest contato;
}
