package br.com.pihoteisepousadas.Projeto.app.api.controller;

import br.com.pihoteisepousadas.Projeto.app.api.CaracteristicaApi;
import br.com.pihoteisepousadas.Projeto.app.api.dto.request.CreateCaracteristicaRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.CaracteristicaListResponse;
import br.com.pihoteisepousadas.Projeto.domain.entity.Caracteristica;
import br.com.pihoteisepousadas.Projeto.domain.service.CaracteristicaService;
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
public class CaracteristicaController implements CaracteristicaApi {
    private final CaracteristicaService caracteristicaService;
    private final ObjectMapper mapper;
    @Autowired
    public CaracteristicaController(CaracteristicaService caracteristicaService, ObjectMapper mapper) {
        this.caracteristicaService = caracteristicaService;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<Page<CaracteristicaListResponse>> buscarCaracteristica(Pageable pageable) {
        Page<Caracteristica> caracteristicaPage = caracteristicaService.buscarCaracteristica(pageable);

        Page<CaracteristicaListResponse> response = caracteristicaPage
                .map(caracteristica -> new CaracteristicaListResponse(
                        caracteristica.getId(),
                        caracteristica.getNome(),
                        caracteristica.getIcone()
                ));
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<CaracteristicaListResponse> criarCaracteristica(CreateCaracteristicaRequest request) {
        Caracteristica caracteristica = mapper.convertValue(request, Caracteristica.class);
        Caracteristica caracteristicaCriado = caracteristicaService.criarCaracteristica(caracteristica);
        CaracteristicaListResponse caracteristicaListResponse = caracteristicaParaCaracteristicaListResponse(caracteristicaCriado);
        return ResponseEntity.status(HttpStatus.CREATED).body(caracteristicaListResponse);
    }

    @Override
    public ResponseEntity<CaracteristicaListResponse> buscarCaracteristicaPorId(UUID id) {
        Caracteristica caracteristica = caracteristicaService.buscarCaracteristicaPorId(id);
        CaracteristicaListResponse caracteristicaListResponse = caracteristicaParaCaracteristicaListResponse(caracteristica);
        return ResponseEntity.ok(caracteristicaListResponse);
    }

    @Override
    public ResponseEntity<CaracteristicaListResponse> atualizarCaracteristicaPorId(UUID id, Map<String, Object> campos) {
        Caracteristica caracteristica = caracteristicaService.atualizarCaracteristica(id);
        CaracteristicaListResponse caracteristicaListResponse = caracteristicaParaCaracteristicaListResponse(caracteristica);
        return ResponseEntity.accepted().body(caracteristicaListResponse);
    }

    @Override
    public ResponseEntity<Void> excluirCaracteristica(UUID id) {
        caracteristicaService.excluirCaracteristica(id);
        return ResponseEntity.noContent().build();
    }

    private CaracteristicaListResponse caracteristicaParaCaracteristicaListResponse (Caracteristica caracteristica) {
        return mapper.convertValue(caracteristica, CaracteristicaListResponse.class);
    }
}
