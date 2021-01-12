package com.truman.show;

import java.util.function.Function;
import org.junit.Test;

public class KafkaProducerTest {

  @Test
  public void test() {
    Function<String, String> function = (a) -> a;
    System.out.println(function.apply("123123aaaAD"));
  }

}
