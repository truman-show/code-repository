package springbook.learningtest.junit;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class JUnitTest {

  static Set<JUnitTest> testObject = new HashSet<>();

  @Test
  public void test1() {
    System.out.println(testObject);
    assertThat(this).doesNotHaveSameClassAs(testObject);
    testObject.add(this);
  }

  @Test
  public void test2() {
    System.out.println(testObject);
    assertThat(this).doesNotHaveSameClassAs(testObject);
    testObject.add(this);
  }

  @Test
  public void test3() {
    System.out.println(testObject);
    assertThat(this).doesNotHaveSameClassAs(testObject);
    testObject.add(this);
  }
}
