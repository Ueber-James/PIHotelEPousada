package br.com.pihoteisepousadas.Projeto.app.runner;

import br.com.pihoteisepousadas.Projeto.domain.entity.Hoteis;
import br.com.pihoteisepousadas.Projeto.domain.repository.HoteisRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Component
public class BancoDeHoteisRunner implements CommandLineRunner {
    private final HoteisRepository hoteisRepository;
    private final Faker faker;
    @Autowired
    public BancoDeHoteisRunner(HoteisRepository hoteisRepository) {
        this.hoteisRepository = hoteisRepository;
        faker = new Faker(new Locale("pt", "BR"));
    }

    @Override
    public void run(String... args) {
        Hoteis hotel1 = new Hoteis();
        hotel1.setNome(faker.company().name());
        hotel1.setCnpj("9999999999999");
        hotel1.setDescricao("");
        hotel1.setRazaoSocial("Hotel Oliveira");
        hotel1.setRua(faker.name().name());
        hotel1.setNumero("3928");
        hotel1.setPais("Brazil");

        Hoteis hotel2 = new Hoteis();
        hotel2.setNome(faker.company().name());
        hotel2.setCnpj("8888888888888");
        hotel2.setDescricao("");
        hotel2.setRazaoSocial("Pousada San Francisco");
        hotel2.setRua(faker.name().name());
        hotel2.setNumero("2324");
        hotel2.setPais("França");

        Hoteis hotel3 = new Hoteis();
        hotel3.setNome(faker.company().name());
        hotel3.setCnpj("7777777777777");
        hotel3.setDescricao("");
        hotel3.setRazaoSocial("Pousada Florentina");
        hotel3.setRua(faker.name().name());
        hotel3.setNumero("9480");
        hotel3.setPais("Italia");


        hoteisRepository.saveAll(List.of(hotel1, hotel2, hotel3));

    }
}
