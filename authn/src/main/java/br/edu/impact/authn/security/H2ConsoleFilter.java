package br.edu.impact.authn.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class H2ConsoleFilter {
    
    /**
     * Configure http security chain to support OAuth protocol on the app
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain h2FilterChain(HttpSecurity http) throws Exception {
        http
            .antMatcher("/h2-console/**")
            .headers().frameOptions().disable()
            .and()
            .authorizeHttpRequests((authorize -> {
                try {
                    authorize
                        .antMatchers("/h2-console/**")
                            .permitAll();
                } catch (Exception e) {
                    System.out.println("erro during authN process...");
                    e.printStackTrace();
                }
            }))
            .cors()
            .and().csrf().disable();

        return http.build();
    }

}
