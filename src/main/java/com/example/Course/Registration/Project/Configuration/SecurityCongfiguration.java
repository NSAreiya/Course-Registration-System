package com.example.Course.Registration.Project.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityCongfiguration {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    CorsConfigurationSource corsConfigurationSource;



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors(cors -> cors.configurationSource(corsConfigurationSource))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/login", "/error", "/api/signup", "/courses/**", "/admin/**").permitAll()
                        .requestMatchers("/user/**").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginProcessingUrl("/login")
                        .successHandler((request, response, authentication) -> {
                            response.setStatus(200);
                            response.getWriter().write("{\"success\": true}");
                        })
                        .failureHandler((request, response, exception) -> {
                            response.setStatus(401);
                            response.getWriter().write("{\"error\": \"Invalid credentials\"}");
                        })
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessHandler((request, response, authentication) -> {
                            response.setStatus(200);
                            response.getWriter().write("{\"success\": true}");
                        })
                        .permitAll())
                .build();
    }

    @Bean
        public AuthenticationProvider authenticationProvider(){
            DaoAuthenticationProvider provider =new DaoAuthenticationProvider();
            provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
            provider.setUserDetailsService(userDetailsService);
            return provider;
        }



}
