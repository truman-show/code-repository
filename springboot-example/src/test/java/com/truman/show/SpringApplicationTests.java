package com.truman.show;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:/test.yml")  //.property 만 지원한다
@SpringBootTest
public class SpringApplicationTests {

  @Autowired
  Environment environment;

  @Test
  public void contextLoads() {
    // 테스트 실패한다.
    // TestPropertySource 에 yml 파일은 사용하지 못해 main resource 의 설정정보를 읽는다.
    // 즉 main resource 의 jihoon.name: ljihoon 이 리턴된다.
    //assertThat(environment.getProperty("jihoon.name")).isEqualTo("ljihoon2");
  }

}
