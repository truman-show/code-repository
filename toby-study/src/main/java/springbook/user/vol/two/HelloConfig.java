package springbook.user.vol.two;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfig {

  @Bean
  public Hello hello() {
    Hello hello = new Hello();
    hello.setName("Spring");
    hello.setPrinter(printer());
    return hello;
  }


  @Bean
  public Hello hello2() {
    Hello hello = new Hello();
    hello.setName("Spring2");
    hello.setPrinter(printer());
    return hello;
  }

  @Bean
  public Printer printer() {
    // 디폴트 메타정보 항목에 따라 이 메소드로 정의되는 빈은 싱글톤이다.
    // 스프링의 특별한 조작을 통해 컨테이너에 등록된 HelloConfig 빈의 printer() 메소드는 매번 동일한 인스턴스를 리턴하도록 만들어진다
    return new StringPrinter();
  }

}
