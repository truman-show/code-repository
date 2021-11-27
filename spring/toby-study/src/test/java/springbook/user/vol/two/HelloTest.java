package springbook.user.vol.two;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springbook.learningtest.junit.JUnit;

// 토비 2권 리스트 1-5 예제 코드
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JUnit.class)  // RunWith 로 테스트 코드를 실행 시 아무런 설정파일이 없으면 예외가 발생한다.
public class HelloTest {

  @Test
  public void test() {
    // IoC 컨테이너 생성. 생성과 동시에 컨테이너로 동작한다.
    StaticApplicationContext applicationContext = new StaticApplicationContext();

    // Hello 클래스를 hello1 이라는 이름의 싱글톤 빈으로 컨테이너에 등록한다.
    // 싱글톤 빈을 등록해주는 registerSingleton() 를 사용해서 등록한다.
    applicationContext.registerSingleton("hello1", Hello.class);

    Hello hello1 = applicationContext.getBean("hello1", Hello.class);
    assertThat(hello1).isNotNull();
  }

}
