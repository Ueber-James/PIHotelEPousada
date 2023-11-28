package br.com.pihoteisepousadas.Projeto.domain.service.impl;

import br.com.pihoteisepousadas.Projeto.domain.entity.Hoteis;
import br.com.pihoteisepousadas.Projeto.domain.exception.HoteisNotFoundException;
import br.com.pihoteisepousadas.Projeto.domain.repository.HoteisRepository;
import br.com.pihoteisepousadas.Projeto.domain.service.HoteisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class HoteisServiceImpl implements HoteisService {
    private final HoteisRepository hoteisRepository;
    @Autowired
    public HoteisServiceImpl(HoteisRepository hoteisRepository) {
        this.hoteisRepository = hoteisRepository;
    }

    @Override
    public Hoteis criarHoteis(Hoteis hoteis) {
        return hoteisRepository.save(hoteis);
    }

    @Override
    public Page<Hoteis> buscarHoteis(Pageable pageable) {
        return hoteisRepository.findAll(pageable);
    }

    @Override
    public Hoteis buscarHoteisPorId(UUID id) {
        return hoteisRepository.findById(id).orElseThrow(() ->
                new HoteisNotFoundException(id));
    }

    @Override
    public Hoteis atualizarHoteis(UUID id) {
        return null;
    }

    @Override
    public void excluirHoteis(UUID id) {
        Hoteis hoteis = hoteisRepository.findById(id).orElseThrow(() ->
                new HoteisNotFoundException(id));
        hoteisRepository.delete(hoteis);

    }
}
