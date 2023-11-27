package br.com.pihoteisepousadas.Projeto.app.api.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class CreateContatoRequest {
    private String email;
    private String telefone;
    private LocalDate criadoEm;
    private LocalDate atualizadoEm;
}
