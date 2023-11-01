package br.com.pihoteisepousadas.Projeto.app.api.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class CreateEnderecoRequest {
    private String logradouro;
    private String bairro;
    private LocalDate criadoEm;
    private LocalDate atualizadoEm;
    private String cidade;
    private String estado;
    private  String cep;
}
