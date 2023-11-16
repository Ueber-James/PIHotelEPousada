package br.com.pihoteisepousadas.Projeto.domain.service.impl;

import br.com.pihoteisepousadas.Projeto.domain.entity.Cidade;
import br.com.pihoteisepousadas.Projeto.domain.exception.CidadeNotFoundException;
import br.com.pihoteisepousadas.Projeto.domain.repository.CidadeRepository;
import br.com.pihoteisepousadas.Projeto.domain.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class CidadeServiceImpl implements CidadeService {
    @Autowired
    private final CidadeRepository cidadeRepository;

    public CidadeServiceImpl(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    @Override
    public Cidade criarCidade(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    @Override
    public Page<Cidade> buscarCidade(Pageable pageable) {
        return cidadeRepository.findAll(pageable);
    }

    @Override
    public Cidade buscarCidadePorId(UUID id) {
        return cidadeRepository.findById(id).orElseThrow(()->
                new CidadeNotFoundException(id));
    }

    @Override
    public Cidade atualizarCidade(UUID id) {
        return null;
    }

    @Override
    public void excluirCidade(UUID id) {
        Cidade cidade = cidadeRepository.findById(id).orElseThrow(() ->
                new CidadeNotFoundException(id));
        cidadeRepository.delete(cidade);

    }
}
