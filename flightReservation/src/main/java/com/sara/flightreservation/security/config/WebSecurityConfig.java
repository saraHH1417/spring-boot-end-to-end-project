package com.sara.flightreservation.security.config;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig implements WebSecurityCustomizer {
    @Bean
    public BCryptPasswordEncoder encoder () {
        return new BCryptPasswordEncoder();
    }

//    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
//    public AuthenticationManager authenticationManager() {
//        return super.authenticationManagerBean();
//    }
//    public void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeRequests().antMatchers(
//                "/showReg",
//                "/",
//                "/index.html",
//                "/registerUser",
//                "/login",
//                "/showLogin",
//                "/login/*",
//                "/reservations/*"
//        )
//                .permitAll()
//                .antMatchers("/admin/showAddFlight")
//                .hasAnyAuthority("ADMIN")
//                .and()
//                .csrf()
//                .disabled();
//    }


    @Override
    public void customize(WebSecurity web) {

    }
}
