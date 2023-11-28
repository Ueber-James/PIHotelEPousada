package br.com.pihoteisepousadas.Projeto.app.api;

import br.com.pihoteisepousadas.Projeto.app.api.dto.request.CreateHoteisRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.HoteisListResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RequestMapping("v1/hoteis")
public interface HoteisApi {
    @GetMapping
    ResponseEntity<Page<HoteisListResponse>> buscarHoteis(@PageableDefault Pageable pageable);
    @PostMapping
    ResponseEntity<HoteisListResponse> criarHoteis(@RequestBody @Valid CreateHoteisRequest request);
    @GetMapping("{id}")
    ResponseEntity<HoteisListResponse> buscarHoteisPorId(@PathVariable UUID id);
    @PatchMapping("{id}")
    ResponseEntity<HoteisListResponse> atualizarHoteisPorId(@PathVariable UUID Id, Map<String, Object> campos);
    @DeleteMapping("{id}")
    ResponseEntity<Void> excluirHoteis(@PathVariable UUID id);
}
