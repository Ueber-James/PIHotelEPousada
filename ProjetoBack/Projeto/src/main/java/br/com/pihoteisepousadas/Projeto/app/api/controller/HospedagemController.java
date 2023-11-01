package br.com.pihoteisepousadas.Projeto.app.api.controller;

import br.com.pihoteisepousadas.Projeto.app.api.HospedagemApi;
import br.com.pihoteisepousadas.Projeto.app.api.dto.request.CreateHospedagemRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.HospedagemListResponse;
import br.com.pihoteisepousadas.Projeto.domain.entity.Hospedagem;
import br.com.pihoteisepousadas.Projeto.domain.service.HospedagemService;
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
public class HospedagemController implements HospedagemApi {
    private final HospedagemService hospedagemService;
    private final ObjectMapper mapper;
    @Autowired
    public HospedagemController(HospedagemService hospedagemService, ObjectMapper mapper) {
        this.hospedagemService = hospedagemService;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<Page<HospedagemListResponse>> buscarHospedagem(Pageable pageable) {
        Page<Hospedagem> hospedagemPage = hospedagemService.buscarHospedagem(pageable);

        Page<HospedagemListResponse> response = hospedagemPage
                .map(hospedagem -> new HospedagemListResponse(hospedagem.getId(), hospedagem.getDataHospedagem(), hospedagem.getCancelada()));
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<HospedagemListResponse> criarHospedagem(CreateHospedagemRequest request) {
        Hospedagem hospedagem = mapper.convertValue(request, Hospedagem.class);
        Hospedagem hospedagemCriado = hospedagemService.criarHospedagem(hospedagem);
        HospedagemListResponse hospedagemListResponse = hospedagemParaHospedagemListResponse(hospedagemCriado);
        return ResponseEntity.status(HttpStatus.CREATED).body(hospedagemListResponse);

    }

    @Override
    public ResponseEntity<HospedagemListResponse> buscarHospedagemPorId(UUID id) {
        Hospedagem hospedagem = hospedagemService.buscarHospedagemPorId(id);
        HospedagemListResponse hospedagemListResponse = hospedagemParaHospedagemListResponse(hospedagem);
        return ResponseEntity.ok(hospedagemListResponse);
    }

    @Override
    public ResponseEntity<HospedagemListResponse> atualizarHospedagemPorId(UUID id, Map<String, Object> campos) {
        Hospedagem hospedagem = hospedagemService.buscarHospedagemPorId(id);
        HospedagemListResponse hospedagemListResponse = hospedagemParaHospedagemListResponse(hospedagem);
        return ResponseEntity.accepted().body(hospedagemListResponse);
    }

    @Override
    public ResponseEntity<Void> excluirHospedagem(UUID id) {
        hospedagemService.excluirHospedagem(id);
        return ResponseEntity.noContent().build();
    }

    private HospedagemListResponse hospedagemParaHospedagemListResponse (Hospedagem hospedagem){
        return mapper.convertValue(hospedagem, HospedagemListResponse.class);
    }
}
