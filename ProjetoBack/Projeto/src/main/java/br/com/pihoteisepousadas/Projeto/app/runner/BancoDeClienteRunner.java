package br.com.pihoteisepousadas.Projeto.app.runner;

import br.com.pihoteisepousadas.Projeto.domain.entity.Cliente;
import br.com.pihoteisepousadas.Projeto.domain.repository.ClienteRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Locale;

public class BancoDeClienteRunner implements CommandLineRunner {
    private final ClienteRepository clienteRepository;
    private final Faker faker;

    public BancoDeClienteRunner(ClienteRepository clienteRepository, Faker faker) {
        this.clienteRepository = clienteRepository;
        this.faker = new Faker(new Locale("pt", "BR"));
    }

    @Override
    public void run(String... args) {
        Cliente cliente1 = new Cliente();
        cliente1.setNome(faker.name().name());
        cliente1.setDataNascimento(LocalDate.of(2017, Month.JULY,16));

        Cliente cliente2 = new Cliente();
        cliente2.setNome(faker.name().name());
        cliente2.setDataNascimento(LocalDate.of(2010, Month.MARCH,30));

        Cliente cliente3 = new Cliente();
        cliente3.setNome(faker.name().name());
        cliente3.setDataNascimento(LocalDate.of(1999, Month.SEPTEMBER,06));

        clienteRepository.saveAll(List.of(cliente1, cliente2, cliente3));
    }
}
