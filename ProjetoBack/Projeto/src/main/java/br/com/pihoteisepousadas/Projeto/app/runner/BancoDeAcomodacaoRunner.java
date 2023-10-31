package br.com.pihoteisepousadas.Projeto.app.runner;

import br.com.pihoteisepousadas.Projeto.domain.entity.Acomodacao;
import br.com.pihoteisepousadas.Projeto.domain.entity.TipoAcomodacao;
import br.com.pihoteisepousadas.Projeto.domain.repository.AcomodacaoRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Component
public class BancoDeAcomodacaoRunner implements CommandLineRunner {
    private final AcomodacaoRepository acomodacaoRepository;
    private final Faker faker;
    @Autowired
    public BancoDeAcomodacaoRunner(AcomodacaoRepository acomodacaoRepository) {
        this.acomodacaoRepository = acomodacaoRepository;
        faker = new Faker(new Locale("pt", "BR"));
    }

    @Override
    public void run(String... args) {
        Acomodacao acomodacao1 = new Acomodacao();
        acomodacao1.setNome(faker.company().name());
        acomodacao1.setCnpj("9999999999999");
        acomodacao1.setDescricao("");
        acomodacao1.setRazaoSocial("Hotel Oliveira");
        acomodacao1.setTipoAcomodacao(TipoAcomodacao.H);

        Acomodacao acomodacao2 = new Acomodacao();
        acomodacao2.setNome(faker.company().name());
        acomodacao2.setCnpj("8888888888888");
        acomodacao2.setDescricao("");
        acomodacao2.setRazaoSocial("Pousada San Francisco");
        acomodacao2.setTipoAcomodacao(TipoAcomodacao.P);

        Acomodacao acomodacao3 = new Acomodacao();
        acomodacao3.setNome(faker.company().name());
        acomodacao3.setCnpj("7777777777777");
        acomodacao3.setDescricao("");
        acomodacao3.setRazaoSocial("Pousada Florentina");
        acomodacao3.setTipoAcomodacao(TipoAcomodacao.P);

        acomodacaoRepository.saveAll(List.of(acomodacao1, acomodacao2, acomodacao3));

    }
}
