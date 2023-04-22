package dev.fbricenos.springsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
              .authorizeRequests(authorization -> {
                  authorization.requestMatchers("api/v1/demo/public").permitAll();
                  authorization.requestMatchers("/error").permitAll();
                  authorization.requestMatchers("/favicon.ico").permitAll();
                  authorization.anyRequest().authenticated();
              })
                .formLogin(Customizer.withDefaults())
                .build();
    }

    @Bean
    public UserDetailsService getUserDetailsService(){
        return new InMemoryUserDetailsManager(
                User.builder()
                      .username("user")
                      .password("{noop}password")
                      .roles("USER")
                      .build()
        );
    }
}
