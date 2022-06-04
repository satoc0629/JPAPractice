package jpalearn.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfigure {

    @Bean
    SecurityFilterChain sec(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .and()
                .authorizeRequests().mvcMatchers("*").permitAll()
                .and()
                .csrf().disable()
                .build();
    }
}
