package com.truman.show;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringRunner implements ApplicationRunner {

  final JihoonProperties jihoonProperties;

  public SpringRunner(JihoonProperties jihoonProperties) {
    this.jihoonProperties = jihoonProperties;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    System.out.println("====================");
    System.out.println(jihoonProperties.getName());
    System.out.println(jihoonProperties.getFullName());
    System.out.println("====================");
  }
}
