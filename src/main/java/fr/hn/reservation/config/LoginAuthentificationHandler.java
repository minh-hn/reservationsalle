package fr.hn.reservation.config;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;


public class LoginAuthentificationHandler extends SavedRequestAwareAuthenticationSuccessHandler {

  
  public LoginAuthentificationHandler(String defaultTargetUrl) {
    setDefaultTargetUrl(defaultTargetUrl);
  }
  
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
    
	  getRedirectStrategy().sendRedirect(request, response, "/homepage");
       
  }
}
