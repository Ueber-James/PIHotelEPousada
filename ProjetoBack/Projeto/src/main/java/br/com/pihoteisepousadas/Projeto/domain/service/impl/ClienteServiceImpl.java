package br.com.pihoteisepousadas.Projeto.domain.service.impl;

import br.com.pihoteisepousadas.Projeto.domain.entity.Cliente;
import br.com.pihoteisepousadas.Projeto.domain.exception.ClienteNotFoundException;
import br.com.pihoteisepousadas.Projeto.domain.repository.ClienteRepository;
import br.com.pihoteisepousadas.Projeto.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;
    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Page<Cliente> buscarCliente(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    @Override
    public Cliente buscarClientePorId(UUID id) {
        return clienteRepository.findById(id).orElseThrow(() ->
        new ClienteNotFoundException(id));
    }

    @Override
    public Cliente atualizarCliente(UUID id) {
        return null;
    }

    @Override
    public void excluirCliente(UUID id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() ->
                new ClienteNotFoundException(id));
        clienteRepository.delete(cliente);

    }
}
