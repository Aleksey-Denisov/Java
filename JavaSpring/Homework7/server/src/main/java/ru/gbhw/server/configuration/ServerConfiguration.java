package ru.gbhw.server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

//Конфигурация сервера
@Configuration
public class ServerConfiguration {
    //Тут определим цепочку фильтров
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //Если в кратце, то все запросы должны иметь токен jwt
        httpSecurity.authorizeHttpRequests(auth -> auth
            .anyRequest().authenticated())
            .oauth2ResourceServer(oauth -> oauth.jwt(Customizer.withDefaults()));
        return httpSecurity.build();
    }
}
