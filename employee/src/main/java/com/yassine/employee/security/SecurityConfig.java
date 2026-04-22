package com.yassine.employee.security;

import java.util.Collections;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .csrf(csrf -> csrf.disable())

                // Configuration CORS pour Angular (Évite les erreurs Cross-Origin)
                .cors(cors -> cors.configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration config = new CorsConfiguration();
                        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                        config.setAllowedMethods(Collections.singletonList("*"));
                        config.setAllowedHeaders(Collections.singletonList("*"));
                        config.setExposedHeaders(Collections.singletonList("Authorization"));
                        return config;
                    }
                }))

                // Restrictions des API selon les rôles (À ADAPTER SELON TES URLS D'EMPLOYE)
                .authorizeHttpRequests(requests -> requests
                        // Consulter la liste des employés : ADMIN et USER
                        .requestMatchers("/api/employes/all").hasAnyAuthority("ADMIN", "USER")

                        // Consulter un employé par ID : ADMIN et USER
                        .requestMatchers(HttpMethod.GET, "/api/employes/getbyid/**").hasAnyAuthority("ADMIN", "USER")

                        // Ajouter un employé : ADMIN seulement
//                        .requestMatchers(HttpMethod.POST, "/api/employes/addemp/**").hasAuthority("ADMIN")

                        // Modifier un employé : ADMIN seulement
                        .requestMatchers(HttpMethod.PUT, "/api/employes/updateemp/**").hasAuthority("ADMIN")

                        // Supprimer un employé : ADMIN seulement
                        .requestMatchers(HttpMethod.DELETE, "/api/employes/delemp/**").hasAuthority("ADMIN")

                        .anyRequest().authenticated())

                // Ajout de notre filtre qui vérifie le JWT
                .addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
