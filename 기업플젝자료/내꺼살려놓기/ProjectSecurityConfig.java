package com.team1.mohaji.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/authenticated").authenticated()
                .requestMatchers("/unauthenticated").permitAll())
              .formLogin(Customizer.withDefaults())
         //   .formLogin(Customizer.withDefaults().loginPage("/custom-login")) // 커스텀 로그인 페이지 경로 설정
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
