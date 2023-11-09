package br.com.pihoteisepousadas.Projeto.app.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
@Getter
@Setter
public class CreateAcomodacaoRequest {
    @NotBlank
    private String nome;
    @CNPJ
    private String cnpj;
    @NotNull
    private String razaoSocial;

}
