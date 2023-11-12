package br.com.pihoteisepousadas.Projeto.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String logradouro;
    @Column(length = 150, nullable = false)
    private String bairro;
    private LocalDate criadoEm;
    private LocalDate atualizadoEm;
    @Column(length = 100, nullable = false)
    private String cidade;
    @Column(length = 2, nullable = false)
    private String estado;
    @Column(length = 10, nullable = false)
    private  String cep;

    public Endereco() {
        this.id = id;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }


}
