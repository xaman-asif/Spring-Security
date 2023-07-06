package com.eazybytes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ProjectSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //match requests as per customer requirement
//        http
//                .authorizeRequests()
//                .antMatchers("/myAccount").authenticated()
//                .antMatchers("/myBalance").authenticated()
//                .antMatchers("/myLoans").authenticated()
//                .antMatchers("/myCards").authenticated()
//                .antMatchers("/notices").permitAll()
//                .antMatchers("/contact").permitAll()
//                .and()
//                .formLogin()
//                .and()
//                .httpBasic();

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
        http
                .authorizeRequests()
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }
}
