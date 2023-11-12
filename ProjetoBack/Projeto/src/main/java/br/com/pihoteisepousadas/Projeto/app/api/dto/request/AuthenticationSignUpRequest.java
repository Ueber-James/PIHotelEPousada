package br.com.pihoteisepousadas.Projeto.app.api.dto.request;

import br.com.pihoteisepousadas.Projeto.domain.entity.security.UserPermission;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class AuthenticationSignUpRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotNull
    private LocalDate dataNascimento;
    @NotNull
    private UserPermission role;
}
