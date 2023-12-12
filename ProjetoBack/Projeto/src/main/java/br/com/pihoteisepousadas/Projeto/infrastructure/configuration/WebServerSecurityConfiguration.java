package br.com.pihoteisepousadas.Projeto.infrastructure.configuration;

import br.com.pihoteisepousadas.Projeto.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebServerSecurityConfiguration {
    private final JwtRequestFilter jwtAuthenticationFilter;
    private final UserService userService;
    private static final String [] SWAGGER_LIST ={
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/swagger-resources/**",
    };

    @Bean
    //permite apenas requisições para authentication, bloqueia todas as outras requisições
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests( auth -> {    auth.requestMatchers("/authentication").permitAll();
                    auth.requestMatchers(SWAGGER_LIST).permitAll();
                    auth.requestMatchers("/authentication/sign-up").permitAll();
                    auth.requestMatchers("/authentication/sign-in").permitAll();

                    auth.anyRequest().authenticated();

                });

        return http.build();
    }

    @Bean
    //Criptografa senha no banco de dados
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    //Adiciona um provedor de autenticação com a senha encriptada
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService.userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
