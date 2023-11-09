package br.com.pihoteisepousadas.Projeto.domain.service;

import br.com.pihoteisepousadas.Projeto.domain.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ClienteService {
    Cliente criarCliente(Cliente cliente);

    Page<Cliente> buscarCliente(Pageable pageable);

    Cliente buscarClientePorId(UUID id);

    Cliente atualizarCliente(UUID id);

    void excluirCliente(UUID id);
}
