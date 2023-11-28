package br.com.pihoteisepousadas.Projeto.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "hoteis")
public class Hoteis {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String cnpj;
    @Column(nullable = false)
    private String razaoSocial;
    private String descricao;
    @Column(nullable = false)
    private String rua;
    @Column(nullable = false)
    private String numero;
    @Column(length = 15, nullable = false)
    private String pais;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "produto_id",
            referencedColumnName = "id",
            foreignKey =
            @ForeignKey(name = "fk_produto_hoteis"))
    private Produto produto;
    private void validar(){
        if (nome == null) {
            throw new IllegalArgumentException("'nome' não informado!");
        }
    }
}