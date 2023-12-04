package br.com.pihoteisepousadas.Projeto.app.api;

import br.com.pihoteisepousadas.Projeto.app.api.dto.request.CreateProdutoRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.ProdutoListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

@RequestMapping("v1/produtos")
@Tag(name = "Produtos", description = "Gerenciamento de Produtos")
public interface ProdutoApi {

    @GetMapping
    @Operation(summary = "Buscar todos os produtos", description = "Obtém uma lista paginada de todos os produtos.")
    @SecurityRequirement(name = "jwt_auth")

    ResponseEntity<Page<ProdutoListResponse>> buscarProduto(@PageableDefault Pageable pageable);

    @PostMapping
    @Operation(summary = "Criar um novo produto", description = "Cria um novo produto com base nos dados fornecidos.")
    ResponseEntity<ProdutoListResponse> criarProduto(@RequestBody @Valid CreateProdutoRequest request);

    @GetMapping("{id}")
    @Operation(summary = "Buscar produto por ID", description = "Obtém as informações de um produto específico com base no ID fornecido.")
    ResponseEntity<ProdutoListResponse> buscarProdutoPorId(@PathVariable UUID id);

    @PatchMapping("{id}")
    @Operation(summary = "Atualizar produto por ID", description = "Atualiza as informações de um produto específico com base no ID fornecido.")
    ResponseEntity<ProdutoListResponse> atualizarProdutoPorId(@PathVariable UUID id, @RequestBody Map<String, Object> campos);

    @DeleteMapping("{id}")
    @Operation(summary = "Excluir produto por ID", description = "Exclui um produto específico com base no ID fornecido.")
    ResponseEntity<Void> excluirProduto(@PathVariable UUID id);
}
