package br.com.pihoteisepousadas.Projeto.app.api;

import br.com.pihoteisepousadas.Projeto.app.api.dto.request.CreateHospedagemRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.HospedagemListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RequestMapping("/hospedagens")
@Tag(name = "Hospedagem", description = "Gerenciamento de Hospedagens")
@SecurityRequirement(name = "jwt_auth")

public interface HospedagemApi {
    @SecurityRequirement(name = "jwt_auth")

    @GetMapping
    @PreAuthorize("hasAuthority('USER')")
    @Operation(summary = "Buscar todas as hospedagens",
            description = "Obtém uma lista paginada de todas as hospedagens.")
    ResponseEntity<Page<HospedagemListResponse>> buscarHospedagem(@PageableDefault Pageable pageable);

    @PostMapping
    @PreAuthorize("hasAuthority('USER')")
    @Operation(summary = "Criar uma nova hospedagem",
            description = "Cria uma nova hospedagem com base nos dados fornecidos.")
    ResponseEntity<HospedagemListResponse> criarHospedagem(
            @RequestBody @Valid CreateHospedagemRequest request);

    @GetMapping("{id}")
    @Operation(summary = "Buscar hospedagem por ID",
            description = "Obtém as informações de uma hospedagem específica com base no ID fornecido.")
    ResponseEntity<HospedagemListResponse> buscarHospedagemPorId(@PathVariable UUID id);

    @PatchMapping("{id}")
    @Operation(summary = "Atualizar hospedagem por ID",
            description = "Atualiza as informações de uma hospedagem específica com base no ID fornecido.")
    ResponseEntity<HospedagemListResponse> atualizarHospedagemPorId(
            @PathVariable UUID id,
            @RequestBody Map<String, Object> campos);

    @DeleteMapping("{id}")
    @Operation(summary = "Excluir hospedagem por ID",
            description = "Exclui uma hospedagem específica com base no ID fornecido.")
    ResponseEntity<Void> excluirHospedagem(@PathVariable UUID id);
}
