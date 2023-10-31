package br.com.pihoteisepousadas.Projeto.app.runner;

import br.com.pihoteisepousadas.Projeto.domain.entity.Hospedagem;
import br.com.pihoteisepousadas.Projeto.domain.repository.HospedagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Component
public class BancoDeHospedagemRunner implements CommandLineRunner {
    private final HospedagemRepository hospedagemRepository;
    @Autowired
    public BancoDeHospedagemRunner(HospedagemRepository hospedagemRepository) {
        this.hospedagemRepository = hospedagemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Hospedagem hospedagem1 = new Hospedagem();
        hospedagem1.setDataHospedagem(LocalDate.of(2023, Month.DECEMBER, 20));
        hospedagem1.setCancelada(Boolean.FALSE);

        Hospedagem hospedagem2 = new Hospedagem();
        hospedagem2.setDataHospedagem(LocalDate.of(2024, Month.MARCH, 15));
        hospedagem2.setCancelada(Boolean.TRUE);

        Hospedagem hospedagem3 = new Hospedagem();
        hospedagem3.setDataHospedagem(LocalDate.of(2023, Month.NOVEMBER, 30));
        hospedagem3.setCancelada(Boolean.TRUE);

        hospedagemRepository.saveAll(List.of(hospedagem1, hospedagem2, hospedagem3));

    }
}
