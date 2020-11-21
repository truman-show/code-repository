package springbook.learningtest.junit;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JUnit.class)
public class JUnitTest {

  @Autowired
  ApplicationContext context; // 컨텍스트가 매번 주입해주는 애플리케이션 컨텍스트는 항상 같은 오브젝트인지 테스트로 확인해본다.

  static Set<JUnitTest> testObject = new HashSet<>();
  static ApplicationContext contextObject = null;

  @Test
  public void test1() {
    System.out.println(testObject);
    assertThat(this).doesNotHaveSameClassAs(testObject);
    testObject.add(this);

    assertThat(contextObject == null || contextObject == this.context).isTrue();
    contextObject = this.context;
  }

  @Test
  public void test2() {
    System.out.println(testObject);
    assertThat(this).doesNotHaveSameClassAs(testObject);
    testObject.add(this);
    assertThat(contextObject == null || contextObject == this.context);
    contextObject = this.context;
  }

  @Test
  public void test3() {
    System.out.println(testObject);
    assertThat(this).doesNotHaveSameClassAs(testObject);
    testObject.add(this);

    assertThat(contextObject == null || contextObject == this.context);
    contextObject = this.context;

  }
}
