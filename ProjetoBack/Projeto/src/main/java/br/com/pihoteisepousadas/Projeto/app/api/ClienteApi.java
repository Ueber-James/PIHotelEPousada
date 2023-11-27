package br.com.pihoteisepousadas.Projeto.app.api;

import br.com.pihoteisepousadas.Projeto.app.api.dto.request.CreateClienteRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.ClienteListResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;
@RequestMapping("v1/clientes")
public interface ClienteApi {
    @GetMapping
    ResponseEntity<Page<ClienteListResponse>> buscarCliente(@PageableDefault Pageable pageable);
    @PostMapping
    ResponseEntity<ClienteListResponse> criarCliente(@RequestBody @Valid CreateClienteRequest request);
    @GetMapping("{id}")
    ResponseEntity<ClienteListResponse> buscarClientePorId(@PathVariable UUID id);
    @PatchMapping("{id}")
    ResponseEntity<ClienteListResponse> atualizarClientePorId(@PathVariable UUID Id, Map<String, Object> campos);
    @DeleteMapping("{id}")
    ResponseEntity<Void> excluirCliente(@PathVariable UUID id);
}