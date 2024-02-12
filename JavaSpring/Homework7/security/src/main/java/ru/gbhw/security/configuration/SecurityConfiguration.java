package ru.gbhw.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//Конфигурация безопасности
@Configuration
public class SecurityConfiguration {
    //Тут всего лишь добавляется пользователь
    @Bean
    UserDetailsService userDetailsService() {
        User.UserBuilder user = User.builder();
        UserDetails userDetails = user
                .username("user")
                .password("1234")
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }
    //Кодирование пароля отключено
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
