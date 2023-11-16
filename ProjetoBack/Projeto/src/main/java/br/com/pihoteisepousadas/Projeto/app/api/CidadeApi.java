package br.com.pihoteisepousadas.Projeto.app.api;

import br.com.pihoteisepousadas.Projeto.app.api.dto.request.CreateCidadeRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.CidadeListResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;
@RequestMapping("v1/cidades")
public interface CidadeApi {
    @GetMapping
    ResponseEntity<Page<CidadeListResponse>> buscarCidade(@PageableDefault Pageable pageable);
    @PostMapping
    ResponseEntity<CidadeListResponse> criarCidade(@RequestBody @Valid CreateCidadeRequest request);
    @GetMapping("{id}")
    ResponseEntity<CidadeListResponse> buscarCidadePorId(@PathVariable UUID id);
    @PatchMapping("{id}")
    ResponseEntity<CidadeListResponse> atualizarCidadePorId(@PathVariable UUID Id, Map<String, Object> campos);
    @DeleteMapping("{id}")
    ResponseEntity<Void> excluirCidade(@PathVariable UUID id);
}
