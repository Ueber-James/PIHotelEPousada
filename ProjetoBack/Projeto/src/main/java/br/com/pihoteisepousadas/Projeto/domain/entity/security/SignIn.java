package br.com.pihoteisepousadas.Projeto.domain.entity.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignIn {
    private String email;
    private String password;
}
