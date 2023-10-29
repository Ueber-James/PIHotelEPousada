package br.com.pihoteisepousadas.Projeto.app.api.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;
@Getter
@Setter
public class EnderecoListResponse {
    private UUID id;
    private String logradouro;
    private String bairro;
    private LocalDate criadoEm;
    private LocalDate atualizadoEm;
    private String cidade;
    private String estado;
    private  String cep;
}
