package com.quizroulette.quizlogeventservice;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;


@Configuration
@EnableWebFlux
public class MyConfiguration implements WebFluxConfigurer {

  public void addCorsMappings(org.springframework.web.reactive.config.CorsRegistry registry) {
    registry.addMapping("/**").allowedMethods("*").allowedHeaders("*");
  }

  @Bean
  public SecurityWebFilterChain securitygWebFilterChain(ServerHttpSecurity http) {
    return http.cors().and().csrf().disable().build();
  }

  @Bean
  public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {

    ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
    initializer.setConnectionFactory(connectionFactory);
    initializer.setDatabasePopulator(
        new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));

    return initializer;
  }
}
