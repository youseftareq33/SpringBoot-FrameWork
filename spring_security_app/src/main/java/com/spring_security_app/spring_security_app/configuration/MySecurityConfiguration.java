package com.spring_security_app.spring_security_app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MySecurityConfiguration {
    
    //** after set provider, the UserDetailsService can remove it

    // @Bean
    // UserDetailsService userDetailsService(){
    //     InMemoryUserDetailsManager userDetailsService=new InMemoryUserDetailsManager();

    //     UserDetails user=User.withUsername("yousef").password(pass_Encoder().encode("1234")).authorities("read").build();

    //     userDetailsService.createUser(user);
    //     return userDetailsService;
    // }


    @Bean
    BCryptPasswordEncoder pass_Encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.formLogin();
        // http.authorizeHttpRequests().anyRequest().authenticated(); ******* that make access to all request in controller
        http.authorizeHttpRequests().requestMatchers(("/hello")).authenticated().anyRequest().denyAll();
        return http.build();
    }
}
