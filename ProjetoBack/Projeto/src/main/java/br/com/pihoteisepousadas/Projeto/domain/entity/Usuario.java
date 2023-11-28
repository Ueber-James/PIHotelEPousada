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
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length = 80, nullable = false)
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private String confirmarSenha;
    private void validar(){
        if (nome == null) {
            throw new IllegalArgumentException("'nome' não informado!");
        }
    }

}
