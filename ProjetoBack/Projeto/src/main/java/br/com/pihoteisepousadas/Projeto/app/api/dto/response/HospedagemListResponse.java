package br.com.pihoteisepousadas.Projeto.app.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
public class HospedagemListResponse {
    private UUID id;
    private LocalDate dataConsulta;
    private Boolean cancelada;
}
