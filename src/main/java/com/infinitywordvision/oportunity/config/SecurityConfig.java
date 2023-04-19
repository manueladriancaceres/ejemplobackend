package com.infinitywordvision.oportunity.config;

import com.infinitywordvision.oportunity.entity.UserSystem;
import com.infinitywordvision.oportunity.repository.UserSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity,
                                         JwtTokenProvider tokenProvider) throws Exception {

        return httpSecurity
                .csrf( csrf -> csrf.disable())
                .cors()
                .configurationSource(corsConfigurationSource())
                .and()
                .authorizeHttpRequests(request -> {
                    request
                            .antMatchers("/ping").permitAll()
                            .antMatchers("/api/auth/**").permitAll()
                            .antMatchers("/h2-console/**").permitAll()
                            .anyRequest().authenticated();
                })
                .addFilterBefore(new JwtTokenAuthenticationFilter(tokenProvider), UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    UserDetailsService customUserDetailsService(UserSystemRepository users) {
        return (username) -> users.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found"));
    }

    @Bean
    AuthenticationManager customAuthenticationManager(UserDetailsService userDetailsService, PasswordEncoder encoder) {
        return authentication -> {
            String username = authentication.getPrincipal() + "";
            String password = authentication.getCredentials() + "";
            UserDetails user = userDetailsService.loadUserByUsername(username);
            if (!password.equals(user.getPassword())) {
                throw new BadCredentialsException("Bad credentials");
            }
            return new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }



    /*
    *  Esto es lo mínimo de autorizacion
    *     @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf( csrf -> csrf.disable())
                .authorizeHttpRequests(request -> {
                    request
                            .antMatchers("/ping").permitAll()
                            .anyRequest().authenticated();
                })
                .build();
    }

    * */
}
