package br.com.pihoteisepousadas.Projeto.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length = 80, nullable = false)
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "endereco_id",
            referencedColumnName = "id",
            foreignKey =
            @ForeignKey(name = "fk_endereco_cliente"))
    private Endereco endereco;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private Genero genero;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "contato_id",
            referencedColumnName = "id",
            foreignKey =
            @ForeignKey(name = "fk_contato_cliente"))
    private Contato contato;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "cidade_id",
            referencedColumnName = "id",
            foreignKey =
            @ForeignKey(name = "fk_cidade_cliente"))
    private Cidade cidade;

    @PrePersist
    public  void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        this.criadoEm = now;
        this.atualizadoEm = now;
    }
    @PreUpdate
    public void preUpdate() {
        this.atualizadoEm = LocalDateTime.now();
    }

    private void validar(){
        if (nome == null) {
            throw new IllegalArgumentException("'nome' não informado!");
        }
    }

}
