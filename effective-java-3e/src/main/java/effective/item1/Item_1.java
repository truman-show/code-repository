package effective.item1;

public class Item_1 {


  static class Foo {
    public static Bar valueOf() {
      return Bar.HELLO;
    }
  }


  enum Bar {
    HELLO
  }


  interface FooInterface {
    static Foo valueOf() {
      return new Foo();
    }
  }

}
