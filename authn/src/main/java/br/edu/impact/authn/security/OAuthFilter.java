package br.edu.impact.authn.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class OAuthFilter extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/Sample/**")
            .csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
            .and()
            .httpBasic().disable()
            .oauth2ResourceServer()
            .jwt();
        http.cors();
    }
}
