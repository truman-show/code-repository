package chapter09.sec02_exam01_nestedclass_object;

public class A {
  A() {
    System.out.println("A 객체가 생성됨");
  }

  //인스턴스 멤버 클래스
  class B {
    int field1;

    //static int field2; 인스턴스 중첩클래스에서는 static 필드를 선언할 수 없다.
    B() {
      System.out.println("B 객체가 생성됨");
    }

    void method1() {
      System.out.println("b : " + this.field1);
    }
    //static void method2(){} 마찬가지로 static method도 선언할 수 없다.
  }

  //정적 멤버 클래스
  static class C {
    int filed1;
    static int field2;

    C() {
      System.out.println("C 객체가 생성됨.");
    }

    void method1() {
      System.out.println("정적 멤버 클래스의 인스턴스 필드 : " + this.filed1);
    }

    static void method2() {
      System.out.println("정적 멤버 클래스의 정적 필드 : " + field2);
    }

  }
}

class Main {
  public static void main(String[] args) {
    A a = new A();
//    A.B b = new A().new B();
    // 인스턴스 멤버클래스는 반드시 바깥 객체가 있어야 객체가 생성할 수 있다.
    A.B b = a.new B();
    b.field1 = 3;
    b.method1();

    // 정적 멤버 클래스는 바깥 객체가 없어도 객체를 생성할 수 있다.
    A.C c = new A.C();
    c.filed1 = 3;
    c.method1();

    A.C.field2 = 3;
    A.C.method2();
  }
}
