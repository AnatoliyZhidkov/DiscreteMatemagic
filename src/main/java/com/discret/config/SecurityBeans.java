package com.discret.config;

import com.discret.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
class SecurityBeans {


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain (final HttpSecurity http) throws Exception{
        return http.authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                        //.requestMatchers("/admin/**").hasRole("ROLE_ADMIN")
                        .requestMatchers("/css/**","/images/**", "/utilities/**").permitAll()
                        .anyRequest().authenticated()
                ).formLogin(form -> form
                        .loginPage("/login").usernameParameter("login")
                        .defaultSuccessUrl("/main")
                        .permitAll())
                .build();
    }

}
