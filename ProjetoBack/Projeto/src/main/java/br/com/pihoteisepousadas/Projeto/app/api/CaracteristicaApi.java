package br.com.pihoteisepousadas.Projeto.app.api;

import br.com.pihoteisepousadas.Projeto.app.api.dto.request.CreateCaracteristicaRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.CaracteristicaListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;
@RequestMapping("/caracteristicas")
@Tag(name = "Caracteríticas", description = "Gerenciamento de Características")
@SecurityRequirement(name = "jwt_auth")
public interface CaracteristicaApi {
    @Tag(name = "Característica", description = "Gerenciamento de Características")
    @GetMapping
    @Operation(summary = "Buscar todas as características", description = "Obtém uma lista paginada de todas as características.")
    ResponseEntity<Page<CaracteristicaListResponse>> buscarCaracteristica(@PageableDefault Pageable pageable);
    @PostMapping
    @Operation(summary = "Criar uma nova característica", description = "Cria uma nova característica com base nos dados fornecidos.")
    ResponseEntity<CaracteristicaListResponse> criarCaracteristica(@RequestBody @Valid CreateCaracteristicaRequest request);
    @GetMapping("{id}")
    @Operation(summary = "Buscar característica por ID", description = "Obtém as informações de uma característica específica com base no ID fornecido.")
    ResponseEntity<CaracteristicaListResponse> buscarCaracteristicaPorId(@PathVariable UUID id);
    @PatchMapping("{id}")
    @Operation(summary = "Atualizar característica por ID", description = "Atualiza as informações de uma característica específica com base no ID fornecido.")
    ResponseEntity<CaracteristicaListResponse> atualizarCaracteristicaPorId(@PathVariable UUID Id, Map<String, Object> campos);
    @DeleteMapping("{id}")
    @Operation(summary = "Excluir característica por ID", description = "Exclui uma característica específica com base no ID fornecido.")
    ResponseEntity<Void> excluirCaracteristica(@PathVariable UUID id);
}
