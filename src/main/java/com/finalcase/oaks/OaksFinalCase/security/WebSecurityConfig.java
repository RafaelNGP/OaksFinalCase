package com.finalcase.oaks.OaksFinalCase.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws java.lang.Exception {
        http.csrf().disable().httpBasic().and().authorizeRequests()
                .antMatchers().permitAll()
                /*.antMatchers("/**").hasRole("ADMIN")*/
                .antMatchers("/producer/**").hasAnyRole("PRODUCER", "ADMIN")
                .antMatchers("/actors/**").hasAnyRole("PRODUCER", "ADMIN")
                .anyRequest().authenticated()
                .and().formLogin().permitAll()
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")
                /*digitar /logout pra deslogar*/);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws java.lang.Exception {

        auth.inMemoryAuthentication()
            .withUser("admin").password("{noop}1234").roles("ADMIN", "PRODUCER", "ACTOR").and()
            .withUser("producer").password("{noop}producer4321").roles("PRODUCER").and()
            .withUser("actor").password("{noop}actor4321").roles("ACTOR");
            /*autenticação em memória (Usuario / Senha / Regra)*/
    }

}
