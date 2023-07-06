package com.eazybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

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

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Approach 1 for InMemoryAuthentication
        //         auth
//                 .inMemoryAuthentication()
//                 .withUser("admin1")
//                 .password("12345")
//                 .authorities("admin")
//                 .and()
//                 .withUser("user1")
//                 .password("123456")
//                 .authorities("read")
//                 .and()
//                 .passwordEncoder(NoOpPasswordEncoder.getInstance());
        // Approach 2 for InMemoryAuthentication
//        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//
//        UserDetails user1 = User.withUsername("admin1").password("12345").authorities("admin").build();
//        UserDetails user2 = User.withUsername("user1").password("123456").authorities("read").build();
//
//        userDetailsService.createUser(user1);
//        userDetailsService.createUser(user2);
//
//        auth.userDetailsService(userDetailsService);
//    }

//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
