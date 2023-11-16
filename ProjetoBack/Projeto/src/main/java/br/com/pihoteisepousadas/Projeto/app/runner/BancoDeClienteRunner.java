package br.com.pihoteisepousadas.Projeto.app.runner;

import br.com.pihoteisepousadas.Projeto.domain.entity.Cliente;
import br.com.pihoteisepousadas.Projeto.domain.entity.Contato;
import br.com.pihoteisepousadas.Projeto.domain.entity.Genero;
import br.com.pihoteisepousadas.Projeto.domain.repository.ClienteRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Locale;
@Component
public class BancoDeClienteRunner implements CommandLineRunner {
    private final ClienteRepository clienteRepository;
    @Autowired
    public BancoDeClienteRunner(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void run(String... args) {
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Elton");
        cliente1.setSobrenome("Tome");
        cliente1.setDataNascimento(LocalDate.of(2017, Month.JULY,16));
        cliente1.setGenero(Genero.M);

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Luiz");
        cliente2.setSobrenome("Souza");
        cliente2.setDataNascimento(LocalDate.of(2010, Month.MARCH,30));
        cliente2.setGenero(Genero.M);

        Cliente cliente3 = new Cliente();
        cliente3.setNome("Deyse");
        cliente3.setSobrenome("Fernandes");
        cliente3.setDataNascimento(LocalDate.of(1999, Month.SEPTEMBER,06));
        cliente3.setGenero(Genero.F);

        Cliente cliente4 = new Cliente();
        cliente4.setNome("Ueber");
        cliente4.setSobrenome("James");
        cliente4.setDataNascimento(LocalDate.of(1993, Month.APRIL,27));
        cliente4.setGenero(Genero.M);

        Cliente cliente5 = new Cliente();
        cliente5.setNome("Artur");
        cliente5.setSobrenome("Miguel");
        cliente5.setDataNascimento(LocalDate.of(2000, Month.JUNE,10));
        cliente5.setGenero(Genero.M);

        clienteRepository.saveAll(List.of(cliente1, cliente2, cliente3, cliente4, cliente5));
    }
}
