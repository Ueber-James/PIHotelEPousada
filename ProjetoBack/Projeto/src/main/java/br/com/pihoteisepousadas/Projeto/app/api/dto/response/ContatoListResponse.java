package br.com.pihoteisepousadas.Projeto.app.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
public class ContatoListResponse {
    private UUID id;
    private String telefone;
    private String email;
    private LocalDate criadoEm;
    private LocalDate atualizadoEm;
    private  String fax;
}
