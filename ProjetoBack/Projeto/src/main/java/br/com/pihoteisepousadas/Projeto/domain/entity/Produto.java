package br.com.pihoteisepousadas.Projeto.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private  String nome;
    private String descricao;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "caracteristica_id",
            referencedColumnName = "id",
            foreignKey =
            @ForeignKey(name = "fk_caracteristica_produto"))
    private Caracteristica caracteristica;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "imagem_id",
            referencedColumnName = "id",
            foreignKey =
            @ForeignKey(name = "fk_imagem_produto"))
    private Imagem imagem;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "categoria_id",
            referencedColumnName = "id",
            foreignKey =
            @ForeignKey(name = "fk_categoria_produto"))
    private Categoria categoria;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "cidade_id",
            referencedColumnName = "id",
            foreignKey =
            @ForeignKey(name = "fk_cidade_hospedagem"))
    private Cidade cidade;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "acomodacao_id",
            referencedColumnName = "id",
            foreignKey =
            @ForeignKey(name = "fk_acomodacao_produto"))
    private Hoteis acomodacao;

}
