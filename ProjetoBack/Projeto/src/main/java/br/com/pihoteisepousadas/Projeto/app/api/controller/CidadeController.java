package br.com.pihoteisepousadas.Projeto.app.api.controller;

import br.com.pihoteisepousadas.Projeto.app.api.CidadeApi;
import br.com.pihoteisepousadas.Projeto.app.api.dto.request.CreateCidadeRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.CidadeListResponse;
import br.com.pihoteisepousadas.Projeto.domain.entity.Cidade;
import br.com.pihoteisepousadas.Projeto.domain.service.CidadeService;
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
public class CidadeController implements CidadeApi {

    private final CidadeService cidadeService;
    private final ObjectMapper mapper;

    @Autowired
    public CidadeController(CidadeService cidadeService, ObjectMapper mapper) {
        this.cidadeService = cidadeService;
        this.mapper = mapper;
    }
    @Override
    public ResponseEntity<Page<CidadeListResponse>> buscarCidade(Pageable pageable) {
        Page<Cidade> cidadePage = cidadeService.buscarCidade(pageable);

        Page<CidadeListResponse> response = cidadePage
                .map(cidade -> new CidadeListResponse(
                        cidade.getId(),
                        cidade.getNome(),
                        cidade.getPais()
                ));
        return ResponseEntity.ok(response);
    }
    @Override
    public ResponseEntity<CidadeListResponse> criarCidade(CreateCidadeRequest request) {
        Cidade cidade = mapper.convertValue(request, Cidade.class);
        Cidade cidadeCriado = cidadeService.criarCidade(cidade);
        CidadeListResponse cidadeListResponse = cidadeParaCidadeListResponse(cidadeCriado);
        return ResponseEntity.status(HttpStatus.CREATED).body(cidadeListResponse);
    }
    @Override
    public ResponseEntity<CidadeListResponse> buscarCidadePorId(UUID id) {
        Cidade cidade = cidadeService.buscarCidadePorId(id);
        CidadeListResponse cidadeListResponse = cidadeParaCidadeListResponse(cidade);
        return ResponseEntity.ok(cidadeListResponse);
    }
    @Override
    public ResponseEntity<CidadeListResponse> atualizarCidadePorId(UUID id, Map<String, Object> campos) {
        Cidade cidade = cidadeService.atualizarCidade(id);
        CidadeListResponse cidadeListResponse = cidadeParaCidadeListResponse(cidade);
        return ResponseEntity.accepted().body(cidadeListResponse);
    }
    @Override
    public ResponseEntity<Void> excluirCidade(UUID id) {
        cidadeService.excluirCidade(id);
        return ResponseEntity.noContent().build();
    }
    private CidadeListResponse cidadeParaCidadeListResponse(Cidade cidade) {
        return mapper.convertValue(cidade, CidadeListResponse.class);
    }
}
