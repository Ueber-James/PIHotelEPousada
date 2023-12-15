package br.com.pihoteisepousadas.Projeto.app.api.dto.request;

import br.com.pihoteisepousadas.Projeto.domain.entity.security.UserPermission;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class AuthenticationSignUpRequest {
    @NotNull
    @Schema(example = "João", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
    @NotNull
    @Schema(example = "de Souza", requiredMode = Schema.RequiredMode.REQUIRED)
    private String lastname;
    @NotBlank
    @Schema(example = "seu_email@email.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;
    @NotBlank
    @Schema(example = "123456", requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;
    @NotNull

    @Schema(example = "USER", requiredMode = Schema.RequiredMode.REQUIRED)
    private UserPermission role;
}
