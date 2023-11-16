package br.com.pihoteisepousadas.Projeto.app.api.dto.response;

import br.com.pihoteisepousadas.Projeto.domain.entity.Qualificacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CategoriaListResponse {
    private UUID id;
    private Qualificacao qualificacao;
    private String descricao;
    private String urlImagem;
}
