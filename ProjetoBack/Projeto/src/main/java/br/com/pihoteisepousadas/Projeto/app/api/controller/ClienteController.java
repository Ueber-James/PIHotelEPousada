package br.com.pihoteisepousadas.Projeto.app.api.controller;

import br.com.pihoteisepousadas.Projeto.app.api.ClienteApi;
import br.com.pihoteisepousadas.Projeto.app.api.dto.request.CreateClienteRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.ClienteListResponse;
import br.com.pihoteisepousadas.Projeto.domain.entity.Cliente;
import br.com.pihoteisepousadas.Projeto.domain.service.ClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;
@RestController
public class ClienteController implements ClienteApi {
    private final ClienteService clienteService;
    private final ObjectMapper mapper;
    @Autowired
    public ClienteController(ClienteService clienteService, ObjectMapper mapper) {
        this.clienteService = clienteService;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<Page<ClienteListResponse>> buscarCliente(Pageable pageable) {
        Page<Cliente> clientePage = clienteService.buscarCliente(pageable);

        Page<ClienteListResponse> response = clientePage
                .map(cliente -> new ClienteListResponse(
                        cliente.getId(),
                        cliente.getNome(),
                        cliente.getSobrenome(),
                        cliente.getDataNascimento()
                ));
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ClienteListResponse> criarCliente(CreateClienteRequest request) {
        Cliente cliente = mapper.convertValue(request, Cliente.class);
        Cliente clienteCriado = clienteService.criarCliente(cliente);
        ClienteListResponse clienteListResponse = clienteParaClienteListResponse(clienteCriado);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteListResponse);
    }

    @Override
    public ResponseEntity<ClienteListResponse> buscarClientePorId(UUID id) {
        Cliente cliente = clienteService.buscarClientePorId(id);
        ClienteListResponse clienteListResponse = clienteParaClienteListResponse(cliente);
        return ResponseEntity.ok(clienteListResponse);
    }

    @Override
    public ResponseEntity<ClienteListResponse> atualizarClientePorId(UUID id, Map<String, Object> campos) {
        Cliente cliente = clienteService.atualizarCliente(id);
        ClienteListResponse clienteListResponse = clienteParaClienteListResponse(cliente);
        return ResponseEntity.accepted().body(clienteListResponse);
    }

    @Override
    public ResponseEntity<Void> excluirCliente(UUID id) {
        clienteService.excluirCliente(id);
        return ResponseEntity.noContent().build();
    }

    private ClienteListResponse clienteParaClienteListResponse (Cliente cliente){
        return mapper.convertValue(cliente, ClienteListResponse.class);
    }
}
