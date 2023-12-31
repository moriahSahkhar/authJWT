package org.demoAuthJWT.AuthJWT.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@AllArgsConstructor
public class SecurityConfig {

    private JwtAuthenticationFilter jwtAuthenticationFilter;

    private AuthenticationProvider authenticationProvider;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
                .authorizeHttpRequests(
                        (authorize) -> authorize
                                .requestMatchers("/home").hasRole("ADMIN")
                                .requestMatchers("/resources/**", "/static/**","/assets/**",
                                        "/css/**", "/js/**","/","/login")
                                .permitAll()
                                .anyRequest()
                                .authenticated())
//                .formLogin(
//                        (login) -> login
//                                .loginPage("/")
//                                .loginProcessingUrl("/login")
//                                .defaultSuccessUrl("/home")
//                                .failureUrl("/?error=Authentication Error")
//                                .permitAll())
//                .logout(
//                        (logout) -> logout
//                                .logoutUrl("/logout")
//                                .logoutSuccessUrl("/?logout")
//                                .permitAll())
                .sessionManagement(
                        (session) -> session
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                .accessDeniedPage("/access-denied");

        return httpSecurity.build();
    }
}
