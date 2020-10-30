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

    @Autowired
    private ImplementsUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws java.lang.Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/**").permitAll()
                .antMatchers(HttpMethod.GET, "/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/actors").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/actors").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/actors").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().formLogin().permitAll()
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")
                /*digitar /logout pra deslogar*/);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws java.lang.Exception {

        auth.userDetailsService(userDetailsService)
            .passwordEncoder(new BCryptPasswordEncoder());

        /*auth.inMemoryAuthentication()
            .withUser("admin").password("{noop}1234").roles("ADMIN");
            autenticação em memória (Usuario / Senha / Regra)*/
    }

    @Override
    public void configure(WebSecurity web) throws java.lang.Exception {
        //web.ignoring().antMatchers("");
    }

}
