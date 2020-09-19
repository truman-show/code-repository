package chapter09.sec03.exam01_member_class_access;

public class A {

  class B {
  }

  static class C {
  }


  //인스턴스 필드
  //중첩 인스턴스/정적 클래스 인스턴스 필드 생성이 가능하다.
  B field1 = new B();
  C field2 = new C();

  //인스턴스 메소드
  void method1() {
    // 로컬 변수
    B var1 = new B();
    C var2 = new C();
  }

  //정적 필드
  //static B field3 = new B(); A객체가 반드시 생성되어야만 사용할수 있다
  static C field4 = new C();

  //정적 메소드
  static void method2() {
//    B var1 = new B();
    C var2 = new C();

  }
}
