package br.com.pihoteisepousadas.Projeto.app.api.dto.request;

import br.com.pihoteisepousadas.Projeto.domain.entity.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
@Getter
@Setter
public class CreateHoteisRequest {
    @NotBlank
    private String nome;
    @CNPJ
    private String cnpj;
    @NotNull
    private String razaoSocial;
    private String descricao;
    private Produto produto;
    @NotNull
    private String rua;
    @NotNull
    private String numero;
    @NotNull
    private String pais;

}
