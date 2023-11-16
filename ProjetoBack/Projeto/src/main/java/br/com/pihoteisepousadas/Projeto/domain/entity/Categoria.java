package br.com.pihoteisepousadas.Projeto.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Qualificacao qualificacao;
    private String descricao;
    private String urlImagem;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "produto_id",
            referencedColumnName = "id",
            foreignKey =
            @ForeignKey(name = "fk_produto_categoria"))
    private Produto produto;

}
