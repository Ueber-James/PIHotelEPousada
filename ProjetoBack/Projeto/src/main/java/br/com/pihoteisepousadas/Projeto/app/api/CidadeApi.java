package br.com.pihoteisepousadas.Projeto.app.api;

import br.com.pihoteisepousadas.Projeto.app.api.dto.request.CreateCidadeRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.CidadeListResponse;
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

@RequestMapping("v1/cidades")
@Tag(name = "Cidade", description = "Gerenciamento de Cidades")
@SecurityRequirement(name = "jwt_auth")
public interface CidadeApi {

    @GetMapping
    @Operation(summary = "Buscar todas as cidades", description = "Obtém uma lista paginada de todas as cidades.")
    ResponseEntity<Page<CidadeListResponse>> buscarCidade(@PageableDefault Pageable pageable);

    @PostMapping
    @Operation(summary = "Criar uma nova cidade", description = "Cria uma nova cidade com base nos dados fornecidos.")
    ResponseEntity<CidadeListResponse> criarCidade(@RequestBody @Valid CreateCidadeRequest request);

    @GetMapping("{id}")
    @Operation(summary = "Buscar cidade por ID", description = "Obtém as informações de uma cidade específica com base no ID fornecido.")
    ResponseEntity<CidadeListResponse> buscarCidadePorId(@PathVariable UUID id);

    @PatchMapping("{id}")
    @Operation(summary = "Atualizar cidade por ID", description = "Atualiza as informações de uma cidade específica com base no ID fornecido.")
    ResponseEntity<CidadeListResponse> atualizarCidadePorId(@PathVariable UUID id, @RequestBody Map<String, Object> campos);

    @DeleteMapping("{id}")
    @Operation(summary = "Excluir cidade por ID", description = "Exclui uma cidade específica com base no ID fornecido.")
    ResponseEntity<Void> excluirCidade(@PathVariable UUID id);

}
