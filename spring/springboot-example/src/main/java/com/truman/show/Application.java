package com.truman.show;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

//  @Bean
//  public ServerProperties serverProperties(){
//    return new ServerProperties();
//  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
