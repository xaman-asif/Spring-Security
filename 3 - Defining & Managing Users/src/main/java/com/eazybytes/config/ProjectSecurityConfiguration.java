package com.eazybytes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class ProjectSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //match requests as per customer requirement
        http
                .authorizeRequests()
                .antMatchers("/myAccount").authenticated()
                .antMatchers("/myBalance").authenticated()
                .antMatchers("/myLoans").authenticated()
                .antMatchers("/myCards").authenticated()
                .antMatchers("/notices").permitAll()
                .antMatchers("/contact").permitAll()
                .and()
                .formLogin()
                .and()
                .httpBasic();

        //deny all the requests
//        http
//                .authorizeRequests()
//                .anyRequest()
//                .denyAll()
//                .and()
//                .formLogin()
//                .and()
//                .httpBasic();
         //permit all the requests
//        http
//                .authorizeRequests()
//                .anyRequest()
//                .permitAll()
//                .and()
//                .formLogin()
//                .and()
//                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth
                 .inMemoryAuthentication()
                 .withUser("admin1")
                 .password("12345")
                 .authorities("admin")
                 .and()
                 .withUser("user1")
                 .password("123456")
                 .authorities("read")
                 .and()
                 .passwordEncoder(NoOpPasswordEncoder.getInstance());

    }
}
