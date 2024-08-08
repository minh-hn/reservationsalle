package fr.hn.reservation;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = {"fr.hn.reservation"})
public class ServletInitializer extends SpringBootServletInitializer {
  
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    
    return application.sources(new Class[] { ReservationApplication.class });
  }
  
  public ServletInitializer() {
    
  }
}
