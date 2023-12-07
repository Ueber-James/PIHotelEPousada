package br.com.pihoteisepousadas.Projeto.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "hospedagens")
public class Hospedagem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "usuario_id",
            referencedColumnName = "id",
            foreignKey =
            @ForeignKey(name = "fk_usuario_hospedagem"))
    private Usuario usuario;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "hoteis_id",
            referencedColumnName = "id",
            foreignKey =
            @ForeignKey(name = "fk_hoteis_hospedagem"))
    private Hoteis hoteis;
    private LocalDate dataHospedagem;
    private Boolean cancelada;
    private String valor;
    private void validar(){
        if (id == null) {
            throw new IllegalArgumentException("'id' não informado!");
        }
    }

}
