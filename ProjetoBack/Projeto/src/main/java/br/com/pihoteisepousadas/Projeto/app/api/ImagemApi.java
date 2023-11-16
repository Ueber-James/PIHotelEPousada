package br.com.pihoteisepousadas.Projeto.app.api;

import br.com.pihoteisepousadas.Projeto.app.api.dto.request.CreateImagemRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.ImagemListResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RequestMapping("v1/imagens")
public interface ImagemApi {
    @GetMapping
    ResponseEntity<Page<ImagemListResponse>> buscarImagem(@PageableDefault Pageable pageable);
    @PostMapping
    ResponseEntity<ImagemListResponse> criarImagem(@RequestBody @Valid CreateImagemRequest request);
    @GetMapping("{id}")
    ResponseEntity<ImagemListResponse> buscarImagemPorId(@PathVariable UUID id);
    @PatchMapping("{id}")
    ResponseEntity<ImagemListResponse> atualizarImagemPorId(@PathVariable UUID Id, Map<String, Object> campos);
    @DeleteMapping("{id}")
    ResponseEntity<Void> excluirImagem(@PathVariable UUID id);

}
