package br.com.pihoteisepousadas.Projeto.app.api;

import br.com.pihoteisepousadas.Projeto.app.api.dto.request.CreateAcomodacaoRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.AcomodacaoListResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RequestMapping("v1/acomodacoes")
public interface AcomodacaoApi {
    @GetMapping
    ResponseEntity<Page<AcomodacaoListResponse>> buscarAcomodacao(@PageableDefault Pageable pageable);
    @PostMapping
    ResponseEntity<AcomodacaoListResponse> criarAcomodacao(@RequestBody @Valid CreateAcomodacaoRequest request);
    @GetMapping("{id}")
    ResponseEntity<AcomodacaoListResponse> buscarAcomodacaoPorId(@PathVariable UUID id);
    @PatchMapping("{id}")
    ResponseEntity<AcomodacaoListResponse> atualizarAcomodacaoPorId(@PathVariable UUID Id, Map<String, Object> campos);
    @DeleteMapping("{id}")
    ResponseEntity<Void> excluirAcomodacao(@PathVariable UUID id);
}
