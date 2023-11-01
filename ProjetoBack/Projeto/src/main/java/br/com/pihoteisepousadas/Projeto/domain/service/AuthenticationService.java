package br.com.pihoteisepousadas.Projeto.domain.service;

import br.com.pihoteisepousadas.Projeto.domain.entity.security.SignIn;
import br.com.pihoteisepousadas.Projeto.domain.entity.security.SignUp;

public interface AuthenticationService {
    String signIn(SignIn request);

    String signUp(SignUp request);
}
