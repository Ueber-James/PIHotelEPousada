package br.com.pihoteisepousadas.Projeto.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@Entity
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private  String nome;
    private String pais;
    
}
