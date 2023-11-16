package br.com.pihoteisepousadas.Projeto.app.api.dto.request;

import br.com.pihoteisepousadas.Projeto.domain.entity.Qualificacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCategoriaRequest {
    @NotNull
    private Qualificacao qualificacao;
    @NotNull
    private String descricao;
    @NotBlank
    private String urlImagem;
}
