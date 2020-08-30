package com.truman.show;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

  @Bean
  public ServerProperties serverProperties(){
    return new ServerProperties();
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
