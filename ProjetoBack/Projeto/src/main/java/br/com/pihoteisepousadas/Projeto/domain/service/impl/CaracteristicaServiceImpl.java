package br.com.pihoteisepousadas.Projeto.domain.service.impl;

import br.com.pihoteisepousadas.Projeto.domain.entity.Caracteristica;
import br.com.pihoteisepousadas.Projeto.domain.exception.CaracteristicaNotFoundException;
import br.com.pihoteisepousadas.Projeto.domain.repository.CaracteristicaRepository;
import br.com.pihoteisepousadas.Projeto.domain.service.CaracteristicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CaracteristicaServiceImpl implements CaracteristicaService {
    private final CaracteristicaRepository caracteristicaRepository;
    @Autowired
    public CaracteristicaServiceImpl(CaracteristicaRepository caracteristicaRepository) {
        this.caracteristicaRepository = caracteristicaRepository;
    }

    @Override
    public Caracteristica criarCaracteristica(Caracteristica caracteristica) {
        return caracteristicaRepository.save(caracteristica);
    }

    @Override
    public Page<Caracteristica> buscarCaracteristica(Pageable pageable) {
        return caracteristicaRepository.findAll(pageable);
    }

    @Override
    public Caracteristica buscarCaracteristicaPorId(UUID id) {
        return caracteristicaRepository.findById(id).orElseThrow(()->
                new CaracteristicaNotFoundException(id));
    }

    @Override
    public Caracteristica atualizarCaracteristica(UUID id) {
        return null;
    }

    @Override
    public void excluirCaracteristica(UUID id) {
        Caracteristica caracteristica = caracteristicaRepository.findById(id).orElseThrow(() ->
                new CaracteristicaNotFoundException(id));
        caracteristicaRepository.delete(caracteristica);

    }
}
