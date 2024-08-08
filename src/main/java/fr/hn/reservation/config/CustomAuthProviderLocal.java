package fr.hn.reservation.config;

import java.util.HashSet;

import java.util.Set;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
@Component
@Deprecated
public class CustomAuthProviderLocal implements AuthenticationProvider {
  public Authentication authenticate(Authentication auth) throws AuthenticationException {
    String username = auth.getName();
    Object password = auth.getCredentials();
    
    if ("pirate".equals(username) ) {     
    	throw new BadCredentialsException("Internal system authentication failed");
    } 
    Set<GrantedAuthority> authority = new HashSet<>();
    //FIXME
    authority.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
    authority.add(new SimpleGrantedAuthority("ROLE_CLIENT"));
    return (Authentication)new UsernamePasswordAuthenticationToken(auth
        .getPrincipal(), password, authority);
    
  }
  
  public boolean supports(Class<?> auth) {
    return auth.equals(UsernamePasswordAuthenticationToken.class);
  }
  
  

}
