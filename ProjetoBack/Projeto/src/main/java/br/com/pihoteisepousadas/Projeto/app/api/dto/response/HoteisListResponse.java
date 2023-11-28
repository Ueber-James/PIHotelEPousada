package br.com.pihoteisepousadas.Projeto.app.api.dto.response;

import br.com.pihoteisepousadas.Projeto.domain.entity.Produto;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
public class HoteisListResponse {
    private UUID id;
    private String nome;
    private String cnpj;
    private String razaoSocial;
    private String descricao;
    private Produto produto;
    private String rua;
    private String numero;
    private String pais;
}
