package com.indica.cosmos.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component("authProvider")
public class AuthProvider implements AuthenticationProvider {
	
	@Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String id = authentication.getName();
        String password = "암호화된비밀번호";
		
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ID", "");
        map.put("Grade", "");
        
		Authentication auth = null;
		
		return auth;
	}
	
	@Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
