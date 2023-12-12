package br.com.pihoteisepousadas.Projeto.app.api.controller;

import br.com.pihoteisepousadas.Projeto.app.api.dto.request.AuthenticationSignInRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.request.AuthenticationSignUpRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.AuthenticationResponse;
import br.com.pihoteisepousadas.Projeto.domain.entity.security.SignIn;
import br.com.pihoteisepousadas.Projeto.domain.entity.security.SignUp;
import br.com.pihoteisepousadas.Projeto.domain.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
@Tag(name = "Autenticação", description = "Gerenciamento de Autenticação")
@SecurityRequirement(name = "jwt_auth")
public class AuthenticationController {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping(value = "/sign-in")

    @Operation(summary = "Autenticar usuário",
            description = "Gera um token de autenticação para o usuário com base nas credenciais fornecidas.")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody @Valid AuthenticationSignInRequest request) throws Exception {
        SignIn signIn = new SignIn(request.getEmail(), request.getPassword());

        try {
            String jwt = authenticationService.signIn(signIn);
            return ResponseEntity.ok(new AuthenticationResponse(jwt));
        } catch (Exception e) {
            logger.error("Erro ao autenticar usuário: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Falha na autenticação");
        }
    }

    @PostMapping(value = "/sign-up")
    @Operation(summary = "Registrar novo usuário", description = "Registra um novo usuário com base nas informações fornecidas.")
    public ResponseEntity<?> createNewUser(@RequestBody @Valid AuthenticationSignUpRequest request) {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        try {
            SignUp signUp = SignUp.builder()
                    .nome(request.getNome())
                    .email(request.getEmail())
                    .password(request.getPassword())
                    .sobrenome(request.getSobrenome())
                    .role(request.getRole())
                    .build();
            authenticationService.signUp(signUp);


            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado com sucesso!");
        } catch (Exception e) {

            logger.error("Ocorreu um erro ao criar o usuário: ", e);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar o usuário");
        }
    }

   /* @PostMapping(value = "/sign-up")
    @Operation(summary = "Registrar novo usuário", description = "Registra um novo usuário com base nas informações fornecidas.")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody @Valid AuthenticationSignUpRequest request) {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        try {
            SignUp signUp = SignUp.builder()
                    .nome(request.getNome())
                    .email(request.getEmail())
                    .password(request.getPassword())
                    .sobrenome(request.getSobrenome())
                    .role(request.getRole())
                    .build();
            String jwt = authenticationService.signUp(signUp);
            return ResponseEntity.status(HttpStatus.CREATED).body(new AuthenticationResponse(jwt));
        } catch (Exception e) {
            // Log the exception
            logger.error("Ocorreu um erro: ", e);
            // Re-throw the exception
            throw e;
        }
    } */
}
