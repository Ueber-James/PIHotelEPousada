package br.com.pihoteisepousadas.Projeto.domain.service.impl;

import br.com.pihoteisepousadas.Projeto.domain.entity.Acomodacao;
import br.com.pihoteisepousadas.Projeto.domain.exception.AcomodacaoNotFoundException;
import br.com.pihoteisepousadas.Projeto.domain.repository.AcomodacaoRepository;
import br.com.pihoteisepousadas.Projeto.domain.service.AcomodacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class AcomodacaoServiceImpl implements AcomodacaoService {
    private final AcomodacaoRepository acomodacaoRepository;
    @Autowired
    public AcomodacaoServiceImpl(AcomodacaoRepository acomodacaoRepository) {
        this.acomodacaoRepository = acomodacaoRepository;
    }

    @Override
    public Acomodacao criarAcomodacao(Acomodacao acomodacao) {
        return acomodacaoRepository.save(acomodacao);
    }

    @Override
    public Page<Acomodacao> buscarAcomodacao(Pageable pageable) {
        return acomodacaoRepository.findAll(pageable);
    }

    @Override
    public Acomodacao buscarAcomodacaoPorId(UUID id) {
        return acomodacaoRepository.findById(id).orElseThrow(() ->
                new AcomodacaoNotFoundException(id));
    }

    @Override
    public Acomodacao atualizarAcomodacao(UUID id) {
        return null;
    }

    @Override
    public void excluirAcomodacao(UUID id) {
        Acomodacao acomodacao = acomodacaoRepository.findById(id).orElseThrow(() ->
                new AcomodacaoNotFoundException(id));
        acomodacaoRepository.delete(acomodacao);

    }
}
