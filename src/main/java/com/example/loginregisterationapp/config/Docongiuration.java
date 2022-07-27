package com.example.loginregisterationapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@Deprecated
public class Docongiuration extends WebSecurityConfigurerAdapter {


    @Bean
    public UserDetailsService usertdetails()
    {
        return new UserdtlsService();
    }
    @Bean
    public BCryptPasswordEncoder getpassword()
    {
        return new  BCryptPasswordEncoder();
    }
    public DaoAuthenticationProvider daoProvider()
    {
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
        dao.setUserDetailsService(usertdetails());
        dao.setPasswordEncoder(getpassword());
        return dao;
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth)  {
        auth.authenticationProvider(daoProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/**").permitAll()
            .and().formLogin().loginPage("/login").loginProcessingUrl("/dologin").defaultSuccessUrl("/user/HomePage").and().csrf().disable();
    }


}


