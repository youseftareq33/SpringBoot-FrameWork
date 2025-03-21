package com.spring_security_app.spring_security_app.provider;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class MyAuthProvider implements AuthenticationProvider{

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        
        String userName=authentication.getName();
        String pass=authentication.getCredentials().toString();

        if("yousef".equals(userName) && "1234".equals(pass)){
            return new UsernamePasswordAuthenticationToken(userName, pass, Arrays.asList());
        }
        else{
            throw new BadCredentialsException("Invalid Username or password");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
    
}
