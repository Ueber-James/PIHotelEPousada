package br.com.pihoteisepousadas.Projeto.app.runner;

import br.com.pihoteisepousadas.Projeto.domain.entity.security.UserDetail;
import br.com.pihoteisepousadas.Projeto.domain.entity.security.UserPermission;
import br.com.pihoteisepousadas.Projeto.domain.repository.UserRepository;
import org.hibernate.metamodel.internal.AbstractDynamicMapInstantiator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BancoDeUserDetailRunner implements CommandLineRunner {
    private final UserRepository userRepository;
    @Autowired
    public BancoDeUserDetailRunner(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        UserDetail user1 = new UserDetail();
        user1.setNome("elton");
        user1.setEmail("elton@gmail.com");
        user1.setPassword("1234");

        UserDetail user2 = new UserDetail();
        user2.setNome("luiz");
        user2.setEmail("");
        user2.setPassword("1234");

        UserDetail user3 = new UserDetail();
        user3.setNome("deyse");
        user3.setEmail("");
        user3.setPassword("1234");

        UserDetail user4 = new UserDetail();
        user4.setNome("james");
        user4.setEmail("");
        user4.setPassword("1234");

        UserDetail user5 = new UserDetail();
        user5.setNome("artur");
        user5.setEmail("");
        user5.setPassword("1234");

        userRepository.saveAll(List.of(user1, user2, user3, user4, user5));
    }
}
