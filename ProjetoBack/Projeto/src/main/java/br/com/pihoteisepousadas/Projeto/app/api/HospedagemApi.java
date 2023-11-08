package br.com.pihoteisepousadas.Projeto.app.api;

import br.com.pihoteisepousadas.Projeto.app.api.dto.request.CreateHospedagemRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.HospedagemListResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;
@RequestMapping("v1/hospedagens")
public interface HospedagemApi {
    @GetMapping
    ResponseEntity<Page<HospedagemListResponse>> buscarHospedagem(@PageableDefault Pageable pageable);
    @PostMapping
    ResponseEntity<HospedagemListResponse> criarHospedagem(@RequestBody @Valid CreateHospedagemRequest request);
    @GetMapping("{id}")
    ResponseEntity<HospedagemListResponse> buscarHospedagemPorId(@PathVariable UUID id);
    @PatchMapping("{id}")
    ResponseEntity<HospedagemListResponse> atualizarHospedagemPorId(@PathVariable UUID Id, Map<String, Object> campos);
    @DeleteMapping("{id}")
    ResponseEntity<Void> excluirHospedagem(@PathVariable UUID id);
}
