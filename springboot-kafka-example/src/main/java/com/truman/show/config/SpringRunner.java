package com.truman.show.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringRunner implements ApplicationRunner {


  @Override
  public void run(ApplicationArguments args) throws Exception {
    System.out.println("==================");
  }
}
