package br.com.pihoteisepousadas.Projeto.domain.entity.security;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class SignUp {
    private String nome;
    private String sobrenome;
    private String password;
    private String email;
    private UserPermission role;
}
