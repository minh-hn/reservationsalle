package fr.hn.reservation.config;

import java.util.Locale;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration

public class AppConfig implements WebMvcConfigurer {
  private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);
  

  
  @Bean
  public Executor taskExecutor() {
    return (Executor)new SimpleAsyncTaskExecutor();
  }
  
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("homepage");
    registry.addViewController("/login").setViewName("login");
  }
  
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler(new String[] { "/images/**", "/css/**", "/js/**", "/fonts/**", "/doc/**" }).addResourceLocations(new String[] { "classpath:/static/images/", "classpath:/static/css/", "classpath:/static/js/", "classpath:/static/fonts/", "classpath:/static/doc/" });
  }
  
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    logger.info("configureContentNegotiation - default text/html");
    configurer
      .favorPathExtension(false)
      .favorParameter(true)
      .defaultContentType(new MediaType[] { MediaType.TEXT_HTML }).mediaType("pdf", MediaType.APPLICATION_PDF)
      .mediaType("xml", MediaType.APPLICATION_XML)
      .mediaType("json", MediaType.APPLICATION_JSON)
      .ignoreAcceptHeader(false);
  }
  
  public void configureViewResolvers(ViewResolverRegistry registry) {
    logger.info("Configure view resolver");
    registry.jsp("/WEB-INF/jsp/", ".jsp").viewClass(JstlView.class);
    registry.enableContentNegotiation(new View[] { (View)new JstlView() });
  }
  
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor((HandlerInterceptor)localeChangeInterceptor());
  }
  
  
  
 
  
  @Bean
  public LocaleResolver localeResolver() {
    SessionLocaleResolver slr = new SessionLocaleResolver();
    slr.setDefaultLocale(Locale.FRANCE);
    return (LocaleResolver)slr;
  }
  
  
  
  @Bean
  public LocaleChangeInterceptor localeChangeInterceptor() {
    LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
    lci.setParamName("lang");
    return lci;
  }
}