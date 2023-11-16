package br.com.pihoteisepousadas.Projeto.app.api;

import br.com.pihoteisepousadas.Projeto.app.api.dto.request.CreateProdutoRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.ProdutoListResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;
@RequestMapping("v1/produtos")
public interface ProdutoApi {
    @GetMapping
    ResponseEntity<Page<ProdutoListResponse>> buscarProduto(@PageableDefault Pageable pageable);
    @PostMapping
    ResponseEntity<ProdutoListResponse> criarProduto(@RequestBody @Valid CreateProdutoRequest request);
    @GetMapping("{id}")
    ResponseEntity<ProdutoListResponse> buscarProdutoPorId(@PathVariable UUID id);
    @PatchMapping("{id}")
    ResponseEntity<ProdutoListResponse> atualizarProdutoPorId(@PathVariable UUID Id, Map<String, Object> campos);
    @DeleteMapping("{id}")
    ResponseEntity<Void> excluirProduto(@PathVariable UUID id);
}
