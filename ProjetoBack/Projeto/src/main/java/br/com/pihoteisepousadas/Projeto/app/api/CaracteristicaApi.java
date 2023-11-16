package br.com.pihoteisepousadas.Projeto.app.api;

import br.com.pihoteisepousadas.Projeto.app.api.dto.request.CreateCaracteristicaRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.CaracteristicaListResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;
@RequestMapping("v1/caracteristicas")
public interface CaracteristicaApi {
    @GetMapping
    ResponseEntity<Page<CaracteristicaListResponse>> buscarCaracteristica(@PageableDefault Pageable pageable);
    @PostMapping
    ResponseEntity<CaracteristicaListResponse> criarCaracteristica(@RequestBody @Valid CreateCaracteristicaRequest request);
    @GetMapping("{id}")
    ResponseEntity<CaracteristicaListResponse> buscarCaracteristicaPorId(@PathVariable UUID id);
    @PatchMapping("{id}")
    ResponseEntity<CaracteristicaListResponse> atualizarCaracteristicaPorId(@PathVariable UUID Id, Map<String, Object> campos);
    @DeleteMapping("{id}")
    ResponseEntity<Void> excluirCaracteristica(@PathVariable UUID id);
}
