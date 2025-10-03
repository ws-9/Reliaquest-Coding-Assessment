package com.challenge.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppSecurityConfig {
    @Value("${defaults.username}")
    private String defaultUsername;

    @Value("${defaults.password}")
    private String defaultPassword;

    @Value("${defaults.role}")
    private String defaultRole;

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails defaultUser = User.builder()
                .username(defaultUsername)
                .password("{noop}" + defaultPassword)
                .roles(defaultRole)
                .build();

        UserDetails unauthorizedUser = User.builder()
                .username("unauthorized")
                .password("{noop}unauthorized")
                .roles("UNAUTHORIZED")
                .build();
        return new InMemoryUserDetailsManager(defaultUser, unauthorizedUser);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer -> configurer
                .requestMatchers("/docs/**", "/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html")
                .permitAll()
                .requestMatchers(HttpMethod.GET, "/api/v1/employee")
                .hasRole(defaultRole)
                .requestMatchers(HttpMethod.GET, "/api/v1/employee/")
                .hasRole(defaultRole)
                .requestMatchers(HttpMethod.POST, "/api/v1/employee")
                .hasRole(defaultRole));
        http.httpBasic(Customizer.withDefaults());
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
