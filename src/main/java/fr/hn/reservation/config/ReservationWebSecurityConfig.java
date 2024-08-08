package fr.hn.reservation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ReservationWebSecurityConfig {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return (PasswordEncoder)new BCryptPasswordEncoder(12);
  }
  
  @Bean
  public AuthenticationSuccessHandler successHandler() {
	  return (AuthenticationSuccessHandler)new LoginAuthentificationHandler("/homepage");
  }
  
  //TODO il faut créer /importer la clé rsa pour les appel https
  
  protected void configure(HttpSecurity http) throws Exception {
	    ((HttpSecurity)((HttpSecurity)((FormLoginConfigurer)((FormLoginConfigurer)((FormLoginConfigurer)((FormLoginConfigurer)((HttpSecurity)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)http.authorizeRequests()
	      .antMatchers(new String[] { "/login", "/css/**", "/font/**", "/datatables/**", "/images/**", "/js/**", "/html/**", "/fontAwesome/**", "/doc/**", "/error" })).permitAll()
	      .antMatchers(new String[] { "/admin/**" })).hasRole("admin")
	      .antMatchers(new String[] { "/**" })).authenticated()		      
	      .and())
	      .formLogin()
	      .loginPage("/login")
	      .defaultSuccessUrl("/homepage"))
	      .successHandler(successHandler()))
	      .failureUrl("/login?error=true"))
	      .permitAll())
	      .and())
	      .logout()
	      .logoutSuccessUrl("/login?logout=true")
	      .invalidateHttpSession(true)		     
	      .deleteCookies(new String[] { "JSESSIONID" }).permitAll()		      
	      .and())
	      .csrf()
	      .disable();
	  }
	  
	  @Autowired
	  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {		    
	    auth.authenticationProvider(localProvider());
	  }
	  
	  
	  
	  @Bean
	  @Deprecated
	  public AuthenticationProvider localProvider() {
	    return new CustomAuthProviderLocal();
	  }
}
