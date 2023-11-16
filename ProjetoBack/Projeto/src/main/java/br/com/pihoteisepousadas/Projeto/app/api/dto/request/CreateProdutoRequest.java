package br.com.pihoteisepousadas.Projeto.app.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProdutoRequest {
    @NotBlank
    private  String nome;
    @NotNull
    private String descricao;
}
